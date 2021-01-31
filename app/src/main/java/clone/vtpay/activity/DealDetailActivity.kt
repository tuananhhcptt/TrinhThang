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
        setupData()
    }

    private fun setupData() {
        if (intent != null) {
            var bundle = intent.extras
            bundle?.let {
                var item = it.getSerializable("DATA") as HistoryItem
                if ("03".equals(item.type)) {
                    tv_header?.text = "Lương"
                } else {
                    tv_header?.text = ""
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