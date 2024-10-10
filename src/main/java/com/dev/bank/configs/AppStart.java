package com.dev.bank.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStart {

    public static void main(String[] args) {
        SpringApplication.run(AppStart.class, args);
    }
}

// UI(User Interface) ------- JS/TS, html, css ------------ NO LOGIC, ONLY DISPLAY INFORMATION
// -------------------------- Communication - JSON --------
// REST API ----------------- Java, Spring, Hibernate ----- LOGIC, ACTIONS WITH DATA
// Database ------------------ MySql ---------------------- STORE DATA



//configs - CONFIG FILES FOR PROJECT
//controllers - CLASSES WITH ENDPOINTS (REST API)
//services - LOGIC
//models - CLASSES WITH MODELS AND ENTITIES
//dao - CLASSES WITH DATA ACCESS OBJECTS
//repositories - CLASSES WITH ACCESS TO DATABASE


//ARCHITECTURE PLAN

//Authentication - login, registration
//Users - get, update, delete users
//Accounts - add, delete, withdraw, transfer
//Security - token security (NOT SPRING SECURITY)


//COMPLETED TASKS

//Authentication:

//login - endpoint, model
//registration - endpoint, model
