package com.codinginflow.chatapp_ktor.data

data class Message(
    val text: String,
    val formattedTime: String,
    val username: String
)