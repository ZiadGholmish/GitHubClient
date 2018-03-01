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

class RepositoriesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repositories_list_acitivty)

        val gitHubClientRepository = DependencyUtil.provideGitHubRepository(applicationContext)
        gitHubClientRepository.getRepositories(object : LoadRepositoriesCallback {
            override fun onRepositoriesLoaded(repos: List<Repository>) {
                var builder = StringBuilder()
                repos.forEach {
                    Log.e("repo name", it.name)
                    builder.append(it.name)
                }
                repo_names.text = builder.toString()
            }

            override fun onError() {
            }

            override fun onDataNotAvailable() {
            }
        })
    }

}
