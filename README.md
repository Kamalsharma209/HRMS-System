# 🚀 HRMS-System (Human Resource Management System)

## 📌 Overview

The HRMS-System is a backend application built using Spring Boot that helps organizations manage employee data and HR operations efficiently.
It follows a layered architecture and exposes RESTful APIs for handling employee management, authentication, and system operations.

This project demonstrates real-world backend development practices including database integration, API design, and scalable architecture.

---

## 🛠️ Tech Stack

* **Backend:** Spring Boot
* **Database:** MySQL
* **ORM:** Spring Data JPA
* **Security:** Spring Security
* **API Docs:** Swagger (OpenAPI)
* **Build Tool:** Maven

---

## 🧠 Architecture

The project follows a standard layered architecture:

Client (Postman / Frontend)
↓
Controller Layer (REST APIs)
↓
Service Layer (Business Logic)
↓
Repository Layer (JPA)
↓
MySQL Database

---

## ✨ Features

* Employee Management (Create, Read, Update, Delete)
* RESTful API design
* Database integration with MySQL
* Layered architecture (Controller → Service → Repository)
* Swagger API documentation
* Scalable backend structure

---

## 📂 Project Structure

src/main/java/
├── controller/     # API endpoints
├── service/        # Business logic
├── repository/     # Database access
├── model/          # Entity classes
├── config/         # Configuration (Swagger, Security)

src/main/resources/
├── application.properties

---

## ⚙️ Installation & Setup

### ✅ Prerequisites

* Java 17+
* Maven
* MySQL
* IDE (IntelliJ / Eclipse)

---

### 🔽 1. Clone Repository

git clone https://github.com/Kamalsharma209/HRMS-System.git
cd HRMS-System

---

### 🗄️ 2. Setup Database

Login to MySQL and create database:

CREATE DATABASE hrms_db;

---

### ⚙️ 3. Configure application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/hrms_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

---

### ▶️ 4. Run the Application

Using Maven:
mvn spring-boot:run

OR run the main class in your IDE.

---

### 🌐 5. Access Application

Server will start at:
http://localhost:8080

---

## 📖 API Documentation (Swagger)

This project uses Swagger (OpenAPI) for API documentation.

### 🔗 Swagger UI

http://localhost:8080/swagger-ui/index.html

### ✨ What You Can Do

* View all APIs in one place
* Test endpoints directly from browser
* See request/response formats

---

## 📡 Sample API Endpoints

| Method | Endpoint            | Description       |
| ------ | ------------------- | ----------------- |
| GET    | /api/employees      | Get all employees |
| POST   | /api/employees      | Add new employee  |
| PUT    | /api/employees/{id} | Update employee   |
| DELETE | /api/employees/{id} | Delete employee   |
| POST   | /api/auth/login     | User login        |

---

## 🧪 Testing

You can test APIs using:

* Swagger UI
* Postman

---

## 🚀 Future Improvements

* JWT Authentication & Authorization
* Role-based access control (Admin/User)
* Frontend integration (React dashboard)
* Exception handling & validation
* Cloud deployment (AWS / Render)

---

## ⚠️ Known Limitations

* No frontend UI yet
* Limited security implementation
* Basic validation

---

## 👨‍💻 Author

Kamal Sharma
GitHub: https://github.com/Kamalsharma209

---

## ⭐ Contributing

Feel free to fork this repository and contribute by submitting a pull request.

---

## 📜 License

This project is open-source and available under the MIT License.
