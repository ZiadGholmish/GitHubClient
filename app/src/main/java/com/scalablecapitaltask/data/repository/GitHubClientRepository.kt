package com.scalablecapitaltask.data.repository

import com.scalablecapitaltask.data.LoadRepositoriesCallback
import com.scalablecapitaltask.data.local.LocalDataSource
import com.scalablecapitaltask.data.mapper.RepositoryEntityToModelMapper
import com.scalablecapitaltask.data.models.RepositoryEntity
import com.scalablecapitaltask.data.remote.network.RemoteDataSource
import com.scalablecapitaltask.domain.DomainRepo
import com.scalablecapitaltask.domain.FetchRepositoriesCallback

/**
 * Created by ziadgholmish on 3/1/18.
 */
class GitHubClientRepository(private val remoteDataSource: RemoteDataSource,
                             private val localDataSource: LocalDataSource) : DomainRepo {

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

    override fun getRepositories(callback: FetchRepositoriesCallback) {
        checkNotNull(callback)
        localDataSource.getRepositories(object : LoadRepositoriesCallback {
            override fun onRepositoriesLoaded(repos: List<RepositoryEntity>) {
                callback.onRepositoriesLoaded(repos.map { RepositoryEntityToModelMapper.transform(it) })
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

    private fun getRepositoriesFromRemoteDataSource(callback: FetchRepositoriesCallback) {
        checkNotNull(callback)
        remoteDataSource.getRepositories(object : LoadRepositoriesCallback {
            override fun onRepositoriesLoaded(repos: List<RepositoryEntity>) {
                localDataSource.saveRepositories(repos)
                callback.onRepositoriesLoaded(repos.map { RepositoryEntityToModelMapper.transform(it) })
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