<h1 align="center"> Java RESTful API Transcription Project 🔄 </h1>

## Overview

- Chrome extension used : Boomerang (for testing out rest calls before implementing them)
- Interacting with the AssemblyAI API to transcribe audio content

## Features

- **Transcription Request Handling:** Initiates transcription requests to the AssemblyAI API by sending audio file URLs.
- **Request Status Monitoring:** Periodically checks the status of the transcription request until it is completed.
- **Result Retrieval:** Retrieves and displays the transcribed text upon completion.
- **Error Handling:** Displays error in the transcription process.

## Requirements

- **Java 11 or later:** Ensure you have Java 11 or a later version installed on your system.
- **Gson Library:** The project uses the Gson library for JSON serialization and deserialization. The library is included in the project or can be added manually.

## Setup

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/Java-RESTful-API.git
   cd Java-RESTful-API

2. **Configure API Key:**

   Open the Constants.java file in the projectpackage package and replace YOUR_API_KEY with your AssemblyAI API key.
## Usage
- **Run the Project:**

  Execute the project to initiate the transcription request and monitor the status.
  ```bash
  javac projectpackage/RestApi.java
  java projectpackage.RestApi

- **Check Console Output:**

  Review the console output for details on the transcription process, including status updates and the transcribed text.

- **Customization:**

 Modify the project to suit your specific needs. We can adapt the code to handle different audio sources, adjust polling intervals, or enhance error handling.

## Expected Output

    ```bash
    {"audio_url":"https://github.com/sam301100/Java-RESTful-API/blob/master/Thirsty.mp4?raw\u003dtrue"}
    {"id": "ecd24a96-dee6-47c5-b014-d7e29a4446b6", "status": "queued", "audio_url": "https://github.com/sam301100/Java-RESTful-API/blob/master/Thirsty.mp4?raw=true", ... }
    ecd24a96-dee6-47c5-b014-d7e29a4446b6
    processing
    processing
    ...
    completed
    Transcription Completed!
    Transcribed Text: These pretzels are making me thirsty.



## Acknowledgments
AssemblyAI - API used for audio transcription.


## Show your support
Please ⭐️ this repository if this project helped you!