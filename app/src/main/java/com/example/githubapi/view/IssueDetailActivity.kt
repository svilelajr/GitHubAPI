package com.example.githubapi.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.githubapi.R
import com.example.githubapi.model.IssueItem
import com.squareup.picasso.Picasso

class IssueDetailActivity: AppCompatActivity() {

    val image by lazy { findViewById<ImageView>(R.id.iv_user_avatar) }
    val tvTitle by lazy { findViewById<TextView>(R.id.tv_issue_title) }
    val tvDescription by lazy { findViewById<TextView>(R.id.tv_issue_detail)}
    val tvIssueCreationDate by lazy { findViewById<TextView>(R.id.tv_creation_date)}
    val btnLinkIssue by lazy { findViewById<Button>(R.id.btn_goto_github)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_issue_detail)

        val extras = intent.extras

        if (extras != null) {

            val issue = extras?.getSerializable("ISSUE") as IssueItem

            Picasso.get().load(issue.user.avatarUrl).into(image)
            tvTitle.text = issue.title
            tvDescription.text = issue.body
            tvIssueCreationDate.text = issue.createdAt
            btnLinkIssue.setOnClickListener {

          val openUrl = Intent(Intent.ACTION_VIEW)
                openUrl.data = Uri.parse(issue.htmlUrl)
                startActivity(openUrl)
            }
        } else {
            Toast.makeText(this, "Não foi possivel encontrar a informação do Issue", Toast.LENGTH_SHORT).show()
        }

        }

    }