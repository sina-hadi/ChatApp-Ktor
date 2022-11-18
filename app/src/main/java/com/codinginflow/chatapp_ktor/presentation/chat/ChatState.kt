package com.codinginflow.chatapp_ktor.presentation.chat

import com.codinginflow.chatapp_ktor.data.Message

data class ChatState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false
)
