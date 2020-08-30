package com.example.sampleinstagram.adapters;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampleinstagram.R;
import com.example.sampleinstagram.apicallsretro.DownloadImageTask;
import com.example.sampleinstagram.models.UserList;

import java.util.List;

public class MainFeedAdapter extends RecyclerView.Adapter<MainFeedAdapter.MainFeedViewHolder> {
    private final String TAG = MainFeedAdapter.class.getSimpleName();
    private List<UserList.Datum> mUsers;

    public MainFeedAdapter( List<UserList.Datum> users) {
        this.mUsers = users;
    }

    @NonNull
    @Override
    public MainFeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.main_feed_item, parent, false);
        MainFeedViewHolder mainFeedViewHolder = new MainFeedViewHolder(v);
        return mainFeedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainFeedViewHolder holder, int position) {

        holder.userIdTextView.setText(mUsers.get(position).id.toString());
        holder.userNameTextView.setText(mUsers.get(position).first_name);
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public static class MainFeedViewHolder extends RecyclerView.ViewHolder {
        private TextView userNameTextView;
        private TextView userIdTextView;
        private ImageView image;
        private View layout;
        public MainFeedViewHolder(View v) {
            super(v);
            layout = v;
            userNameTextView = (TextView) v.findViewById(R.id.userName);
            userIdTextView = (TextView) v.findViewById(R.id.userId);
            image = (ImageView) v.findViewById(R.id.imageView);
        }
    }

}
