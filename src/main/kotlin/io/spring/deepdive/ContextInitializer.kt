package io.spring.deepdive

import io.spring.deepdive.repository.databaseContext
import io.spring.deepdive.web.webContext
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext

class ContextInitializer : ApplicationContextInitializer<GenericApplicationContext> {
    override fun initialize(context: GenericApplicationContext) {
        databaseContext().initialize(context)
        webContext().initialize(context)
    }
}