package com.example.video_meeting_app.Activites;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.video_meeting_app.databinding.ActivityIncomingInvitationBinding;

public class IncomingInvitationActivity extends AppCompatActivity {

    ActivityIncomingInvitationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIncomingInvitationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}