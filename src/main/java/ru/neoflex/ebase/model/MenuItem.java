package ru.neoflex.ebase.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kshahin on 5/29/2015.
 */
public class MenuItem {
    private Long id;
    private Long parentId;
    private String nameItem;

    private List<MenuItem> childs;

    public MenuItem(){
        childs = new ArrayList<MenuItem>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public List<MenuItem> getChilds() {
        return childs;
    }

    public void setChilds(List<MenuItem> childs) {
        this.childs = childs;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
