package test;

import com.bill.mvc.database.bean.enUserEntity;
import com.bill.mvc.service.UserService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenking on 2017/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
@WebAppConfiguration
public class UserServiceImplTest {

    @Autowired
    private ApplicationContext context;


    UserService service;

    @org.junit.Test
    public void findAllUser() throws Exception {
            List<enUserEntity> users=service.findAllUser();
        System.out.println(users.size());
    }

    @org.junit.Test
    public void findByssn() throws Exception {
        enUserEntity result=service.findByssn("1");
        System.out.println(result.toString());
    }

    @Before
    public void setUp() throws Exception {
        service=(UserService)context.getBean("userServiced");

    }
}