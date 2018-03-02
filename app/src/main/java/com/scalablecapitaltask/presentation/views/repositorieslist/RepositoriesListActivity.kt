package com.scalablecapitaltask.presentation.views.repositorieslist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.scalablecapitaltask.R
import com.scalablecapitaltask.data.models.CommitEntity
import com.scalablecapitaltask.data.models.RepositoryEntity
import com.scalablecapitaltask.domain.models.RepositoryModel
import kotlinx.android.synthetic.main.repositories_content_layout.*

class RepositoriesListActivity : AppCompatActivity(), RepositoriesListContract.View {

    private var mPresenter: RepositoriesListPresenter? = null
    lateinit var adapter: RepositoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repositories_list_acitivty)
        mPresenter = RepositoriesListPresenter(applicationContext)
        mPresenter?.attachView(this)
        mPresenter?.getRepositories()
    }

    override fun showError(errorMessage: String) {
        val snackBar = Snackbar
                .make(repositories_recycler, errorMessage, Snackbar.LENGTH_LONG)
        snackBar.show()
    }

    override fun showNoData() {
        tv_empty_label.visibility = View.VISIBLE
    }

    override fun showRepositories(repos: List<RepositoryModel>) {
        adapter = RepositoriesAdapter(repos, applicationContext)
        val layoutManager = LinearLayoutManager(applicationContext)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        repositories_recycler.layoutManager = layoutManager
        repositories_recycler.adapter = adapter
    }

    override fun showLoading() {
        repos_loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        repos_loading.visibility = View.GONE
    }


    override fun notifyAdapterForCommitAdded(position: Int, commitEntity: CommitEntity) {
        adapter.notifyItemChanged(position)
        adapter.updateRepoWithCommit(position, commitEntity)
    }

}
