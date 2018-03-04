package com.scalablecapitaltask.data

import com.scalablecapitaltask.data.models.CommitEntity
import com.scalablecapitaltask.data.models.RepositoryEntity

/**
 * Created by ziadgholmish on 3/2/18.
 */
interface LoadCommitsCallback {

    /**
     * called when there is data to show
     */
    fun onCommitsLoaded(commits: List<CommitEntity>)

    /**
     * when error occurred
     */
    fun onError(throwable: Throwable)

    /**
     * will be called when there is no data
     */
    fun onDataNotAvailable()
}