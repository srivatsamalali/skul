package com.eco.util;

public class login {

    private void mainMenu() throws WriterException, IOException {

        System.out.println("Choose an Option");
        System.out.println("----------------");
        System.out.println("1. Login");
        System.out.println("2. Sign up or Register");
        System.out.println("3. Exit\n");

        System.out.print("Your Option: ");
        int loginoption = option.nextInt();
        loginDetails(loginoption);
    }

    private void loginDetails(final int selectedoption) throws WriterException, IOException {

        switch (selectedoption) {
            case 1:
                // loginService();
                serviceMenu(4);
                break;

            case 2:
                signUpService();
                break;

            case 3:
                Runtime.getRuntime().halt(0);
                break;

            default:
                System.out.println("\nPlease Select either 1, 2 or 3.");
        }

        mainMenu();
    }

    private void loginService() throws WriterException, IOException {

        System.out.println("\nLogin");
        System.out.println("-----");

        System.out.print("Enter Your Email ID: ");
        String userEmail = option.next();

        char[] pwd = passwordInput.readPassword("Enter Your Password: ");
        String userPassword = String.valueOf(pwd);

        // * * Login VerificationMethod 1
        User checkEmail = UserFactory.check(userEmail);

        if (checkEmail != null) {

            User signIn = UserFactory.find(userEmail, userPassword);

            if (signIn != null) {

                System.out.println("\nLogged in Successfully!");
                System.out.println("Your User ID is: " + signIn.getUserId());
                serviceMenu(signIn.getUserId());

            } else {

                System.out.println("\nEmail or Password is incorrect.\n");
                loginDetails(1);
            }

        } else {

            System.out.println("\nUser Not Found. Please register with us to use the service.\n");
            mainMenu();

        }

    }

    /**
     * @throws WriterException
     * @throws IOException
     */
    private void signUpService() throws WriterException, IOException {

        System.out.println("\nSignUp Form");
        System.out.println("-----------");

        System.out.print("Enter Your First Name: ");
        option.nextLine();
        String userFirstName = option.nextLine();

        System.out.print("Enter Your Last Name: ");
        String userLastName = option.nextLine();

        System.out.print("Enter Your Phone Number: ");
        String userPhone = option.next();

        System.out.print("Enter Your Email Address: ");
        String userEmail = option.next();

        System.out.print("Confirm Your Email Address: ");
        String userEmailConfirm = option.next();

        System.out.print("");
        char[] pwd = passwordInput.readPassword("Enter Your Password: ");
        String userPassword = String.valueOf(pwd);

        System.out.print("");
        char[] pwdConfirm = passwordInput.readPassword("Confirm Your Password: ");
        String userPasswordConfirm = String.valueOf(pwdConfirm);

        if (userEmail.equals(userEmailConfirm) && userPassword.equals(userPasswordConfirm)) {

            User user = UserFactory.check(userEmail);
            System.out.println(" ");
            if (user != null) {

                System.out.println("This Email has already registered with us. Please Login.");
                mainMenu();

            } else {

                UserFactory.updateUser(userFirstName, userLastName, userEmail, userPassword, userPhone);
                System.out.println("\nThank you Registering with us!");
                System.out.println("Please Login to Obtain your User ID.");
                mainMenu();

            }

        } else {

            System.out.println("\nEmail/Password Confirmation Failed, Please Try Again");
            signUpService();

        }

    }

}
