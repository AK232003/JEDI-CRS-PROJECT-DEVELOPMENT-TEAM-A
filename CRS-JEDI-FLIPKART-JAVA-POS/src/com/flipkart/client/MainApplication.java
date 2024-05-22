package com.flipkart.client;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.flipkart.buisness.Auth;

public class MainApplication {
    static boolean loggedin = false;

    Auth userAuth = new Auth();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MainApplication crsApplication = new MainApplication();
        int userInput;
        // Create the main menu
        createMainMenu();
        userInput = sc.nextInt();
        try {
            // Until user does not exit the application
            while (userInput != 4) {
                switch (userInput) {
                    case 1:
                        // Login
                        crsApplication.loginUser();
                        break;
                    case 2:
                        // Student registration
                        crsApplication.registerStudent();
                        break;
                    case 3:
                        crsApplication.updatePassword();
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
                createMainMenu();
                userInput = sc.nextInt();
            }
        } catch (Exception ex) {
            System.err.println("Error occurred " + ex);
        } finally {
            sc.close();
        }
    }

    /**
     * Method to Create Main Menu
     */
    public static void createMainMenu() {
        System.out.println("----------Welcome to Course Management System---------");
        System.out.println("1. Login");
        System.out.println("2. Student Registration");
        System.out.println("3. Update password");
        System.out.println("4. Exit");
        System.out.println("Enter user input");
    }

    /**
     * Method for Login functionality
     */
    public void loginUser() {
        Scanner sc = new Scanner(System.in);
        String userId, password;
        try {
            System.out.println("-----------------Login------------------");
            System.out.println("Email:");
            userId = sc.next();
            System.out.println("Password:");
            password = sc.next();
            loggedin = userAuth.verifyCredentials(userId, password);
            if (loggedin) {
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                LocalDateTime myDateObj = LocalDateTime.now();
                String formattedDate = myDateObj.format(myFormatObj);
                String role = userAuth.getRole(userId);
                Role userRole = Role.stringToName(role);
                switch (userRole) {
                    case ADMIN:
                        System.out.println(formattedDate + " Login Successful");
                        AdminCRSMenu adminMenu = new AdminCRSMenu();
                        adminMenu.createMenu();
                        break;
                    case PROFESSOR:
                        System.out.println(formattedDate + " Login Successful");
                        ProfessorCRSMenu professorMenu = new ProfessorCRSMenu();
                        professorMenu.createMenu(userId);
                        break;
                    case STUDENT:
                        int studentId = studentInterface.getStudentId(userId);
                        boolean isApproved = studentInterface.isApproved(studentId);
                        if (isApproved) {
                            System.out.println(formattedDate + " Login Successful");
                            StudentCRSMenu studentMenu = new StudentCRSMenu();
                            studentMenu.create_menu(studentId);
                        } else {
                            System.err.println("Failed to login, you have not been approved by the administration!");
                            loggedin = false;
                        }
                        break;
                }
            } else {
                System.err.println("Invalid Credentials!");
            }
        } catch (UserNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Method to help Student register themselves, pending admin approval
     */
    public void registerStudent() {
        Scanner sc = new Scanner(System.in);
        String userId, name, password, address, country, branchName;
        Gender gender;
        int genderV, batch;
        try {
            // Input all the student details
            System.out.println("---------------Student Registration-------------");
            System.out.println("Name:");
            name = sc.nextLine();
            System.out.println("Email:");
            userId = sc.next();
            System.out.println("Password:");
            password = sc.next();
            System.out.println("Gender: \t 1: Male \t 2.Female\t 3.Other");
            genderV = sc.nextInt();
            sc.nextLine();
            System.out.println("Branch:");
            branchName = sc.nextLine();
            System.out.println("Batch:");
            batch = sc.nextInt();
            sc.nextLine();
            System.out.println("Address:");
            address = sc.nextLine();
            System.out.println("Country:");
            country = sc.next();
            gender = Gender.getName(genderV);
            int newStudentId = studentInterface.register(name, userId, password, gender, batch, branchName, address, country);
            notificationInterface.sendNotification(NotificationType.REGISTRATION, newStudentId, null, 0);
        } catch (Exception ex) {
            System.err.println("Error occurred " + ex);
        }
    }

