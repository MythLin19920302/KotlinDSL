package com.example.kotlindsl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kotlindsl.coroutine.launchException
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * description:
 * create by HuangLin
 * on 2020/12/2
 */
private const val TAG = "MainViewModel"

class MainViewModel() : BaseViewModel() {

    @Inject
    lateinit var map: Map<String, String>

    val selected = MutableLiveData<Boolean>()
    fun test() {
        Log.e(TAG, "map =${map["huang"]}")

        viewModelScope.launchException({
            Log.e(TAG, "ex thread ${Thread.currentThread().name} ${it}")
        }) {
            testFlow()
        }
    }

    private suspend fun testFlow() {
        flow {
            delay(1000)
            Log.e(TAG, "flow thread ${Thread.currentThread().name}")
            this.emit("lin")
        }.flowOn(Dispatchers.IO).map {
            delay(1000)
            Log.e(TAG, "map thread ${Thread.currentThread().name}")
        }.flowOn(Dispatchers.Main)
            .map {
                delay(1000)
                Log.e(TAG, "map2 thread ${Thread.currentThread().name}")
            }.flowOn(Dispatchers.IO)
            .collect {
                Log.e(TAG, "collect thread ${Thread.currentThread().name} $it")
            }
    }


}