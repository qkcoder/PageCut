package com.qk.pagescutsample.fragment

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.core.view.ViewCompat
import androidx.fragment.app.FragmentTransaction
import androidx.transition.*
import com.qk.pagescutsample.R

/**
 ** @author qkcoder
 ** @email  qkcoder@aliyun.com
 ** @date   2020/9/2 13:18
 ** @desc   Fragment 演示页面
 **/
class FragmentTransitionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_transition)
        goHomePage()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            val curFragment = supportFragmentManager.findFragmentById(R.id.fl_fragment_container)
            if (curFragment is DetailFragment) {
                goHomePage()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun goHomePage() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val homeFragment = HomeFragment.getInstance()
        fragmentTransaction.add(
            R.id.fl_fragment_container,
            homeFragment,
            "home_fragment"
        ).add(
            R.id.fl_fragment_container,
            DetailFragment.getInstance(),
            "detail_fragment"
        ).show(homeFragment).commitAllowingStateLoss()
    }

}