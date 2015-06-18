package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.neoflex.ebase.dao.ItemDAO;
import ru.neoflex.ebase.model.Item;

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
        ItemDAO itemDAO = ctx.getBean("itemDAO",ItemDAO.class);

        //Gson gson = new Gson();
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
       // System.out.println(gson.toJson(menu));


         //MenuItem menuItem = menuDAO.getMenuItem();
        //menuItem.toString();
        //String json = gson.toJson(menuItem);
        //System.out.println(json);
        Item item = itemDAO.getItemById(new Long(2));
        List<Item> itemList = itemDAO.getItemsById(new Long(2));
        System.out.println(item);
    }
}
