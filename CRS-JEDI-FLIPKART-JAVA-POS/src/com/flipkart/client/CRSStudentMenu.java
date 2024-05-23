package com.flipkart.client;

import com.flipkart.beans.Student;
import com.flipkart.buisness.StudentInterface;
import com.flipkart.buisness.StudentService;

import java.util.*;

/**
 *
 */
public class CRSStudentMenu {
    public int studentid;
    public CRSStudentMenu(int id) {
        studentid = id;
    }



    public void ShowOptions() {
        // TODO Auto-generated method stub
        Scanner sc= new Scanner(System.in);
        StudentInterface studentService = new StudentService();
        int a=1;
        while(a!=0)
        {
            System.out.println("Enter the choice: ");
            System.out.println("1. Register course ");
            System.out.println("2. View the result ");
            System.out.println("3. View the catalogue ");
            System.out.println("4. Pay Bills ");
            System.out.println("0. Exit ");
            a= sc.nextInt();

            switch(a)
            {
                case 0:
                    return;
                case 1:
                    studentService.registercourse(studentid);
                    break;
                case 2:
                    studentService.viewresult(studentid);
                    break;
                case 3:
                    studentService.viewcatalogue(studentid);
                    break;
                case 4:
                    studentService.payBills(studentid);
                    break;
                default:
                    continue;
            }
        }


    }

}