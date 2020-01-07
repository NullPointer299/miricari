package com.fjb3u.miricari.repository;

import com.fjb3u.miricari.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    @Query(value =
            "SELECT user_id, user_name,address,tel\n" +
                    "FROM users\n" +
                    "WHERE user_id = 1 AND password = 2;",
            nativeQuery = true)
    User login(final String id, final String password);
}
