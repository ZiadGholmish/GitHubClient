package com.scalablecapitaltask.data

import com.scalablecapitaltask.data.models.CommitEntity
import com.scalablecapitaltask.data.models.RepositoryEntity

/**
 * Created by ziadgholmish on 3/2/18.
 */
interface LoadCommitsCallback {

    fun onCommitsLoaded(commits: List<CommitEntity>)

    fun onError()

    fun onDataNotAvailable()
}