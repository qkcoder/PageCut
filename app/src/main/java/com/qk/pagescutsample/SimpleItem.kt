package com.qk.pagescutsample

import android.content.res.Resources
import android.net.Uri
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

/**
 ** @author qkcoder
 ** @email  qkcoder@aliyun.com
 ** @date   2020/9/1
 ** @desc   列表Adapter
 **/
class SimpleItem : AbstractItem<SimpleItem.ViewHolder>() {
    var url: String? = null
    var content: String? = null

    override val layoutRes: Int
        get() = R.layout.layout_simple_item_list
    override val type: Int
        get() = R.id.adapter_sample_item_id

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    fun withImgUrl(imgUrl: String): SimpleItem {
        this.url = imgUrl
        return this
    }

    fun withImgDesc(content: String): SimpleItem {
        this.content = content
        return this
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<SimpleItem>(view) {
        private val img: ImageView = view.findViewById(R.id.image_view_item)

        override fun bindView(
            item: SimpleItem,
            payloads: List<Any>
        ) {
            Glide.with(img.context).load(item.url).into(img)
        }

        override fun unbindView(item: SimpleItem) {

        }
    }
}