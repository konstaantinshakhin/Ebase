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
import ru.neoflex.ebase.dao.CustomerDAO;
import ru.neoflex.ebase.dao.MenuDAO;
import ru.neoflex.ebase.model.MenuItem;

@Controller
public class HelloWorldController {

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    MenuDAO menuDAO;


    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("name","World");
        //returns the view name
        return "index";

    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

    @RequestMapping(value="/getMenu", method=RequestMethod.GET)
    public @ResponseBody String getMenu() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        MenuItem menuItem = menuDAO.getMenuItem();

        String json = "["+gson.toJson(menuItem)+"]";

        return json;
    }

    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public ModelAndView login() {

        ModelAndView model = new ModelAndView();
        model.setViewName("tree");

        return model;

    }
}