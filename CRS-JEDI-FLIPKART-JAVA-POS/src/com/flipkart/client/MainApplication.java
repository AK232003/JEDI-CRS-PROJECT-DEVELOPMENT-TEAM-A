package com.flipkart.client;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.flipkart.buisness.AuthService;
import com.flipkart.buisness.NotificationService;
import com.flipkart.buisness.StudentService;
import com.flipkart.buisness.UserService;
import com.flipkart.constant.NotificationType;

public class MainApplication {
    static boolean loggedin = false;

    AuthService userAuthService = new AuthService();

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
            System.out.println("-----------------Login------------------");
            System.out.println("Email:");
            userId = sc.next();
            System.out.println("Password:");
            password = sc.next();
            loggedin = userAuthService.verifyCredentials(userId, password);
            if (loggedin) {
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                LocalDateTime myDateObj = LocalDateTime.now();
                String formattedDate = myDateObj.format(myFormatObj);
                String role = userAuthService.getRole(userId);
                switch (role) {
                    case "ADMIN":
                        System.out.println(formattedDate + " Login Successful");
                        CRSAdminMenu adminMenu = new CRSAdminMenu(10);
                        adminMenu.ShowOptions();
                        break;
                    case "PROFESSOR":
                        System.out.println(formattedDate + " Login Successful");
                        CRSProfessorMenu professorMenu = new CRSProfessorMenu(10);
                        professorMenu.ShowOptions();
                        break;
                    case "STUDENT":
                        System.out.println(formattedDate + " Login Successful");
                        CRSStudentMenu studentMenu = new CRSStudentMenu(10);
                        studentMenu.ShowOptions();
                        break;
                }
            } else {
                System.err.println("Invalid Credentials!");
            }

    }

    /**
     * Method to help Student register themselves, pending admin approval
     */
    public void registerStudent() {
        Scanner sc = new Scanner(System.in);
        String userId, name, password, address, country, branchName;
        String gender;
        int genderV, batch;
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
            System.out.println("Gender:");
            gender=sc.next();
            int newStudentId = StudentService.register(name, userId, password, gender, batch, branchName, address, country);
            NotificationService.sendNotification(NotificationType.REGISTRATION, newStudentId, null, 0);

    }

    /**
     * Method to update password of User
     */
    public void updatePassword() {
        Scanner sc = new Scanner(System.in);
        String userId, newPassword;
        try {
            System.out.println("------------------Update Password--------------------");
            System.out.println("Email:");
            userId = sc.next();
            System.out.println("New Password:");
            newPassword = sc.next();
            boolean isUpdated = UserService.updatePassword(userId, newPassword);
            if (isUpdated) {
                System.out.println("Password updated successfully!");
            } else {
                System.err.println("Something went wrong, please try again!");
            }
        } catch (Exception ex) {
            System.err.println("Error Occurred " + ex.getMessage());
        }
    }

}