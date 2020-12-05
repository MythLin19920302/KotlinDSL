package com.example.kotlindsl.base

import android.os.Bundle
import android.os.PersistableBundle
import com.example.kotlindsl.BaseViewModel



/**
 * description:
 * create by HuangLin
 * on 2020/12/2
 */
abstract class BaseVMActivity<VM : BaseViewModel> : BaseActivity() {

    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        viewModel = buildViewModel()
        lifecycle.addObserver(viewModel)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(viewModel)
    }

    abstract fun buildViewModel(): VM

}