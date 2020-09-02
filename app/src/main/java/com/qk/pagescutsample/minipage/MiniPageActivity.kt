package com.qk.pagescutsample.minipage

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.listeners.ClickEventHook
import com.qk.pagescutsample.R
import com.qk.pagescutsample.SimpleItem
import com.qk.pagescutsample.detachFromParent
import com.qk.pagescutsample.getSimpleData
import kotlinx.android.synthetic.main.activity_mini_page.*


/**
 ** @author qkcoder
 ** @email  qkcoder@aliyun.com
 ** @date   2020/9/2 13:19
 ** @desc   MiniPage演示页面
 **/
class MiniPageActivity : AppCompatActivity() {

    private var mDetailPage: DetailPage? = null
    private val mHandler: Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mini_page)

        initRecyclerView()

        lazyInit()
    }

    private fun lazyInit() {
        mHandler.post {
            initDetailPage()
        }
    }

    private fun initDetailPage() {
        mDetailPage = DetailPage(this)
        val decorView = window.decorView.findViewById<ViewGroup>(android.R.id.content)
        mDetailPage?.getRootView()?.also {
            it.setBackgroundColor(Color.TRANSPARENT)
            detachFromParent(it)
            decorView.addView(it)
        }
    }


    private fun showDetailPage(
        content: String?,
        url: String?,
        sharedView: View
    ) {
        if (mDetailPage == null) {
            initDetailPage()
        }
        val intent = Intent()
        intent.putExtra("content", content)
        intent.putExtra("url", url)
        mDetailPage?.show(Pair(intent, sharedView))
    }

    private fun initRecyclerView() {
        rv_common_list.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_common_list.itemAnimator = null

        val itemAdapter = ItemAdapter<SimpleItem>()
        val fastAdapter = FastAdapter.with(itemAdapter)
        fastAdapter.addEventHook(object : ClickEventHook<SimpleItem>() {
            override fun onBind(viewHolder: RecyclerView.ViewHolder): View? {
                return viewHolder.itemView
            }

            override fun onClick(
                v: View,
                position: Int,
                fastAdapter: FastAdapter<SimpleItem>,
                item: SimpleItem
            ) {
                showDetailPage(
                    item.content,
                    item.url,
                    v
                )
            }
        })
        rv_common_list.adapter = fastAdapter
        itemAdapter.add(getSimpleData())

    }
}