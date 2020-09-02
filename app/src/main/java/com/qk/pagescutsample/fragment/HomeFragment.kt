package com.qk.pagescutsample.fragment

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.listeners.ClickEventHook
import com.qk.pagescutsample.R
import com.qk.pagescutsample.SimpleItem
import com.qk.pagescutsample.getSimpleData2
import com.qk.pagescutsample.getSimpleData3
import com.qk.pagescutsample.transition.AndroidTransitionFrameworkActivity2
import kotlinx.android.synthetic.main.activity_android_transition_framework.*
import kotlinx.android.synthetic.main.activity_android_transition_framework.rv_common_list2
import kotlinx.android.synthetic.main.fragment_home.*

/**
 ** @author qkcoder
 ** @email  qkcoder@aliyun.com
 ** @date   2020/9/2
 ** @desc   列表首页Fragment
 **/
class HomeFragment : Fragment() {
    companion object {
        private var mInstance: HomeFragment = HomeFragment()

        fun getInstance() = mInstance
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        rv_common_list3.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rv_common_list3.itemAnimator = null

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
                val detailFragment = DetailFragment.getInstance()
                val bundle = Bundle()
                bundle.putString("content", item.content)
                bundle.putString("url", item.url)
                detailFragment.arguments = bundle

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    detailFragment.sharedElementEnterTransition = DetailTransition()
                    detailFragment.enterTransition = Fade()
                    detailFragment.sharedElementReturnTransition = DetailTransition()
                }

                ViewCompat.setTransitionName(v, "share_view3")

                activity?.also {
                    it.supportFragmentManager.beginTransaction()
                        .addSharedElement(v, "share_view3")
                        .replace(
                            R.id.fl_fragment_container,
                            detailFragment,
                            "detail_fragment"
                        )
                        .addToBackStack(null)
                        .commitAllowingStateLoss()
                }

            }
        })
        rv_common_list3.adapter = fastAdapter
        itemAdapter.add(getSimpleData3())

    }

    class DetailTransition : TransitionSet() {
        init {
            ordering = ORDERING_TOGETHER
            addTransition(ChangeBounds())
                .addTransition(ChangeTransform())
                .addTransition(ChangeImageTransform())
        }
    }
}