package com.example.githubapi.model


import com.google.gson.annotations.SerializedName
import android.support.annotation.Keep
import java.io.Serializable

data class PullRequest(
    @SerializedName("diff_url")
    val diffUrl: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("patch_url")
    val patchUrl: String,
    @SerializedName("url")
    val url: String
):Serializable