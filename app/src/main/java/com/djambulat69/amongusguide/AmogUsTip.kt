package com.djambulat69.amongusguide

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class AmongUsTip(
    @StringRes val title: Int,
    @StringRes val text: Int,
    @DrawableRes val imageId: Int = R.drawable.among_us_dummy_image
)