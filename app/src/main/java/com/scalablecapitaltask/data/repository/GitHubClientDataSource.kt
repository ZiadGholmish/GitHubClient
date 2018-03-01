package com.scalablecapitaltask.data.repository

import com.scalablecapitaltask.data.LoadRepositoriesCallback
import com.scalablecapitaltask.data.models.Repository

/**
 * Created by ziadgholmish on 3/1/18.
 */

interface GitHubClientDataSource {

    fun getRepositories(callback: LoadRepositoriesCallback)

    fun saveRepositories(repositories: List<Repository>)

    fun refreshRepositories()

    fun deleteAllRepositories()
}
