package com.blink22.mvpinteractorsskeleton.data.network

import org.koin.core.KoinComponent
import org.koin.core.inject

class ApiHelperImp : ApiHelper, KoinComponent {

    private val apiClient: ApiClient by inject()
}