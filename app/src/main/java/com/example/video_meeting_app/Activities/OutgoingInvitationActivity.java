package com.example.video_meeting_app.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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

    }
}