package com.example.armflore.notesexample.objects

import android.content.Context
import com.example.armflore.notesexample.interfaces.Controller
import com.example.armflore.notesexample.interfaces.DeleteNote
import com.example.armflore.notesexample.models.GeneralNote
import com.example.armflore.notesexample.models.Note

object NotesController: Controller<Note>, DeleteNote {
    override val sharedPreferencesName: String
        get() = "KotlinNotes"

    override fun getAll(context: Context): ArrayList<Note> {
        val sharedPreferencesEditor = context.getSharedPreferences()
        val notesMap = sharedPreferencesEditor.all
        val notesList: ArrayList<Note> = arrayListOf()
        notesMap.forEach{
            notesList.add(GeneralNote(it.key, it.value as String))
        }
        return notesList
    }

    override fun save(context: Context, note: Note, onCompleted: (notetitle:String) -> Unit, onError: (noteTitle:String) -> Unit) {
        try {
            var noteToSave: Note = note

            getAll(context).forEach()
            {
                if(it.title == note.title)
                {
                    noteToSave = note + "(second)"
                }
            }
           val sharedPreferencesEditor = context.getSharedPreferences().edit()
            sharedPreferencesEditor.putString(noteToSave.title, noteToSave.body)
            sharedPreferencesEditor.apply()
            onCompleted.invoke(note.title)
        }catch (e:Exception)
        {
            onError(note.title)
        }
    }

    override fun delete(context: Context, note: Note) {
        super<Controller>.delete(context, note)
        super<DeleteNote>.delete(context, note)
        val sharedPreferencesEditor = context.getSharedPreferences().edit()
        sharedPreferencesEditor.remove(note.title)
        sharedPreferencesEditor.apply()
    }
}