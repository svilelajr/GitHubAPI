package com.example.githubapi.network

import retrofit2.Retrofit
import kotlin.reflect.KClass
import retrofit2.converter.gson.GsonConverterFactory


class GitHubRestApiTask(url: String) {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T : Any> create(clazz: KClass<T>): T = retrofit.create(clazz.java)


}