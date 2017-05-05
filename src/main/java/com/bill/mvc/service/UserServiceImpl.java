package com.bill.mvc.service;

import com.bill.mvc.database.bean.enUserEntity;
import com.bill.mvc.database.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenking on 2017/5/5.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    public List<enUserEntity> findAllUser() {

        return dao.findAllUser();
    }
    @Transactional
    public void saveUser(enUserEntity user) {
        dao.saveEmployee(user);
    }
    @Transactional
    public void deleteUserByssn(String ssn) {
        dao.deleteUserByssn(ssn);
    }

    public enUserEntity findByssn(String ssn) {
        return dao.findBySsn(ssn);
    }
    @Transactional
    public void updateUser(enUserEntity user) {
        dao.updateEmployee(user);
    }
}
