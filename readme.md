# ARCore Text Stabilizer for Moving Vehicles

This Android app, developed in **Kotlin**, uses **Google ARCore** technology to stabilize text in a moving vehicle, reducing eye strain for readers. By detecting spatial awareness using the phone's sensors (camera, accelerometer, and gyroscope), this app keeps the text stable relative to the user's view, compensating for the motion of the vehicle.

## Features
- **Text Stabilization**: Keeps text steady in a moving environment, making it easier to read while traveling.
- **ARCore Integration**: Uses **Google ARCore** to detect and track the phone's position in real-time, providing precise stabilization.
- **Kotlin**: Fully developed in **Kotlin**, leveraging the modern language features of Android development.
- **User-Friendly UI**: Simple and intuitive interface for a smooth reading experience.

## Getting Started

### Prerequisites
- Android device with **ARCore** support
- Android Studio with Kotlin plugin installed
- Minimum Android SDK version 24 (Android 7.0 Nougat)
- ARCore 1.15.0 SDK for Android

### Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/Sriram247/arcore-text-stabilizer.git
    ```
2. Open the project in **Android Studio**.
3. Sync the Gradle files and resolve any dependencies.
4. Build and run the app on an **ARCore**-supported device.

### Dependencies
- **Google ARCore SDK**: Provides the AR capabilities.
- **Sceneform SDK**: Handles rendering of 3D content and interaction with ARCore (version 1.15.0).
- **Kotlin Standard Library**: The foundation for Kotlin-based Android development.

## Usage
1. Launch the app.
2. The app will automatically detect your environment and stabilize the text based on your motion.
3. Adjust settings as needed for different text sizes or environments.

## Screenshots
_(To be included as per process)_

## Future Enhancements
- **Customizable text display**: Allow users to change font size, style, and color.
- **Advanced stabilization settings**: Let users adjust the sensitivity of text stabilization based on motion intensity.
- **Ability to recalibrate the text as per position of device**

## Contributions
Contributions are welcome! Please submit a pull request or open an issue for any improvements or bugs.

## License
This project is licensed under the MIT License - see the [LICENSE](https://opensource.org/license/mit) file for details.

---

### Credits
- Based on **Google ARCore** and **Sceneform 1.15.0**
- Thanks to [ChatGPT](https://openai.com/chatgpt) for assisting with code, Consultation and project Workflow.
