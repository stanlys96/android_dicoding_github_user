package com.stanly.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class UserDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val imgPhoto: ImageView = findViewById(R.id.user_img_photo)
        val tvName: TextView = findViewById(R.id.user_name)
        val tvLocation: TextView = findViewById(R.id.user_location)
        val tvUsername: TextView = findViewById(R.id.user_username)
        val tvRepository: TextView = findViewById(R.id.user_repository)
        val tvCompany: TextView = findViewById(R.id.user_company)
        val tvFollowers: TextView = findViewById(R.id.user_followers)
        val tvFollowing: TextView = findViewById(R.id.user_following)

        val user = intent.getParcelableExtra<UserParcelable>(EXTRA_USER) as UserParcelable
        tvName.text = user.name
        tvLocation.text = user.location
        user.avatar?.let { imgPhoto.setImageResource(it) }
        tvUsername.text = user.username
        tvRepository.text = user.repository
        tvCompany.text = user.company
        tvFollowers.text = user.followers
        tvFollowing.text = user.following
    }
}