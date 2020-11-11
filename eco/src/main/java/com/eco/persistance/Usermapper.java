package com.eco.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.eco.model.User;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class Usermapper implements ResultSetMapper<User> {

    @Override
    public final User map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        // TODO Auto-generated method stub

        return new User(r.getString("id"), r.getString("firstName"), r.getString("lastName"), r.getString("mobile"),
                r.getString("email"), r.getString("passwordHash"));
    }

}
