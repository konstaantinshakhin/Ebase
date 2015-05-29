package ru.neoflex.ebase.model.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kshahin on 5/28/2015.
 */
public  class Group extends TreeItem {

    private Map<String, Object> properties;

    public Object getValue(Object key) {
        return properties.get(key);
    }

    public Object putValue(String key, Object value) {
        return properties.put(key, value);
    }

    public Group () {
        super();
        properties = new HashMap<String, Object>();
    }
}