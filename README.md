# Firebase Remote Config

## Compatibility

This application targets Android (5.0) Lollipop and newer.

## Project Modules

This particular Android project consists of the following modules:

1. **data** - implements networking, domain and persistence models, converters and managers,
2. **application** - produces executable Android application.

## Firebase

Before trying to compile this sample project, you need to configure Firebase application first.

  > Remember you can add multiple sample apps to the same Firebase project. There is no need to create separate projects for each app.

To add sample application to a Firebase project:

  - use the `applicationId` value specified in the `application/build.gradle` file of the application as the Android package name,
  - download generated `google-services.json` file and copy it to the `application` module base directory.

  > Note that this file is not tracked by git, so remember you need to repeat the process in case if you will remove this project from your hard drive.

## Remote Parameters

Available parameters that can be configured in `Firebase Console`:

  - `welcome_text` - a message that is visible on the splash screen view.

## Default Parameters

In-app default values are set using an XML file.

This file is a `remote_config_defaults.xml` file located in `data` module's `res/xml` directory.

It allows you to use Remote Config for any default value you might want to override in the future, without the need to set all of those values in the `Firebase Console`. 

## Gradle properties

Available options that can be configured in `gradle.properties` file:

  - `EnableBugTracker` - allows to enable/disable default bugtracker (eg. Crashlytics),
  - `EnableDebugBridge` - allows to enable/disable debug bridge (eg. Stetho).

> Note that you can find `gradle.properties.sample` file in application modules. If you would like to use default values, just copy this file and paste as `gradle.properties`.

> File `gradle.properties` is not tracked by git so you can use sensitive data there - but use it with care!  

After preparing `gradle.properties` file you have to synchronize your Gradle build. This allows to generate `BuildConfig` class with required constant variables.
