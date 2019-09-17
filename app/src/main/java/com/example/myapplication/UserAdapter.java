package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User.Datum> users;
    private Context context;

    public UserAdapter(Context context, List<User.Datum> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View item = inflater.inflate(R.layout.item_list, viewGroup, false);

        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txtName.setText(users.get(i).getFirstName() + " " + users.get(i).getLastName());
        viewHolder.txtEmail.setText(users.get(i).getEmail());

        Glide.with(context).load(users.get(i).getAvatar())
                .placeholder(R.drawable.ic_launcher_background)
                .into(viewHolder.imgProfile);
    }

    @Override
    public int getItemCount() {
        return users == null ? 0 : users.size();
    }


    protected class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgProfile;
        private TextView txtName;
        private TextView txtEmail;

        public ViewHolder(View itemView) {
            super(itemView);

            imgProfile = itemView.findViewById(R.id.imgProfile);
            txtName = itemView.findViewById(R.id.txtName);
            txtEmail = itemView.findViewById(R.id.txtEmail);
        }
    }



}
