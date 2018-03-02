package com.scalablecapitaltask.data.remote.network

import com.scalablecapitaltask.data.LoadRepositoriesCallback
import com.scalablecapitaltask.data.models.RepositoryEntity
import com.scalablecapitaltask.data.repository.GitHubClientDataSource

/**
 * Created by ziadgholmish on 3/1/18.
 */
class RemoteDataSource : GitHubClientDataSource {

    companion object {
        private var instance: RemoteDataSource? = null
        fun getRemoteInstance(): RemoteDataSource {
            if (instance == null) {
                instance = RemoteDataSource()
            }
            return instance as RemoteDataSource
        }
    }

    override fun getRepositories(callback: LoadRepositoriesCallback) {
        RepositoriesWebService(callback).execute()
    }

    override fun saveRepositories(repositories: List<RepositoryEntity>) {
    }
    override fun refreshRepositories() {
    }

    override fun deleteAllRepositories() {
    }
}