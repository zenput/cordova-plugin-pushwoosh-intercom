package com.zenput.push;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.pushwoosh.firebase.PushwooshFcmHelper;
import io.intercom.android.sdk.push.IntercomPushClient;

// See Pushwoosh Docs for more:
// https://www.pushwoosh.com/platform-docs/pushwoosh-sdk/android-push-notifications/android-faq#using-pushwoosh-sdk-with-other-fcm-services

public class FirebaseMessagingRouterService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        IntercomPushClient intercomPushClient = new IntercomPushClient();

        if (PushwooshFcmHelper.isPushwooshMessage(remoteMessage)) {
            PushwooshFcmHelper.onMessageReceived(this, remoteMessage);
        } else if (intercomPushClient.isIntercomPush(remoteMessage.getData())) {
            intercomPushClient.handlePush(getApplication(), remoteMessage.getData());
        }
    }

    @Override
   public void onNewToken(String token) {
       // Send a new token to Pushwoosh
       PushwooshFcmHelper.onTokenRefresh(token);
       // send the new token to Intercom
       IntercomPushClient intercomPushClient = new IntercomPushClient();
       intercomPushClient.sendTokenToIntercom(getApplication(), token);
   }
}
