package com.kay.powerups

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apollographql.apollo3.ApolloClient
import com.kay.PowerUpsQuery
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*GlobalScope.launch { test() }*/
    }

    /*suspend fun test() {
        // Create a client
        val apolloClient = ApolloClient.Builder()
            .serverUrl("https://app.tibber.com/v4/gql\n")
            .build()

        // Execute your query. This will suspend until the response is received.
        // this will be called from the repository.
        val response = apolloClient.query(PowerUpsQuery()).execute()
        val breakpoint = true
    }*/
}
