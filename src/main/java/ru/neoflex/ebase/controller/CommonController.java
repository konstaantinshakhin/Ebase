package ru.neoflex.ebase.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.neoflex.ebase.dao.ItemDAO;
import ru.neoflex.ebase.model.Item;
import ru.neoflex.ebase.model.MenuItem;

import java.util.List;

@Controller
public class CommonController {


    @Autowired
    ItemDAO itemDAO;


    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("name","World");
        //returns the view name
        return "item";

    }

    @RequestMapping(value ="/items", method = RequestMethod.GET)
    public ModelAndView items(
            @RequestParam(value = "id", required = false) Long id
    ) {
        ModelAndView model = new ModelAndView();
        List<Item> items = itemDAO.getItemsById(id);
        model.addObject("items", items);
        //returns the view name
        return model;

    }

    @RequestMapping(value ="/item", method = RequestMethod.GET)
    public ModelAndView item(
            @RequestParam(value = "id", required = false) Long id
    ) {
        ModelAndView model = new ModelAndView();
        Item item = itemDAO.getItemById(id);
        model.addObject("item", item);
        model.setViewName("item");

        return model;

    }


    @RequestMapping(value="/getMenu", method=RequestMethod.GET, produces={"application/json; charset=UTF-8"})
    public @ResponseBody String getMenu() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        List<MenuItem> menuItemList = itemDAO.getMenuItem();

        String json = gson.toJson(menuItemList);

        return json;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView cart() {

        ModelAndView model = new ModelAndView();
        model.setViewName("cart");

        return model;

    }
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView page(
            @RequestParam(value = "id", required = false) Long id
    ) {

        ModelAndView model = new ModelAndView();
        List<Item> items = itemDAO.getItemsById(id);
        model.setViewName("page");
        model.addObject("items", items);
        return model;

    }
}