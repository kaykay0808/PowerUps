package com.kay.powerups.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PowerUpsUiModel(
    val title: String,
    val description: String,
    val longDescription: String,
    val connected: Boolean,
    val storeUrl: String,
    val imageUrl: String
) : Parcelable
