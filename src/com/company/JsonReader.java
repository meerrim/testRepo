package com.company;

import com.company.states.ForSaleProductState;
import com.company.states.InStockProductState;
import com.company.states.SoldProductState;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonReader {

    private String fileName;

    public JsonReader(String fileName) {
        this.fileName = fileName;
    }

    public Product[] getProducts() throws Exception{

        JSONParser parser = new JSONParser();
        try(Reader reader = new FileReader(fileName)) {
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            Product[] products = new Product[jsonArray.size()];
            Integer q = 0;

            for (Object o : jsonArray) {
                JSONObject fact = (JSONObject) o;
                products[q] = new Product((String) fact.get("id"),
                        (String) fact.get("name"),
                        (Long) fact.get("price"),
                        (Long) fact.get("startPrice"),
                        (String) fact.get("honorary_code"),
                        State.valueOf((String) fact.get("state")));
                q++;
            }
            for (Product p : products) {
                switch (p.getState()) {
                    case for_sale:
                        p.setStateClass(new ForSaleProductState());
                        break;
                    case in_stock:
                        p.setStateClass(new InStockProductState());
                        break;
                    case sold:
                        p.setStateClass(new SoldProductState());
                        break;
                }
            }
            return products;
        }
            catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


}
