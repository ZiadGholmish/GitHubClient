package com.scalablecapitaltask.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by ziadgholmish on 3/1/18.
 */
data class OwnerEntity(
        @SerializedName("login") val login: String,
        @SerializedName("id") val id: Int,
        @SerializedName("avatar_url") val avatar_url: String,
        @SerializedName("gravatar_id") val gravatar_id: String,
        @SerializedName("url") val url: String,
        @SerializedName("repos_url") val repos_url: String,
        @SerializedName("site_admin") val site_admin: Boolean
)