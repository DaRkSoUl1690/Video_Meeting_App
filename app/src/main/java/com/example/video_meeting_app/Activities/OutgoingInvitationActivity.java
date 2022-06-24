package com.example.video_meeting_app.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.video_meeting_app.Model.User;
import com.example.video_meeting_app.R;
import com.example.video_meeting_app.Utilities.PreferenceManager;
import com.example.video_meeting_app.databinding.ActivityOutgoingInvitationBinding;

public class OutgoingInvitationActivity extends AppCompatActivity {

    ActivityOutgoingInvitationBinding binding;
    private PreferenceManager preferenceManager;
    private final String inviterToken = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOutgoingInvitationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String meetingType = getIntent().getStringExtra("type");
        if (meetingType != null) {
            if (meetingType.equals("video")) {
                binding.imageMeetingType.setImageResource(R.drawable.ic_video);
            }
        }
        User user = (User) getIntent().getSerializableExtra("user");
        if (user != null) {
            binding.textFirstChar.setText(user.firstName.substring(0, 1));
            binding.textUsername.setText(String.format("%s %s", user.firstName, user.lastName));
            binding.textEmail.setText(user.email);

        }
        binding.imageStopInvitation.setOnClickListener(v -> onBackPressed());
    }
}