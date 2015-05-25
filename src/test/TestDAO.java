package test;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.neoflex.ebase.dao.CustomerDAO;
import ru.neoflex.ebase.model.Customer;

/**
 * Created by kshahin on 5/15/2015.
 */
public class TestDAO {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        //ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("db_context.xml");

        ctx.load("db_context.xml");
        ctx.refresh();
        CustomerDAO customerDAO = ctx.getBean("personDAO", CustomerDAO.class);
        Customer customer = customerDAO.getByLogin("user");
        System.out.println(customer);
    }
}
