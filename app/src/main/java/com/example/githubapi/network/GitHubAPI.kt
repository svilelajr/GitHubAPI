
package com.example.githubapi.network

import com.example.githubapi.model.Issues
import retrofit2.http.GET

interface GitHubAPI {

    @GET("repos/JetBrains/kotlin/issues")
    suspend fun getResponseAllIssues(): Issues
}