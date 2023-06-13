# Compose Multiplatform Playground
This is a [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) mobile application running on Android and iOS platform. The app has two screens: a registration screen and a certificate screen. Users can register with  name, email and ID on the registration screen and then navigate to the certificate screen.

## Requirements
To build and run the app, you will need:
- [Android Studio](https://developer.android.com/studio) 4.2 or later
- [Xcode](https://apps.apple.com/us/app/xcode/id497799835) 12 or later
- [Kotlin Multiplatform Mobile plugin](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile) for Android Studio
## Getting Started
- Clone the repository
- Open the project in Android Studio
- Build the project
## Project Structure
The project consists of three main modules:
- `androidApp`: contains the code for the Android app.
- `iosApp`: contains the code for the iOS app.
- `common`: contains the shared code that is used by both the Android and iOS apps.
## Running the App
To run the app on Android:
- Connect an Android device to your computer or start an emulator.
- Run the app using Android Studio.

To run the app on iOS:
- Open the project in Xcode.
- Connect an iOS device to your computer.
- Build and run the app using Xcode.
### Screenshots
<img src="https://github.com/jhnaiem/ComposeMultiplatform_KMMPlayGround/assets/33525108/94e1d1f4-8950-48be-91ed-b2eb36dd11d4" width=25% height=25%>
<img src="https://github.com/jhnaiem/ComposeMultiplatform_KMMPlayGround/assets/33525108/796b0d08-a477-438f-9d56-373a7c7b9e9f" width=25% height=25%>

## Acknowledgements
This app is built using the [Compose Multiplatform template](https://github.com/JetBrains/compose-multiplatform-ios-android-template) provided by JetBrains. We've also used the Kotlin Multiplatform Mobile [documentation](https://kotlinlang.org/docs/multiplatform-mobile-create-first-app.html) to guide us in developing this app.
