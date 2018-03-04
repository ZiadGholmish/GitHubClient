package com.scalablecapitaltask.data

import com.scalablecapitaltask.data.models.RepositoryEntity

/**
 * Created by ziadgholmish on 3/1/18.
 */
interface LoadRepositoriesCallback {

    /**
     * will be called when there is data
     */
    fun onRepositoriesLoaded(repos: List<RepositoryEntity>)

    /**
     * when error occurred
     */
    fun onError(throwable: Throwable)

    /**
     * will be called when there is no data
     */
    fun onDataNotAvailable()
}