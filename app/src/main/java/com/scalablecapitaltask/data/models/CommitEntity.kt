package com.scalablecapitaltask.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by ziadgholmish on 3/2/18.
 */
data class CommitEntity(
        @SerializedName("commit") val commit: CommitInfo)

data class CommitInfo(
        @SerializedName("author") val author: Author,
        @SerializedName("committer") val committer: Committer,
        @SerializedName("message") val message: String,
        @SerializedName("url") val url: String)

data class Author(
        @SerializedName("name") val name: String,
        @SerializedName("email") val email: String)

data class Committer(
        @SerializedName("name") val name: String,
        @SerializedName("email") val email: String)
