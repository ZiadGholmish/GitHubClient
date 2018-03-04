package com.scalablecapitaltask.presentation.views.repositorieslist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.scalablecapitaltask.R
import com.scalablecapitaltask.domain.models.RepositoryModel
import com.scalablecapitaltask.utils.GithubDateUtils

/**
 * Created by ziadgholmish on 3/2/18.
 */
class RepositoryViewHolder(view: View, private val context: Context) : RecyclerView.ViewHolder(view) {

    private val tvRepoName: TextView = view?.findViewById(R.id.tv_repo_name)
    private val tvRepoDesc: TextView = view?.findViewById(R.id.tv_repo_desc)
    private val tvRepoLangName: TextView = view?.findViewById(R.id.tv_repo_lang_name)
    private val tvRepoLastUpdated: TextView = view?.findViewById(R.id.tv_repo_last_updated)
    private val tvRepoLastCommit: TextView = view?.findViewById(R.id.tv_repo_last_commit)

    fun bindData(repository: RepositoryModel) {
        tvRepoName.text = repository.name
        if (repository.description.isNotBlank()) {
            tvRepoDesc.visibility = View.VISIBLE
            tvRepoDesc.text = repository.description
        } else {
            tvRepoDesc.visibility = View.GONE
        }
        tvRepoLangName.text = repository.language
        tvRepoLastUpdated.text = String.format(context.getString(R.string.updated_at_string),
                GithubDateUtils.getFormattedDate(repository.updated_at))

        if (repository.commit != null) {
            tvRepoLastCommit.text = repository.commit?.commit?.message
        }
    }
}