package com.scalablecapitaltask.presentation.views.repositorieslist

import com.scalablecapitaltask.data.models.RepositoryEntity
import com.scalablecapitaltask.domain.models.RepositoryModel

/**
 * Created by ziadgholmish on 2/26/18.
 */
interface RepositoriesListContract {

    interface View {

        fun showLoading()

        fun hideLoading()

        fun showError(errorMessage: String)

        fun showNoData()

        fun showRepositories(repos: List<RepositoryModel>)
    }

    interface Actions {

        fun getRepositories()
    }
}