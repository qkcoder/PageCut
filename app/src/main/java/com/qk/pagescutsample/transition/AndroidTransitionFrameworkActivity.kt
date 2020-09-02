package com.qk.pagescutsample.transition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.listeners.ClickEventHook
import com.qk.pagescutsample.R
import com.qk.pagescutsample.SimpleItem
import com.qk.pagescutsample.getSimpleData2
import kotlinx.android.synthetic.main.activity_android_transition_framework.*

/**
 ** @author qkcoder
 ** @email  qkcoder@aliyun.com
 ** @date   2020/9/2 13:17
 ** @desc   Android Transition Framework 演示页面 （列表场景起始页）
 **/
class AndroidTransitionFrameworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_transition_framework)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rv_common_list2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_common_list2.itemAnimator = null

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

                ViewCompat.setTransitionName(v, "transition_share_view")

                val intent = Intent(
                    this@AndroidTransitionFrameworkActivity,
                    AndroidTransitionFrameworkActivity2::class.java
                )
                intent.putExtra("content", item.content)
                intent.putExtra("url", item.url)
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this@AndroidTransitionFrameworkActivity,
                    v,
                    "transition_share_view"
                )
              // ActivityOptionsCompat.makeSceneTransitionAnimation()
                startActivity(intent, options.toBundle())
            }
        })
        rv_common_list2.adapter = fastAdapter
        itemAdapter.add(getSimpleData2())

    }
}