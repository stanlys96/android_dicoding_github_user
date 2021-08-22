package com.stanly.githubuser

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: UserAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var dataUsername: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private var users = arrayListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView: ListView = findViewById(R.id.lv_list)
        adapter = UserAdapter(this)
        listView.adapter = adapter
        prepare()
        addItem()
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
//            Toast.makeText(this@MainActivity, users[position].name, Toast.LENGTH_SHORT).show()
            val user = UserParcelable(
                name = users[position].name,
                location = users[position].location,
                avatar = users[position].avatar,
                username = users[position].username,
                repository = users[position].repository,
                company = users[position].company,
                followers = users[position].followers,
                following = users[position].following,
            )
            val intent = Intent(this@MainActivity, UserDetail::class.java)
            intent.putExtra(UserDetail.EXTRA_USER, user)
            startActivity(intent)
        }
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
        dataUsername = resources.getStringArray(R.array.username)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = User(
                name = dataName[position],
                location = dataLocation[position],
                avatar = dataPhoto.getResourceId(position, -1),
                username = dataUsername[position],
                repository = dataRepository[position],
                company = dataCompany[position],
                followers = dataFollowers[position],
                following = dataFollowing[position],
            )
            users.add(user)
        }
        adapter.users = users
    }
}