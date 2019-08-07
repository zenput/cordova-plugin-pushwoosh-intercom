package com.zenput.push;

import com.google.firebase.messaging.FirebaseMessagingService;
import io.intercom.android.sdk.push.IntercomPushClient;
import com.pushwoosh.PushwooshFcmHelper;

public class FirebaseInstanceIdRouterService extends FirebaseMessagingService {

    @Override
    public void onNewToken(String token) {
        // Send a new token to Pushwoosh
        PushwooshFcmHelper.onTokenRefresh(this, token);
        sendTokenToAnotherService(token);
    }

    private void sendTokenToAnotherService(String token) {
        IntercomPushClient intercomPushClient = new IntercomPushClient();
        intercomPushClient.sendTokenToIntercom(getApplication(), token);
    }
}