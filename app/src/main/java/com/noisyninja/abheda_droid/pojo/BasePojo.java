package com.noisyninja.abheda_droid.pojo;

import com.google.gson.Gson;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class BasePojo {


    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
