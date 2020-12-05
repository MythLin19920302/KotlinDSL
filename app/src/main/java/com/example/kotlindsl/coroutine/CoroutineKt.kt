package com.example.kotlindsl.coroutine

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * description:
 * create by HuangLin
 * on 2020/12/2
 */
private const val TAG = "CoroutineKt"

fun CoroutineScope.launchException(
    exceptionCall: ((Throwable) -> Unit)? = null,
    block: suspend CoroutineScope.() -> Unit
) {
    this.launch(CoroutineExceptionHandler { _, exception ->
        exceptionCall?.invoke(exception) ?: Log.e(
            TAG,
            "CoroutineExceptionHandler exception $exception"
        )
    }, block = block)
}