package com.example.recyclerviewstudy.activity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewstudy.R
import com.example.recyclerviewstudy.adapter.TestAdapter
import java.lang.StringBuilder
import kotlin.random.Random

class HorizontalActivity : BaseActivity() {

    override fun initView() {
        val recyclerView = findViewById<RecyclerView>(R.id.test_rv)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        //recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = TestAdapter(initData())
    }

    private fun initData(): List<TestAdapter.Bean?> {
        val list = mutableListOf<TestAdapter.Bean>()
        repeat(2) {
            list.add(TestAdapter.Bean(R.drawable.ic_baseline_3d_rotation_24, getName("3d_rotation_24",true)))
            list.add(TestAdapter.Bean(R.drawable.ic_baseline_ac_unit_24, getName("ac_unit_24",true)))
            list.add(TestAdapter.Bean(R.drawable.ic_baseline_access_alarm_24, getName("access_alarm_24",true)))
            list.add(TestAdapter.Bean(R.drawable.ic_baseline_access_alarms_24, getName("access_alarms_24",true)))
            list.add(TestAdapter.Bean(R.drawable.ic_baseline_access_time_24, getName("access_time_24",true)))
            list.add(TestAdapter.Bean(R.drawable.ic_baseline_check_box_24, getName("check_box_24",true)))
            list.add(TestAdapter.Bean(R.drawable.ic_baseline_check_box_outline_blank_24, getName("check_box_outline_blank_24",true)))
            list.add(TestAdapter.Bean(R.drawable.ic_baseline_indeterminate_check_box_24, getName("indeterminate_check_box_24",true)))
            list.add(TestAdapter.Bean(R.drawable.ic_baseline_radio_button_checked_24, getName("radio_button_checked_24",true)))
        }
        return list
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_horizontal
    }
}