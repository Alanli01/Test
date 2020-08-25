package com.alan.testproject.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ResponseBean {

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
    @Id
    public String time;
    public String current_user_url;
    public String current_user_authorizations_html_url;
    public String authorizations_url;
    public String code_search_url;
    public String commit_search_url;
    public String emails_url;
    public String emojis_url;
    public String events_url;
    public String feeds_url;
    public String followers_url;
    public String following_url;
    public String gists_url;
    public String hub_url;
    public String issue_search_url;
    public String issues_url;
    public String keys_url;
    public String label_search_url;
    public String notifications_url;
    public String organization_url;
    public String organization_repositories_url;
    public String organization_teams_url;
    public String public_gists_url;
    public String rate_limit_url;
    public String repository_url;
    public String repository_search_url;
    public String current_user_repositories_url;
    public String starred_url;
    public String starred_gists_url;
    public String user_url;
    public String user_organizations_url;
    public String user_repositories_url;
    public String user_search_url;
    @Generated(hash = 200956434)
    public ResponseBean(String time, String current_user_url, String current_user_authorizations_html_url,
            String authorizations_url, String code_search_url, String commit_search_url, String emails_url,
            String emojis_url, String events_url, String feeds_url, String followers_url, String following_url,
            String gists_url, String hub_url, String issue_search_url, String issues_url, String keys_url,
            String label_search_url, String notifications_url, String organization_url,
            String organization_repositories_url, String organization_teams_url, String public_gists_url,
            String rate_limit_url, String repository_url, String repository_search_url,
            String current_user_repositories_url, String starred_url, String starred_gists_url, String user_url,
            String user_organizations_url, String user_repositories_url, String user_search_url) {
        this.time = time;
        this.current_user_url = current_user_url;
        this.current_user_authorizations_html_url = current_user_authorizations_html_url;
        this.authorizations_url = authorizations_url;
        this.code_search_url = code_search_url;
        this.commit_search_url = commit_search_url;
        this.emails_url = emails_url;
        this.emojis_url = emojis_url;
        this.events_url = events_url;
        this.feeds_url = feeds_url;
        this.followers_url = followers_url;
        this.following_url = following_url;
        this.gists_url = gists_url;
        this.hub_url = hub_url;
        this.issue_search_url = issue_search_url;
        this.issues_url = issues_url;
        this.keys_url = keys_url;
        this.label_search_url = label_search_url;
        this.notifications_url = notifications_url;
        this.organization_url = organization_url;
        this.organization_repositories_url = organization_repositories_url;
        this.organization_teams_url = organization_teams_url;
        this.public_gists_url = public_gists_url;
        this.rate_limit_url = rate_limit_url;
        this.repository_url = repository_url;
        this.repository_search_url = repository_search_url;
        this.current_user_repositories_url = current_user_repositories_url;
        this.starred_url = starred_url;
        this.starred_gists_url = starred_gists_url;
        this.user_url = user_url;
        this.user_organizations_url = user_organizations_url;
        this.user_repositories_url = user_repositories_url;
        this.user_search_url = user_search_url;
    }
    @Generated(hash = 2038147101)
    public ResponseBean() {
    }
    public String getCurrent_user_url() {
        return this.current_user_url;
    }
    public void setCurrent_user_url(String current_user_url) {
        this.current_user_url = current_user_url;
    }
    public String getCurrent_user_authorizations_html_url() {
        return this.current_user_authorizations_html_url;
    }
    public void setCurrent_user_authorizations_html_url(String current_user_authorizations_html_url) {
        this.current_user_authorizations_html_url = current_user_authorizations_html_url;
    }
    public String getAuthorizations_url() {
        return this.authorizations_url;
    }
    public void setAuthorizations_url(String authorizations_url) {
        this.authorizations_url = authorizations_url;
    }
    public String getCode_search_url() {
        return this.code_search_url;
    }
    public void setCode_search_url(String code_search_url) {
        this.code_search_url = code_search_url;
    }
    public String getCommit_search_url() {
        return this.commit_search_url;
    }
    public void setCommit_search_url(String commit_search_url) {
        this.commit_search_url = commit_search_url;
    }
    public String getEmails_url() {
        return this.emails_url;
    }
    public void setEmails_url(String emails_url) {
        this.emails_url = emails_url;
    }
    public String getEmojis_url() {
        return this.emojis_url;
    }
    public void setEmojis_url(String emojis_url) {
        this.emojis_url = emojis_url;
    }
    public String getEvents_url() {
        return this.events_url;
    }
    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }
    public String getFeeds_url() {
        return this.feeds_url;
    }
    public void setFeeds_url(String feeds_url) {
        this.feeds_url = feeds_url;
    }
    public String getFollowers_url() {
        return this.followers_url;
    }
    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }
    public String getFollowing_url() {
        return this.following_url;
    }
    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }
    public String getGists_url() {
        return this.gists_url;
    }
    public void setGists_url(String gists_url) {
        this.gists_url = gists_url;
    }
    public String getHub_url() {
        return this.hub_url;
    }
    public void setHub_url(String hub_url) {
        this.hub_url = hub_url;
    }
    public String getIssue_search_url() {
        return this.issue_search_url;
    }
    public void setIssue_search_url(String issue_search_url) {
        this.issue_search_url = issue_search_url;
    }
    public String getIssues_url() {
        return this.issues_url;
    }
    public void setIssues_url(String issues_url) {
        this.issues_url = issues_url;
    }
    public String getKeys_url() {
        return this.keys_url;
    }
    public void setKeys_url(String keys_url) {
        this.keys_url = keys_url;
    }
    public String getLabel_search_url() {
        return this.label_search_url;
    }
    public void setLabel_search_url(String label_search_url) {
        this.label_search_url = label_search_url;
    }
    public String getNotifications_url() {
        return this.notifications_url;
    }
    public void setNotifications_url(String notifications_url) {
        this.notifications_url = notifications_url;
    }
    public String getOrganization_url() {
        return this.organization_url;
    }
    public void setOrganization_url(String organization_url) {
        this.organization_url = organization_url;
    }
    public String getOrganization_repositories_url() {
        return this.organization_repositories_url;
    }
    public void setOrganization_repositories_url(String organization_repositories_url) {
        this.organization_repositories_url = organization_repositories_url;
    }
    public String getOrganization_teams_url() {
        return this.organization_teams_url;
    }
    public void setOrganization_teams_url(String organization_teams_url) {
        this.organization_teams_url = organization_teams_url;
    }
    public String getPublic_gists_url() {
        return this.public_gists_url;
    }
    public void setPublic_gists_url(String public_gists_url) {
        this.public_gists_url = public_gists_url;
    }
    public String getRate_limit_url() {
        return this.rate_limit_url;
    }
    public void setRate_limit_url(String rate_limit_url) {
        this.rate_limit_url = rate_limit_url;
    }
    public String getRepository_url() {
        return this.repository_url;
    }
    public void setRepository_url(String repository_url) {
        this.repository_url = repository_url;
    }
    public String getRepository_search_url() {
        return this.repository_search_url;
    }
    public void setRepository_search_url(String repository_search_url) {
        this.repository_search_url = repository_search_url;
    }
    public String getCurrent_user_repositories_url() {
        return this.current_user_repositories_url;
    }
    public void setCurrent_user_repositories_url(String current_user_repositories_url) {
        this.current_user_repositories_url = current_user_repositories_url;
    }
    public String getStarred_url() {
        return this.starred_url;
    }
    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }
    public String getStarred_gists_url() {
        return this.starred_gists_url;
    }
    public void setStarred_gists_url(String starred_gists_url) {
        this.starred_gists_url = starred_gists_url;
    }
    public String getUser_url() {
        return this.user_url;
    }
    public void setUser_url(String user_url) {
        this.user_url = user_url;
    }
    public String getUser_organizations_url() {
        return this.user_organizations_url;
    }
    public void setUser_organizations_url(String user_organizations_url) {
        this.user_organizations_url = user_organizations_url;
    }
    public String getUser_repositories_url() {
        return this.user_repositories_url;
    }
    public void setUser_repositories_url(String user_repositories_url) {
        this.user_repositories_url = user_repositories_url;
    }
    public String getUser_search_url() {
        return this.user_search_url;
    }
    public void setUser_search_url(String user_search_url) {
        this.user_search_url = user_search_url;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    
}
