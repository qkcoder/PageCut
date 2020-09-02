package com.qk.pagescutsample.minipage

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import com.bumptech.glide.Glide
import com.qk.pagescut.minipage.MiniPage
import com.qk.pagescutsample.R

/**
 ** @author qkcoder
 ** @email  qkcoder@aliyun.com
 ** @date   2020/9/2
 ** @desc  详情页面
 **/
class DetailPage(activity: Activity) : MiniPage(activity) {
    private var mImgView: ImageView? = null
    private var mContentView: TextView? = null

    private var mPageContent: String? = null
    private var mPageLogoUrl: String? = null
    private var mSharedView: View? = null
    private var mOriginalTop: Int = 0

    @SuppressLint("InflateParams")
    override fun buildView(layoutInflater: LayoutInflater): View {
        return layoutInflater.inflate(R.layout.layout_detail_page, null)
    }

    override fun handleParams() {
        super.handleParams()
        val param: Pair<Intent, Any>? = getLaunchParams()
        param?.first?.also {
            mPageContent = it.getStringExtra("content")
            mPageLogoUrl = it.getStringExtra("url")
        }

        param?.second?.also {
            mSharedView = it as? View
        }
    }

    override fun onCreate() {
        super.onCreate()
        mImgView = findViewById(R.id.image_view_share)
        mContentView = findViewById(R.id.tv_page_content)
    }

    override fun onResume() {
        super.onResume()
        if (TextUtils.isEmpty(mPageLogoUrl) || TextUtils.isEmpty(mPageContent)) {
            dismiss()
            return
        }

        mImgView?.also { Glide.with(getHost()).load(mPageLogoUrl).into(it) }

        mContentView?.text = mPageContent


        //Step1:视图归位
        ViewCompat.setTranslationY(getRootView(), 0f)

        //Step2: 重定位到上一个页面的位置
        val originalTop: Int = mSharedView?.let {
            val location = IntArray(2)
            val location2 = IntArray(2)
            it.getLocationInWindow(location)
            mImgView?.getLocationInWindow(location2)
            mOriginalTop = location[1] - location2[1]
            mOriginalTop
        } ?: 0
        ViewCompat.setTranslationY(getRootView(), originalTop.toFloat())

        //设置背景
        getRootView()?.also {
            it.setBackgroundColor(Color.WHITE)
            it.visibility = View.VISIBLE
        }

        postRunnable {
            //Step3: 一波转场入场动画无缝衔接
            val translationAnim: ObjectAnimator = ObjectAnimator.ofFloat(
                getRootView(),
                "translationY",
                originalTop.toFloat(),
                0F
            )
            translationAnim.duration = 500
            translationAnim.start()
        }
    }

    override fun onDismiss() {
        super.onDismiss()
        mContentView?.text = ""
        postRunnable {
            //Step2: 一波转场出场动画无缝衔接
            val translationAnim: ObjectAnimator = ObjectAnimator.ofFloat(
                getRootView(),
                "translationY",
                0F,
                mOriginalTop.toFloat()
            )
            translationAnim.duration = 400
            translationAnim.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    animation?.removeAllListeners()
                    //重置背景
                    getRootView()?.also {
                        it.setBackgroundColor(Color.TRANSPARENT)
                        it.visibility = View.GONE
                    }
                }
            })
            translationAnim.start()
        }
    }
}