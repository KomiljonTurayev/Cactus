# Cactus Android App 🌵

A premium, modern Android application for cactus enthusiasts, built with **Clean Architecture**, **MVVM**, and the latest Android development standards.

## 🚀 Features
- **Modern UI/UX:** Rich aesthetics with a custom cactus-themed color palette and Material Design 3 elements.
- **Home Screen:** Browse a variety of cacti and succulents with real-time data fetching.
- **Shopping Basket:** Add products to your cart, manage quantities, and see real-time price calculations.
- **Image Loading:** Smooth and efficient image loading using Coil with crossfade animations.
- **Navigation:** Seamless transitions between fragments using Android Jetpack Navigation Component.

## 🛠 Tech Stack & Libraries
- **Language:** [Kotlin](https://kotlinlang.org/) (1.8.21)
- **Architecture:** Clean Architecture (Domain, Data, Presentation layers)
- **Pattern:** MVVM (Model-View-ViewModel)
- **Dependency Injection:** [Hilt](https://dagger.dev/hilt/)
- **Networking:** [Retrofit](https://square.github.io/retrofit/) & [OkHttp](https://square.github.io/okhttp/)
- **Asynchronous Tasks:** Coroutines & Kotlin Flow
- **Image Loading:** [Coil](https://coil-kt.github.io/coil/)
- **View Binding:** [ViewBindingPropertyDelegate](https://github.com/kirich1409/ViewBindingPropertyDelegate)
- **CI/CD:** GitHub Actions (Automated build and test pipeline)

## 🏗 Project Structure
```bash
app/src/main/java/com/example/cactus/
├── common/         # Common utilities, Resource wrapper, Constants
├── data/           # Repositories implementation, API Service, DTOs, Mappers
├── di/             # Hilt Modules (Network, Repository, Api)
├── domain/         # Domain Models (Entities), Repository Interfaces
└── presentation/   # UI components, ViewModels, Fragments, Adapters
```

## ⚙️ CI/CD Pipeline
The project includes a robust GitHub Actions workflow located in `.github/workflows/android.yml`. It automatically:
1. Sets up the environment (JDK 17).
2. Verifies compilation (`assembleDebug`).
3. Runs unit tests to ensure code quality on every push to `master`.

## 📸 Screenshots
*(Coming Soon)*

## 🛠 Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/KomiljonTurayev/Cactus.git
   ```
2. Open the project in Android Studio.
3. Build and run on your emulator or physical device.

---
Developed with ❤️ by **Komiljon Turayev** & **Antigravity AI**.
