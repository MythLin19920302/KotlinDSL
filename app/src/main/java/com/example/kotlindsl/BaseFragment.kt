package com.example.kotlindsl

import android.content.pm.PackageManager
import android.os.Bundle
import android.text.style.UnderlineSpan
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

/**
 * description:
 * create by HuangLin
 * on 2020/12/2
 */
class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
}