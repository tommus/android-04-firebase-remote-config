# Firebase Remote Config

## Compatibility

This application targets Android (5.0) Lollipop and newer.

## Project Modules

This particular Android project consists of the following modules:

1. **data** - implements networking, domain and persistence models, converters and managers,
2. **application** - produces executable Android application.

## Gradle properties

Available options that can be configured in `gradle.properties` file:

  - `EnableBugTracker` - allows to enable/disable default bugtracker (eg. Crashlytics),
  - `EnableDebugBridge` - allows to enable/disable debug bridge (eg. Stetho).

> Note that you can find `gradle.properties.sample` file in application modules. If you would like to use default values, just copy this file and paste as `gradle.properties`.

> File `gradle.properties` is not tracked by git so you can use sensitive data there - but use it with care!  

After preparing `gradle.properties` file you have to synchronize your Gradle build. This allows to generate `BuildConfig` class with required constant variables.
