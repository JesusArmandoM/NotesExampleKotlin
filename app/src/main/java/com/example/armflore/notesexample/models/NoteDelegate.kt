package com.example.armflore.notesexample.models

import android.content.Context
import android.widget.Toast
import com.example.armflore.notesexample.models.Note
import kotlin.reflect.KProperty

class NoteDelegate(val context: Context, val onSet: String, val onGet:String)  {
    private var note: Note? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Note?
    {
        Toast.makeText(context,onGet,Toast.LENGTH_SHORT)
        return note
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Note?)
    {
        Toast.makeText(context,onSet,Toast.LENGTH_SHORT)
        note = value
    }
}
