package io.spring.deepdive.repository

import io.spring.deepdive.model.PostEvent
import org.springframework.data.mongodb.repository.Tailable
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface PostEventRepository : ReactiveCrudRepository<PostEvent, String> {

    @Tailable
    fun findWithTailableCursorBy(): Flux<PostEvent>

}