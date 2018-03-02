package com.scalablecapitaltask.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.Nullable
import com.scalablecapitaltask.constants.DataBaseConstants

/**
 * Created by ziadgholmish on 3/1/18.
 */

@Entity(tableName = DataBaseConstants.REPOSITORY_TABLE_NAME)
data class Repository(
        @PrimaryKey val id: Int,
        val name: String,
        val full_name: String,
        var owner: Owner,
        val description: String?,
        val private: Boolean,
        val html_url: String,
        val fork: Boolean,
        val url: String,
        val forks_url: String,
        val keys_url: String,
        val collaborators_url: String,
        val teams_url: String,
        val hooks_url: String,
        val issue_events_url: String,
        val events_url: String,
        val assignees_url: String,
        val branches_url: String,
        val tags_url: String,
        val blobs_url: String,
        val git_tags_url: String,
        val git_refs_url: String,
        val trees_url: String,
        val statuses_url: String,
        val languages_url: String,
        val stargazers_url: String,
        val contributors_url: String,
        val subscribers_url: String,
        val subscription_url: String,
        val commits_url: String,
        val git_commits_url: String,
        val comments_url: String,
        val issue_comment_url: String,
        val contents_url: String,
        val compare_url: String,
        val merges_url: String,
        val archive_url: String,
        val downloads_url: String,
        val issues_url: String,
        val pulls_url: String,
        val milestones_url: String,
        val notifications_url: String,
        val labels_url: String,
        val releases_url: String,
        val deployments_url: String,
        val created_at: String,
        val updated_at: String,
        val pushed_at: String,
        val git_url: String,
        val ssh_url: String,
        val clone_url: String,
        val svn_url: String,
        val size: Int,
        val stargazers_count: Int,
        val watchers_count: Int,
        val language: String,
        val has_issues: Boolean,
        val has_projects: Boolean,
        val has_downloads: Boolean,
        val has_wiki: Boolean,
        val has_pages: Boolean,
        val forks_count: Int,
        val archived: Boolean,
        val open_issues_count: Int,
        val forks: Int,
        val open_issues: Int,
        val watchers: Int,
        val default_branch: String
)

