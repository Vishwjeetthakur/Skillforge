# Skillforge

Skillforge is a modern Android learning application built using **Kotlin** and **Jetpack Compose**. The app allows users to browse learning categories, explore course details, and watch lesson videos. It follows the **MVVM architecture** and consumes data from a single REST API using Retrofit.

## Tech Stack

* Kotlin
* Jetpack Compose
* MVVM Architecture
* Retrofit
* Kotlin Coroutines
* Coil
* Navigation Compose
* Media3 ExoPlayer
* JUnit

## Features

* Browse course categories and popular courses
* View detailed course information
* Lesson player screen
* Loading and error state handling
* SharedNavigationViewModel for sharing selected Course and Lesson across screens
* Repository unit testing

## Architecture

The project follows the MVVM architecture with a Repository layer.

Instead of passing complete `Course` and `Lesson` objects through Navigation Compose arguments, the application uses a **SharedNavigationViewModel**. When a user selects a course or lesson, the selected object is stored in a `StateFlow` inside the shared ViewModel. Destination screens observe the shared state, resulting in cleaner navigation code and avoiding object serialization.

## Unit Testing

The project includes a repository unit test using a fake implementation of the API service. The test verifies that the repository correctly returns the expected course data without making an actual network request.

## AI Usage

### AI Tools Used

* ChatGPT, Gemini Ai

### Example Prompts

1. "Generate Retrofit data models for the nested Skillforge JSON response."
2. "Create a Navigation Compose flow using a SharedNavigationViewModel to share selected Course and Lesson objects between screens."
3. "Generate a repository unit test using a fake ApiService implementation for Kotlin Coroutines."

### What AI Got Right

* Helped generate the Retrofit models and MVVM project structure.
* Assisted with reusable Jetpack Compose components.
* Suggested a clean repository unit test using a fake API service.
* Provided guidance for organizing navigation and screen structure.

### What AI Got Wrong

The initial navigation solution suggested passing complete objects through navigation arguments. Instead, I implemented a **SharedNavigationViewModel** using `StateFlow` to manage the selected Course and Lesson, resulting in simpler navigation and improved separation of concerns.

## API

The application consumes the assessment API:

https://raw.githubusercontent.com/android-assesment/notes/refs/heads/main/data.json

## Author

**Vishwajeet Thakur**
