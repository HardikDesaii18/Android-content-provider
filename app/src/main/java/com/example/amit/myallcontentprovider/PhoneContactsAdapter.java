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

public class PhoneContactsAdapter extends RecyclerView.Adapter<AllContactsAdapter.ContactViewHolder> {
    private List<PhoneContactsView> PhoneContactsList;
    private Context mycontext;

    public PhoneContactsAdapter(List<PhoneContactsView> phoneContactsList, Context context) {
        PhoneContactsList = phoneContactsList;
        this.mycontext = context;
    }

    @Override
    public AllContactsAdapter.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mycontext).inflate(R.layout.contact_cardview, null);
        AllContactsAdapter.ContactViewHolder contactViewHolder = new AllContactsAdapter.ContactViewHolder(view);
        return contactViewHolder;

    }

    @Override
    public void onBindViewHolder(AllContactsAdapter.ContactViewHolder holder, int position) {
        PhoneContactsView phoneContactsView=PhoneContactsList.get(position);

     //holder.ivContactImage.setImageResource(Integer.parseInt(String.valueOf(phoneContactsView.getContactImagePic())));

       holder.ivContactImage.setImageResource(phoneContactsView.getContactImagePic());
        holder.tvContactName.setText(phoneContactsView.getContactName());
        holder.tvPhoneNumber.setText(phoneContactsView.getContactPhoneNumber());
        holder.tvPhoneEmail.setText(phoneContactsView.getContactEmailId());
    }

    @Override
    public int getItemCount() {
        return PhoneContactsList.size();
    }

    public static class PhoneContactViewHolder extends RecyclerView.ViewHolder{

        ImageView ivImage;
        TextView tvName;
        TextView tvNumber;
        TextView tvEmail;

        public PhoneContactViewHolder(View itemView) {
            super(itemView);
            ivImage = (ImageView) itemView.findViewById(R.id.ivProfile);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvNumber = (TextView) itemView.findViewById(R.id.tvNumber);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
        }
    }
}
