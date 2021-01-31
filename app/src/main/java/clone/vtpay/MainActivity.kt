package clone.vtpay

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import clone.vtpay.fragment.HistoryFragment
import clone.vtpay.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var historyFragment: HistoryFragment? = null
    private var homeFragment: HomeFragment? = null
    private var fm: FragmentManager? = null
    private var active: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initListener()

    }

    private fun initView() {

        historyFragment = HistoryFragment()
        homeFragment = HomeFragment()
        fm = supportFragmentManager
        active = homeFragment

        fm!!.beginTransaction().add(R.id.frame_container, historyFragment!!, "history")
            .hide(historyFragment!!).commit()
        fm!!.beginTransaction().add(R.id.frame_container, homeFragment!!, "home").commit()
    }

    private fun initListener() {

        navigation.setOnNavigationItemSelectedListener {
            val transaction = fm!!.beginTransaction()
            when (it.itemId) {
                R.id.navigation_home -> {
                    Log.d("MainActivity", "initListener: ")
                    //                fm.beginTransaction().setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out).hide(active).show(myCarFragment).setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();

                    transaction.hide(active!!).show(homeFragment!!).commit()
                    active = homeFragment


                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    Log.d("MainActivity", "initListener: ")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_history -> {
                    Log.d("MainActivity", "initListener: ")

                    transaction.hide(active!!).show(historyFragment!!).commit()
                    active = historyFragment
                    

                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }


}