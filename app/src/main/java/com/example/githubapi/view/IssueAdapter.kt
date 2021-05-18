package com.example.githubapi.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapi.R
import com.example.githubapi.model.IssueItem

class IssueAdapter(private val issueList: MutableList<IssueItem>):RecyclerView.Adapter<IssueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = IssueViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_kotlin_issue,parent,false))

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        val position = issueList[position]
        holder.issueTitle.text = position.title
        holder.issueState.text = position.state

        holder.issueCard.setOnClickListener{
            val intent = Intent(it.context, IssueDetailActivity::class.java)
            intent.putExtra("ISSUE", position)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = issueList.size

    }