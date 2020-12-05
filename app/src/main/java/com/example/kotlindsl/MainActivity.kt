package com.example.kotlindsl

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindsl.di.NetDataSource

class MainActivity : AppCompatActivity() {

    lateinit var netDataSource: NetDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MainActivity", "map =${netDataSource.test()}")
//        viewModel.test()
    }

}