package dev.ogabek.kotlin.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.model.Member

class ProfileActivity : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var itemMemberPhoto: ImageView
    private lateinit var itemMemberFullName: TextView
    private lateinit var itemMemberUsername: TextView
    private lateinit var itemBackButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initViews()

        setInfo(getDataFromIntent()!!)

    }

    private fun setInfo(member: Member) {
        itemMemberPhoto.setImageResource(member.image)
        itemMemberFullName.text = member.name
        itemMemberUsername.text = member.username
    }

    private fun getDataFromIntent(): Member? {
        return intent.getParcelableExtra("member")
    }

    private fun initViews() {
        context = this
        itemMemberPhoto = findViewById(R.id.iv_member_photo)
        itemMemberFullName = findViewById(R.id.tv_item_member_full_name)
        itemMemberUsername = findViewById(R.id.tv_item_member_username)
        itemBackButton = findViewById(R.id.btn_back_member)

        itemBackButton.setOnClickListener {
            finish()
        }
    }
}