package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            //Root JSONObject Sandwich
            JSONObject jsonSandwich = new JSONObject(json);

            //Sandwich common name and also known as
            JSONObject sandwichName = jsonSandwich.getJSONObject("name");

            //Common name of the sandwich
            String commonName = sandwichName.getString("mainName");

            //Sandwich is also known as
            List<String> alsoKnownAsName = jsonArrayList(sandwichName
                    .getJSONArray("alsoKnownAs"));

            //Place of origin of the sandwich
            String placeOfOrigin = jsonSandwich.getString("placeOfOrigin");

            //Description of the sandwich
            String descript = jsonSandwich.getString("description");

            //Image of the sandwich
            String sandwichImg = jsonSandwich.getString("image");

            //Ingredients of the sandwich
            List<String> sandwichIngredients = jsonArrayList(jsonSandwich
                    .getJSONArray("ingredients"));

            //Return object Sandwich
            return new Sandwich(commonName, alsoKnownAsName, placeOfOrigin,
                    descript, sandwichImg, sandwichIngredients);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Method for listing ingredients and also known as names
    public static List<String> jsonArrayList(JSONArray jsonArray) throws JSONException {
        List<String> jsonList = new ArrayList<String>();

        if(jsonArray != null) {
            for(int i=0; i < jsonArray.length(); i++) {
                jsonList.add(jsonArray.getString(i));
            }
        }

        return jsonList;
    }
}
