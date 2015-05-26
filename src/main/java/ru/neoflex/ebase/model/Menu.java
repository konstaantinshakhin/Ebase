package ru.neoflex.ebase.model;

import java.util.List;

/**
 * Created by kshahin on 5/26/2015.
 */
public class Menu {
    private Item menuItem;
    private List<Item> itemList;


    public Item getItem() {
        return menuItem;
    }

    public void setItem(Item menuItem) {
        this.menuItem = menuItem;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
