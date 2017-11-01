package io.spring.deepdive.web

import com.samskivert.mustache.Mustache
import io.spring.deepdive.MarkdownConverter
import io.spring.deepdive.repository.PostEventListener
import io.spring.deepdive.repository.PostEventRepository
import io.spring.deepdive.repository.PostRepository
import io.spring.deepdive.repository.UserRepository
import org.springframework.context.support.beans

fun webContext() = beans {
    bean { router(ref(), ref(), ref()) }
    bean { Mustache.compiler().escapeHTML(false).withLoader(ref()) }
    bean<HtmlHandler>()
    bean<PostHandler>()
    bean<UserHandler>()
    bean<MarkdownConverter>()
}