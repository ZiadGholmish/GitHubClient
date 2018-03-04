package com.scalablecapitaltask.presentation.views.repositorieslist

import android.content.Context
import com.scalablecapitaltask.app.AbsPresenter
import com.scalablecapitaltask.data.LoadCommitsCallback
import com.scalablecapitaltask.data.models.CommitEntity
import com.scalablecapitaltask.domain.callbacks.FetchRepositoriesCallback
import com.scalablecapitaltask.domain.interactors.GetCommitsUseCase
import com.scalablecapitaltask.domain.interactors.GetRepositoriesUseCase
import com.scalablecapitaltask.domain.models.RepositoryModel

/**
 * Created by ziadgholmish on 2/26/18.
 */

class RepositoriesListPresenter(private val context: Context) : AbsPresenter<RepositoriesListContract.View>(), RepositoriesListContract.Actions {

    lateinit var mRepos: List<RepositoryModel>
    override fun getRepositories() {
        mView?.showLoading()
        GetRepositoriesUseCase(context).getRepositories(object : FetchRepositoriesCallback {
            override fun onRepositoriesLoaded(repos: List<RepositoryModel>) {
                mRepos = repos
                mView?.hideLoading()
                mView?.showRepositories(mRepos)
                loadCommits(mRepos)
            }

            override fun onError(throwable: Throwable) {
                mView?.hideLoading()
                mView?.showError(throwable.localizedMessage)
            }

            override fun onDataNotAvailable() {
                mView?.hideLoading()
                mView?.showNoData()
            }
        })
    }

    private fun loadCommits(repos: List<RepositoryModel>) {
        repos.forEach { repository ->
            GetCommitsUseCase(context).getCommits(object : LoadCommitsCallback {
                override fun onCommitsLoaded(commits: List<CommitEntity>) {
                    updateRepoWithLastCommit(commits.first())
                }

                override fun onError(throwable: Throwable) {
                }

                override fun onDataNotAvailable() {
                }
            }, repository.owner_login, repository.name)
        }
    }

    private fun updateRepoWithLastCommit(commit: CommitEntity) {
        for (i in mRepos.indices) {
            if (commit.commit.url.contains(mRepos[i].name, true)
                    && mRepos[i].commit == null) {
                mRepos[i].commit = commit
                mView?.notifyAdapterForCommitAdded(i, commit)
                break
            }
        }
    }

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
    }

}