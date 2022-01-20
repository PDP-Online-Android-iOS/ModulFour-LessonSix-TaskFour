package dev.ogabek.kotlin.helper

import android.content.Context
import android.content.Intent
import dev.ogabek.kotlin.activity.ProfileActivity
import dev.ogabek.kotlin.model.Member

class CallActivities {

    fun openProfileActivityWithData(context: Context, member: Member): Intent {
        val intent = Intent(context, ProfileActivity::class.java)
        intent.putExtra("member", member)
        return intent
    }

}