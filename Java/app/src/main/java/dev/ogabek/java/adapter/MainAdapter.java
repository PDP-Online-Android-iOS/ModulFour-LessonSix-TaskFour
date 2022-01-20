package dev.ogabek.java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.java.R;
import dev.ogabek.java.activity.MainActivity;
import dev.ogabek.java.helper.CallActivities;
import dev.ogabek.java.model.Member;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    MainActivity context;
    List<Member> members;
    CallActivities intent = new CallActivities();

    public MainAdapter(MainActivity context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).userPhoto.setImageResource(member.getPhoto());
            ((ItemViewHolder) holder).userFullName.setText(member.getName());
            ((ItemViewHolder) holder).userUsername.setText(member.getUsername());
            ((ItemViewHolder) holder).item_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.openIntent(intent.openProfileActivityWithData(context, member));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView userPhoto;
        TextView userFullName, userUsername;

        LinearLayout item_view;

        public ItemViewHolder(View view) {
            super(view);

            userPhoto = view.findViewById(R.id.iv_item_photo);
            userFullName = view.findViewById(R.id.tv_item_name);
            userUsername = view.findViewById(R.id.tv_item_job_title);

            item_view = view.findViewById(R.id.ll_item);

        }
    }
}
