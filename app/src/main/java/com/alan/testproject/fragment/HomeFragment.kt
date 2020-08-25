package com.alan.testproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.alan.testproject.R
import com.alan.testproject.ViewModel.MyViewMode
import com.alan.testproject.adapter.HomeAdapter
import com.alan.testproject.bean.HomeBean
import com.alan.testproject.bean.ResponseBean
import com.alan.testproject.util.HomeBeanUtil
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    var list :ArrayList<HomeBean>? =null
    var homeAdapter:HomeAdapter? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val myViewMode = ViewModelProviders.of(requireActivity()).get(MyViewMode::class.java)
        list  = ArrayList()
        homeAdapter = HomeAdapter(R.layout.item_home_rv,list)
        rv_home.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = homeAdapter
        }

        myViewMode.getData().observe(this, Observer<List<ResponseBean>?>() {datas ->

            datas?.let {
                if (it.isNotEmpty()) {
                    list?.clear()

                    val data = it[it.size - 1]
                    HomeBeanUtil.setData(data, list )
                    homeAdapter?.notifyDataSetChanged()
                }
            }
        })
        myViewMode.LoadData()

    }

    override fun onResume() {
        super.onResume()
    }



    companion object {

        @JvmStatic
        fun newInstance() =
            HomeFragment()

    }
}