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
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    var list :MutableList<HomeBean>? =null
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
                    list?.add(HomeBean("authorizations_url",data.authorizations_url))
                    list?.add(HomeBean("code_search_url",data.code_search_url))
                    list?.add(HomeBean("commit_search_url",data.commit_search_url))
                    list?.add(HomeBean("current_user_authorizations_html_url",data.current_user_authorizations_html_url))
                    list?.add(HomeBean("current_user_url",data.current_user_url))
                    list?.add(HomeBean("emails_url",data.emails_url))
                    list?.add(HomeBean("emojis_url",data.emojis_url))
                    list?.add(HomeBean("feeds_url",data.feeds_url))
                    list?.add(HomeBean("followers_url",data.followers_url))
                    list?.add(HomeBean("following_url",data.following_url))
                    list?.add(HomeBean("gists_url",data.gists_url))
                    list?.add(HomeBean("hub_url",data.hub_url))
                    list?.add(HomeBean("issue_search_url",data.issue_search_url))
                    list?.add(HomeBean("issues_url",data.issues_url))
                    list?.add(HomeBean("events_url",data.events_url))
                    list?.add(HomeBean("keys_url",data.keys_url))
                    list?.add(HomeBean("label_search_url",data.label_search_url))
                    list?.add(HomeBean("notifications_url",data.notifications_url))
                    list?.add(HomeBean("organization_teams_url",data.organization_teams_url))
                    list?.add(HomeBean("organization_repositories_url",data.organization_repositories_url))
                    list?.add(HomeBean("rate_limit_url",data.rate_limit_url))
                    list?.add(HomeBean("repository_url",data.repository_url))
                    list?.add(HomeBean("repository_search_url",data.repository_search_url))
                    list?.add(HomeBean("current_user_repositories_url",data.current_user_repositories_url))
                    list?.add(HomeBean("starred_url",data.starred_url))
                    list?.add(HomeBean("starred_gists_url",data.starred_gists_url))
                    list?.add(HomeBean("user_url",data.user_url))
                    list?.add(HomeBean("user_organizations_url",data.user_organizations_url))
                    list?.add(HomeBean("user_repositories_url",data.user_repositories_url))
                    list?.add(HomeBean("user_search_url",data.user_search_url))
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