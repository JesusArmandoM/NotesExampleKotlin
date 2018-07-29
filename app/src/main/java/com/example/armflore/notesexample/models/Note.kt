package com.example.armflore.notesexample.models

import java.io.Serializable

sealed class Note (var title:String, var body:String): Serializable
{
    operator fun unaryPlus(): Note {
        return this

    }

    abstract operator fun unaryMinus(): Note
    abstract operator fun inc(): Note
    abstract operator fun plus(string:String): Note
}

class GeneralNote(title:String, body:String): Note(title,body)
{
    override operator fun unaryMinus(): GeneralNote {
        return GeneralNote(body, title)
    }

    override operator fun inc(): GeneralNote
    {
        return GeneralNote("$title (2)", body)
    }

   override operator fun plus(string:String): GeneralNote
    {
        return GeneralNote(title, body + string)
    }
}
class ListNote(title: String,body: String = "-\n-\n-\n"): Note(title,body)
{
    override operator fun unaryMinus(): ListNote {
        return ListNote(body, title)
    }

    override operator fun inc(): ListNote
    {
        return ListNote("$title (2)", body)
    }

    override operator fun plus(string:String): ListNote
    {
        return ListNote(title, body + string)
    }
}
