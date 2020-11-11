package com.eco.persistance;

import org.skife.jdbi.v2.DBI;

public class DbConnection {
    public final DBI getConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbc = "localhost:3306";
            DBI dbo = new DBI(
                    "jdbc:mysql://" + dbc + "/shop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "root", "skul");
            return dbo;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
