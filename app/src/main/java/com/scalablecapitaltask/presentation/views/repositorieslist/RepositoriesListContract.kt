package com.scalablecapitaltask.presentation.views.repositorieslist

import com.scalablecapitaltask.data.models.Repository

/**
 * Created by ziadgholmish on 2/26/18.
 */
interface RepositoriesListContract {

    interface View {

        fun showLoading()

        fun hideLoading()

        fun showError()

        fun showNoData()

        fun showRepositories(repos: List<Repository>)
    }

    interface Actions {

        fun getRepositories()
    }
}