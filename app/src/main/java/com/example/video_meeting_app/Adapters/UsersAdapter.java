package com.example.video_meeting_app.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.video_meeting_app.Listeners.UserListener;
import com.example.video_meeting_app.Model.User;
import com.example.video_meeting_app.R;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {
    private final List<User> users, selectedUsers;
    private final UserListener userListener;

    public UsersAdapter(List<User> users, UserListener userListener) {
        this.users = users;
        this.userListener = userListener;
        this.selectedUsers = new ArrayList<>();
    }

    public List<User> getSelectedUsers() {
        return selectedUsers;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_container_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.setUserData(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView textFirstChar, textUsername, textEmail;
        ImageView imageAudioMeeting, imageVideoMeeting, imageSelected;
        ConstraintLayout userContainer;

        UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textFirstChar = itemView.findViewById(R.id.textFirstChar);
            textUsername = itemView.findViewById(R.id.textUsername);
            textEmail = itemView.findViewById(R.id.textEmail);

            imageAudioMeeting = itemView.findViewById(R.id.imageAudioMeeting);
            imageVideoMeeting = itemView.findViewById(R.id.imageVideoMeeting);
            imageSelected = itemView.findViewById(R.id.imageSelected);

            userContainer = itemView.findViewById(R.id.userContainer);

        }

        void setUserData(User user) {
            textFirstChar.setText(user.firstName.substring(0, 1));
            textUsername.setText(String.format("%s %s", user.firstName, user.lastName));
            textEmail.setText(user.email);
            imageAudioMeeting.setOnClickListener(v -> userListener.initiateAudioMeeting(user));
            imageVideoMeeting.setOnClickListener(v -> userListener.initiateVideoMeeting(user));

            userContainer.setOnLongClickListener(v -> {
                if (imageSelected.getVisibility() == View.GONE) {
                    selectedUsers.add(user);
                    imageSelected.setVisibility(View.VISIBLE);
                    imageAudioMeeting.setVisibility(View.GONE);
                    imageVideoMeeting.setVisibility(View.GONE);
                    userListener.onMultipleUsersAction(true);
                }
                return true;
            });

            userContainer.setOnClickListener(v -> {
                if (imageSelected.getVisibility() == View.VISIBLE) {
                    selectedUsers.remove(user);
                    imageSelected.setVisibility(View.GONE);
                    imageAudioMeeting.setVisibility(View.VISIBLE);
                    imageVideoMeeting.setVisibility(View.VISIBLE);
                    if (selectedUsers.size() == 0) {
                        userListener.onMultipleUsersAction(false);
                    }
                } else {
                    if (selectedUsers.size() > 0) {
                        imageSelected.setVisibility(View.VISIBLE);
                        imageAudioMeeting.setVisibility(View.GONE);
                        imageVideoMeeting.setVisibility(View.GONE);
                    }
                }
            });
        }
    }
}