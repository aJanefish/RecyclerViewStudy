package com.example.recyclerviewstudy.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.lang.StringBuilder
import kotlin.random.Random

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
    }

    protected abstract fun initView()
    protected abstract fun getLayoutId(): Int


    internal fun getName(name: String): String {
        var r = Random(10).nextInt(10)
        return with(StringBuilder(), {
            for (i in 0..r) {
                append(name).append(":")
            }
            toString()
        })
    }

    internal fun getName(name: String, flag: Boolean): String {
        return if (flag){
            name
        }else{
            getName(name)
        }
    }
}