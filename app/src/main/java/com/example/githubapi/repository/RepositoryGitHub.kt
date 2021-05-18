package com.example.githubapi.repository

import com.example.githubapi.model.Issues
import com.example.githubapi.network.GitHubAPI
import com.example.githubapi.network.GitHubRestApiTask

class RepositoryGitHub {

    private val url = "https://api.github.com/"
    private val service = GitHubAPI::class

    private val serviceGitHub = GitHubRestApiTask(url).create(service)

    suspend fun getGitHubKotlinIssues(): Issues = serviceGitHub.getResponseAllIssues()

}