package com.example.githubapi.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapi.R
import com.example.githubapi.model.IssueItem

class MainActivity:  AppCompatActivity() {
        private val rvIssues by lazy { findViewById<RecyclerView>(R.id.rv_kotlin_issues) }
        private lateinit var mainViewModel: MainViewModel
        var issuesList = mutableListOf<IssueItem>()
        val adapterIssues = IssueAdapter(issuesList)

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getAllIssues()
        mainViewModel._issuesList.observe(this, Observer { IssueList ->
                IssueList.let{issuesList.addAll(IssueList)}
                adapterIssues.notifyDataSetChanged()
        })
                rvIssues.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                rvIssues.adapter = adapterIssues

        }

}
