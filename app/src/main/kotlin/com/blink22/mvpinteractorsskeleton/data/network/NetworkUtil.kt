package com.blink22.mvpinteractorsskeleton.data.network

import android.content.Context
import android.net.ConnectivityManager
import org.koin.core.KoinComponent
import org.koin.core.inject

object NetworkUtil : KoinComponent {

    private val context: Context by inject()

    fun isInternetConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }
}