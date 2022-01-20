package dev.ogabek.java.helper;

import android.content.Context;
import android.content.Intent;

import dev.ogabek.java.activity.ProfileActivity;
import dev.ogabek.java.model.Member;

public class CallActivities {

    public Intent openProfileActivityWithData(Context context, Member member) {
        Intent intent = new Intent(context, ProfileActivity.class);
        intent.putExtra("member", member);
        return intent;
    }

}
