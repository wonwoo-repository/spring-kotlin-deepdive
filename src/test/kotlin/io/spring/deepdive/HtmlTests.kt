package io.spring.deepdive

import kotlinx.coroutines.experimental.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.net.URI

class HtmlTests : AbstractIntegrationTests() {

    @Test
    fun `Assert content on blog page`() = runBlocking<Unit> {
        val body = client.get().uri("http://localhost:$port/").retrieve().body< String>()
        assertThat(body)
                .contains("Reactor Bismuth is out")
                .contains("September 28th")
                .contains("Sebastien")
                .doesNotContain("brand-new generation")
    }

    @Test
    fun `Assert content on blog post page`() = runBlocking<Unit> {
        val body = client.get().uri("http://localhost:$port/spring-framework-5-0-goes-ga").retrieve().body<String>()
        assertThat(body)
                .contains("Spring Framework 5.0 goes GA")
                .contains("Dear Spring community")
                .contains("brand-new generation")
                .contains("Juergen")
                .doesNotContain("Sebastien")
    }

}
