package com.example.armflore.notesexample.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.armflore.notesexample.models.GeneralNote
import com.example.armflore.notesexample.models.Note
import com.example.armflore.notesexample.objects.NotesController
import com.example.armflore.notesexample.R
import kotlinx.android.synthetic.main.activity_note.*

class NoteActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        val note = intent.extras?.getSerializable("note") as Note?

        if (note != null)
        {
            noteTitle.setText(note.title)
            noteBody.setText(note.body)
        }
        btnDelete.setOnClickListener{
            if(note != null)
            {
                NotesController.delete(this, note)
                finish()
            }
        }

        btnSave.setOnClickListener {

            if (note != null && (note.title != noteTitle.text.toString() || note.body != noteBody.text.toString()))
            {
                NotesController.delete(this, note)
            }

            NotesController.save(this, GeneralNote(noteTitle.text.toString(), noteBody.text.toString()),
                    onCompleted = {
                        Toast.makeText(this, "Saved note $it", Toast.LENGTH_SHORT).show()
                        finish()
                    },
                    onError = {
                        Toast.makeText(this, "Error saving $it", Toast.LENGTH_SHORT).show()
                    })
        }
    }

    fun newNote(context: Context)
    {
        val intent = Intent(context, NoteActivity::class.java)
        context.startActivity(intent)
    }

    fun openNoteDetail(context: Context, note: Note) {
        val intent = Intent(context, NoteActivity::class.java)
        intent.putExtra("note",note)
        context.startActivity(intent)

    }

}