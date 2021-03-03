package clone.vtpay.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import clone.vtpay.R
import clone.vtpay.repository.HistoryItem
import kotlinx.android.synthetic.main.activity_deal_detail.*

class DealDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deal_detail)

        tv_term_value.isSelected = true

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        setupData()
    }

    private fun setupData() {
        if (intent != null) {
            var bundle = intent.extras
            bundle?.let {
                var item = it.getSerializable("DATA") as HistoryItem

                var nd = item.noidung
                if ("03".equals(item.type)) {
                    nd = item.noidung.substring(3)
                } else if (item.noidung.startsWith("01:") || item.noidung.startsWith("02:") ) {
                    nd = item.noidung.substring(3)
                } else if (item.noidung.startsWith("01") || item.noidung.startsWith("02") ) {
                    nd = item.noidung.substring(2)
                }

                if (item.isIsluong){
                    tv_header?.text = "Lương"
                } else {
                    tv_header?.text = item.randomPhoneNumber
                }

                var drawable =
                    resources.getIdentifier(
                        item.iconDrawable ?: "icon_34",
                        "drawable",
                        packageName
                    )
                icon?.setImageDrawable(getDrawable(drawable))
                tv_money_value?.text = item.money
                tv_term_value?.text = item.noidung
                tv_time_value?.text = item.thoigian
                tv_code_value?.text = item.trade_code
            }
        }
    }
}