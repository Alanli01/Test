package com.alan.testproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alan.testproject.R
import com.alan.testproject.ViewModel.MyViewMode
import com.alan.testproject.bean.DataBean
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {


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
        myViewMode.getData().observe(this, Observer<List<DataBean>?>() {datas ->

            datas?.let {
                if (it.size > 0) {
                    tv_home.text = it[it.size - 1].data
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