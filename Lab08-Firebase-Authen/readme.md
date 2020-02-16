## Add Firebase using the Firebase console

1. Create a Firebase project in [Firebase console](https://console.firebase.google.com/)
2. Register your app with Firebase
   - lick the Android icon to launch the setup workflow.
   - Enter app's package name in the Android package name field.
   - Enter Nickname App (optional)
   - Add SHA-1 key by open Gradle tap on top right screen, SHA-1 can find in App/Tasks/Android/signinReport
3. Click Register App
4. Download config file and put to your android project directory
5. Add Firebase SDK at build.gradle (<project>/build.gradle)

```gradle
buildscript {
  repositories {
    // Check that you have the following line (if not, add it):
    google()  // Google's Maven repository
  }
  dependencies {
    ...
    // Add this line
    classpath 'com.google.gms:google-services:4.3.3'
  }
}

allprojects {
  ...
  repositories {
    // Check that you have the following line (if not, add it):
    google()  // Google's Maven repository
    ...
  }
}
```

and App-level build.gradle (<project>/<app-module>/build.gradle):

```gradle
apply plugin: 'com.android.application'
// Add this line
apply plugin: 'com.google.gms.google-services'

dependencies {
  // add the Firebase SDK for Google Analytics
  implementation 'com.google.firebase:firebase-analytics:17.2.2'
  // add SDKs for any other desired Firebase products
  // https://firebase.google.com/docs/android/setup#available-libraries
}
```

6. Start app for register to firebase console

## Enable Google Sign-In in the Firebase console

1. In the Firebase console, open the Auth section.
2. On the Sign in method tab, enable the Google sign-in method and click Save.
