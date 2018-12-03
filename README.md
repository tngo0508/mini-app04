# CPSC 411- Mobile Device Application Development
# Fall 2018 - Mini-App 3, due November 29
## Introduction
In this project, I modify the code for [Mini-App 2](https://github.com/tngo0508/mini-app02) to use 
fragments and take advantage of the [Android KTX](https://developer.android.com/kotlin/ktx) library.
## Fragments
Convert the UI to use a [fragment](https://developer.android.com/guide/components/fragments), 
and modify the activity to host the fragment dynamically using [supportFragmentManager](https://developer.android.com/reference/android/support/v4/app/FragmentManager).
## Handling Configuration Changes
Update the application to [save the instance state](https://developer.android.com/reference/android/app/Activity#onSaveInstanceState(android.os.Bundle)) 
of widgets when undergoing a configuration change such as rotation.
## Android KTX
+ Add [Android KTX](https://developer.android.com/kotlin/ktx) to your build.gradle dependencies and 
modify the activity to use the [FragmentManager.transaction](https://developer.android.com/reference/kotlin/androidx/fragment/app/package-summary#extension-functions-summary) extension function.
+ Note that in order to add all of the required KTX packages successfully, need to [migrate to AndroidX](https://developer.android.com/jetpack/androidx/migrate).
