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

import java.text.DecimalFormat;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Generate JSON
 * Build a full order from catalog
 */
public class Exercice5 {
    public static void main(String[] args) throws Exception {
        String json = FileReader.loadFileIntoString("json/catalog.json", "utf-8");
        JSONArray cds = JSONArray.fromObject(json);

        // Build the album list to add in the order
        JSONArray albums = new JSONArray();
        double total = 0.0;
        for(int i = 0; i < cds.size(); i++) {
            JSONObject album = cds.getJSONObject(i);
            if(album.getDouble("price") < 10.0) {
                   total += album.getDouble("price");
                   albums.add(album);
            }
        }

        // Format the price
        DecimalFormat format = new DecimalFormat();
        format.setMinimumFractionDigits(2);
        String totalStr = format.format(total);

        // Build the order
        JSONObject order = new JSONObject();
        order.accumulate("id", "1321033823");
        order.accumulate("total", totalStr);
        order.accumulate("date", "11/11/2011");
        order.accumulate("validated", true);
        order.accumulate("albums", albums);

        System.out.println(order);
    }
}