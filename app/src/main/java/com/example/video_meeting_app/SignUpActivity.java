package com.example.video_meeting_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.video_meeting_app.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageBack.setOnClickListener(v -> onBackPressed());
        binding.textSignIn.setOnClickListener(v -> onBackPressed());
    }
}