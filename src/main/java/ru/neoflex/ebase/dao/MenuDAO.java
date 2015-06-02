package ru.neoflex.ebase.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import ru.neoflex.ebase.model.*;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kshahin on 5/26/2015.
 */
public class MenuDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Item> getAllItem(){

        return  jdbcTemplate.query(
                "SELECT id,parent_id,name_item,count_item,lev,path FROM items ",
                new RowMapper<Item>() {
                    @Override
                    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Item(rs.getLong("id"),
                                        rs.getLong("parent_id"),
                                        rs.getString("name_item"),
                                        rs.getLong("count_item"),
                                        rs.getLong("lev"),
                                        rs.getString("path"));

                    }
                });


    }
    public MenuItem getMenuItem(){
        List<Item> itemList= getAllItem();
        Map<Long, MenuItem> menuItemMap = new HashMap<>();
        for(Item item:itemList){
            MenuItem menuItem = new MenuItem();
            menuItem.setId(item.getId());
            menuItem.setParentId(item.getParentId());
            menuItem.setNameItem(item.getItemName());
            menuItemMap.put(item.getId(), menuItem);
        }
        for (Map.Entry<Long, MenuItem> entry : menuItemMap.entrySet()) {
            Long id = entry.getKey();
            for (Map.Entry<Long, MenuItem> ent : menuItemMap.entrySet()){
                Long parentId = ent.getValue().getParentId();
                if (parentId.equals(id)){
                    entry.getValue().getChilds().add(ent.getValue());
                }
            }
        }
        return menuItemMap.get(new Long("1"));

    }
}
