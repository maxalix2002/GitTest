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
 * Generate a JSON String
 * Build an order manually
 */
public class Exercice4 {
    public static void main(String[] args) throws Exception {
        // Build the order object
        JSONObject order = new JSONObject();
        order.accumulate("id", "1321033823");
        order.accumulate("total", 9.9);
        order.accumulate("date", "11/11/2011");
        order.accumulate("validated", true);

        // Build another object for representing the album
        JSONObject album = new JSONObject();
        album.accumulate("id", "1");
        album.accumulate("title", "Hide your heart");

        // Build a JSON array of albums
        JSONArray albums = new JSONArray();
        albums.add(album);

        // Add the array to the order
        order.accumulate("albums", albums);

        System.out.println(order);
    }
}