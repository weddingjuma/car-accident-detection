package com.bill.mvc.database.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chenking on 2017/5/5.
 */
@Transactional
public class AbstractDao {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.openSession();
    }
    public void persist(Object entity){
        getSession().persist(entity);
    }
    public void delete(Object entity){
        getSession().delete(entity);
    }

}
