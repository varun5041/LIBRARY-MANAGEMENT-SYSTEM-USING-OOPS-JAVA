# 📚 Library Management System

A console-based **Library Management System** built using **Java, Object-Oriented Programming (OOP), JDBC, and MySQL**.

The project provides basic library operations such as managing books and members, issuing books, tracking borrowed books, and returning books.

It follows a simple layered architecture using **Service and Repository layers**, with JDBC used to communicate with the MySQL database.

---

## ✨ Features

- 📖 Add new books
- 📚 View all available books
- 🗑️ Remove books
- 👤 Add new library members
- 👥 View all library members
- ❌ Remove members
- 📕 Issue books to members
- 📋 View all borrowed books
- 🔄 Return borrowed books
- 💾 Persistent data storage using MySQL
- 🔎 Validation for invalid member and book IDs

---

## 🛠️ Technologies Used

- **Java**
- **JDBC (Java Database Connectivity)**
- **MySQL**
- **MySQL Connector/J**
- **Object-Oriented Programming (OOP)**
- **SQL**
- **IntelliJ IDEA**

---

# 🏗️ Project Architecture

The project follows a simple layered architecture:

```text
                 Main
                  │
                  ▼
          AdminServices
            (Interface)
                  │
                  ▼
        SqlAdminServiceimpl
                  │
       ┌──────────┼──────────┐
       ▼          ▼          ▼
 BookRepository  MemberRepository  IssueRepository
       │          │          │
       └──────────┼──────────┘
                  ▼
          DatabaseConnection
                  │
                  ▼
                MySQL
```

The application creates an `Admin` object in `Main` and passes it to the SQL-based service implementation. :contentReference[oaicite:0]{index=0}

The service implementation communicates with the `BookRepository`, `MemberRepository`, and `IssueRepository`. :contentReference[oaicite:1]{index=1}

---

# 📁 Project Structure

```text
src/
│
├── Application/
│   └── Main.java
│
├── Database/
│   └── databaseConnection.java
│
├── Models/
│   ├── Admin.java
│   ├── Book.java
│   └── Member.java
│
├── Repositories/
│   ├── BookRepository.java
│   ├── MemberRepository.java
│   └── IssueRepository.java
│
└── Services/
    ├── AdminServices.java
    │
    └── Implimentations/
        ├── AdminServicesImpl.java
        └── SqlAdminServiceimpl.java
```

---

# 🧩 Main Components

## Models

The project contains model classes representing the main entities of the application:

- `Admin`
- `Book`
- `Member`

---

## Service Layer

The service layer contains the application's operations and validation logic.

```text
AdminServices
      │
      ▼
SqlAdminServiceimpl
```

For example, before issuing a book, the service checks whether:

- Books are available
- The requested book exists
- The requested member exists

Only after these validations does it call the issue repository. :contentReference[oaicite:2]{index=2}

---

## Repository Layer

The Repository layer handles database operations using JDBC.

### BookRepository

Handles operations related to books:

```text
addBook()
getAllBooks()
getBookbyId()
DeleteBook()
```

### MemberRepository

Handles operations related to members:

```text
addMember()
getAllMembers()
getMemberById()
deleteMember()
```

### IssueRepository

Handles book borrowing operations:

```text
issueBook()
getBorrowedBooks()
returnBook()
```

The return operation retrieves the borrowed book information, adds the book back through `BookRepository`, and removes the borrowing record. :contentReference[oaicite:3]{index=3}

---

# 🗄️ Database Structure

The project uses a MySQL database named:

```text
library
```

It contains three main tables.

---

## `books`

Stores books that are currently available in the library.

| Column | Description |
|---|---|
| `id` | Unique Book ID |
| `title` | Book title |
| `author` | Book author |

---

## `members`

Stores registered library members.

| Column | Description |
|---|---|
| `id` | Unique Member ID |
| `name` | Member name |

---

## `borrowed_books`

Stores information about issued books.

| Column | Description |
|---|---|
| `member_id` | ID of member borrowing the book |
| `book_id` | ID of borrowed book |
| `member_name` | Name of member |
| `book_title` | Title of borrowed book |
| `book_author` | Author of borrowed book |

The application stores the book and member details in this table because issued books are removed from the currently available `books` table.

---

# 📕 Book Issue Flow

When an admin issues a book:

```text
Member ID + Book ID
        │
        ▼
Check Member
        │
        ▼
Check Book
        │
        ▼
Get Member Object
        │
        ▼
Get Book Object
        │
        ▼
Insert details into
borrowed_books
        │
        ▼
Remove Book from
books table
```

The repository first retrieves the member and book, inserts their details into `borrowed_books`, and then deletes the issued book from the available books table. :contentReference[oaicite:4]{index=4}

### Before Issue

```text
books

1111 | Atomic Habits | Author Name
```

### After Issue

The book is removed from:

```text
books
```

and stored in:

```text
borrowed_books

1234 | 1111 | Sachin | Atomic Habits | Author Name
```

---

# 🔄 Book Return Flow

Returning a book performs the reverse operation.

```text
Member ID + Book ID
        │
        ▼
Search borrowed_books
        │
        ▼
Get Book Details
        │
        ▼
Create Book Object
        │
        ▼
BookRepository.addBook()
        │
        ▼
Book added back to books
        │
        ▼
Delete entry from borrowed_books
```

After returning a book:

- The book becomes available again.
- The borrowing entry is removed.

---

# 🔌 JDBC Flow

The project uses JDBC to communicate with MySQL.

The general JDBC flow is:

```text
SQL Query
    │
    ▼
Connection
    │
    ▼
PreparedStatement
    │
    ▼
Set Parameters
    │
    ▼
executeQuery()
      OR
executeUpdate()
    │
    ▼
ResultSet
(for SELECT queries)
```

For example, `BookRepository` uses a `PreparedStatement` to insert a book into the database. :contentReference[oaicite:5]{index=5}

It converts rows returned from MySQL into `Book` objects when retrieving all books. :contentReference[oaicite:6]{index=6}

---

# 🖥️ Application Menu

When the application starts, the following menu is displayed:

```text
WELCOME TO LIBRARY!
=================================
1.Add Book
2.Show all Books
3.Remove Book
4.Add Members
5.Remove Members
6.Show all Members
7.Issue Book To a member
8.Show Books Borrowed By members
9.Return a book back
10.Exit
=================================
```

These options are currently implemented in the application's `Main` class. :contentReference[oaicite:7]{index=7}

---

# ⚙️ Setup on Your Device

Follow these steps to run the project locally.

## 1. Prerequisites

Install the following software:

- Java JDK
- MySQL Server
- MySQL Workbench
- IntelliJ IDEA or another Java IDE
- Git
- MySQL Connector/J

Verify Java:

```bash
java -version
```

Verify Git:

```bash
git --version
```

---

## 2. Clone the Repository

Open Terminal, Command Prompt, or Git Bash.

Run:

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPOSITORY_NAME.git
```

Then enter the project directory:

```bash
cd YOUR_REPOSITORY_NAME
```

Replace `YOUR_USERNAME` and `YOUR_REPOSITORY_NAME` with the actual repository details.

---

## 3. Open the Project

Open the cloned project using IntelliJ IDEA.

```text
File
  ↓
Open
  ↓
Select Project Folder
```

Make sure a valid Java JDK is configured for the project.

In IntelliJ IDEA:

```text
File
  ↓
Project Structure
  ↓
Project
  ↓
SDK
```

Select your installed JDK.

---

# 🗃️ MySQL Setup

## 4. Start MySQL

Make sure MySQL Server is installed and running.

Open **MySQL Workbench** and connect to your local MySQL server.

---

## 5. Create the Database

Run:

```sql
CREATE DATABASE library;
```

Then select it:

```sql
USE library;
```

---

## 6. Create the `books` Table

```sql
CREATE TABLE books (
    id INT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255)
);
```

---

## 7. Create the `members` Table

```sql
CREATE TABLE members (
    id INT PRIMARY KEY,
    name VARCHAR(255)
);
```

---

## 8. Create the `borrowed_books` Table

```sql
CREATE TABLE borrowed_books (
    member_id INT,
    book_id INT,
    member_name VARCHAR(255),
    book_title VARCHAR(255),
    book_author VARCHAR(255)
);
```

---

## 9. Verify the Tables

Run:

```sql
SHOW TABLES;
```

You should see:

```text
books
borrowed_books
members
```

---

# 🔗 Configure Database Connection

Open:

```text
src/Database/databaseConnection.java
```

Configure the connection according to your local MySQL installation.

Example:

```java
String url = "jdbc:mysql://localhost:3306/library";
String username = "root";
String password = "YOUR_MYSQL_PASSWORD";
```

Replace:

```text
YOUR_MYSQL_PASSWORD
```

with your own MySQL password.

> ⚠️ Never upload your real MySQL password or other credentials to a public GitHub repository.

---

# 🔌 MySQL Connector/J Setup

Java requires **MySQL Connector/J** to communicate with the MySQL database through JDBC.

Make sure the MySQL JDBC driver is included in the project.

If you are manually managing libraries, add the MySQL Connector/J `.jar` file to the project classpath.

If you later migrate the project to Maven, the driver can be managed as a Maven dependency.

---

# ▶️ Running the Application

Once the database and connection are configured:

1. Start MySQL Server.
2. Open the project in your IDE.
3. Open:

```text
src/Application/Main.java
```

4. Run the `main()` method.
5. Use the console menu to interact with the application.

The current `Main` creates the `Admin` and passes it to `SqlAdminServiceimpl` before starting the menu loop. :contentReference[oaicite:8]{index=8}

---

# 🧪 Testing the Application

After setup, you can test the complete application flow.

## Step 1 — Add a Book

Choose:

```text
1. Add Book
```

Enter:

```text
Book ID
Book Title
Book Author
```

Then select:

```text
2. Show all Books
```

The newly added book should appear.

---

## Step 2 — Add a Member

Choose:

```text
4. Add Members
```

Enter:

```text
Member ID
Member Name
```

Then choose:

```text
6. Show all Members
```

The member should appear in the list.

---

## Step 3 — Issue a Book

Choose:

```text
7. Issue Book To a member
```

Enter an existing:

```text
Member ID
Book ID
```

After successfully issuing the book:

```text
Show all Books
```

should no longer show that book.

Then:

```text
Show Books Borrowed By members
```

should show the issued book.

---

## Step 4 — Return the Book

Choose:

```text
9. Return a book back
```

Enter the:

```text
Member ID
Book ID
```

After a successful return:

- The book should appear again under **Show all Books**.
- The borrowing record should be removed from **Show Books Borrowed By members**.

---

# 🧠 Concepts Practiced

This project was built to practice:

- Java
- Object-Oriented Programming
- Classes and Objects
- Encapsulation
- Interfaces
- Abstraction
- Service Layer
- Repository Pattern
- JDBC
- MySQL
- SQL CRUD operations
- `Connection`
- `PreparedStatement`
- `ResultSet`
- Java Collections
- Exception Handling
- Layered Architecture
- Database Persistence

---

# ❗ Troubleshooting

## Unknown Database `library`

If you receive:

```text
Unknown database 'library'
```

create the database:

```sql
CREATE DATABASE library;
```

---

## Access Denied for MySQL User

If you receive an access denied error, check the username and password configured in:

```text
Database/databaseConnection.java
```

Make sure they match your local MySQL credentials.

---

## Communications Link Failure

Make sure:

- MySQL Server is running.
- The hostname is correct.
- The port is correct.
- The database exists.

The typical local connection URL is:

```text
jdbc:mysql://localhost:3306/library
```

---

## Table Doesn't Exist

Select the database:

```sql
USE library;
```

Then verify:

```sql
SHOW TABLES;
```

If the tables are missing, create them using the SQL commands provided in the setup section.

---

## MySQL JDBC Driver Not Found

If Java cannot find the MySQL JDBC driver, make sure **MySQL Connector/J** is included in the project's dependencies or classpath.

---

# 🔐 Security

Never commit sensitive information to GitHub, including:

```text
Database passwords
Database credentials
API keys
Tokens
```

Keep credentials local or use environment variables/configuration files that are excluded from Git.

---

# 🚀 Future Improvements

Possible improvements for future versions:

- JDBC transactions for issue/return operations
- `try-with-resources` for JDBC resources
- Improved exception handling
- Search books by title or author
- Track book availability
- Due dates for borrowed books
- Late-return fines
- Admin authentication
- Multiple admin accounts
- Better database normalization
- DTOs
- GUI interface
- REST API
- Spring Boot migration
- JPA/Hibernate integration
- Web frontend

---

# 🎯 Project Purpose

The main goal of this project is to understand how a basic Java OOP application can be connected to a relational database using JDBC.

The project demonstrates the transition from an in-memory application:

```text
Java Objects
     +
ArrayLists
```

to a database-backed application:

```text
Java Objects
      │
      ▼
Service Layer
      │
      ▼
Repository Layer
      │
      ▼
JDBC
      │
      ▼
MySQL
```

It provides a foundation for learning more advanced Java backend technologies such as **Spring Boot, JPA, Hibernate, and REST APIs**.

---

# 👨‍💻 Author

**Varun Soni**

Built as a Java OOP, JDBC, and MySQL learning project.