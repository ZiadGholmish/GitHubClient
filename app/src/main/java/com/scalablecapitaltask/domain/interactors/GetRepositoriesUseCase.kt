package com.scalablecapitaltask.domain.interactors

import android.content.Context
import com.scalablecapitaltask.domain.callbacks.FetchRepositoriesCallback
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