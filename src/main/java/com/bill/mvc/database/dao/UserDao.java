package com.bill.mvc.database.dao;

import com.bill.mvc.database.bean.enUserEntity;

import java.util.List;

/**
 * Created by chenking on 2017/5/5.
 */
public interface UserDao {
    void saveEmployee(enUserEntity user);
    List<enUserEntity> findAllUser();
    void deleteUserByssn(String ssn);
    enUserEntity findBySsn(String ssn);
    void updateEmployee(enUserEntity user);
}
