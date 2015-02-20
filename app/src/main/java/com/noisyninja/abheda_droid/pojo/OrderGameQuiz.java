package com.noisyninja.abheda_droid.pojo;

import com.noisyninja.abheda_droid.util.Constants;

import java.util.ArrayList;

/**
 * Created by ir2pi on 12/13/2014.
 */
public class OrderGameQuiz extends BaseLesson {

    public OrderGameQuiz()
    {
        module_type = Constants.MODULE_TYPE.ORDER_GAME_QUIZ;
    }

    String name;
    String description;
    ArrayList<OrderGameQuestion> orderGameQuestions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<OrderGameQuestion> getOrderGameQuestions() {
        return orderGameQuestions;
    }

    public void setOrderGameQuestions(ArrayList<OrderGameQuestion> orderGameQuestions) {
        this.orderGameQuestions = orderGameQuestions;
    }
}
