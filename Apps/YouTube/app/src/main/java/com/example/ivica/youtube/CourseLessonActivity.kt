package com.example.ivica.youtube

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_course_lesson.*

/**
 * Created by Ivica on 9.1.2018..
 */

class CourseLessonActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_course_lesson)

//        webView_course_lesson.setBackgroundColor(Color.RED)

        val courseLink = intent.getStringExtra(CourseDetailActvitiy.CourseLessonViewHolder.COURSE_LESSON_LINK_KEY)

        webView_course_lesson.settings.javaScriptEnabled = true
        webView_course_lesson.settings.loadWithOverviewMode = true
        webView_course_lesson.settings.useWideViewPort = true

        webView_course_lesson.loadUrl(courseLink)
    }

}