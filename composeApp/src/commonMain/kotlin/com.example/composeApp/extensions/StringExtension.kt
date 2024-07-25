package com.example.composeApp.extensions

fun String.urlToString(): String = this.replace("/", " ")
fun String.stringToUrl(): String = this.replace(" ", "/")
