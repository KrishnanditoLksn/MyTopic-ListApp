package app.dito.mytopic.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val topicDescription:Int,
    val topicImages :Int,
    @DrawableRes val images : Int
)
