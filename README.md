Java-Based POS System with GitHub Actions and Allure Reporting

A desktop point-of-sale system implemented in Java with JUnit testing, GitHub Actions CI/CD, and automated test reporting through Allure.

---

![CI](https://img.shields.io/badge/CI-passing-brightgreen)
![Java](https://img.shields.io/badge/Java-17-blue)
![Allure](https://img.shields.io/badge/report-Allure-purple)
![License](https://img.shields.io/badge/license-MIT-green)

This repository contains the **Point-of-Sale System**, developed as part of a collaborative course project for CSC-449 Java Software Engineering at National University.

The project is implemented in Java and tested with JUnit, integrated with GitHub Actions for CI/CD, and published using Allure reporting.


---
Point-Of-Sale-Project

This Java-powered Point of Sale (POS) system is built for small businesses, offering an intuitive desktop interface for managing sales. Users can scan products, calculate totals in real time, and finalize transactions effortlessly. The system supports itemized receipts, multiple payment methods, and customizable user roles to enhance operational efficiency.

---

Features

Add and remove items to a cart                                     

Scan items by ID

Real-time cart subtotal and quantity updates

Support for multiple payment methods

Receipt printing

Unit-tested with **JUnit** and fully integrated with CI/CD

Test reports published via **Allure**

---

CI and Testing

Every push to the `main` branch automatically triggers:

JDK setup

Compilation and unit testing

Allure test report generation

Live deployment to GitHub Pages

View the latest test report here:
[Allure Test Report](https://ls1771.github.io/POS-Allure-Report/)

---

Tech Stack

Java

JUnit 5

GitHub Actions (CI/CD)

Allure Reporting

IntelliJ IDEA

---



 Here is the repository clone for local use:

   ```bash
   git clone https://github.com/Ls1771/Point-Of-Sale-Project.git
   cd Point-Of-Sale-Project
   ```
Compile and run into IDE:

   ```bash
   javac -d out src/**/*.java
   java Main
   ```

---
Credits

Laurence Smith

Alejandro Alatorre

Brandon Jett

---

Project Structure

```
Point-Of-Sale-Project/
├── .github/
│   └── workflows/
│       └── ci.yml
├── .idea/
├── out/
├── AuthService.java
├── Cart.java
├── CartItem.java
├── CartManager.java
├── Main.java
├── POSWindow.java
├── PaymentMethod.java
├── PaymentService.java
├── Product.java
├── README.md
├── ReceiptPrinter.java
├── Role.java
├── Transaction.java
├── TransactionService.java
├── User.java
├── receipt.txt
```
