# Attendance-Management-System


A Java Swing based **Attendance Management System** for  
 
This project provides a modern dashboard-style UI with sidebar navigation, top search bar, attendance table, and summary cards.

---

## ✨ Features
- Dashboard-style UI (Sidebar + Top Bar + Center Table + Right Summary Panel)
- Student registration (ID, Name, Dept, Batch, Section)
- Attendance marking (Present/Absent/Leave)
- Dynamic summary cards:
  - Total Students
  - Present Today
  - Absent Today
- SQLite database integration (`attendance.db`)
- Clean, modern design with **Segoe UI** fonts and custom colors

---

## 🛠️ Technologies Used
- **Java Swing** (UI components)
- **SQLite JDBC** (Database)
- **CardLayout** (Panel navigation)
- **JTable** (Attendance & Reports)

---

## 📂 Project Structure

AttendanceSystem/
├── MainDashboard.java
├── DatabaseHelper.java
├── StudentPanel.java
├── AttendancePanel.java
├── ReportPanel.java
└── attendance.db   (auto created on first run)

## 🚀 Setup & Run

## 1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/attendance-system.git
   cd attendance-system
   
## 2.Compile the project:
## 3.Run the project:**
  java MainDashboard
