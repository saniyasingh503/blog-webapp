# Dockerized Blog Webapp 

## Overview

This project is a **blog application** that is fully containerized and integrates **MySQL, Redis, and ELK (Elasticsearch, Logstash, Kibana)** for logging and monitoring. The entire application stack is orchestrated using **Docker Compose**, ensuring smooth communication betweenservices.

---

## Project Highlights

1. **Scalability and Efficiency**: Designed to be scalable and optimized for various environments (development, testing, production).
2. **Multi-Service Architecture**:
   - **Web Service**: A Java Spring Boot application that handles user requests and business logic.
   - **Database Service**: MySQL for persistent data storage.
   - **Cache Service**: Redis for fast data retrieval.
   - **Logging & Monitoring**: ELK Stack (Elasticsearch, Logstash, Kibana) for centralized logging and monitoring.

---

## Key Functionality

1. **Create Post (POST)**:
   - A new post is stored in the MySQL database.
   - The post is cached in Redis for quick access.
   - Log data is collected and sent to Elasticsearch via Logstash.

2. **Retrieve Post (GET)**:
   - The application first checks Redis for the requested post.
   - If not found in the cache, it fetches from MySQL, updates the cache, and returns the data.
   - API requests are logged in Elasticsearch for analysis.

3. **Update Post (PUT)**:
   - Updates an existing post in MySQL.
   - The cache in Redis is updated to maintain consistency.
   - The update event is logged and monitored using ELK.

4. **Delete Post (DELETE)**:
   - Deletes the post from MySQL.
   - Invalidates the corresponding Redis cache entry.
   - Logs the deletion event in Elasticsearch for auditing.

---

## Features

- **Java & Spring Boot**: Backend application built using Spring Boot.
- **MySQL**: Relational database for structured data storage.
- **Redis**: In-memory cache for quick access.
- **ELK Stack**: Centralized logging using Elasticsearch, Logstash, and Kibana.
- **Dockerized Setup**: Easy deployment with Docker Compose.
- **Environment Configuration**: Manage different environments using `.env` files.

---

## Technologies Used

- **Java & Spring Boot**: Backend framework for business logic.
- **MySQL**: Relational database for persistent storage.
- **Redis**: In-memory cache for quick access.
- **Docker**: Containerization platform for running services.
- **Docker Compose**: Tool for defining and managing multi-container applications.
- **Elasticsearch**: Distributed search engine for logs and analytics.
- **Logstash**: Log processing pipeline that sends logs to Elasticsearch.
- **Kibana**: Dashboard for monitoring logs and analytics.

---


## Prerequisites
Ensure you have the following installed:

1. [Docker](https://www.docker.com/)
2. [Docker Compose](https://docs.docker.com/compose/)

---

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/saniyasingh503/blog-webapp.git
cd blog-weapp
```

### 2. Build and Start the Application
Use Docker Compose to build and start the services.

```bash
docker-compose up --build
```

### 3. Access the Application

Once the application is running, you can access the following APIs:

- **GET** `/api/posts` – Retrieve the list of posts.
- **POST** `/api/posts` – Create a new post.
- **GET** `/api/posts/:id` – Retrieve an existing post by ID.
- **PUT** `/api/posts/:id` – Update an existing post by ID.
- **DELETE** `/api/posts/:id` – Delete a post by ID.

All APIs are available at the following base URL:

- **URL**: [http://localhost:8083](http://localhost:8083)


## Directory Structure

```bash
.
.
├── blog-app-backend/          # Java Spring Boot application source code
├── db/                        # MySQL Docker build context
├── cache/                     # Redis Docker build context
├── logs/                      # ELK Stack configuration
├── docker-compose.yml         # Docker Compose configuration
├── .env                       # Environment variables for development


```

## Stopping the Services
To stop and remove the containers, networks, and volumes, run the following command:

```bash
docker-compose down
```

## Health Checks
The setup includes health checks for MySQL, Redis, and ELK:

- **MySQL**: Runs a health check query.
- **Redis**: Checks service health with a PING command.
- **Elasticsearch**: Monitors log ingestion and search operations.

## Logging & Monitoring with ELK
- **Elasticsearch**: Stores logs and enables fast searching.
- **Logstash**: Collects and processes logs before sending them to Elasticsearch.
- **Kibana**: Provides visualization tools for logs and analytics.

Use Kibana to monitor logs and track performance metrics in real-time.

# CI/CD Pipeline with Docker and Docker Compose

This repository demonstrates how to set up a CI/CD pipeline to automate the build, test, and deployment process using Docker and Docker Compose.

