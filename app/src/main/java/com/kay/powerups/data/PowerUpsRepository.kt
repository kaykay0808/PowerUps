package com.kay.powerups.data

import com.apollographql.apollo3.ApolloClient
import com.kay.PowerUpsQuery
import com.kay.powerups.ui.PowerUpsUiModel

class PowerUpsRepository(val api: ApolloClient) {
    suspend fun getData(): List<PowerUpsUiModel>? {
        val response = api.query(PowerUpsQuery()).execute()
        val uiModel = response.data?.assignmentData?.map {

            PowerUpsUiModel(
                title = it.title,
                description = it.description,
                longDescription = it.longDescription,
                connected = it.connected,
                storeUrl = it.storeUrl,
                imageUrl = it.imageUrl
            )
        }
        return uiModel
    }
}
