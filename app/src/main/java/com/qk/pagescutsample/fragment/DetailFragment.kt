package com.qk.pagescutsample.fragment

import android.annotation.TargetApi
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.qk.pagescutsample.R
import kotlinx.android.synthetic.main.fragment_detail.*


/**
 ** @author qkcoder
 ** @email  qkcoder@aliyun.com
 ** @date   2020/9/2
 ** @desc   详情页Fragment
 **/
class DetailFragment : Fragment() {
    private var mPageContent: String? = null
    private var mPageLogoUrl: String? = null


    companion object {
        private var mInstance: DetailFragment = DetailFragment()

        fun getInstance() = mInstance
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewCompat.setTransitionName(image_view_share3, "share_view3")

        mPageContent = arguments?.getString("content")
        mPageLogoUrl = arguments?.getString("url")

        if (TextUtils.isEmpty(mPageContent) || TextUtils.isEmpty(mPageLogoUrl)) {
            return
        }


        activity?.supportPostponeEnterTransition()

        Glide.with(this).load(mPageLogoUrl).listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {

                image_view_share3.viewTreeObserver.addOnPreDrawListener(
                    object : ViewTreeObserver.OnPreDrawListener {
                        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                        override fun onPreDraw(): Boolean {
                            return handleShareElement(this)
                        }
                    })

                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                image_view_share3.viewTreeObserver.addOnPreDrawListener(
                    object : ViewTreeObserver.OnPreDrawListener {
                        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                        override fun onPreDraw(): Boolean {
                            return handleShareElement(this)
                        }
                    })
                return false
            }
        }).into(image_view_share3)
        tv_page_content3.text = mPageContent
    }

    private fun handleShareElement(listener: ViewTreeObserver.OnPreDrawListener): Boolean {
        if (image_view_share3 == null) return false
        image_view_share3.viewTreeObserver.removeOnPreDrawListener(listener)
        //开启动画
        activity?.supportStartPostponedEnterTransition()
        return true
    }
}