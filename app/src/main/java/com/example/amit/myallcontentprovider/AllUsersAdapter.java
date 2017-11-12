package com.example.amit.myallcontentprovider;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Amit on 1/20/2017.
 */

public class AllUsersAdapter extends RecyclerView.Adapter<AllUsersAdapter.UserViewHolder>{

    private List<AllUsers.User> userList;
    private Context context;
    public AllUsersAdapter(List<AllUsers.User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    public AllUsersAdapter(List<PhoneContactsView> allContacts, PhoneContacts context) {

    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_cardview_layout, null);
        UserViewHolder userViewHolder = new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        AllUsers.User user = userList.get(position);
        holder.ivProfilePic.setImageResource(user.getImageResourceId());
        holder.tvProfileName.setText(user.getProfileName());
        holder.tvPhoneNumber.setText(user.getPhoneNumber());
        holder.tvEmailId.setText(user.getEmailId());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView ivProfilePic;
        TextView tvProfileName;
        TextView tvPhoneNumber;
        TextView tvEmailId;
        public UserViewHolder(View itemView) {
            super(itemView);
            ivProfilePic = (ImageView) itemView.findViewById(R.id.ivProfilePic);
            tvProfileName = (TextView) itemView.findViewById(R.id.tvProfileName);
            tvPhoneNumber = (TextView) itemView.findViewById(R.id.tvPhoneNumber);
            tvEmailId = (TextView) itemView.findViewById(R.id.tvEmailId);
        }
    }
}
