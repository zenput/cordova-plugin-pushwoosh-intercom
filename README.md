This is a Cordova plugin for use in conjunction with [pushwoosh-cordova-plugin](https://github.com/Pushwoosh/pushwoosh-phonegap-plugin#readme) and [cordova-plugin-intercom](https://github.com/intercom/intercom-cordova#readme) that fixes push notifications for Intercom. This is based on the instructions from Pushwoosh, [here](https://www.pushwoosh.com/platform-docs/pushwoosh-sdk/android-push-notifications/android-faq#using-pushwoosh-sdk-with-other-fcm-services).

# Set Up

1. Install the Pushwoosh and Intercom plugins:

    ```sh
    cordova plugin add pushwoosh-cordova-plugin
    cordova plugin add cordova-plugin-intercom
    ```

1. Install this plugin:

    ```sh
    npx cordova plugin add git+ssh://git@github.com/zenput/cordova-plugin-pushwoosh-intercom.git
    ```