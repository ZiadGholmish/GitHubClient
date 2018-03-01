package com.scalablecapitaltask.utils

import android.content.Context
import com.scalablecapitaltask.data.local.GitHubClientDataBase
import com.scalablecapitaltask.data.local.LocalDataSource
import com.scalablecapitaltask.data.remote.network.RemoteDataSource
import com.scalablecapitaltask.data.repository.GitHubClientRepository

/**
 * Created by ziadgholmish on 3/1/18.
 */
class DependencyUtil {

    companion object {
        fun provideGitHubRepository(context: Context): GitHubClientRepository {
            checkNotNull(context)
            val database = GitHubClientDataBase.getInstance(context)
            return GitHubClientRepository.getInstance(RemoteDataSource.getRemoteInstance(),
                    LocalDataSource.getLocalInstance(AppExecutors(),
                            database.repositoryDAO()))
        }
    }

}