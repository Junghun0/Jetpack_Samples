package com.fishing.paging_sample_app.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fishing.paging_sample_app.R
import com.fishing.paging_sample_app.model.Repo

class ReposAdapter : ListAdapter<Repo, ReposAdapter.RepoViewHolder>(REPO_COMPARATOR) {

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Repo>() {
            override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean =
                oldItem.fullName == newItem.fullName


            override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean =
                oldItem == newItem

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposAdapter.RepoViewHolder {
        return RepoViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ReposAdapter.RepoViewHolder, position: Int) {
        val repoItem = getItem(position)
        if (repoItem != null) {
            holder.bind(repoItem)
        }
    }

    inner class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.repo_name)
        private val description: TextView = view.findViewById(R.id.repo_description)
        private val stars: TextView = view.findViewById(R.id.repo_stars)
        private val language: TextView = view.findViewById(R.id.repo_language)
        private val forks: TextView = view.findViewById(R.id.repo_forks)

        private var repo: Repo? = null

        init {
            view.setOnClickListener {
                repo?.url?.let {url ->
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    view.context.startActivity(intent)
                }
            }
        }

        fun create(parent: ViewGroup): RepoViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.repo_view_item, parent, false)
            return RepoViewHolder(view)
        }

        fun bind(repo: Repo?) {
            if (repo == null) {
                val resource = itemView.resources
                name.text = resource.getString(R.string.loading)
                description.visibility = View.GONE
                language.visibility = View.GONE
                stars.text = resource.getString(R.string.unknown)
                forks.text = resource.getString(R.string.unknown)
            } else {
                showRepoData(repo)
            }
        }

        private fun showRepoData(repo: Repo) {
            this.repo = repo
            name.text = repo.fullName

            var descriptionVisibility = View.GONE
            if (repo.description != null) {
                description.text = repo.description
                descriptionVisibility = View.VISIBLE
            }
            description.visibility = descriptionVisibility

            stars.text = repo.stars.toString()
            forks.text = repo.forks.toString()

            var languageVisibility = View.GONE
            if (!repo.language.isNullOrEmpty()) {
                val resource = this.itemView.context.resources
                language.text = resource.getString(R.string.language, repo.language)
                languageVisibility = View.VISIBLE
            }
            language.visibility = languageVisibility
        }
    }


}