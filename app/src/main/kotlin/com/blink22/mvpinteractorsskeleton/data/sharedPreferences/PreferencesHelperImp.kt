package com.blink22.mvpinteractorsskeleton.data.sharedPreferences

import android.content.SharedPreferences
import org.koin.core.KoinComponent
import org.koin.core.inject

class PreferencesHelperImp : PreferencesHelper, KoinComponent {

    private val mPrefs: SharedPreferences by inject()
}