package com.qk.pagescutsample

import android.view.View
import android.view.ViewGroup

/**
 ** @author qkcoder
 ** @email  qkcoder@aliyun.com
 ** @date   2020/9/2
 ** @desc   工具类
 **/

fun getSimpleData(): List<SimpleItem> {
    return listOf(
        SimpleItem().withImgUrl("http://image.iltaw.com/20121106/65/114/zX2qFGODDCbER4Ar.jpg")
            .withImgDesc("1我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容"),
        SimpleItem().withImgUrl("http://image.iltaw.com/20121106/85/73/KByel6oztjbcwHUI.jpg")
            .withImgDesc("2我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容"),
        SimpleItem().withImgUrl("http://image.iltaw.com/20121106/77/88/dMBnlpEOxaUTHQMX.jpg")
            .withImgDesc("3我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容"),
        SimpleItem().withImgUrl("http://image.iltaw.com/20121106/52/82/ZKdn8b4FiJRbZj4R.jpg")
            .withImgDesc("4我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容我是大熊猫测试内容")
    )
}


fun getSimpleData2(): List<SimpleItem> {
    return listOf(
        SimpleItem().withImgUrl("http://photocdn.sohu.com/20160312/mp63169765_1457787339379_2.jpeg")
            .withImgDesc("1连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑"),
        SimpleItem().withImgUrl("http://photocdn.sohu.com/20160312/mp63169765_1457787339379_5.jpeg")
            .withImgDesc("2连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑"),
        SimpleItem().withImgUrl("http://photocdn.sohu.com/20160312/mp63169765_1457787339379_7.jpeg")
            .withImgDesc("3连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑"),
        SimpleItem().withImgUrl("http://photocdn.sohu.com/20160312/mp63169765_1457787339379_9.jpeg")
            .withImgDesc("4连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑"),
        SimpleItem().withImgUrl("http://photocdn.sohu.com/20160312/mp63169765_1457787339379_10.jpeg")
            .withImgDesc("5连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑连明星也无法拒绝它的甜蜜诱惑")
    )
}

fun getSimpleData3(): List<SimpleItem> {
    return listOf(
        SimpleItem().withImgUrl("https://bkimg.cdn.bcebos.com/pic/d4628535e5dde71190ef2144bea6d91b9d16fdfacb62?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2UyNzI=,g_7,xp_5,yp_5")
            .withImgDesc("1我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅"),
        SimpleItem().withImgUrl("http://pic3.newssc.org/upload/0028000000000/news/20200902/1599009590685.jpeg")
            .withImgDesc("2我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅"),
        SimpleItem().withImgUrl("http://pic3.newssc.org/upload/0028000000000/news/20200902/1599009591777.jpeg")
            .withImgDesc("3我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅"),
        SimpleItem().withImgUrl("http://pic3.newssc.org/upload/0028000000000/news/20200902/1599009592151.png")
            .withImgDesc("4我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅我是火锅")
    )
}

fun detachFromParent(view: View?) {
    (view?.parent as? ViewGroup)?.also {
        it.removeView(view)
    }
}