package com.scalablecapitaltask.data.local

import com.scalablecapitaltask.data.LoadCommitsCallback
import com.scalablecapitaltask.data.LoadRepositoriesCallback
import com.scalablecapitaltask.data.models.RepositoryEntity
import com.scalablecapitaltask.data.repository.GitHubClientDataSource
import com.scalablecapitaltask.utils.AppExecutors

/**
 * Created by ziadgholmish on 3/1/18.
 */
class LocalDataSource(private val appExecutors: AppExecutors, private val repositoryDAO: RepositoryDAO) : GitHubClientDataSource {

    /**
     * get one instance from local data source, i can use dagger2 here to manage the dependencies
     */
    companion object {
        private var instance: LocalDataSource? = null
        fun getLocalInstance(appExecutors: AppExecutors, repositoryDAO: RepositoryDAO): LocalDataSource {
            if (instance == null) {
                instance = LocalDataSource(appExecutors, repositoryDAO)
            }
            return instance as LocalDataSource
        }
    }

    /**
     * get the available repositories from the local database in background thread
     * then populate the results in the main thread
     */
    override fun getRepositories(callback: LoadRepositoriesCallback) {
        checkNotNull(callback)
        val runnable = Runnable {
            val repositories = repositoryDAO.getRepositories()
            appExecutors.mainThread.execute(
                    {
                        if (!repositories.isEmpty()) {
                            callback.onRepositoriesLoaded(repositories)
                        } else {
                            callback.onDataNotAvailable()
                        }
                    }
            )
        }
        appExecutors.diskIO.execute(runnable)
    }

    /**
     * save the repositories in the database and update the old data
     */
    override fun saveRepositories(repositories: List<RepositoryEntity>) {
        val runnable = Runnable {
            repositories.forEach { repository ->
                repositoryDAO.insertRepository(repository)
            }
        }
        appExecutors.diskIO.execute(runnable)
    }

    /**
     * we do not use it here as for now we do not save the commits for the repository
     */
    override fun getCommits(callback: LoadCommitsCallback, userName: String, repoName: String) {
    }

    override fun refreshRepositories() {
    }

    override fun deleteAllRepositories() {
    }
}