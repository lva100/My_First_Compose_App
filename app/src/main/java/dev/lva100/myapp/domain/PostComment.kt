package dev.lva100.myapp.domain

import dev.lva100.myapp.R

data class PostComment(
    val id: Int,
    val authorName: String = "Author",
    val authorAvatarId: Int = R.drawable.avatar_male,
    val commentText: String = "Long comment text",
    val publicationDate: String = "14:00"
)
