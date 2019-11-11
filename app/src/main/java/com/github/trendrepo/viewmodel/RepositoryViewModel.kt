package com.github.trendrepo.viewmodel

import com.github.trendrepo.base.BaseViewModel
import com.github.trendrepo.databinding.ItemRepositoryBinding
import com.github.trendrepo.room.Repository

class RepositoryViewModel : BaseViewModel() {
    var repository: Repository? = null
    var isExpanded: Boolean = false

    fun bind(
        repository: Repository,
        binding: ItemRepositoryBinding,
        expended: Boolean
    ) {
        repository.languageColor?.let { binding.circularView.setSolidColor(it) }
        this.repository = repository;
        this.isExpanded = expended
    }

}