package com.scalablecapitaltask.data.repository

import com.scalablecapitaltask.data.LoadRepositoriesCallback
import com.scalablecapitaltask.data.models.RepositoryEntity

/**
 * Created by ziadgholmish on 3/1/18.
 */

interface GitHubClientDataSource {

    fun getRepositories(callback: LoadRepositoriesCallback)

    fun saveRepositories(repositories: List<RepositoryEntity>)

    fun refreshRepositories()

    fun deleteAllRepositories()
}
