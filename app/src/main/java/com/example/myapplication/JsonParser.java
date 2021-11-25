package com.example.myapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonParser {
    private HashMap<String, String> praseJsonObject(JSONObject object) {
         HashMap<String, String> dataList = new HashMap<>();
        try {
            String name = object.getString("name");
            String latitude = object.getJSONObject("geometry").getJSONObject("location").getString("lat");
            String longitude = object.getJSONObject("geometry").getJSONObject("location").getString("lng");
            dataList.put("name",name);
            dataList.put("lat",latitude);
            dataList.put("lng",longitude);
        }catch (JSONException e){
            e.printStackTrace();

        }
        return dataList;
    }
    private List<HashMap<String,String>> praseJsonArray(JSONArray jsonArray){
        List<HashMap<String,String>> datalist = new ArrayList<>();
        for (int i = 0; i<jsonArray.length(); i++){
            try{
                HashMap<String,String> data = praseJsonObject((JSONObject) jsonArray.get(i));
                datalist.add(data);

            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return datalist;
    }
    public List<HashMap<String, String>> praseResult(JSONObject object){
        JSONArray jsonArray = null;
        try{
            jsonArray = object.getJSONArray("results");

        }catch (JSONException e){
            e.printStackTrace();
        }
        return praseJsonArray(jsonArray);
    }
}
