package com.noisyninja.abheda_droid.util;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.noisyninja.abheda_droid.pojo.Chapter;
import com.noisyninja.abheda_droid.pojo.Courses;
import com.noisyninja.abheda_droid.pojo.Lesson;
import com.noisyninja.abheda_droid.pojo.Lessons;
import com.noisyninja.abheda_droid.pojo.MCQQuiz;
import com.noisyninja.abheda_droid.pojo.Module;
import com.noisyninja.abheda_droid.pojo.OrderGameQuiz;
import com.noisyninja.abheda_droid.pojo.PictureMatchQuiz;
import com.noisyninja.abheda_droid.pojo.Quizzes;
import com.noisyninja.abheda_droid.pojo.Topic;
import com.noisyninja.abheda_droid.pojo.Topics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ir2pi on 12/13/2014.
 */
public class DataStore {

    private static Topics topics;
    private static DataStore instance = null;
    protected DataStore() {
        // Exists only to defeat instantiation.
    }
    public static DataStore getInstance(Context context) {
        if(instance == null) {
            init(context);
            instance = new DataStore();
        }
        return instance;
    }

    public Topics getTopics()
    {
        return topics;
    }

    public Topic getTopic()
    {
        return topics.getTopics()
                .get(Constants.TOPIC_ID);
    }

    public Courses getCourses()
    {
        return topics.getTopics()
                .get(Constants.TOPIC_ID)
                .getCoursesList().get(Constants.COURSE_ID);
    }

    public Module getModule()
    {
        return topics.getTopics()
                .get(Constants.TOPIC_ID)
                .getCoursesList().get(Constants.COURSE_ID)
                .getModules().get(Constants.MODULE_ID);
    }

   /* public Lesson getLesson()
    {
        ArrayList<Lesson> lessons = topics.getTopics()
                .get(Constants.TOPIC_ID)
                .getCoursesList().get(Constants.COURSE_ID)
                .getModules().get(Constants.MODULE_ID)
                .getLessons().getLessons();
        if(lessons.size() < Constants.LESSON_QUIZ_ID)
        {
            return lessons.get(Constants.LESSON_QUIZ_ID);
        }
        else return null;
    }

    public Quizzes getQuiz()
    {
        return topics.getTopics()
                .get(Constants.TOPIC_ID)
                .getCoursesList().get(Constants.COURSE_ID)
                .getModules().get(Constants.MODULE_ID)
                .getLessons().getLessons().get(Constants.LESSON_QUIZ_ID);
    }*/



    public static void init(Context context)
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        //gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        Gson gson = gsonBuilder.create();
        Topics temp = null;
        /*
        List<Post> posts = new ArrayList<Post>();
        posts = Arrays.asList(gson.fromJson(reader, Post[].class));
        */
        String json = Utils.read(context);
        if(json != null)
        {
            temp = gson.fromJson(json, Topics.class);
        }
        else{
            temp = gson.fromJson(Utils.getStringFromAsset(context, Constants.DATA_FILE), Topics.class);
        }
        topics = temp;
    }

    public Topics getMockTopics()
    {
        Topics topics1 = new Topics();
        ArrayList<Topic> topicsArrayList = new ArrayList<Topic>();


        Topic topic = new Topic();
        topic.setName("English");
        topic.setDescription("English fundamentals");
        topic.setMarks(0);
        topic.setCompletion(0);
        topic.setLevel(0);
        topic.setCoursesList(getCoursesList());

        topicsArrayList.add(topic);
        topics1.setTopics(topicsArrayList);

        return topics1;
    }
    private ArrayList<Courses> getCoursesList()
    {
        ArrayList<Courses> coursesList = new ArrayList<Courses>();
        coursesList.add(getCoursesBCP());
        coursesList.add(getCoursesBCG());
        return coursesList;
    }

    private Courses getCoursesBCP()
    {
        Courses courses = new Courses();
        courses.setCompletion(0);
        courses.setCourseName("BCP");
        courses.setCourseDescription("BCP Description");
        courses.setMarks(0);
        ArrayList<Module> moduleArrayList = new ArrayList<Module>();
        moduleArrayList.add(getBCPCourse1());
        moduleArrayList.add(getBCPCourse2());
        courses.setModules(moduleArrayList);
        return courses;
    }

    private Courses getCoursesBCG()
    {
        Courses courses = new Courses();
        courses.setCompletion(0);
        courses.setCourseName("BCG");
        courses.setCourseDescription("BCG Description");
        courses.setMarks(0);
        return courses;
    }

    private Module getBCPCourse1()
    {
        Module module = new Module();
        module.setName("B C P 1");
        module.setDescription("B C P 1 description");
        module.setDesc("B C P 1 short description");
        module.setInstruction("B C P 1 instruction ");
        module.setLevel(0);
        module.setDaysToComplete(5);
        module.setLessons(getBCP1Lessons());
        module.setQuizzes(getBCP1Quizzes());
        return module;
    }

    private Module getBCPCourse2()
    {
        Module module = new Module();
        module.setName("B C P 2");
        module.setDescription("B C P 2 description");
        module.setDesc("B C P 2 short description");
        module.setInstruction("B C P 2 instruction ");
        module.setLevel(0);
        module.setDaysToComplete(2);
        module.setLessons(getBCP2Lessons());
        module.setQuizzes(getBCP2Quizzes());
        return module;
    }

/*
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
    }*/

    private Lessons getBCP1Lessons()
    {
        Lessons lessons = new Lessons();
        ArrayList<Lesson> lessonArrayList = new ArrayList<Lesson>();

        lessonArrayList.add(getLesson("BCP1.1 "));
        lessonArrayList.add(getLesson("BCP1.2 "));
        lessonArrayList.add(getFalshcard("BCP1.3flashcard"));

        lessons.setLessons(lessonArrayList);


        return lessons;
    }


    private Lessons getBCP2Lessons()
    {
        Lessons lessons = new Lessons();
        ArrayList<Lesson> lessonArrayList = new ArrayList<Lesson>();

        lessonArrayList.add(getLesson("BCP2.1 "));
        lessonArrayList.add(getLesson("BCP2.2 "));
        lessonArrayList.add(getFalshcard("BCP2.3flashcard"));

        lessons.setLessons(lessonArrayList);

        return lessons;
    }

    private Lesson getLesson(String prefix)
    {
        Lesson lesson = new Lesson();
        lesson.setName(prefix+" lesson Name0");
        lesson.setDescription(prefix+" lesson description0");
        lesson.setFlashCard(false);
        lesson.setImage(prefix+"lesson.jpg");
        lesson.setChapters(getLessonChapter(prefix));
        return lesson;
    }

    private Lesson getFalshcard(String prefix)
    {
        Lesson lesson = new Lesson();
        lesson.setName(prefix+" lesson Name0");
        lesson.setDescription(prefix+" lesson description0");
        lesson.setFlashCard(true);
        lesson.setImage(prefix+"lesson.jpg");
        lesson.setChapters(getFalshcardChapter(prefix));
        return lesson;
    }

    private ArrayList<Chapter> getLessonChapter(String prefix)
    {
        ArrayList<Chapter> chapters = new ArrayList<Chapter>();

        Chapter chapter1 = new Chapter();
        chapter1.setDescription(prefix+"description chapter1");
        chapter1.setName(prefix+"Name chapter1");
        chapter1.setImage1(prefix+"image chapter1");
        chapter1.setText1(prefix+"text chapter1");

        Chapter chapter2 = new Chapter();
        chapter2.setDescription(prefix+"description chapter2");
        chapter2.setName(prefix+"Name chapter2");
        chapter2.setImage1(prefix+"image chapter2");
        chapter2.setText1(prefix+"text chapter2");

        chapters.add(chapter1);
        chapters.add(chapter2);

        return chapters;
    }

    private ArrayList<Chapter> getFalshcardChapter(String prefix)
    {
        ArrayList<Chapter> chapters = new ArrayList<Chapter>();

        Chapter chapter1 = new Chapter();
        chapter1.setDescription(prefix+"description chapter1");
        chapter1.setName(prefix+"Name chapter1");
        chapter1.setImage1(prefix+"image1 chapter1");
        chapter1.setText1(prefix+"text1 chapter1");
        chapter1.setImage2(prefix+"image2 chapter1");
        chapter1.setText2(prefix+"text2 chapter1");

        Chapter chapter2 = new Chapter();
        chapter2.setDescription(prefix+"description chapter2");
        chapter2.setName(prefix+"Name chapter2");
        chapter2.setImage1(prefix+"image1 chapter2");
        chapter2.setText1(prefix+"text1 chapter2");
        chapter2.setImage2(prefix+"image2 chapter1");
        chapter2.setText2(prefix+"text2 chapter1");

        chapters.add(chapter1);
        chapters.add(chapter2);

        return chapters;
    }

/*
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
    }*/

    private Quizzes getBCP1Quizzes()
    {
        Quizzes quizzes = new Quizzes();

        ArrayList<MCQQuiz> mcqQuizs = new ArrayList<MCQQuiz>();
        ArrayList<OrderGameQuiz> orderGameQuizs = new ArrayList<OrderGameQuiz>();
        ArrayList<PictureMatchQuiz> pictureMatchQuiz = new ArrayList<PictureMatchQuiz>();

        MCQQuiz mcqQuiz0 = new MCQQuiz();
        mcqQuiz0.setName("BCP1name0");
        mcqQuiz0.setDescription("BCP1description0");
        mcqQuiz0.setOption1("BCPoption1");
        mcqQuiz0.setOption2("BCPoption2");
        mcqQuiz0.setOption3("BCPoption3");
        mcqQuiz0.setOption4("BCPoption4");
        mcqQuiz0.setCorrect(3);
        mcqQuizs.add(mcqQuiz0);

        MCQQuiz mcqQuiz1 = new MCQQuiz();
        mcqQuiz1.setName("BCP1name1");
        mcqQuiz1.setDescription("BCP1description1");
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
        words3.put("BCP1imagePictureMatchQuizx1.jpg","option1");
        words3.put("BCP1imagePictureMatchQuizx2.jpg","option2");
        words3.put("BCP1imagePictureMatchQuizx3.jpg","option3");
        words3.put("BCP1imagePictureMatchQuizx4.jpg","option4");
        pictureMatchQuiz1.setWords(words3);
        pictureMatchQuiz.add(pictureMatchQuiz1);

        quizzes.setMcqQuizs(mcqQuizs);
        quizzes.setOrderGameQuizs(orderGameQuizs);
        quizzes.setPictureMatchQuiz(pictureMatchQuiz);
        return quizzes;
    }




    private Quizzes getBCP2Quizzes()
    {
        Quizzes quizzes = new Quizzes();

        ArrayList<MCQQuiz> mcqQuizs = new ArrayList<MCQQuiz>();
        ArrayList<OrderGameQuiz> orderGameQuizs = new ArrayList<OrderGameQuiz>();
        ArrayList<PictureMatchQuiz> pictureMatchQuiz = new ArrayList<PictureMatchQuiz>();

        MCQQuiz mcqQuiz0 = new MCQQuiz();
        mcqQuiz0.setName("BCP2 quiz name0");
        mcqQuiz0.setDescription("BCP2 quiz description0");
        mcqQuiz0.setOption1("BCPoption1");
        mcqQuiz0.setOption2("BCPoption2");
        mcqQuiz0.setOption3("BCPoption3");
        mcqQuiz0.setOption4("BCPoption4");
        mcqQuiz0.setCorrect(3);
        mcqQuizs.add(mcqQuiz0);

        MCQQuiz mcqQuiz1 = new MCQQuiz();
        mcqQuiz1.setName("BCP2 quiz name1");
        mcqQuiz1.setDescription("BCP2 quiz description1");
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
        words3.put("BCP2imagePictureMatchQuizx1.jpg","option1");
        words3.put("BCP2imagePictureMatchQuizx2.jpg","option2");
        words3.put("BCP2imagePictureMatchQuizx3.jpg","option3");
        words3.put("BCP2imagePictureMatchQuizx4.jpg","option4");
        pictureMatchQuiz1.setWords(words3);
        pictureMatchQuiz.add(pictureMatchQuiz1);

        quizzes.setMcqQuizs(mcqQuizs);
        quizzes.setOrderGameQuizs(orderGameQuizs);
        quizzes.setPictureMatchQuiz(pictureMatchQuiz);
        return quizzes;
    }

}
