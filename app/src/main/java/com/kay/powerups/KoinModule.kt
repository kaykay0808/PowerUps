package com.kay.powerups

import com.apollographql.apollo3.ApolloClient
import com.kay.powerups.data.PowerUpsRepository
import org.koin.dsl.module

val appModule = module {
    single { PowerUpsRepository(get()) }
    single {
        ApolloClient.Builder()
            .serverUrl("https://app.tibber.com/v4/gql\n")
            .build()
    }
}
