package com.noisyninja.abheda_droid.pojo;

import java.util.Map;

/**
 * Created by ir2pi on 2/19/2015.
 */
public class OrderGameQuestion extends BasePojo {

    Map<Integer,String> words;

    public Map<Integer, String> getWords() {
        return words;
    }

    public void setWords(Map<Integer, String> words) {
        this.words = words;
    }
}