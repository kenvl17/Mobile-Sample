
Copy code
# Test Automation Suite

This repository contains a suite of automated tests for an Android application using Appium and TestNG. It includes tests for login and registration functionalities, ensuring that the application behaves as expected under various conditions.

## Table of Contents

- [Setup](#setup)
- [Usage](#usage)

## Setup

### Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java**: JDK 8 or higher
- **Gradle**: For managing dependencies and running tests
- **Appium**: The Appium server should be running
- **Android SDK**: Required for Android device interaction
- **Dotenv**: For managing environment variables

### Installation

1. **Clone the Repository**

   ```sh
   git clone https://github.com/yourusername/your-repository.git
   cd your-repository
2. **Install Dependencies**

Ensure you have Gradle installed. If not, follow the Gradle installation instructions.

```sh
gradle build
```
3. **Set Up Environment Variables**

Create a .env file in the root directory of the project and add the necessary environment variables:

```plaintext
DEVICE_NAME=YourDeviceName
PLATFORM_NAME=Android
APP_PACKAGE=com.loginmodule.learning
APP_ACTIVITY=com.loginmodule.learning.MainActivity
NO_RESET=true
VALID_EMAIL=your_valid_email@example.com
VALID_PASSWORD=your_valid_password
INVALID_EMAIL_FORMAT=invalid_email_format
INCORRECT_EMAIL=incorrect_email@example.com
NAME=YourName
INVALID_REINPUT_PASSWORD=invalid_reinput_password
```
4. **Start Appium Server**

Make sure the Appium server is running before executing the tests. You can start it using the Appium desktop app or via the command line:

```sh
appium
```
## Usage
### Running Tests
To run the tests, use the following Gradle command:

```sh
gradle test
```
This command will execute all the test cases defined in the RunnerTests class.

### Test Cases
#### Login Tests:

- **testLoginWithValidData**
- **testLoginWithInvalidData**
- **testLoginWithInvalidFormatEmail**
#### Registration Tests:

- **invalidRegisterWrongReinputPassword**
- **invalidRegisterBlankField**
- **invalidRegisterDuplicateEmail**
- **registerWithValidData**
- **registerWithInvalidData**
