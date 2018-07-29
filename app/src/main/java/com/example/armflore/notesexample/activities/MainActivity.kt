package com.example.armflore.notesexample.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.armflore.notesexample.*
import com.example.armflore.notesexample.adapters.NotesAdapter
import com.example.armflore.notesexample.enums.NoteType
import com.example.armflore.notesexample.objects.NotesController
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener{
            startActivity(intentFor<NoteActivity>())
        }
        doSomething()
    }

    fun doSomething() {

        NoteType.values().forEach {
            it.showToast(this)
        }
    }
    override fun onResume() {
        super.onResume()

        val adapter = NotesAdapter(this, NotesController)
        adapter.getAll(this)
        list.adapter = adapter
    }
}
