package com.scalablecapitaltask.domain.models

import com.scalablecapitaltask.data.models.CommitEntity

/**
 * Created by ziadgholmish on 3/2/18.
 */
data class RepositoryModel(
        val name: String,
        val full_name: String,
        val description: String,
        val language: String,
        val fork: Boolean,
        val url: String,
        val created_at: String,
        val updated_at: String,
        val pushed_at: String,
        val owner_login: String,
        val owner_avatar_url: String,
        val owner_gravatar_id: String,
        val owner_url: String,
        val owner_repos_url: String ,
        var commit: CommitEntity?
        )