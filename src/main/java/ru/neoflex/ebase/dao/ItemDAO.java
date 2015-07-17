package ru.neoflex.ebase.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.neoflex.ebase.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by kshahin on 5/26/2015.
 */
public class ItemDAO {

    private JdbcTemplate jdbcTemplate;

    private List<Item> listItems;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Item> getItemsById(Long id){
        List<Item> itemList= new ArrayList<>();
        for(Item item:  getAllItems()){
            if (item.getParentId().equals(id)){
                itemList.add(item);
            }
        }
        return itemList;
    }

    public Item getItemById(Long id){
        Item itm = null;
        for(Item item:  getAllItems()){
            if (item.getId().equals(id)){
                itm = item;
            }
        }
        return itm;
    }

    public List<Item> getAllItems(){
        if (listItems == null){
            listItems = jdbcTemplate.query(
                    "SELECT id,parent_id,name_item,count_item,lev,path,price FROM items ",
                    new RowMapper<Item>() {
                        @Override
                        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
                            return new Item(rs.getLong("id"),
                                    rs.getLong("parent_id"),
                                    rs.getString("name_item"),
                                    rs.getString("count_item"),
                                    rs.getLong("lev"),
                                    rs.getString("path"),
                                    rs.getFloat("price"));

                        }
                    });
        }
        return  listItems;

    }

    public List<Item> getAllChildItems(){
        List<Item> itemList= getAllItems();
        List<Item> itms = new ArrayList<>();
        Item item = null;
        Iterator<Item> itr = itemList.iterator();
        while(itr.hasNext()){
            item =itr.next();
            if(null != item.getItemCount()){
               itms.add(item);
            }

        }
        return itms;
    }

    public List<MenuItem> getMenuItem(){
        List<Item> itemList= getAllItems();

        Map<Long, MenuItem> menuItemMap = new HashMap<>();
        for(Item item:itemList){
            if(item.getItemCount() == null) {
                MenuItem menuItem = new MenuItem();
                menuItem.setId(item.getId());
                menuItem.setParentId(item.getParentId());
                menuItem.setNameItem(item.getItemName());
                menuItemMap.put(item.getId(), menuItem);
            }
        }
        for (Map.Entry<Long, MenuItem> entry : menuItemMap.entrySet()) {
            Long id = entry.getKey();
            for (Map.Entry<Long, MenuItem> ent : menuItemMap.entrySet()){
                Long parentId = ent.getValue().getParentId();
                if (parentId.equals(id)){
                    //if(ent.getValue().getId())
                    entry.getValue().getChilds().add(ent.getValue());
                }
            }
        }
        return menuItemMap.get(new Long("1")).getChilds();

    }

    public Map<Long, MenuItem> getMenuItemMap(){
        return null;
    }
}
