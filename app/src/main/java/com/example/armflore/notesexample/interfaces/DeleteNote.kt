package com.example.armflore.notesexample.interfaces

import android.content.Context
import android.util.Log
import com.example.armflore.notesexample.models.Note

interface DeleteNote {
    fun delete(context: Context,note: Note)
    {
        Log.d("Delite note", "DeleteNote interface")
    }
}