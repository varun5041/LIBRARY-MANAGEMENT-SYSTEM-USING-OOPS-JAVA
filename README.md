# 📚 Library Management System

A console-based **Library Management System** built using **Java, Object-Oriented Programming (OOP), JDBC, and MySQL**.

This project was initially designed using Java collections and OOP concepts and was later integrated with a MySQL database using JDBC for persistent data storage.

---

## 🚀 Features

The application provides the following features:

- 📖 Add a new book
- 📚 Display all available books
- 🗑️ Remove a book
- 👤 Add a library member
- ❌ Remove a library member
- 👥 Display all library members
- 📕 Issue a book to a member
- 📋 Display all borrowed books
- 🔄 Return a borrowed book
- 💾 Persistent data storage using MySQL

---

## 🛠️ Technologies Used

- **Java**
- **JDBC (Java Database Connectivity)**
- **MySQL**
- **MySQL Connector/J**
- **IntelliJ IDEA**
- **Object-Oriented Programming**

---

## 🏗️ Project Architecture

The project follows a layered architecture:

```text
Main
 │
 ▼
AdminServices (Interface)
 │
 ▼
SqlAdminServiceimpl
 │
 ├───────────────┬────────────────┬─────────────────┐
 ▼               ▼                ▼
BookRepository  MemberRepository  IssueRepository
 │               │                │
 └───────────────┴────────────────┘
                 │
                 ▼
          DatabaseConnection
                 │
                 ▼
              MySQL