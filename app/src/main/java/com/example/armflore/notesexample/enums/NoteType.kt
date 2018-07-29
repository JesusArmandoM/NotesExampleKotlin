package com.example.armflore.notesexample.enums

import android.content.Context
import android.widget.Toast

enum class NoteType(val intVal: Int) {

    GENERAL(100)
    {
        override fun showToast(context: Context) {
            Toast.makeText(context, "My value is $intVal", Toast.LENGTH_SHORT).show()
        }

    },
    LIST(200)
    {
        override fun showToast(context: Context) {
            Toast.makeText(context, "My value is $intVal", Toast.LENGTH_SHORT).show()
        }

    };

    abstract fun showToast(context: Context)


}