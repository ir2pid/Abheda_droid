package com.noisyninja.abheda_droid.pojo;

import com.noisyninja.abheda_droid.util.Constants;

import java.util.ArrayList;

/**
 * Created by ir2pi on 11/30/2014.
 */
public class MCQQuiz extends BaseLesson{

    public MCQQuiz()
    {
        module_type = Constants.MODULE_TYPE.MCQ_QUIZ;
    }

    String name;
    String description;
    ArrayList<MCQQuestion>mcqQuestions;

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

    public ArrayList<MCQQuestion> getMcqQuestions() {
        return mcqQuestions;
    }

    public void setMcqQuestions(ArrayList<MCQQuestion> mcqQuestions) {
        this.mcqQuestions = mcqQuestions;
    }
}
