package com.noisyninja.abheda_droid.pojo;

import java.util.Map;

/**
 * Created by ir2pi on 2/19/2015.
 */
public class PictureMatchQuestion  extends BasePojo{

    Map<String,String> words;
    String hint;

    public Map<String, String> getWords() {
        return words;
    }

    public void setWords(Map<String, String> words) {
        this.words = words;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
