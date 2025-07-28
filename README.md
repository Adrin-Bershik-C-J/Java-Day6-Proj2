# Java Bug Tracking System (Day 6 Project 2)

This project is a **console-based Bug Tracking System** built using **Java**, **JDBC**, and **PostgreSQL**.  
It follows a **clean layered architecture** (Controller → Service → Repository → Database).

---

## 📂 Project Structure

Directory structure:
└── adrin-bershik-c-j-java-day6-proj2/
    ├── pom.xml
    └── src/
        ├── main/
        │   └── java/
        │       └── com/
        │           └── day6proj2/
        │               ├── Main.java
        │               ├── controller/
        │               │   └── BugController.java
        │               ├── entity/
        │               │   └── Bug.java
        │               ├── repository/
        │               │   ├── BugRepository.java
        │               │   └── BugRepositoryImpl.java
        │               ├── service/
        │               │   └── BugService.java
        │               └── utils/
        │                   └── DBUtil.java
        └── test/
            └── java/
                └── com/
                    └── day6proj2/
                        └── AppTest.java


---

## 🚀 Features

- ➕ Insert new bugs with title, description, and status.  
- 📋 View all bugs stored in the database.  
- ❌ Delete a bug by its ID.  
- 🔄 Update the status of an existing bug.  
- ✅ Follows clean **MVC + DAO** structure.

---

## 🛠️ Technologies Used

- **Java 17+**
- **JDBC (Java Database Connectivity)**
- **PostgreSQL**
- **Maven**

---
