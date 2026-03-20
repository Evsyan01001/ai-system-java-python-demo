#   Java -> FastAPI File Upload Demo

## Overview

    This project demonstrates how to upload a file from Java client to a Python FastAPI server using 'multipart/form-data'.

    It is a minimal working example for:
-   Java HTTP file upload
-   FastAPI file receving
-   Cross-language communication (Java -> Python)

## Project Structure

    |---java-client/
    | |---CallAPI.java
    | |---test.txt
    |
    |---python-server/
    | |---main.py
    | |---test.txt
    |
    |---.gitignore
    |___README.md

## Quick Start

### 1.Start Python Server

    Bash
    cd python-server
    uvicorn main:app --reoad --port :8000
    // server will run at:
    // http://127.0.0.1:8000

### 2.Run Java Client

    Bash
    cd java-client
    javac CallAPI.java
    java CallAPI test.txt

## Response

    Response: {"filename":"test.txt","size":4}

## Key Concepts

-   mulipart/form-data encoding
-   Boundary separation in HTTP
-   File streaming (Java -> Python)
-   FastAPI Uplodafile

## Notes

-   Do not upload large files without streaming (memory risk)
-   .class and __pycache__ are ignore via .gitignore
-   This is a minimal demo, not production-ready

## Future Improvements

-   Add extra parameters (e.g., modal_type)
-   Support video/audio upload
-   Integrate DeepFake detection model
-   Use streaming instead of full file read

## Author

-   Elvis Yan