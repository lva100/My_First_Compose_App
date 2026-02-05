package dev.lva100.myapp.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatisticItem(
    val type: StatisticType,
    val count: Int = 0
) : Parcelable

enum class StatisticType {
    VIES, COMMENTS, SHARES, LIKES
}