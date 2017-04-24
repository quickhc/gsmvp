package com.gslibrary.utils.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/*********************************************
 ***       河南坚磐科技电子有限公司        ***
 ***                                       ***
 ***       Created by HC on 2017/4/14.       ***
 *********************************************/

public class GsonUtils {

    //解析简单Json数据
    public static <T> T parseJson(String jsonData, Class<T> entityType) {
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
        T t = gson.fromJson(jsonData, entityType);
        return t;
    }

    //解析JsonArray数据
    public static <T> List<T> parseJsonArray(String jsonArrayData) {
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
        List<T> list = gson.fromJson(jsonArrayData, new TypeToken<List<T>>() {
        }.getType());
        return list;
    }

    //下面两种方法是解析JsonArray的自己写的方法，可用new TypeToken<List<T>>(){}.getType()代替

    public static <T> List<T> readJsonArray(JSONArray array, Class<T> entityType) {
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
        List<T> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            try {
                T t = gson.fromJson(array.getJSONObject(i).toString(), entityType);
                list.add(t);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static <T> List<T> readJsonArray(String array, Class<T> entityType) throws JSONException {
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
        JSONArray jsonArray = new JSONArray(array);
        List<T> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            try {
                T t = gson.fromJson(jsonArray.getJSONObject(i).toString(), entityType);
                list.add(t);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}