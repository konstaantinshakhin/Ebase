package ru.neoflex.ebase.model.tree;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kshahin on 5/28/2015.
 */
public class Test {
    public static void main(String[] args) {
        // hierarchical data in a flattened list
        String[][] data = {
                {"Toyota", "Gas", "Compact", "Corolla"},
                {"Toyota", "Gas", "Compact", "Camry"},
                {"Toyota", "Hybrid", "Compact", "Prius"},
                {"Honda", "Gas", "Compact", "Civic"}
        };

        TreeManager treeManager = new TreeManager();

        for (String[] row : data) {
            // build the path to our items in the tree
            List<String> path = new ArrayList<String>();
            for (String item : row) {
                // add this item to our path
                path.add(item);
                // will add it unless an Item with this name already exists at this path
                treeManager.addData(treeManager, path);
            }
        }

        treeManager.getData(data[0]).putValue("MPG", 38);
        treeManager.getData(data[1]).putValue("MPG", 28);

        Gson gson = new Gson();
        String strGson = gson.toJson(treeManager);
        System.out.println(strGson);
    }
}
