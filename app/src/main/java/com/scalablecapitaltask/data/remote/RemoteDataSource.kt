package com.scalablecapitaltask.data.remote

import com.scalablecapitaltask.data.LoadCommitsCallback
import com.scalablecapitaltask.data.LoadRepositoriesCallback
import com.scalablecapitaltask.data.models.RepositoryEntity
import com.scalablecapitaltask.data.remote.commits.CommitWebService
import com.scalablecapitaltask.data.remote.repositories.RepositoriesWebService
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

    override fun getCommits(callback: LoadCommitsCallback, userName: String, repoName: String) {
        CommitWebService(callback, userName, repoName).execute()
    }

    override fun saveRepositories(repositories: List<RepositoryEntity>) {
    }

    override fun refreshRepositories() {
    }

    override fun deleteAllRepositories() {
    }

}