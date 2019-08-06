package com.zenput.push;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.pushwoosh.PushwooshFcmHelper;
import io.intercom.android.sdk.push.IntercomPushClient;

public class FirebaseInstanceIdRouterService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        // Send a new token to Pushwoosh
        PushwooshFcmHelper.onTokenRefresh(this, refreshedToken);
        sendTokenToAnotherService(token);
    }

    private void sendTokenToAnotherService(String token) {
        intercomPushClient.sendTokenToIntercom(getApplication(), refreshedToken);
    }
}