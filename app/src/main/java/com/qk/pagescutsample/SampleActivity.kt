package com.qk.pagescutsample

import android.app.Service
import android.content.BroadcastReceiver
import android.content.ContentProvider
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.qk.pagescutsample.fragment.FragmentTransitionActivity
import com.qk.pagescutsample.minipage.MiniPageActivity
import com.qk.pagescutsample.transition.AndroidTransitionFrameworkActivity
import kotlinx.android.synthetic.main.activity_sample.*


/**
 ** @author qkcoder
 ** @email  qkcoder@aliyun.com
 ** @date   2020/9/2 13:19
 ** @desc   Android转场动画技术整合主页
 **/
class SampleActivity : AppCompatActivity(), View.OnClickListener {
    private var mService: Service? = null
    private var boraderCast: BroadcastReceiver? = null
    private var contentProvider: ContentProvider? = null

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_android_transition_framework -> {
                startActivity(Intent(this, AndroidTransitionFrameworkActivity::class.java))
            }
            R.id.tv_fragment -> {
                startActivity(Intent(this, FragmentTransitionActivity::class.java))
            }
            R.id.tv_mini_page -> {
                startActivity(Intent(this, MiniPageActivity::class.java))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        tv_android_transition_framework.background = createRoundCornerBg()
        tv_fragment.background = createRoundCornerBg()
        tv_mini_page.background = createRoundCornerBg()

        tv_android_transition_framework.setOnClickListener(this)
        tv_fragment.setOnClickListener(this)
        tv_mini_page.setOnClickListener(this)
    }

    private fun createRoundCornerBg(): GradientDrawable {
        val gradientDrawable = GradientDrawable()
        gradientDrawable.setColor(Color.parseColor("#d0d0d0"))
        gradientDrawable.cornerRadius = 160f
        gradientDrawable.shape = GradientDrawable.RECTANGLE
        return gradientDrawable
    }
}