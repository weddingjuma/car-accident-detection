package com.billwork.mvc.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenking on 2017/5/5.
 */
@Service
public class UserServiceImpl implements UserService {

    public List<String> getAllUserNames() {
        List<String> users=new ArrayList<String>();
        users.add("KEN");
        users.add("Eric");
        users.add("CBQ");
        return users;
    }
}
