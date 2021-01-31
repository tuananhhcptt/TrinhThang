package clone.vtpay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_screen1.*

class Screen1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        initListener()
    }

    private fun initListener() {
        login.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}