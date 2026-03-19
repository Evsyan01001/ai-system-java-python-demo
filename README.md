#   AI System Demo (Java + Python)

## 1. 项目简介

    本项目实现了一个基于 Java + Python 的 AI 系统原型，用于支持伪造音视频检测任务。

    系统采用前后端分离架构：
-   使用 FastAPI 构建 Python 后端服务，负责接收文件并进行处理
-   使用 Java 作为客户端，通过 HTTP 请求上传文件并获取结果

    该项目为后续集成 Deepfake 检测模型 （音频 + 视频）提供了完整的系统基础。

## 2. 技术栈

- Java
- FastAPI
- HTTP通信

## 3. 功能

- Java 调用 Python API
- 文件上传
- 返回结果

## 4. 如何运行

### 启动 Python 服务
    bash
uvicorn api:app --reload --port 8000

### 运行Java
Javac CallAPI.java
java CallAPI

## 5. 示例
curl -X POST "http://127.0.0.1:8000/Predict" \
  -F "file=@test.txt"

