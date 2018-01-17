package com.example.ivica.kotlinintro

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private class Student(val name: String, val age: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val thisIsAVariabvle = "some string"
        Log.d("onCreate", thisIsAVariabvle)

        val student = Student("Brian", 100)
        val student2 = Student(name = "Doug", age = 20)
        val student3 = Student(age = 10, name = "Phil")



        for (i in 0..100){
//            System.out.println(i)

            if (i % 3 == 0){
                System.out.println("Fizz")
            }
            else if (i % 2 == 0){
                System.out.println("Buzz")
            }
        }

    }
}
