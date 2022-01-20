package dev.ogabek.java.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import dev.ogabek.java.R;
import dev.ogabek.java.model.Member;

public class ProfileActivity extends AppCompatActivity {

    ImageView userPhoto;
    TextView userFullName, userUserName;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();

        setInfo(getDataFromIntent());

    }

    private void setInfo(Member member) {
        userPhoto.setImageResource(member.getPhoto());
        userFullName.setText(member.getName());
        userUserName.setText(member.getUsername());
    }

    private Member getDataFromIntent() {
        return (Member) getIntent().getParcelableExtra("member");
    }

    private void initViews() {
        userPhoto = findViewById(R.id.iv_member_photo);
        userFullName = findViewById(R.id.tv_item_member_full_name);
        userUserName = findViewById(R.id.tv_item_member_username);
        backButton = findViewById(R.id.btn_back_member);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}