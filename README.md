# OrangeHRM Selenium Java E2E Framework

## 📌 Project Overview
This project is an End-to-End Test Automation Framework developed using:
- Selenium WebDriver
- Java
- TestNG
- Maven
- Page Object Model (POM)

The framework automates login and page title validation scenarios for the OrangeHRM demo application.

---

## 🏗 Framework Design
- Page Object Model (POM)
- Reusable Base Test Class
- Configuration Management
- Maven Build Management
- TestNG Execution

---

## ▶ How to Run Tests

### Using Maven:
```bash
mvn clean test
```

### Using TestNG:

Run `testng.xml`

---

## 🌿 Branching Strategy
This project follows an industry-standard Git branching model:
- **`main`**: Production-ready code.
- **`develop`**: Main integration branch for features.
- **`feature/*`**: New features (e.g., `feature/login-automation`).
- **`fix/*`**: Bug fixes (e.g., `fix/dashboard-header-locator`).
- **`hotfix/*`**: Urgent fixes for the `main` branch.
- **`release/*`**: Preparation for a new production release.

---

## 📂 Project Structure

```
src
 ├── main/java
 │   └── com/automation/orangehrm/
 │       ├── base/
 │       └── utils/
 ├── test/java
 │   └── com/automation/orangehrm/
 │       ├── pages/
 │       └── tests/
 └── test/resources
     ├── config/
     ├── testng.xml
     └── log4j2.xml
```

---

## 👨‍💻 Author

Your Name
