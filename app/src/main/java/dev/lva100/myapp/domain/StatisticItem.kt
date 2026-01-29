package dev.lva100.myapp.domain

data class StatisticItem (
    val type: StatisticType,
    val count: Int = 0
)

enum class StatisticType {
    VIES, COMMENTS, SHARES, LIKES
}