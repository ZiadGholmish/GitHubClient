package com.scalablecapitaltask.data

import com.scalablecapitaltask.data.models.Repository

/**
 * Created by ziadgholmish on 3/1/18.
 */
interface LoadRepositoriesCallback{

    fun onRepositoriesLoaded(repos: List<Repository>)

    fun onError()

    fun onDataNotAvailable()
}