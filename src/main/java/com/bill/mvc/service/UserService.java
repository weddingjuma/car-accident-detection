package com.bill.mvc.service;

import com.bill.mvc.database.bean.enUserEntity;

import java.util.List;

/**
 * Created by chenking on 2017/5/5.
 */
public interface UserService {
    List<enUserEntity> findAllUser();
    void saveUser(enUserEntity user);
    void deleteUserByssn(String ssn);
    enUserEntity findByssn(String ssn);
    void updateUser(enUserEntity user);

}
