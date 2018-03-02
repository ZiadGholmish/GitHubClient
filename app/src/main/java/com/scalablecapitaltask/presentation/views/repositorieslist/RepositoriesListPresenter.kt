package com.scalablecapitaltask.presentation.views.repositorieslist

import android.content.Context
import android.telecom.Call
import android.util.Log
import com.scalablecapitaltask.app.AbsPresenter
import com.scalablecapitaltask.data.LoadRepositoriesCallback
import com.scalablecapitaltask.data.models.Repository
import com.scalablecapitaltask.utils.DependencyUtil
import kotlinx.android.synthetic.main.activity_repositories_list_acitivty.*

/**
 * Created by ziadgholmish on 2/26/18.
 */

class RepositoriesListPresenter(context: Context) : AbsPresenter<RepositoriesListContract.View>(), RepositoriesListContract.Actions {

    private val gitHubClientRepository = DependencyUtil.provideGitHubRepository(context)

    override fun getRepositories() {
        mView?.showLoading()
        gitHubClientRepository.getRepositories(object : LoadRepositoriesCallback {
            override fun onRepositoriesLoaded(repos: List<Repository>) {
                mView?.hideLoading()
                mView?.showRepositories(repos)
            }

            override fun onError() {
                mView?.hideLoading()
                mView?.showError("")
            }

            override fun onDataNotAvailable() {
                mView?.hideLoading()
                mView?.showNoData()
            }
        })
    }

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
    }
}