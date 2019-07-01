package com.zhenxin.service;

import com.zhenxin.pojo.JsonData;
import com.zhenxin.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    JsonData findUser();

    JsonData addUser(User user);

    JsonData updateUser(User user);

    JsonData deleteUser(int userId);

    JsonData login(String userName, String password);
}
