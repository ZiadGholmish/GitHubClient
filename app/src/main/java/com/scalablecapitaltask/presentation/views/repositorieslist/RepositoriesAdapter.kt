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
class RepositoriesAdapter(private val repos: List<RepositoryModel>, val context: Context) : RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.repo_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentRepo = repos[holder.adapterPosition]
        holder.tvRepoName.text = currentRepo.full_name
        holder.tvRepoDesc.text = currentRepo.description
        holder.tvRepoLangName.text = currentRepo.language
        holder.tvRepoLastUpdated.text = String.format(context.getString(R.string.updated_at_string), GithubDateUtils.getFormattedDate(currentRepo.updated_at))

        if (currentRepo.commit != null) {
            holder.tvRepoLastCommit.text = currentRepo.commit?.commit?.message
        }
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvRepoName: TextView = view?.findViewById(R.id.tv_repo_name)
        val tvRepoDesc: TextView = view?.findViewById(R.id.tv_repo_desc)
        val tvRepoLangName: TextView = view?.findViewById(R.id.tv_repo_lang_name)
        val tvRepoLastUpdated: TextView = view?.findViewById(R.id.tv_repo_last_updated)
        val tvRepoLastCommit: TextView = view?.findViewById(R.id.tv_repo_last_commit)
    }

    fun updateRepoWithCommit(position: Int, commitEntity: CommitEntity) {
        repos[position].commit = commitEntity
        notifyItemChanged(position)
    }
}