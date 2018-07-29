package com.example.armflore.notesexample.interfaces

import android.content.Context
import android.util.Log

interface Controller<T> {
    val sharedPreferencesName:String

    fun getAll(context: Context): ArrayList<T>
    fun save(context: Context,t:T, onCompleted: (notetitle:String) -> Unit, onError: (noteTitle:String) -> Unit)
    fun delete(context: Context,t:T)
    {
        Log.d("Delite note", "Controller interface")
    }
    fun Context.getSharedPreferences() = getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)
}