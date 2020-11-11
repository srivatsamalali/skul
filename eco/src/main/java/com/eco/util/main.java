package com.eco.util;

import java.util.Scanner;

import com.eco.factory.Userfactory;
import com.eco.model.User;

public class main {
    Scanner sc = new Scanner(System.in);

    private void mainmenu() {
        System.out.println("Welcome to Ecommerce Website!");
        System.out.println("Please enter you choice!");
        System.out.println("1. Sign-up");
        System.out.println("2. Profile");
        System.out.println("3. Product list");
        System.out.println("4. Cart");
        System.out.println("5. Exit");
        int opt = sc.nextInt();
        menu(opt);
    }

    public void menu(final int option) {
        switch (option) {
            case 1:
                signup();
                break;
            case 2:
                showuser();
                break;
            case 3:
                product();
                break;
            case 4:
                cart();
            case 5:
                Runtime.getRuntime().halt(0);
                break;
            default:
                System.out.println("enter your choice1 ,2 ,3 ,4 or 5");
        }
    }

    private void cart() {
        mainmenu();
    }

    private void product() {

    }

    private void showuser() {
        System.out.println("User Profile\n");
        System.out.println("Enter your Email-id\n");
        String mail = sc.next();
        User uco = Userfactory.getuser(mail);
        if (uco == null) {
            System.out.println("no user has that mail id\n");
            System.out.println("Try Resetting your password\n");
            System.out.println("1. To Reset your Password\n");
            System.out.println("2. try again\n");
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    passreset();
                    break;
                case 2:
                    mainmenu();
                    break;
                case 3:
                    Runtime.getRuntime().exit(0);
                    break;
                default:
                    System.out.println("Please select your choice");
            }
        } else {
            System.out.println("Profile Id : " + uco.getId() + "\n");
            System.out.println("First Name : " + uco.getFirstname() + "\n");
            System.out.println("Last Name : " + uco.getLastname() + "\n");
            System.out.println("Phone Number : " + uco.getPhoneNumber() + "\n");
            System.out.println("Email-Id : " + uco.getEmail() + "\n");
        }
        mainmenu();
    }

    private void signup() {
        System.out.println("Welcome to our shopping website :-)");
        System.out.println("*******************Sign-up******************");
        System.out.println("Enter your First Name\n");
        String firstname = sc.next();

        System.out.println("Enter your Last Name\n");
        String lastName = sc.next();

        System.out.println("Enter your Mobile Number\n");
        String mobileNumber = sc.next();

        System.out.println("Enter your Email-id\n");
        String Email = sc.next();

        System.out.println("Enter your preferred password\n");
        String password = sc.next();
        Userfactory.insertUser(firstname, lastName, mobileNumber, Email, password);
        System.out.println("********************User Added********************");
        System.out.println("Thanks for signing in " + firstname);
        mainmenu();
    }

    private void passreset() {
        System.out.println("Enter your mail-id\n");
        String mail = sc.next();
        User uco = Userfactory.getuser(mail);
        if (uco == null) {
            System.out.println("Enter your phone number\n");
            String phone = sc.next();
            User phonenum = Userfactory.resetphone(phone);
            if (phonenum == null) {
                System.out.println("No Such User\n");
            } else {
                System.out.println("Enter Your new Password\n");
                String newp = sc.next();
                Userfactory.resetpasswordwithphone(phone, newp);
            }
        } else {
            System.out.println("Enter Your new Password\n");
            String newp = sc.next();
            Userfactory.resetpasswordwithmail(mail, newp);
        }
        System.out.println("Successfully changed password\n");
        mainmenu();

    }

    public static void main(final String[] args) {
        final main obj = new main();
        obj.mainmenu();

    }
}