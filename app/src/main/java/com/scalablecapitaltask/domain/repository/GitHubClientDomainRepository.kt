package com.scalablecapitaltask.domain.repository

import com.scalablecapitaltask.data.LoadCommitsCallback
import com.scalablecapitaltask.domain.callbacks.FetchRepositoriesCallback

/**
 * Created by ziadgholmish on 3/2/18.
 */

interface GitHubClientDomainRepository {

    fun getRepositories(callback: FetchRepositoriesCallback)

    fun getCommits(callback: LoadCommitsCallback, userName: String, repoName: String)
}