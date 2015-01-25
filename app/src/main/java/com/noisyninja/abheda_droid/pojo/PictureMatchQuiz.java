package com.noisyninja.abheda_droid.pojo;

import com.noisyninja.abheda_droid.util.Constants;

import java.util.Map;

/**
 * Created by ir2pi on 12/24/2014.
 */
public class PictureMatchQuiz extends BaseLesson {

    Map<String,String> words;

    public PictureMatchQuiz()
    {
        module_type = Constants.MODULE_TYPE.PICTURE_MATCH_QUIZ;
    }

    public Map<String, String> getWords() {
        return words;
    }

    public void setWords(Map<String, String> words) {
        this.words = words;
    }
}
