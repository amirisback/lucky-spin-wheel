package com.frogobox.spinwheel

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

/**
 * Created by mohamed on 22/04/17.
 */
data class WheelItem(
    var color: Int,
    var image: Bitmap,
    var text: String? = null,
    var value: String? = null
) {

    constructor(
        context: Context,
        @ColorRes color: Int,
        @DrawableRes drawable: Int,
        text: String? = null,
        value: String? = null
    ) : this(
        ContextCompat.getColor(context, color),
        BitmapFactory.decodeResource(context.resources, drawable),
        text,
        value
    )

}