package ru.neoflex.ebase.model.tree;

/**
 * Created by kshahin on 5/28/2015.
 */

import java.util.Arrays;
import java.util.List;

/**
 * This is our special case, root node. It is a TreeItem in itself
 * but contains methods for building and retrieving items from our tree
 *
 */
public  class TreeManager extends TreeItem
{
    /**
     * Will add an Item to the tree at the specified path with the value
     * equal to the last item in the path, unless that Item already exists
     */
    public void addData(List<String> path)
    {
        addData(this, path);
    }

    public void addData(TreeItem parent, List<String> path)
    {
        // if we're at the end of the path - create a node
        String data = path.get(0);
        if(path.size() == 1)
        {
            // unless there is already a node with this name
            if(!parent.hasChild(data))
            {
                Group group = new Group();
                group.setName(data);
                parent.addChild(data, group);
            }
        }
        else
        {
            // pass the tail of this path down to the next level in the hierarchy
            addData(parent.getChild(data), path.subList(1, path.size()));
        }
    }

    public Group getData(String[] path)
    {
        return (Group) getData(this, Arrays.asList(path));
    }

    public Group getData(List<String> path)
    {
        return (Group) getData(this, path);
    }

    private TreeItem getData(TreeItem parent, List<String> path)
    {
        if(parent == null || path.size() == 0)
        {
            throw new IllegalArgumentException("Invalid path specified in getData, remainder: "
                    + Arrays.toString(path.toArray()));
        }
        String data = path.get(0);
        if(path.size() == 1)
        {
            return parent.getChild(data);
        }
        else
        {
            // pass the tail of this path down to the next level in the hierarchy
            return getData(parent.getChild(data), path.subList(1, path.size()));
        }
    }
}