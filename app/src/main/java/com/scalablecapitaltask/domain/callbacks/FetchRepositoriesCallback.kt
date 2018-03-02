package com.scalablecapitaltask.domain.callbacks

import com.scalablecapitaltask.data.models.RepositoryEntity
import com.scalablecapitaltask.domain.models.RepositoryModel

/**
 * Created by ziadgholmish on 3/2/18.
 */
interface FetchRepositoriesCallback {

    fun onRepositoriesLoaded(repos: List<RepositoryModel>)

    fun onError()

    fun onDataNotAvailable()
}