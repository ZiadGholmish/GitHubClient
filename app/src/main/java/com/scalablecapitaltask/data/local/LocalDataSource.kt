package com.scalablecapitaltask.data.local

import com.scalablecapitaltask.data.LoadRepositoriesCallback
import com.scalablecapitaltask.data.models.Repository
import com.scalablecapitaltask.data.remote.network.RemoteDataSource
import com.scalablecapitaltask.data.repository.GitHubClientDataSource
import com.scalablecapitaltask.utils.AppExecutors

/**
 * Created by ziadgholmish on 3/1/18.
 */
class LocalDataSource(private val appExecutors: AppExecutors, private val repositoryDAO: RepositoryDAO) : GitHubClientDataSource {

    companion object {
        private var instance: LocalDataSource? = null
        fun getLocalInstance(appExecutors: AppExecutors, repositoryDAO: RepositoryDAO): LocalDataSource {
            if (instance == null) {
                instance = LocalDataSource(appExecutors, repositoryDAO)
            }
            return instance as LocalDataSource
        }
    }

    override fun getRepositories(callback: LoadRepositoriesCallback) {
        checkNotNull(callback)
        val runnable = Runnable {
            val repositories = repositoryDAO.getRepositories()
            appExecutors.mainThread.execute({
                if (!repositories.isEmpty()) {
                    callback.onRepositoriesLoaded(repositories)
                } else {
                    callback.onDataNotAvailable()
                }
            })
        }
        appExecutors.diskIO.execute(runnable)
    }

    override fun saveRepositories(repositories: List<Repository>) {
        val runnable = Runnable {
            repositories.forEach {
                repositoryDAO.insertRepository(it)
            }
        }
        appExecutors.diskIO.execute(runnable)
    }

    override fun refreshRepositories() {
    }

    override fun deleteAllRepositories() {
    }
}