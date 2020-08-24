package com.alan.testproject.bean

import android.os.Parcel
import android.os.Parcelable

data class ResponseBean(
    /**
     * current_user_url : https://api.github.com/user
     * current_user_authorizations_html_url : https://github.com/settings/connections/applications{/client_id}
     * authorizations_url : https://api.github.com/authorizations
     * code_search_url : https://api.github.com/search/code?q={query}{&page,per_page,sort,order}
     * commit_search_url : https://api.github.com/search/commits?q={query}{&page,per_page,sort,order}
     * emails_url : https://api.github.com/user/emails
     * emojis_url : https://api.github.com/emojis
     * events_url : https://api.github.com/events
     * feeds_url : https://api.github.com/feeds
     * followers_url : https://api.github.com/user/followers
     * following_url : https://api.github.com/user/following{/target}
     * gists_url : https://api.github.com/gists{/gist_id}
     * hub_url : https://api.github.com/hub
     * issue_search_url : https://api.github.com/search/issues?q={query}{&page,per_page,sort,order}
     * issues_url : https://api.github.com/issues
     * keys_url : https://api.github.com/user/keys
     * label_search_url : https://api.github.com/search/labels?q={query}&repository_id={repository_id}{&page,per_page}
     * notifications_url : https://api.github.com/notifications
     * organization_url : https://api.github.com/orgs/{org}
     * organization_repositories_url : https://api.github.com/orgs/{org}/repos{?type,page,per_page,sort}
     * organization_teams_url : https://api.github.com/orgs/{org}/teams
     * public_gists_url : https://api.github.com/gists/public
     * rate_limit_url : https://api.github.com/rate_limit
     * repository_url : https://api.github.com/repos/{owner}/{repo}
     * repository_search_url : https://api.github.com/search/repositories?q={query}{&page,per_page,sort,order}
     * current_user_repositories_url : https://api.github.com/user/repos{?type,page,per_page,sort}
     * starred_url : https://api.github.com/user/starred{/owner}{/repo}
     * starred_gists_url : https://api.github.com/gists/starred
     * user_url : https://api.github.com/users/{user}
     * user_organizations_url : https://api.github.com/user/orgs
     * user_repositories_url : https://api.github.com/users/{user}/repos{?type,page,per_page,sort}
     * user_search_url : https://api.github.com/search/users?q={query}{&page,per_page,sort,order}
     */
    var current_user_url: String? = null,
    var current_user_authorizations_html_url: String? = null,
    var authorizations_url: String? = null,
    var code_search_url: String? = null,
    var commit_search_url: String? = null,
    var emails_url: String? = null,
    var emojis_url: String? = null,
    var events_url: String? = null,
    var feeds_url: String? = null,
    var followers_url: String? = null,
    var following_url: String? = null,
    var gists_url: String? = null,
    var hub_url: String? = null,
    var issue_search_url: String? = null,
    var issues_url: String? = null,
    var keys_url: String? = null,
    var label_search_url: String? = null,
    var notifications_url: String? = null,
    var organization_url: String? = null,
    var organization_repositories_url: String? = null,
    var organization_teams_url: String? = null,
    var public_gists_url: String? = null,
    var rate_limit_url: String? = null,
    var repository_url: String? = null,
    var repository_search_url: String? = null,
    var current_user_repositories_url: String? = null,
    var starred_url: String? = null,
    var starred_gists_url: String? = null,
    var user_url: String? = null,
    var user_organizations_url: String? = null,
    var user_repositories_url: String? = null,
    var user_search_url: String? = null

) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(current_user_url)
        writeString(current_user_authorizations_html_url)
        writeString(authorizations_url)
        writeString(code_search_url)
        writeString(commit_search_url)
        writeString(emails_url)
        writeString(emojis_url)
        writeString(events_url)
        writeString(feeds_url)
        writeString(followers_url)
        writeString(following_url)
        writeString(gists_url)
        writeString(hub_url)
        writeString(issue_search_url)
        writeString(issues_url)
        writeString(keys_url)
        writeString(label_search_url)
        writeString(notifications_url)
        writeString(organization_url)
        writeString(organization_repositories_url)
        writeString(organization_teams_url)
        writeString(public_gists_url)
        writeString(rate_limit_url)
        writeString(repository_url)
        writeString(repository_search_url)
        writeString(current_user_repositories_url)
        writeString(starred_url)
        writeString(starred_gists_url)
        writeString(user_url)
        writeString(user_organizations_url)
        writeString(user_repositories_url)
        writeString(user_search_url)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ResponseBean> = object : Parcelable.Creator<ResponseBean> {
            override fun createFromParcel(source: Parcel): ResponseBean = ResponseBean(source)
            override fun newArray(size: Int): Array<ResponseBean?> = arrayOfNulls(size)
        }
    }
}