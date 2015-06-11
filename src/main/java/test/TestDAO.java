package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.neoflex.ebase.dao.CustomerDAO;
import ru.neoflex.ebase.dao.MenuDAO;
import ru.neoflex.ebase.model.Customer;
import ru.neoflex.ebase.model.Item;
import ru.neoflex.ebase.model.Menu;
import ru.neoflex.ebase.model.MenuItem;

import java.util.List;

/**
 * Created by kshahin on 5/15/2015.
 */
public class TestDAO {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        //ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("db_context.xml");

        ctx.load("db_context.xml");
        ctx.refresh();
        //CustomerDAO customerDAO = ctx.getBean("customerDAO", CustomerDAO.class);
        //Customer customer = customerDAO.getByLogin("user");
        //System.out.println(customer);
        MenuDAO menuDAO = ctx.getBean("menuDAO",MenuDAO.class);

        //Gson gson = new Gson();
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
       // System.out.println(gson.toJson(menu));


         //MenuItem menuItem = menuDAO.getMenuItem();
        //menuItem.toString();
        //String json = gson.toJson(menuItem);
        //System.out.println(json);
    }
}
