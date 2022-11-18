package com.codinginflow.chatapp_ktor.data

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class MessageServiceImpl(
    private val client: HttpClient
) : MessageService {

    override suspend fun getAllMessages(): List<Message> {
        return try {
            val response: HttpResponse = client.get(MessageService.Endpoints.GetAllMessages.url)

            response.body<List<MessageDto>>().map {
                it.toMessage()
            }

        } catch (e: Exception) {
            emptyList()
        }
    }
}