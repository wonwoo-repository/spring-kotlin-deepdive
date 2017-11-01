package io.spring.deepdive

import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.consumeEach
import org.springframework.web.coroutine.function.client.CoroutineWebClient
import java.net.URI

suspend fun <T> ReceiveChannel<T>.toList(): List<T> =
        ArrayList<T>().also { list ->
            consumeEach { list.add(it) }
        }

inline suspend fun <reified T : Any> CoroutineWebClient.CoroutineResponseSpec.body() =
        body(T::class.java)

fun CoroutineWebClient.RequestHeadersUriSpec<*>.uri(uri: String) =
        uri(URI(uri))