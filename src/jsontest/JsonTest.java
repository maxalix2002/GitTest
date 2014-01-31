/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsontest;

import net.sf.json.JSONArray;

public class JsonTest {

    public static void main(String[] args) {

        String obj = "";
        
        try {
            obj = FileReader.loadFileIntoString("json/Catalog.json", "UTF-8");

        } catch (Exception ex) {
            System.out.println("fail");
            System.exit(1);
        }
        JSONArray array = JSONArray.fromObject(obj);
        System.out.println(array);
        
        int size = array.size();
        System.out.println("Il y a " + size + " cd dans le catalogue");
        
        
    }
}