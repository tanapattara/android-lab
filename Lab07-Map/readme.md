## Add necessary Permissions

add uses-permission in `AndroidManifest.xml`

```xml
<manifest>
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
    <application> ... </application>
</manifest>
```

## Use location manager

Add Google play service available via your app `build.gradle` file.

```gradle
dependencies {
    ...
    implementation ‘com.google.android.gms:play-services-location:17.0.0
}
```
