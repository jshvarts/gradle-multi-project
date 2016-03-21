# Build It Bigger App

This app demonstrates breaking up an app into multiple components that can all be built separately and interact with each other
using Gradle.

Here are all the components and their purpose:

## Java Module [javaJokes](https://github.com/jshvarts/gradle-multi-project/tree/master/javaJokes)

Provides a model for the app. Jokes are created and available via Joke Factory.

## Backend [jokesBackend](https://github.com/jshvarts/gradle-multi-project/tree/master/jokesBackend)

Uses GCE (Google Cloud Endpoints) to set up a REST url to look up joke data from *javaJokes*.

## Joke Detail UI [jokeIntentHandler](https://github.com/jshvarts/gradle-multi-project/tree/master/jokeIntentHandler)

Displays the joke data based on the data routed to it by the *app* via Intent.

## Joke lookup and routing UI [app](https://github.com/jshvarts/gradle-multi-project/tree/master/app)

Routes joke data to *jokeIntentHandler* from the *jokesBackend*.

Note: *The Google App ID is required for the Backend to work.* You can set it up in your Google Developer console.

## FEATURES

The app offers 2 product flavors: free and paid.

## Building

To build this project on the command line, the following commands are available

```bash
./gradlew assembleFreeDebug
```
```bash
./gradlew assemblePaidDebug
```

See ```./gradlew tasks``` for a full listing of available build commands.

## Tests

### Unit Tests

*jokesBackend* provides unit tests for the Jok Factory code and unit tests can be ran using the following command.

```bash
./gradlew test
```

### Instrumentation Tests

Espresso has been implemented into this project in order to simulate user interaction to test UI. 
Espresso tests run on a physical device or an emulator/Genymotion. The tests allow you to test the  request/response Joke handling UI.

```bash
./gradlew connectedAndroidTest
```
