package com.scalablecapitaltask.presentation.views.repositorieslist

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.scalablecapitaltask.R
import com.scalablecapitaltask.data.models.CommitEntity
import com.scalablecapitaltask.data.models.RepositoryEntity
import com.scalablecapitaltask.domain.models.RepositoryModel
import com.scalablecapitaltask.utils.GithubDateUtils

/**
 * Created by ziadgholmish on 3/2/18.
 */
class RepositoriesAdapter(private val repos: List<RepositoryModel>, val context: Context) : RecyclerView.Adapter<RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.repo_item_layout, parent, false)
        return RepositoryViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bindData(repos[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    fun updateRepoWithCommit(position: Int, commitEntity: CommitEntity) {
        repos[position].commit = commitEntity
        notifyItemChanged(position)
    }
}