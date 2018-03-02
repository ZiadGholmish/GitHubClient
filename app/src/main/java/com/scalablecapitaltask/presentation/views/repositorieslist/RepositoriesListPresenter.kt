package com.scalablecapitaltask.presentation.views.repositorieslist

import android.content.Context
import com.scalablecapitaltask.app.AbsPresenter
import com.scalablecapitaltask.data.LoadRepositoriesCallback
import com.scalablecapitaltask.data.models.RepositoryEntity
import com.scalablecapitaltask.domain.FetchRepositoriesCallback
import com.scalablecapitaltask.domain.interactors.GetRepositoriesUseCase
import com.scalablecapitaltask.domain.models.RepositoryModel
import com.scalablecapitaltask.utils.DependencyUtil

/**
 * Created by ziadgholmish on 2/26/18.
 */

class RepositoriesListPresenter(private val context: Context) : AbsPresenter<RepositoriesListContract.View>(), RepositoriesListContract.Actions {

    override fun getRepositories() {
        mView?.showLoading()
        GetRepositoriesUseCase(context).getRepositories(object : FetchRepositoriesCallback {
            override fun onRepositoriesLoaded(repos: List<RepositoryModel>) {
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