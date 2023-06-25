package com.sunuerico.realestatemobileapp

import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush

data class ImageItem(val id: Int)

data class PropertyItem(
    val image: Int,
    val name: String,
    val location: String,
    val rating: Double,
    val background: Brush
)