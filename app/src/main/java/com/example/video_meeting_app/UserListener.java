package com.example.video_meeting_app;

import com.example.video_meeting_app.Model.User;

public interface UserListener {
    void initiateVideoMeeting(User user);

    void initiateAudioMeeting(User user);

    void onMultipleUsersAction(Boolean isMultipleUsersSelected);
}
