package com.scalablecapitaltask.data

import com.scalablecapitaltask.data.models.RepositoryEntity

/**
 * Created by ziadgholmish on 3/1/18.
 */
interface LoadRepositoriesCallback{

    fun onRepositoriesLoaded(repos: List<RepositoryEntity>)

    fun onError()

    fun onDataNotAvailable()
}