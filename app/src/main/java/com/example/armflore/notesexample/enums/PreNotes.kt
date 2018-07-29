package com.example.armflore.notesexample.enums

import com.example.armflore.notesexample.models.GeneralNote
import com.example.armflore.notesexample.models.ListNote
import com.example.armflore.notesexample.models.Note

enum class PreNotes(val note: Note) {
    WELCOME(GeneralNote("Welcome", "Welcome to the notes app!")),
    WELCOME_LIST(ListNote("You can create a list!")),
}