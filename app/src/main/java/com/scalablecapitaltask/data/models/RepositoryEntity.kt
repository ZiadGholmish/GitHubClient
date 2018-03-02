package com.scalablecapitaltask.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.scalablecapitaltask.constants.DataBaseConstants

/**
 * Created by ziadgholmish on 3/1/18.
 */

@Entity(tableName = DataBaseConstants.REPOSITORY_TABLE_NAME)
data class RepositoryEntity(
        @SerializedName("id") @PrimaryKey val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("full_name") val full_name: String,
        @SerializedName("owner") var owner: OwnerEntity,
        @SerializedName("description") val description: String?,
        @SerializedName("private") val private: Boolean,
        @SerializedName("html_url") val html_url: String,
        @SerializedName("fork") val fork: Boolean,
        @SerializedName("url") val url: String,
        @SerializedName("tags_url") val tags_url: String,
        @SerializedName("created_at") val created_at: String,
        @SerializedName("updated_at") val updated_at: String,
        @SerializedName("pushed_at") val pushed_at: String,
        @SerializedName("size") val size: Int,
        @SerializedName("stargazers_count") val stargazers_count: Int,
        @SerializedName("watchers_count") val watchers_count: Int,
        @SerializedName("language") val language: String,
        @SerializedName("has_issues") val has_issues: Boolean,
        @SerializedName("has_projects") val has_projects: Boolean,
        @SerializedName("has_downloads") val has_downloads: Boolean,
        @SerializedName("has_wiki") val has_wiki: Boolean,
        @SerializedName("has_pages") val has_pages: Boolean,
        @SerializedName("forks_count") val forks_count: Int,
        @SerializedName("archived") val archived: Boolean,
        @SerializedName("open_issues_count") val open_issues_count: Int,
        @SerializedName("forks") val forks: Int,
        @SerializedName("open_issues") val open_issues: Int,
        @SerializedName("watchers") val watchers: Int,
        @SerializedName("default_branch") val default_branch: String
)

