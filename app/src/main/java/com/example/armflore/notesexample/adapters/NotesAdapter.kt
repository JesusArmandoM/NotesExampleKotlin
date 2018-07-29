package com.example.armflore.notesexample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.armflore.notesexample.interfaces.Controller
import com.example.armflore.notesexample.models.Note
import com.example.armflore.notesexample.objects.NotesController
import com.example.armflore.notesexample.activities.NoteActivity

class NotesAdapter(val context: Context, val notesController: NotesController, val notes: ArrayList<Note> = arrayListOf()) : BaseAdapter(), Controller<Note> by NotesController {

    init { notes.addAll(getAll(context)) }

    override fun getItem(p0: Int) = notes[p0]
    override fun getItemId(p0: Int) = p0.toLong()
    override fun getCount() = notes.size

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val note = getItem(p0)
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_expandable_list_item_2, p2, false)
        view.findViewById<TextView>(android.R.id.text1).text = note.title
        view.findViewById<TextView>(android.R.id.text2).text = note.body

        view.setOnLongClickListener{

            delete(context, note)

            notifyDataSetChanged()

            true
        }
        view.setOnClickListener{
            NoteActivity().openNoteDetail(context, note)
        }

        return view
    }

    override fun notifyDataSetChanged() {
        notes.clear()
        notes.addAll(getAll(context))
        super.notifyDataSetChanged()
    }

}
