package com.codinginflow.chatapp_ktor.di

import com.codinginflow.chatapp_ktor.data.ChatSocketService
import com.codinginflow.chatapp_ktor.data.ChatSocketServiceImpl
import com.codinginflow.chatapp_ktor.data.MessageService
import com.codinginflow.chatapp_ktor.data.MessageServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.websocket.*
import javax.inject.Singleton
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(CIO) {
            install(Logging)
            install(WebSockets)
            install(ContentNegotiation) {
                json()
            }
        }
    }

    @Provides
    @Singleton
    fun provideMessageService(client: HttpClient): MessageService {
        return MessageServiceImpl(client)
    }

    @Provides
    @Singleton
    fun provideChatSocketService(client: HttpClient): ChatSocketService {
        return ChatSocketServiceImpl(client)
    }
}