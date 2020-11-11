package com.eco.factory;

import com.eco.model.User;
import com.eco.persistance.DbConnection;
import com.eco.persistance.userDAO;

public class Userfactory {

    private static userDAO dao() {
        DbConnection connection = new DbConnection();
        return connection.getConnect().onDemand(userDAO.class);

    }

    public static int insertUser(String firstname, String lastName, String mobileNumber, String email,
            String password) {
        return dao().insert(firstname, lastName, mobileNumber, email, password);
    }

    public static User getuser(String email) {
        return dao().get(email);
    }

    public static User resetphone(String phoneNumber) {
        return dao().getph(phoneNumber);
    }

    public static int resetpasswordwithphone(String phoneNumber, String password) {
        return dao().updatephone(password, phoneNumber);
    }

    public static int resetpasswordwithmail(String email,String password) {
        return dao().updatemail(password, email);
    }
}
