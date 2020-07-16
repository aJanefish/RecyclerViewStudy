package com.example.recyclerviewstudy

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewstudy.activity.*
import com.example.recyclerviewstudy.adapter.MainAdapter
import java.util.*

class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        init()
    }

    private fun init() {
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        //recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.horizontal, false)
        recyclerView.adapter = MainAdapter(initData())
    }

    private fun initData(): List<MainAdapter.Bean?> {
        val list: MutableList<MainAdapter.Bean?> = ArrayList<MainAdapter.Bean?>()
        list.add(MainAdapter.Bean("竖直RecyclerView", VerticalTestActivity::class.java))
        list.add(MainAdapter.Bean("水平RecyclerView", HorizontalActivity::class.java))
        list.add(MainAdapter.Bean("Grid RecyclerView", GridRVActivity::class.java))
        list.add(MainAdapter.Bean("瀑布 RecyclerView", WaterfallRVActivity::class.java))
        list.add(MainAdapter.Bean("RecyclerView 缓存机制研究1", StudyOneActivity::class.java))
        return list
    }
}