package com.example.recyclerviewstudy.activity

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewstudy.R
import com.example.recyclerviewstudy.adapter.StudyOneAdapter

class StudyOneActivity : BaseActivity() {
    val sTAG = "zy.StudyOneActivity"
    override fun initView() {
        val recyclerView = findViewById<RecyclerView>(R.id.test_rv)
        //recyclerView.layoutManager = GridLayoutManager(this, 4)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = StudyOneAdapter(initData())
    }

    private fun initData(): List<StudyOneAdapter.Bean?> {
        val list = mutableListOf<StudyOneAdapter.Bean>()
        repeat(5) {
            Log.d(sTAG, "$it")
            list.add(StudyOneAdapter.Bean(it * 9 + 0, R.drawable.ic_baseline_3d_rotation_24, getName("3d_rotation_24", true)))
            list.add(StudyOneAdapter.Bean(it * 9 + 1, R.drawable.ic_baseline_ac_unit_24, getName("ac_unit_24", true)))
            list.add(StudyOneAdapter.Bean(it * 9 + 2, R.drawable.ic_baseline_access_alarm_24, getName("access_alarm_24", true)))
            list.add(StudyOneAdapter.Bean(it * 9 + 3, R.drawable.ic_baseline_access_alarms_24, getName("access_alarms_24", true)))
            list.add(StudyOneAdapter.Bean(it * 9 + 4, R.drawable.ic_baseline_access_time_24, getName("access_time_24", true)))
            list.add(StudyOneAdapter.Bean(it * 9 + 5, R.drawable.ic_baseline_check_box_24, getName("check_box_24", true)))
            list.add(StudyOneAdapter.Bean(it * 9 + 6, R.drawable.ic_baseline_check_box_outline_blank_24, getName("check_box_outline_blank_24", true)))
            list.add(StudyOneAdapter.Bean(it * 9 + 7, R.drawable.ic_baseline_indeterminate_check_box_24, getName("indeterminate_check_box_24", true)))
            list.add(StudyOneAdapter.Bean(it * 9 + 8, R.drawable.ic_baseline_radio_button_checked_24, getName("radio_button_checked_24", true)))
        }
        return list
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_study_one
    }
}