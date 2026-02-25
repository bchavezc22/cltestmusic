# cltestmusic

# Clara Test - Discogs Artist Explorer

This is an Android mobile application built with **Kotlin** and **Jetpack Compose** that interacts with the Discogs API. It allows users to search for music artists, view detailed information about them, and browse their album releases.

This project was created as a technical assessment and demonstrates modern Android development practices, including clean architecture, dependency injection, and a reactive UI.

---

## 🚀 Features

* **Artist Search:** Search for artists by name using the Discogs database.
* **Detailed Artist View:** View detailed information for a selected artist, including their profile and band members.
* **Album/Release List:** Browse a list of an artist's releases.
* **Sorting & Filtering:** Sort albums by release date and filter them by year, genre, or label.
* **Clean, Modern UI:** A user-friendly interface built entirely with Jetpack Compose.

---

## 🛠 Tech Stack & Libraries

* **Language:** Kotlin
* **UI Toolkit:** Jetpack Compose (Declarative UI)
* **Architecture:** Clean Architecture
* **Asynchronous Programming:** Kotlin Coroutines
* **Networking:**
    * **Retrofit:** Type-safe HTTP requests.
    * **Moshi:** Efficient JSON parsing.
* **Image Loading:** **Coil** for loading and caching images.
* **Dependency Injection:** Manual DI managed via a singleton `AppModule` object.

---

## ⚙️ How to Build and Run

### Prerequisites
* **Android Studio** (latest stable version recommended).
* An Android device or emulator running **API level 24** or higher.
* A **Discogs API Key**.

### Setup

1. **Clone the Repository**
   ```bash
   git clone [https://github.com/bchavezc22/cltestmusic.git](https://github.com/bchavezc22/cltestmusic.git)
   cd cltestmusic

2. **Get a Discogs API Key**   
Go to the Discogs Developers page.
Create a new application to receive your Key and Secret.

2. **Add Your API Credentials**  
Open the ArtistRepositoryImpl.kt file located at:
app/src/main/java/com/test/cl/claratest/data/repository/ArtistRepositoryImpl.kt
Replace the placeholder values for the API key and secret with your own credentials:
