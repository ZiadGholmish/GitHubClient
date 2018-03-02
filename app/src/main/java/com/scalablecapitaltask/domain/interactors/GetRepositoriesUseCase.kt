package com.scalablecapitaltask.domain.interactors

import android.content.Context
import com.scalablecapitaltask.data.LoadRepositoriesCallback
import com.scalablecapitaltask.data.local.LocalDataSource
import com.scalablecapitaltask.data.models.RepositoryEntity
import com.scalablecapitaltask.data.remote.network.RemoteDataSource
import com.scalablecapitaltask.data.repository.GitHubClientRepository
import com.scalablecapitaltask.domain.FetchRepositoriesCallback
import com.scalablecapitaltask.utils.DependencyUtil

/**
 * Created by ziadgholmish on 3/2/18.
 */
class GetRepositoriesUseCase(context: Context) {
    private val gitHubClientRepository = DependencyUtil.provideGitHubRepository(context)
    fun getRepositories(callback: FetchRepositoriesCallback) {
        gitHubClientRepository.getRepositories(callback)
    }
}