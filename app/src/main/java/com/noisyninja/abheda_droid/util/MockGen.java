package com.noisyninja.abheda_droid.util;

import com.noisyninja.abheda_droid.pojo.Course;
import com.noisyninja.abheda_droid.pojo.Courses;
import com.noisyninja.abheda_droid.pojo.Lesson;
import com.noisyninja.abheda_droid.pojo.Lessons;
import com.noisyninja.abheda_droid.pojo.MCQQuiz;
import com.noisyninja.abheda_droid.pojo.Module;
import com.noisyninja.abheda_droid.pojo.Modules;
import com.noisyninja.abheda_droid.pojo.OrderGameQuiz;
import com.noisyninja.abheda_droid.pojo.PictureMatchQuiz;
import com.noisyninja.abheda_droid.pojo.Quizzes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ir2pi on 12/13/2014.
 */
public class MockGen {

    public Modules getMock()
    {
        Modules modules = new Modules();
        ArrayList<Module> moduleArrayList = new ArrayList<Module>();
        moduleArrayList.add(getModule());
        modules.setModules(moduleArrayList);

        return modules;
    }

    public Module getModule()
    {
        Module module = new Module();
        module.setName("English");
        module.setDescription("English fundamentals");
        module.setLevel(0);
        module.setCourses(getCourses());
        return module;
    }
    public Courses getCourses()
    {
        Courses courses = new Courses();
        ArrayList<Course> courseArrayList = new ArrayList<Course>();
        courseArrayList.add(getCourse1());
        courseArrayList.add(getCourse2());
        courseArrayList.add(getCourse3());
        courses.setCourses(courseArrayList);
        return courses;
    }

    public Course getCourse1()
    {
        Course course = new Course();
        course.setName("B C P");
        course.setDescription("English fundamental sentences and questions with am/is/are, has/have, shall/will, basic pronouns, adjectives, prepositions and  very basic conjugation patterns");
        course.setDesc("Basic Sentences");
        course.setInstruction("এই অনুশীলনীগুলি ইংরিজি ভাষার ভিত্তিস্বরূপ । অত্যন্ত সরল বাক্যের সাহায্যে তোমাদের ভিত তৈরী করা হচ্ছে । এগুলি শেষ করতে যা সময় তোমার লাগবে, তা নাও । সাধারণ ভুল যেগুলি ছাত্ররা করে, সেগুলিকে মাথায় রেখে ব্যাখ্যাগুলি দেওয়া হয়েছে আর কুইজগুলি তৈরী করা হয়েছে । সবকটা কুইজে ১০০% পেলে তবেই অন্য/পরের অনুশীলনীর কথা ভাববে, কারণ এই অনুশীলনীগুলির বাক্যগুলি এতই মৌলিক যে এগুলো কম বা ভুল শিখলে পরের অনুশীলনীগুলি শিখতে অসুবিধে হবে ।");
        course.setLevel(0);
        course.setLessons(getBCPLessons());
        course.setQuizzes(getBCPQuizzes());
        return course;
    }
    public Course getCourse2()
    {
        Course course = new Course();
        course.setName("B C G");
        course.setDescription("Conjugation using Verb 'Go'");
        course.setDesc("Conjugation - 'Go'");
        course.setInstruction("Conjugation যে কোন ভাষার বাক্যগঠনের কাঠামো । সরল ইংরিজি লিখতে যা conjugation দরকার হয়, তা এখানে দেওয়া হয়েছে শুধুমাত্র 'go' verb ব্যবহার ক'রে । এই প্যাটার্নগুলি শিখে নিলে তারপর তোমরা অন্য verb-এর ক্ষেত্রে সেগুলি প্রয়োগ করতে পারবে, যখন BVA-এর মাধ্যমে অন্য verb-এর বিভিন্ন form তোমরা জানবে । তাই এগুলো প্রায় মুখস্থের মত করে নাও । এখানেও সবকটা কুইজে ১০০% পেলে তবেই অন্য/পরের অনুশীলনীর কথা ভাববে, কারণ একই ।");
        course.setLevel(1);
        course.setLessons(getBCGLessons());
        course.setQuizzes(getBCGQuizzes());
        return course;
    }

    public Course getCourse3()
    {
        Course course = new Course();
        course.setName("B V A");
        course.setDescription("Conjugation, Comprehension and Translation Involving 120 Verbs and basic adverbs");
        course.setDesc("Verbs & Adverbs");
        course.setInstruction("BCG-তে যে conjugation প্যাটার্নগুলি শেখানো হয়েছে, এখানে অন্য সব verb ব্যবহার করে সেইসব প্যাটার্নগুলির প্রয়োগ দেখানো হয়েছে ছবির মাধ্যমে । প্রতি verb-এর জন্য ৪টি কুইজ দেওয়া হল, যার ২টি উদাহরণ থেকে নেওয়া, আর ২টি অদেখা । verb-গুলির ব্যবহার আরো ভালো করে শেখার জন্য ২৪টি translation আর ২৪টি comprehension  করতে দেওয়া হল,  যেগুলিতে ১২০টি verb-ই প্রয়োগ হয়েছে । এর সঙ্গে রয়েছে adverb-এর একটি module । কুইজের passmark ৮৫% । Comprehension আর translation-এর শব্দের জন্য ভালো কোন বাঙলা-ইংরাজী অভিধান download করে নাও । BAPPI Bangla-English Dictionary এমনই একটি অভিধান ।  BCO module না শিখে BVA-এর পরের দিকের translation ও comprehension শুরু কোরো না ।");
        course.setLevel(2);
        course.setLessons(getBVALessons());
        course.setQuizzes(getBVAQuizzes());
        return course;
    }

    public Lessons getBCPLessons()
    {
        Lessons lessons = new Lessons();
        ArrayList<Lesson> lessonArrayList = new ArrayList<Lesson>();

        Lesson lesson0 = new Lesson();
        lesson0.setName("BCPlesson Name0");
        lesson0.setDescription("BCPlesson description0");
        lesson0.setText("BCPlesson text0");
        lesson0.setImage("BCPlessonx0.jpg");
        lesson0.setFlashCard(false);

        Lesson lesson1 = new Lesson();
        lesson1.setName("BCPlesson Name1");
        lesson1.setDescription("BCPlesson description1");
        lesson1.setText("BCPlesson text1");
        lesson1.setImage("BCPlessonBCPx1.jpg");
        lesson1.setFlashCard(true);

        Lesson lesson2 = new Lesson();
        lesson2.setName("BCPlesson Name2");
        lesson2.setDescription("BCPlesson description2");
        lesson2.setText("BCPlesson text2");
        lesson2.setImage("BCPlessonBCPx2.jpg");
        lesson2.setFlashCard(false);

        lessonArrayList.add(lesson0);
        lessonArrayList.add(lesson1);
        lessonArrayList.add(lesson2);

        lessons.setLessons(lessonArrayList);

        return lessons;
    }

    public Lessons getBCGLessons()
    {
        Lessons lessons = new Lessons();

        ArrayList<Lesson> lessonArrayList = new ArrayList<Lesson>();

        Lesson lesson0 = new Lesson();
        lesson0.setName("BCGlesson Name0");
        lesson0.setDescription("BCGlesson description0");
        lesson0.setText("BCGlesson text0");
        lesson0.setImage("BCGlessonx0.jpg");
        lesson0.setFlashCard(false);

        Lesson lesson1 = new Lesson();
        lesson1.setName("BCGlesson Name1");
        lesson1.setDescription("BCGlesson description1");
        lesson1.setText("BCGlesson text1");
        lesson1.setImage("BCGlessonBCPx1.jpg");
        lesson1.setFlashCard(false);

        Lesson lesson2 = new Lesson();
        lesson2.setName("BCGlesson Name2");
        lesson2.setDescription("BCGlesson description2");
        lesson2.setText("BCGlesson text2");
        lesson2.setImage("BCGlessonx2.jpg");
        lesson2.setFlashCard(true);

        lessonArrayList.add(lesson0);
        lessonArrayList.add(lesson1);
        lessonArrayList.add(lesson2);

        lessons.setLessons(lessonArrayList);

        return lessons;
    }

    public Lessons getBVALessons()
    {
        Lessons lessons = new Lessons();

        ArrayList<Lesson> lessonArrayList = new ArrayList<Lesson>();

        Lesson lesson0 = new Lesson();
        lesson0.setName("BVAlesson Name0");
        lesson0.setDescription("BVAlesson description0");
        lesson0.setText("BVAlesson text0");
        lesson0.setImage("BVAlessonx0.jpg");
        lesson0.setFlashCard(true);

        Lesson lesson1 = new Lesson();
        lesson1.setName("BVAlesson Name1");
        lesson1.setDescription("BVAlesson description1");
        lesson1.setText("BVAlesson text1");
        lesson1.setImage("BVAlessonBCPx1.jpg");
        lesson1.setFlashCard(true);

        Lesson lesson2 = new Lesson();
        lesson2.setName("BVAlesson Name2");
        lesson2.setDescription("BVAlesson description2");
        lesson2.setText("BVAlesson text2");
        lesson2.setImage("BVAlessonx2.jpg");
        lesson2.setFlashCard(true);

        lessonArrayList.add(lesson0);
        lessonArrayList.add(lesson1);
        lessonArrayList.add(lesson2);

        lessons.setLessons(lessonArrayList);

        return lessons;
    }

    public Quizzes getBCPQuizzes()
    {
        Quizzes quizzes = new Quizzes();

        ArrayList<MCQQuiz> mcqQuizs = new ArrayList<MCQQuiz>();
        ArrayList<OrderGameQuiz> orderGameQuizs = new ArrayList<OrderGameQuiz>();
        ArrayList<PictureMatchQuiz> pictureMatchQuiz = new ArrayList<PictureMatchQuiz>();

        MCQQuiz mcqQuiz0 = new MCQQuiz();
        mcqQuiz0.setName("BCPname0");
        mcqQuiz0.setDescription("BCPdescription0");
        mcqQuiz0.setOption1("BCPoption1");
        mcqQuiz0.setOption2("BCPoption2");
        mcqQuiz0.setOption3("BCPoption3");
        mcqQuiz0.setOption4("BCPoption4");
        mcqQuiz0.setCorrect(3);
        mcqQuizs.add(mcqQuiz0);

        MCQQuiz mcqQuiz1 = new MCQQuiz();
        mcqQuiz1.setName("BCPname1");
        mcqQuiz1.setDescription("BCPdescription1");
        mcqQuiz1.setOption1("BCPoption1");
        mcqQuiz1.setOption2("BCPoption2");
        mcqQuiz1.setOption3("BCPoption3");
        mcqQuiz1.setOption4("BCPoption4");
        mcqQuiz1.setCorrect(3);
        mcqQuizs.add(mcqQuiz1);

        OrderGameQuiz orderGameQuiz0 = new OrderGameQuiz();
        Map<Integer,String> words0 = new HashMap<Integer, String>();
        words0.put(1, "BCPword1");
        words0.put(2, "BCPword2");
        words0.put(3, "BCPword3");
        words0.put(4, "BCPword4");
        orderGameQuiz0.setWords(words0);
        orderGameQuizs.add(orderGameQuiz0);

        OrderGameQuiz orderGameQuiz1 = new OrderGameQuiz();
        Map<Integer,String> words1 = new HashMap<Integer, String>();
        words1.put(1, "BCPword1");
        words1.put(2, "BCPword2");
        words1.put(3, "BCPword3");
        words1.put(4, "BCPword4");
        orderGameQuiz1.setWords(words1);
        orderGameQuizs.add(orderGameQuiz1);

        PictureMatchQuiz pictureMatchQuiz1 = new PictureMatchQuiz();
        Map<String,String> words3 = new HashMap<String, String>();
        words3.put("BCPimagePictureMatchQuizx1.jpg","option1");
        words3.put("BCPimagePictureMatchQuizx2.jpg","option2");
        words3.put("BCPimagePictureMatchQuizx3.jpg","option3");
        words3.put("BCPimagePictureMatchQuizx4.jpg","option4");
        pictureMatchQuiz1.setWords(words3);
        pictureMatchQuiz.add(pictureMatchQuiz1);

        quizzes.setMcqQuizs(mcqQuizs);
        quizzes.setOrderGameQuizs(orderGameQuizs);
        quizzes.setPictureMatchQuiz(pictureMatchQuiz);
        return quizzes;
    }

    public Quizzes getBCGQuizzes()
    {

        Quizzes quizzes = new Quizzes();

        ArrayList<MCQQuiz> mcqQuizs = new ArrayList<MCQQuiz>();
        ArrayList<OrderGameQuiz> orderGameQuizs = new ArrayList<OrderGameQuiz>();
        ArrayList<PictureMatchQuiz> pictureMatchQuiz = new ArrayList<PictureMatchQuiz>();

        MCQQuiz mcqQuiz0 = new MCQQuiz();
        mcqQuiz0.setName("BCGname0");
        mcqQuiz0.setDescription("BCGdescription0");
        mcqQuiz0.setOption1("BCGoption1");
        mcqQuiz0.setOption2("BCGoption2");
        mcqQuiz0.setOption3("BCGoption3");
        mcqQuiz0.setOption4("BCGoption4");
        mcqQuiz0.setCorrect(3);
        mcqQuizs.add(mcqQuiz0);

        MCQQuiz mcqQuiz1 = new MCQQuiz();
        mcqQuiz1.setName("BCGname1");
        mcqQuiz1.setDescription("BCGdescription1");
        mcqQuiz1.setOption1("BCGoption1");
        mcqQuiz1.setOption2("BCGoption2");
        mcqQuiz1.setOption3("BCGoption3");
        mcqQuiz1.setOption4("BCGoption4");
        mcqQuiz1.setCorrect(3);
        mcqQuizs.add(mcqQuiz1);

        OrderGameQuiz orderGameQuiz0 = new OrderGameQuiz();
        Map<Integer,String> words0 = new HashMap<Integer, String>();
        words0.put(1, "BCGword1");
        words0.put(2, "BCGword2");
        words0.put(3, "BCGword3");
        words0.put(4, "BCGword4");
        orderGameQuiz0.setWords(words0);
        orderGameQuizs.add(orderGameQuiz0);

        OrderGameQuiz orderGameQuiz1 = new OrderGameQuiz();
        Map<Integer,String> words1 = new HashMap<Integer, String>();
        words1.put(1, "BCGword1");
        words1.put(2, "BCGword2");
        words1.put(3, "BCGword3");
        words1.put(4, "BCGword4");
        orderGameQuiz1.setWords(words1);
        orderGameQuizs.add(orderGameQuiz1);

        PictureMatchQuiz pictureMatchQuiz1 = new PictureMatchQuiz();
        Map<String,String> words3 = new HashMap<String, String>();
        words3.put("BCGimagePictureMatchQuizx1.jpg","option1");
        words3.put("BCGimagePictureMatchQuizx2.jpg","option2");
        words3.put("BCGimagePictureMatchQuizx3.jpg","option3");
        words3.put("BCGimagePictureMatchQuizx4.jpg","option4");
        pictureMatchQuiz1.setWords(words3);
        pictureMatchQuiz.add(pictureMatchQuiz1);

        quizzes.setMcqQuizs(mcqQuizs);
        quizzes.setOrderGameQuizs(orderGameQuizs);
        quizzes.setPictureMatchQuiz(pictureMatchQuiz);

        return quizzes;
    }

    public Quizzes getBVAQuizzes()
    {
        Quizzes quizzes = new Quizzes();

        ArrayList<MCQQuiz> mcqQuizs = new ArrayList<MCQQuiz>();
        ArrayList<OrderGameQuiz> orderGameQuizs = new ArrayList<OrderGameQuiz>();
        ArrayList<PictureMatchQuiz> pictureMatchQuiz = new ArrayList<PictureMatchQuiz>();

        MCQQuiz mcqQuiz0 = new MCQQuiz();
        mcqQuiz0.setName("BVAname0");
        mcqQuiz0.setDescription("BVAdescription0");
        mcqQuiz0.setOption1("BVAoption1");
        mcqQuiz0.setOption2("BVAoption2");
        mcqQuiz0.setOption3("BVAoption3");
        mcqQuiz0.setOption4("BVAoption4");
        mcqQuiz0.setCorrect(3);
        mcqQuizs.add(mcqQuiz0);

        MCQQuiz mcqQuiz1 = new MCQQuiz();
        mcqQuiz1.setName("BVAname1");
        mcqQuiz1.setDescription("BVAdescription1");
        mcqQuiz1.setOption1("BVAoption1");
        mcqQuiz1.setOption2("BVAoption2");
        mcqQuiz1.setOption3("BVAoption3");
        mcqQuiz1.setOption4("BVAoption4");
        mcqQuiz1.setCorrect(3);
        mcqQuizs.add(mcqQuiz1);

        OrderGameQuiz orderGameQuiz0 = new OrderGameQuiz();
        Map<Integer,String> words0 = new HashMap<Integer, String>();
        words0.put(1, "BVAword1");
        words0.put(2, "BVAword2");
        words0.put(3, "BVAword3");
        words0.put(4, "BVAword4");
        orderGameQuiz0.setWords(words0);
        orderGameQuizs.add(orderGameQuiz0);

        OrderGameQuiz orderGameQuiz1 = new OrderGameQuiz();
        Map<Integer,String> words1 = new HashMap<Integer, String>();
        words1.put(1, "BVAword1");
        words1.put(2, "BVAword2");
        words1.put(3, "BVAword3");
        words1.put(4, "BVAword4");
        orderGameQuiz1.setWords(words1);
        orderGameQuizs.add(orderGameQuiz1);

        PictureMatchQuiz pictureMatchQuiz1 = new PictureMatchQuiz();
        Map<String,String> words3 = new HashMap<String, String>();
        words3.put("BVAimagePictureMatchQuizx1.jpg","option1");
        words3.put("BVAimagePictureMatchQuizx2.jpg","option2");
        words3.put("BVAimagePictureMatchQuizx3.jpg","option3");
        words3.put("BVAimagePictureMatchQuizx4.jpg","option4");
        pictureMatchQuiz1.setWords(words3);
        pictureMatchQuiz.add(pictureMatchQuiz1);

        quizzes.setMcqQuizs(mcqQuizs);
        quizzes.setOrderGameQuizs(orderGameQuizs);
        quizzes.setPictureMatchQuiz(pictureMatchQuiz);

        return quizzes;
    }

}
