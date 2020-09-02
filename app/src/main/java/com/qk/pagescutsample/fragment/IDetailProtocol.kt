package com.qk.pagescutsample.fragment

import android.view.View

/**
 ** @author qkcoder
 ** @email  qkcoder@aliyun.com
 ** @date   2020/9/2
 ** @desc   详情页接口协议
 **/
interface IDetailProtocol {

    fun launchDetailPage(targetView: View?, content: String?, url: String?)

}