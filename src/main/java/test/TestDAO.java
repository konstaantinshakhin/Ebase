package test;

import com.google.gson.Gson;
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
        Item im = null;
        List<Item> itemList=menuDAO.getListItem(im);
        List<Item> il;
        for(Item item:itemList){
            il=menuDAO.getListItem(item);
            il.toString();
        }
        Long id = null;
        Menu menu = menuDAO.getMenuItem(id);
        Gson gson = new Gson();
       // System.out.println(gson.toJson(menu));
        Menu mu ;
        for(Item item:menu.getChildList()){
            mu=menuDAO.getMenuItem(item.getId());
            mu.toString();
        }
        menu.toString();

        MenuItem menuItem = menuDAO.getMenuItem();
        menuItem.toString();
        System.out.println(gson.toJson(menuItem));
    }
}
