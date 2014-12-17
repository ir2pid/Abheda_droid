package com.noisyninja.abheda_droid.pojo;

/**
 * Created by ir2pi on 12/2/2014.
 */
public class Course extends BasePojo {

    String name;
    String description;
    String desc;
    String instruction;
    Lessons lessons;
    Quizzes quizzes;
    int level;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Lessons getLessons() {
        return lessons;
    }

    public void setLessons(Lessons lessons) {
        this.lessons = lessons;
    }

    public Quizzes getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Quizzes quizzes) {
        this.quizzes = quizzes;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
