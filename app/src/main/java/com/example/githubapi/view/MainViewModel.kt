package com.example.githubapi.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubapi.model.IssueItem
import com.example.githubapi.repository.RepositoryGitHub
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class MainViewModel: ViewModel() {

    var _issuesList = MutableLiveData<List<IssueItem>>()

    val issueList: LiveData<List<IssueItem>>
        get() = _issuesList

    private val repository = RepositoryGitHub()

    fun getAllIssues() = CoroutineScope(Dispatchers.IO).launch {
        repository.getGitHubKotlinIssues().let {
            _issuesList.postValue(it)
        }

        }
}