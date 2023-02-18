package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class JsonWriter {

    public State updateJson(String str) {
        JSONParser parser = new JSONParser();

        try(Reader reader = new FileReader("product.json")) {
            JSONArray jsonArray = (JSONArray) parser.parse(reader);

            for (Object o : jsonArray) {
                JSONObject fact = (JSONObject) o;
                fact.put("state", str);

                FileWriter file = new FileWriter("product.json");
                file.write(fact.toJSONString());
                file.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return State.sold;
    }




}
