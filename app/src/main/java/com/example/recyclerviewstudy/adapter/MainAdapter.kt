package com.example.recyclerviewstudy.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerviewstudy.R
import com.example.recyclerviewstudy.adapter.MainAdapter.MainHolder


class MainAdapter(list: List<Bean?>) : RecyclerView.Adapter<MainHolder>() {
    private var mList: List<Bean?> = mutableListOf<Bean?>()

    init {
        mList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.onBind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class MainHolder(itemView: View) : ViewHolder(itemView), View.OnClickListener {
        private val mTitle: TextView = itemView.findViewById(R.id.activity_main_item_title)
        private var mBean: Bean? = null
        fun onBind(bean: Bean?) {
            if (bean == null) {
                return
            }
            mBean = bean
            mTitle.text = mBean?.mTitle ?: "我是小可爱"
        }

        override fun onClick(v: View) {
            if (mBean!!.aClass == null) {
                return
            }
            itemView.context.startActivity(Intent(itemView.context, mBean!!.aClass))
        }

        init {
            itemView.setOnClickListener(this)
        }
    }

    class Bean(internal val mTitle: String, val aClass: Class<*>?)


}