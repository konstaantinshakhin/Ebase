package ru.neoflex.ebase.model.tree;

/**
 * Created by kshahin on 5/28/2015.
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This base class provides the hierarchical property of
 * an object that contains a Map of child objects of the same type.
 * It also has a field - Name
 *
 */
public  abstract class TreeItem implements Iterable<TreeItem>{

    private Map<String, TreeItem> children;
    private String name;

    public TreeItem() {
        children = new HashMap<String, TreeItem>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addChild(String key, TreeItem data)
    {
        children.put(key, data);
    }

    public TreeItem getChild(String key)
    {
        return children.get(key);
    }

    public boolean hasChild(String key)
    {
        return children.containsKey(key);
    }

    @Override
    public Iterator<TreeItem> iterator() {
        return children.values().iterator();
    }
}