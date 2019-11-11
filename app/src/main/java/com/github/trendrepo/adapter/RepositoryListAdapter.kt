package com.github.trandrepo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.trendrepo.R
import com.github.trendrepo.databinding.ItemRepositoryBinding
import com.github.trendrepo.room.Repository
import com.github.trendrepo.viewmodel.RepositoryViewModel

class RepositoryListAdapter : RecyclerView.Adapter<RepositoryListAdapter.ViewHolder>() {
    private lateinit var postList: List<Repository>
    private var clickedNode: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryListAdapter.ViewHolder {
        val binding: ItemRepositoryBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_repository,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (clickedNode != -1 && clickedNode == position) {
            holder.bind(postList[position], true)
        } else {
            holder.bind(postList[position], false)
        }
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (position == clickedNode) {
                    clickedNode = -1;
                } else {
                    clickedNode = position
                }
                notifyDataSetChanged()
            }
        })
    }

    override fun getItemCount(): Int {
        return if (::postList.isInitialized) postList.size else 0
    }

    fun updatePostList(postList: List<Repository>) {
        this.postList = postList
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemRepositoryBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = RepositoryViewModel()
        fun bind(repository: Repository, isExpended: Boolean) {
            viewModel.bind(repository, binding, isExpended)
            binding.viewModel = viewModel
        }

    }
}