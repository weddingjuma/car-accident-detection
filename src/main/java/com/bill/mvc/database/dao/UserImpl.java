package com.bill.mvc.database.dao;

import com.bill.mvc.database.bean.enUserEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chenking on 2017/5/5.
 */
@Transactional
@Repository("userdao")
public class UserImpl extends AbstractDao implements UserDao {
    public void saveEmployee(enUserEntity user) {
        persist(user);
    }

    @SuppressWarnings("unchecked")
    public List<enUserEntity> findAllUser() {
        Criteria criteria=getSession().createCriteria(enUserEntity.class);

        return (List<enUserEntity>) criteria.list();
    }

    public void deleteUserByssn(String ssn) {
        Query query=getSession().createSQLQuery("delete from user where id=:ssn");
        query.setString("ssn",ssn);
        query.executeUpdate();
    }

    public enUserEntity findBySsn(String ssn) {
        Criteria criteria=getSession().createCriteria(enUserEntity.class);
        criteria.add(Restrictions.eq("ssn",ssn));
        return (enUserEntity) criteria.uniqueResult();

    }

    public void updateEmployee(enUserEntity user) {
        getSession().update(user);
    }

}
