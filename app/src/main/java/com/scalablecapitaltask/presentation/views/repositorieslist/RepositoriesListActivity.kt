package com.scalablecapitaltask.presentation.views.repositorieslist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.scalablecapitaltask.R
import com.scalablecapitaltask.data.LoadRepositoriesCallback
import com.scalablecapitaltask.data.local.LocalDataSource
import com.scalablecapitaltask.data.models.Repository
import com.scalablecapitaltask.data.remote.network.RemoteDataSource
import com.scalablecapitaltask.data.repository.GitHubClientRepository
import com.scalablecapitaltask.utils.DependencyUtil
import kotlinx.android.synthetic.main.activity_repositories_list_acitivty.*

class RepositoriesListActivity : AppCompatActivity(), RepositoriesListContract.View {

    private var mPresenter: RepositoriesListPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repositories_list_acitivty)
        mPresenter = RepositoriesListPresenter(applicationContext)
        mPresenter?.attachView(this)
    }

    override fun showError() {
    }

    override fun showNoData() {
    }

    override fun showRepositories(repos: List<Repository>) {
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

}
