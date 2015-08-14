package ru.neoflex.ebase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.neoflex.ebase.dao.ItemDAO;
import ru.neoflex.ebase.model.Item;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kshahin on 7/6/2015.
 */
@Controller
@SessionAttributes({"cart"})
public class CartController {
    @Autowired
    ItemDAO itemDAO;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart(
            Model model
    ) {

        return "cart";

    }


    @RequestMapping(value = "/addItem", method = RequestMethod.GET)
    public String addItem(
            @RequestParam(value = "id", required = false) Long id,
            Model model) {
        ArrayList<Item> cart = null;
        if (!model.containsAttribute("cart")) {
            cart = new ArrayList<Item>();
            model.addAttribute("cart", cart);
        } else cart = (ArrayList<Item>) model.asMap().get("cart");
        Item item = itemDAO.getItemById(id);
        Boolean containKey = false;
        for (Item itm : cart) {
            if (itm.getId().equals(id)) {
                containKey = true;
            }
        }

        if (!containKey) {
            cart.add(item);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/changeCount", method = RequestMethod.GET)
    public String changeCount(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "value", required = false) String value,
            Model model) {
        ArrayList<Item> cart = null;

        if (!model.containsAttribute("cart")) {
            cart = new ArrayList<Item>();
            model.addAttribute("cart", cart);
        } else cart = (ArrayList<Item>) model.asMap().get("cart");
        //Item item = itemDAO.getItemById(id);

        for (Item itm : cart) {
            if (itm.getId().equals(id)) {
            itm.setItemCount(value);
            }

        }
        return "/cart";
    }
}
