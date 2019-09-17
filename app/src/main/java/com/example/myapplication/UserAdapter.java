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

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM = 0;
    private static final int LOADING = 1;


    private List<User.Datum> users;
    private Context context;

    private boolean isLoadingAdded = false;

    public UserAdapter(Context context, List<User.Datum> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        switch (i) {
            case ITEM:
                View item = inflater.inflate(R.layout.item_list, viewGroup, false);
                viewHolder = new LoadingVH(item);
                break;
            case LOADING:
                View loading = inflater.inflate(R.layout.item_progress, viewGroup, false);
                viewHolder = new LoadingVH(loading);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


        switch (getItemViewType(i)) {
            case ITEM:
                UserVH userVH = (UserVH) viewHolder;

                userVH.txtName.setText(users.get(i).getFirstName() + " " + users.get(i).getLastName());
                userVH.txtEmail.setText(users.get(i).getEmail());

                Glide.with(context).load(users.get(i).getAvatar())
                        .placeholder(R.drawable.ic_launcher_background)
                        .into(userVH.imgProfile);

                break;
            case LOADING:
//                Do nothing
                break;
        }
    }

    @Override
    public int getItemCount() {
        return users == null ? 0 : users.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == users.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }

    protected class UserVH extends RecyclerView.ViewHolder {
        private ImageView imgProfile;
        private TextView txtName;
        private TextView txtEmail;

        public UserVH(View itemView) {
            super(itemView);

            imgProfile = itemView.findViewById(R.id.imgProfile);
            txtName = itemView.findViewById(R.id.txtName);
            txtEmail = itemView.findViewById(R.id.txtEmail);
        }
    }


    protected class LoadingVH extends RecyclerView.ViewHolder {

        public LoadingVH(View itemView) {
            super(itemView);
        }
    }


    public void addAll(List<User.Datum> datumList) {
        for (User.Datum datum: datumList) {
            add(datum);
        }
    }

    public void add(User.Datum datum) {
        users.add(datum);
        notifyItemInserted(users.size() - 1);
    }


    public void addLoadingFooter() {
        isLoadingAdded = true;
//        add(new Movie());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = users.size() - 1;
        User.Datum item = users.get(position);

        if (item != null) {
            users.remove(position);
            notifyItemRemoved(position);
        }
    }

}
