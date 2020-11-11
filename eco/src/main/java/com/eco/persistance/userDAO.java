package com.eco.persistance;

import com.eco.model.User;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface userDAO {

    @SqlUpdate("insert into user(firstName,lastName,mobile,email,passwordHash) values(:firstname,:lastname,:mobile,:email,:passwordHash)")
    int insert(@Bind("firstname") String firstname, @Bind("lastname") String lastname, @Bind("mobile") String mobile,
            @Bind("email") String email, @Bind("passwordHash") String passwordHash);

    @SqlQuery("select * from user where email=:email")
    @Mapper(Usermapper.class)
    User get(@Bind("email") String email);

    @SqlUpdate("update user set passwordHash=:passwordHash where email=:email")
    int updatemail(@Bind("passwordHash") String passwordHash,@Bind("email") String email);
    // UPDATE ACTOR SET FIRST_NAME = :firstName, LAST_UPDATE = :lastUpdate WHERE
    // ACTOR_ID = :actorId;

    @SqlUpdate("update user set passwordHash=:passwordHash where mobile=:phoneNumber")
    int updatephone(@Bind("passwordHash") String passwordHash, @Bind("phoneNumber") String phoneNumber);

}
