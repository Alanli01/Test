package com.alan.testproject.util

import com.alan.testproject.bean.HomeBean
import com.alan.testproject.bean.ResponseBean

object HomeBeanUtil {
    fun setData(data: ResponseBean?, list: ArrayList<HomeBean>?) {
        data?.let {
            list?.apply {
             add(HomeBean("authorizations_url",data.authorizations_url))
                add(HomeBean("code_search_url",data.code_search_url))
                add(HomeBean("commit_search_url",data.commit_search_url))
                add(HomeBean("current_user_authorizations_html_url",data.current_user_authorizations_html_url))
                add(HomeBean("current_user_url",data.current_user_url))
                add(HomeBean("emails_url",data.emails_url))
                add(HomeBean("emojis_url",data.emojis_url))
                add(HomeBean("feeds_url",data.feeds_url))
                add(HomeBean("followers_url",data.followers_url))
                add(HomeBean("following_url",data.following_url))
                add(HomeBean("gists_url",data.gists_url))
                add(HomeBean("hub_url",data.hub_url))
                add(HomeBean("issue_search_url",data.issue_search_url))
                add(HomeBean("issues_url",data.issues_url))
                add(HomeBean("events_url",data.events_url))
                add(HomeBean("keys_url",data.keys_url))
                add(HomeBean("label_search_url",data.label_search_url))
                add(HomeBean("notifications_url",data.notifications_url))
                add(HomeBean("organization_teams_url",data.organization_teams_url))
                add(HomeBean("organization_repositories_url",data.organization_repositories_url))
                add(HomeBean("rate_limit_url",data.rate_limit_url))
                add(HomeBean("repository_url",data.repository_url))
                add(HomeBean("repository_search_url",data.repository_search_url))
                add(HomeBean("current_user_repositories_url",data.current_user_repositories_url))
                add(HomeBean("starred_url",data.starred_url))
                add(HomeBean("starred_gists_url",data.starred_gists_url))
                add(HomeBean("user_url",data.user_url))
                add(HomeBean("user_organizations_url",data.user_organizations_url))
                add(HomeBean("user_repositories_url",data.user_repositories_url))
                add(HomeBean("user_search_url",data.user_search_url))
            }

        }
    }
}