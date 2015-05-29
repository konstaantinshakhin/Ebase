package ru.neoflex.ebase.model;

import java.util.List;

/**
 * Created by kshahin on 5/26/2015.
 */
public class Menu {
    private Item parentItem;
    private List<Item> childList;


    public Menu(){

    }


    public Item getParentItem() {
        return parentItem;
    }

    public void setParentItem(Item parentItem) {
        this.parentItem = parentItem;
    }

    public List<Item> getChildList() {
        return childList;
    }

    public void setChildList(List<Item> itemList) {
        this.childList = itemList;
    }


}
