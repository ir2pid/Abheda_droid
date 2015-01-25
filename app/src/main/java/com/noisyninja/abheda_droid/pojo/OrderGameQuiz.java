package com.noisyninja.abheda_droid.pojo;

import com.noisyninja.abheda_droid.util.Constants;

import java.util.Map;

/**
 * Created by ir2pi on 12/13/2014.
 */
public class OrderGameQuiz extends BaseLesson {

    Map<Integer,String> words;


    public OrderGameQuiz()
    {
        module_type = Constants.MODULE_TYPE.ORDER_GAME_QUIZ;
    }

    public Map<Integer, String> getWords() {
        return words;
    }

    public void setWords(Map<Integer, String> words) {
        this.words = words;
    }
}
