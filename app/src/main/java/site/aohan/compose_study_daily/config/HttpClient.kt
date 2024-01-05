package site.aohan.compose_study_daily.config

import io.github.oshai.kotlinlogging.KotlinLogging
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter

private val netLogger by lazy {
    KotlinLogging.logger {}
}

val client by lazy {
    HttpClient {
        install(ContentNegotiation) {
            register(ContentType.Text.Html, KotlinxSerializationConverter(json))
            register(ContentType.Application.Json, KotlinxSerializationConverter(json))
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    netLogger.info { message }
                }
            }
            level = LogLevel.ALL

        }
    }
}