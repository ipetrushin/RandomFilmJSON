package com.example.randomfilmjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.gson.Gson
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val m = resources.getStringArray(R.array.movies)
        val gson = Gson()
        val stream = resources.openRawResource(R.raw.movie)
        val reader = InputStreamReader(stream)
        val movies:Movies = gson.fromJson(reader, Movies::class.java) // для некоторых версий компилятора возникает ошибка
        Log.d("mytag", "movies loaded: " + movies.movies.size)
        val rating = movies.movies[0].rating

        val tvHello = findViewById<TextView>(R.id.hello)
        tvHello.text = rating.toString()

    }
}