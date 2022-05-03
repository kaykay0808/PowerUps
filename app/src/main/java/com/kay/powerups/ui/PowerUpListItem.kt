package com.kay.powerups.ui

// HomeRecyclerViewItem
sealed class PowerUpListItem {

    data class Header(
        val title: String
    ) : PowerUpListItem()

    /*data class PowerUpUiModel(var uiModel: PowerUpsUiModel) : PowerUpListItem()*/
    // Note: adding the PowerUpListItem to the UiModel instead
}