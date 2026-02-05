package dev.lva100.myapp.domain

import android.os.Parcelable
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import com.google.gson.Gson
import dev.lva100.myapp.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeedPost(
    val id: Int = 0,
    val communityName: String = "/dev/null",
    val publicationDate: String = "14:00",
    val avatarResId: Int = R.drawable.telegram,
    val contentText: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
    val contentImageResId: Int = R.drawable.post_content_image,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIES, count = 966),
        StatisticItem(type = StatisticType.SHARES, count = 7),
        StatisticItem(type = StatisticType.COMMENTS, count = 8),
        StatisticItem(type = StatisticType.LIKES, count = 27),
    )
) : Parcelable {
    companion object {
        val NavigationType: NavType<FeedPost> = object : NavType<FeedPost>(false) {

            override fun get(
                bundle: SavedState,
                key: String
            ): FeedPost? {
                return bundle.getParcelable(key)
            }

            override fun parseValue(value: String): FeedPost {
                return Gson().fromJson(value, FeedPost::class.java)
            }

            override fun put(
                bundle: SavedState,
                key: String,
                value: FeedPost
            ) {
                bundle.putParcelable(key, value)
            }
        }
    }
}
