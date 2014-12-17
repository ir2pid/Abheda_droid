package com.noisyninja.abheda_droid.util;

import com.noisyninja.abheda_droid.pojo.Course;
import com.noisyninja.abheda_droid.pojo.Courses;
import com.noisyninja.abheda_droid.pojo.Lessons;
import com.noisyninja.abheda_droid.pojo.Module;
import com.noisyninja.abheda_droid.pojo.Modules;
import com.noisyninja.abheda_droid.pojo.Quizzes;

import java.util.ArrayList;

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


        return lessons;
    }

    public Lessons getBCGLessons()
    {
        Lessons lessons = new Lessons();


        return lessons;
    }

    public Lessons getBVALessons()
    {
        Lessons lessons = new Lessons();


        return lessons;
    }

    public Quizzes getBCPQuizzes()
    {
        Quizzes quizzes = new Quizzes();


        return quizzes;
    }

    public Quizzes getBCGQuizzes()
    {
        Quizzes quizzes = new Quizzes();


        return quizzes;
    }

    public Quizzes getBVAQuizzes()
    {
        Quizzes quizzes = new Quizzes();


        return quizzes;
    }

}
