package com.example.recyclerviewstudy.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerviewstudy.R


class StudyOneAdapter(list: List<Bean?>) : RecyclerView.Adapter<StudyOneAdapter.TestHolder>() {
    private val sTAG = "zy.StudyOneAdapter"
    private var mList: List<Bean?> = mutableListOf<Bean?>()
    private var mCreateNum = 0
    private val mHolderList = mutableSetOf<TestHolder>()

    init {
        mList = list
    }

    //创建Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolder {
        Log.d(sTAG, "onCreateViewHolder")
        mCreateNum++
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_study_one_item, parent, false)
        return when (viewType) {
            0 -> TestHolder(view)
            1 -> TestHolder(view)
            else -> TestHolder(view)
        }
    }

    //绑定数据，如果有复用会直接返回复用的Holder
    override fun onBindViewHolder(holder: TestHolder, position: Int) {
        mHolderList.add(holder)
        Log.d(sTAG, "onBindViewHolder mCreateNum=$mCreateNum mHolderList.size=${mHolderList.size}  lastPosition=${holder.lastPosition} --> nowPosition=$position $holder ")
        holder.newPosition = position
        holder.onBind(mList[position])
    }

    //返回数据个数，会根据这个生成视图
    override fun getItemCount(): Int {
        return mList.size
    }

    //返回ItemType,用来展示不同的是同一个RecyclerView，最常见的就是对话形式的展示,
    override fun getItemViewType(position: Int): Int {
        return mList[position]?.itemType ?: 0
    }


    class TestHolder(itemView: View) : ViewHolder(itemView) {
        //findViewById 获取View,在复用的时候就不用每次都去findView,增加开销
        private val mTitle: TextView = itemView.findViewById(R.id.activity_study_one_item_tv)
        private val mIndex: TextView = itemView.findViewById(R.id.activity_study_one_item_index)
        private val mDes: TextView = itemView.findViewById(R.id.activity_study_one_item_des)
        private val mImageView: ImageView = itemView.findViewById(R.id.activity_study_one_item_iv)
        var lastPosition = -1
        var newPosition = -1
        private var mBean: Bean? = null

        fun onBind(bean: Bean?) {
            if (bean == null) {
                return
            }
            mBean = bean
            mTitle.text = mBean?.mTitle ?: "我是小可爱"
            mIndex.text = mBean?.index.toString() ?: "我是小可爱"

            mDes.text = "$lastPosition -> $newPosition"
            mImageView.setImageResource(mBean!!.imageId)
            lastPosition = newPosition
        }


        init {
        }
    }

    //数据类
    class Bean(val index: Int, val imageId: Int, val mTitle: String, val itemType: Int = 0)
}