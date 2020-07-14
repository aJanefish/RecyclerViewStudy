package com.example.recyclerviewstudy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerviewstudy.R


class TestAdapter(list: List<Bean?>) : RecyclerView.Adapter<TestAdapter.TestHolder>() {
    private var mList: List<Bean?> = mutableListOf<Bean?>()

    init {
        mList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_test_item, parent, false)
        return TestHolder(view)
    }

    override fun onBindViewHolder(holder: TestHolder, position: Int) {
        holder.onBind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class TestHolder(itemView: View) : ViewHolder(itemView) {
        private val mTitle: TextView = itemView.findViewById(R.id.activity_test_item_tv)
        private val mImageView: ImageView = itemView.findViewById(R.id.activity_test_item_iv)
        private var mBean: Bean? = null
        fun onBind(bean: Bean?) {
            if (bean == null) {
                return
            }
            mBean = bean
            mTitle.text = mBean?.mTitle ?: "我是小可爱"
            mImageView.setImageResource(mBean!!.imageId)
        }


        init {
        }
    }

    class Bean(val imageId: Int, val mTitle: String)


}