package com.qk.pagescutsample.transition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.core.view.ViewCompat
import com.bumptech.glide.Glide
import com.qk.pagescutsample.R
import kotlinx.android.synthetic.main.activity_android_transition_framework2.*


/**
 ** @author qkcoder
 ** @email  qkcoder@aliyun.com
 ** @date   2020/9/2 13:18
 ** @desc   Android Transition Framework 演示页面 （列表场景终点页）
 **/
class AndroidTransitionFrameworkActivity2 : AppCompatActivity() {
    private var mPageContent: String? = null
    private var mPageLogoUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_transition_framework2)

        mPageContent = intent.getStringExtra("content");
        mPageLogoUrl = intent.getStringExtra("url");

        if (TextUtils.isEmpty(mPageContent) || TextUtils.isEmpty(mPageLogoUrl)) {
            finish()
            return
        }

        Glide.with(this).load(mPageLogoUrl).into(image_view_share2)
        tv_page_content2.text = mPageContent

        ViewCompat.setTransitionName(image_view_share2, "transition_share_view")
    }
}