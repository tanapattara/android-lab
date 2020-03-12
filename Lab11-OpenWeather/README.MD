# Getting App ID from OpenWeather
1. Open [OpenWeatherMap](https://openweathermap.org/api) Site and sign up for get app id.
2. Create app id in API Keys tab of the site after logged in.

# Implement dependencies
add implementaion Google services library in app level build.gradle
```gradle
dependencies {
    ...

    implementation 'com.squareup.retrofit2:retrofit:2.4.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.4.0'
}
```