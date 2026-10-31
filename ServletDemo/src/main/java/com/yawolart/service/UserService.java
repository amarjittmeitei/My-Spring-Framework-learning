package com.yawolart.service;

import com.yawolart.model.User;
import com.yawolart.repository.UserRepository;

public class UserService {

    UserRepository users = new UserRepository();

    public User createService(User user)
    {
        User checkUser = new User();
        checkUser = users.save(user);
        return checkUser;
    }

    public User getUserService(long id)
    {
        User checkUser = new User();
        checkUser = users.findById(id);
        return checkUser;
    }

    public boolean deleteUserService(long id)
    {
        boolean isDeleted = users.delete(id);
        return isDeleted;
    }


}
