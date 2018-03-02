package com.scalablecapitaltask.domain.interactors

import android.content.Context
import com.scalablecapitaltask.data.LoadCommitsCallback
import com.scalablecapitaltask.domain.callbacks.FetchRepositoriesCallback
import com.scalablecapitaltask.utils.DependencyUtil

/**
 * Created by ziadgholmish on 3/2/18.
 */
class GetCommitsUseCase(context: Context) {
    private val gitHubClientRepository = DependencyUtil.provideGitHubRepository(context)
    fun getCommits(callback: LoadCommitsCallback, userName: String, repoName: String) {
        gitHubClientRepository.getCommits(callback, userName, repoName)
    }
}