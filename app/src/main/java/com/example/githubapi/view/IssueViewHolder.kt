package com.example.githubapi.view

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapi.R

class IssueViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val issueTitle by lazy { view.findViewById<TextView>(R.id.tv_issue_title) }
    val issueState by lazy { view.findViewById<TextView>(R.id.tv_issue_state) }
    val issueCard by lazy {view.findViewById<CardView>(R.id.cv_kotlin_issue) }

}