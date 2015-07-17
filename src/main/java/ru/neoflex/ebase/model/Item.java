package ru.neoflex.ebase.model;

/**
 * Created by kshahin on 5/25/2015.
 */
public class Item {
    private Long id;
    private Long parentId;
    private String itemName;
    private String itemCount;
    private Long lev;
    private String path;
    private Float price;

    public Item(long id,String itemName, String path) {
        this.id = id;
        this.itemName = itemName;
        this.path = path;
    }

    public Item(){

    }

    public Item(long id, long parentId, String itemName, String itemCount, Long lev, String path,Float price) {
        this.id = id;
        this.parentId = parentId;
        this.itemName = itemName;
        this.itemCount= itemCount;
        this.setLev(lev);
        this.path = path;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCount() {
        return itemCount;
    }

    public void setItemCount(String itemCount) {
        this.itemCount = itemCount;
    }



    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getLev() {
        return lev;
    }

    public void setLev(Long lev) {
        this.lev = lev;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
