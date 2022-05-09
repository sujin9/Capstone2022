package com.ildango.capstone.mypages.myalarmlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ildango.capstone.mypages.MyViewModel
import com.ildango.capstone.databinding.ActivityPriceAlarmListBinding

class MyAlarmListActivity : AppCompatActivity() {

    private var _binding: ActivityPriceAlarmListBinding?= null
    private val binding get() = _binding!!
    private lateinit var viewModel: MyViewModel

    private val mItems = MutableLiveData<ArrayList<MyAlarmItem>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPriceAlarmListBinding.inflate(this.layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        // list view
        binding.recyclerviewAlarmList.layoutManager = LinearLayoutManager(this)

        val dataObserver: Observer<ArrayList<MyAlarmItem>> =
            Observer { livedata ->
                mItems.value = livedata
                val mAdapter = MyAlarmListAdapter(mItems)
                binding.recyclerviewAlarmList.adapter = mAdapter
            }
        viewModel.alarmLiveData.observe(this, dataObserver)

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}