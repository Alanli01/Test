package com.alan.testproject.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.alan.testproject.HistoryActivity
import com.alan.testproject.R
import com.alan.testproject.ViewModel.MyViewMode
import com.alan.testproject.adapter.HistoryAdapter
import com.alan.testproject.bean.ResponseBean
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.fragment_history.*


class HistoryFragment : Fragment() {
    private var lists :ArrayList<ResponseBean>?=null
    var historyAdapter :HistoryAdapter? =null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val myViewMode = ViewModelProviders.of(requireActivity()).get(MyViewMode::class.java)
        lists = ArrayList()
        lists?.let {
            rv_history.apply {
                layoutManager = LinearLayoutManager(requireContext())
                historyAdapter  = HistoryAdapter(R.layout.item_rv, it)
                adapter= historyAdapter
            }

        }
        historyAdapter?.setOnItemClickListener { adapter, view, position ->
            val intent = Intent(requireActivity(),HistoryActivity::class.java)
            intent.putExtra("bean",lists?.get(position))
            requireActivity().startActivity(intent)
        }
        myViewMode.getData().observe(this, Observer<List<ResponseBean>?>() { datas ->

            datas?.let {
                if(it.size>0) {
                    lists?.apply {
                        clear()
                        addAll(datas)
                        historyAdapter?.notifyDataSetChanged()
                    }
                }
            }
        })
        myViewMode.LoadData()

    }
    companion object {

        @JvmStatic
        fun newInstance() = HistoryFragment()
    }
}