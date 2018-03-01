package com.scalablecapitaltask.data.repository

import android.util.Log
import com.scalablecapitaltask.data.LoadRepositoriesCallback
import com.scalablecapitaltask.data.local.LocalDataSource
import com.scalablecapitaltask.data.models.Repository
import com.scalablecapitaltask.data.remote.network.RemoteDataSource

/**
 * Created by ziadgholmish on 3/1/18.
 */
class GitHubClientRepository(private val remoteDataSource: RemoteDataSource,
                             private val localDataSource: LocalDataSource) : GitHubClientDataSource {

    companion object {
        private var instance: GitHubClientRepository? = null
        fun getInstance(remoteDataSource: RemoteDataSource,
                        localDataSource: LocalDataSource): GitHubClientRepository {
            if (instance == null) {
                instance = GitHubClientRepository(remoteDataSource, localDataSource)
            }
            return instance as GitHubClientRepository
        }
    }

    override fun getRepositories(callback: LoadRepositoriesCallback) {
        checkNotNull(callback)
        localDataSource.getRepositories(object : LoadRepositoriesCallback {
            override fun onRepositoriesLoaded(repos: List<Repository>) {
                callback.onRepositoriesLoaded(repos)
                getRepositoriesFromRemoteDataSource(callback)
            }

            override fun onError() {
                callback.onError()
            }

            override fun onDataNotAvailable() {
                getRepositoriesFromRemoteDataSource(callback)
            }
        })
    }

    override fun saveRepositories(repositories: List<Repository>) {
    }

    override fun refreshRepositories() {
    }

    override fun deleteAllRepositories() {
    }

    private fun getRepositoriesFromRemoteDataSource(callback: LoadRepositoriesCallback) {
        checkNotNull(callback)
        remoteDataSource.getRepositories(object : LoadRepositoriesCallback {
            override fun onRepositoriesLoaded(repos: List<Repository>) {
                localDataSource.saveRepositories(repos)
                callback.onRepositoriesLoaded(repos)
            }

            override fun onError() {
                callback.onError()
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }


}