/*
 * Copyright 2013 Alexandre Terrasa <alexandre@moz-code.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jsontest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Iterate over a JSON array
 * Display in stock albums
 */
public class Exercice3 {
    public static void main(String[] args) throws Exception {
        String json = FileReader.loadFileIntoString("json/catalog.json", "utf-8");
        JSONArray albums = JSONArray.fromObject(json);

        System.out.println("Prix des albums en stock:");
        int cpt = 0;
        for(int i = 0; i < albums.size(); i++) {
            JSONObject album = albums.getJSONObject(i);
            if(album.getBoolean("instock")) {
                   cpt += 1;
                   System.out.println(" * " + album.getString("title") + ": " + album.getDouble("price") + "$");
            }
        }
        System.out.println("Il y a " + cpt + " CD(s) en stock.");
    }
}