package com.scalablecapitaltask.data.repository

import com.scalablecapitaltask.data.LoadCommitsCallback
import com.scalablecapitaltask.data.LoadRepositoriesCallback
import com.scalablecapitaltask.data.local.LocalDataSource
import com.scalablecapitaltask.data.mapper.RepositoryEntityToModelMapper
import com.scalablecapitaltask.data.models.CommitEntity
import com.scalablecapitaltask.data.models.RepositoryEntity
import com.scalablecapitaltask.data.remote.RemoteDataSource
import com.scalablecapitaltask.domain.repository.GitHubClientDomainRepository
import com.scalablecapitaltask.domain.callbacks.FetchRepositoriesCallback

/**
 * Created by ziadgholmish on 3/1/18.
 */
class GitHubClientRepository(private val remoteDataSource: RemoteDataSource,
                             private val localDataSource: LocalDataSource) : GitHubClientDomainRepository {

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

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
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

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }

    override fun getCommits(callback: LoadCommitsCallback, userName: String, repoName: String) {
        checkNotNull(callback)
        checkNotNull(userName)
        checkNotNull(repoName)
        remoteDataSource.getCommits(object : LoadCommitsCallback {
            override fun onCommitsLoaded(commits: List<CommitEntity>) {
                if (!commits.isEmpty()) {
                    callback.onCommitsLoaded(commits)
                } else {
                    callback.onDataNotAvailable()
                }
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        }, userName, repoName)
    }

}