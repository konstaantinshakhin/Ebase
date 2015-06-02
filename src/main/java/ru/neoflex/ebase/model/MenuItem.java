package ru.neoflex.ebase.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kshahin on 5/29/2015.
 */
public class MenuItem {


    @Expose(serialize = false)
    private Long parentId;

    @Expose(serialize = true)
    @SerializedName("label")
    private String nameItem;

    @Expose(serialize = true)
    private Long id;

    @Expose(serialize = true)
    @SerializedName("children")
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
