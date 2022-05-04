package com.kay.powerups.ui

// HomeRecyclerViewItem
sealed class PowerUpListItem {
    data class Header(
        val title: String
    ) : PowerUpListItem()
}