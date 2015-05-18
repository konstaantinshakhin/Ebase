package ru.neoflex.ebase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.neoflex.ebase.dao.PersonDAO;

@Controller
public class HelloWorldController {

    @Autowired
    PersonDAO personDAO;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("name","World");
        //returns the view name
        return "index";

    }

}