package com.samplelogin.ekarth;

import com.samplelogin.ekarth.pojo.User;
import com.samplelogin.ekarth.pojo.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shiwang on 5/23/17.
 */
    public class Main
    {
        public static void main( String[] args )
        {
            String userDir = System.getProperty("user.dir");
            String relativeDir = "/src/main/webapp/WEB-INF/spring-datasource.xml";
            ApplicationContext context =
                    new ClassPathXmlApplicationContext("spring-core-config.xml");
            

            UserDAO customerDAO = (UserDAO) context.getBean("customerDAO");
            User customer = new User(1, "shiwangi",28);
            customerDAO.insert(customer);

            User customer1 = customerDAO.findByCustomerId(1);
            System.out.println(customer1);

        }
    }
