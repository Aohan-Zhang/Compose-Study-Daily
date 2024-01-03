package site.aohan.compose_study_daily.config

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter

val client = HttpClient {
    install(ContentNegotiation) {
        register(ContentType.Text.Html, KotlinxSerializationConverter(json))
        register(ContentType.Application.Json, KotlinxSerializationConverter(json))
    }
}