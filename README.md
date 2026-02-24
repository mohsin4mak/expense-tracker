# Expense Tracker

A personal finance tracker for managing monthly income and expenses.
Built as a full-stack learning project following production-grade engineering practices.

## Features

- Add, edit, and delete transactions (income or expense)
- View all transactions in a chronological passbook
- Monthly summary: total income, total expenses, and net balance
- Categorise transactions (e.g. rent, utilities, salary)

## Tech Stack

| Layer      | Technology              |
|------------|-------------------------|
| Backend    | Java 21, Spring Boot 3  |
| Frontend   | React 18, Vite          |
| Database   | PostgreSQL               |
| CI/CD      | GitHub Actions           |
| Deployment | Railway                  |

## Prerequisites

Before running this project locally, make sure you have installed:

- Java 21
- Node.js 20+
- PostgreSQL
- Maven

## Running Locally

### 1. Clone the repository
git clone https://github.com/YOUR_USERNAME/expense-tracker.git
cd expense-tracker

### 2. Start the backend
cd backend
./mvnw spring-boot:run

### 3. Start the frontend
cd frontend
npm install
npm run dev

### 4. Open in browser
http://localhost:5173

## Project Structure

expense-tracker/
├── backend/     # Spring Boot REST API
├── frontend/    # React application
└── .github/     # CI/CD workflows

## License
MIT
