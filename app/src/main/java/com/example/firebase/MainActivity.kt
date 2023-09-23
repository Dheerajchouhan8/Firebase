package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.firebase.model.note
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db= Firebase.firestore

        //Add Data
        val notes = note(1,"First note","Hello Firebase")

        db.collection("note")
            .add(notes).addOnSuccessListener {
                Log.d("Note Add Successfully","${it.id}")
            }.addOnFailureListener {
                Log.d("Note Exception","${it.message}")
                it.printStackTrace()
            }




        
    }
}