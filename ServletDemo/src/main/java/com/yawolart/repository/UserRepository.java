package com.yawolart.repository;

import com.yawolart.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    Map<Long, User> userDb = new HashMap<>();

    //mimicking the JpaRepository methods naming convention

    public User save (User user)
    {
        userDb.put(user.getId(),user);
        return userDb.get(user.getId());
    }

    public User findById(long id)
    {
        return userDb.get(id);
    }

    public boolean delete(long id)
    {
        if(userDb.get(id) == null)
            return false;
        return userDb.remove(id) != null;
    }


}
