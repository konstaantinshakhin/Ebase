package test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.neoflex.ebase.dao.PersonDAO;
import ru.neoflex.ebase.model.Person;

/**
 * Created by kshahin on 5/15/2015.
 */
public class TestDAO {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        //ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("db_context.xml");

        ctx.load("db_context.xml");
        ctx.refresh();
        PersonDAO personDAO = ctx.getBean("personDAO", PersonDAO.class);
        Person person = personDAO.getByLogin("user");
        System.out.println(person);
    }
}
