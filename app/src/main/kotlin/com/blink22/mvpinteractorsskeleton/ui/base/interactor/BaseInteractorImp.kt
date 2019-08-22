package com.blink22.mvpinteractorsskeleton.ui.base.interactor

import com.blink22.mvpinteractorsskeleton.data.database.DatabaseHelper
import com.blink22.mvpinteractorsskeleton.data.network.ApiHelper
import com.blink22.mvpinteractorsskeleton.data.sharedPreferences.PreferencesHelper

open class BaseInteractorImp(
    internal val databaseHelper: DatabaseHelper? = null,
    internal val apiHelper: ApiHelper? = null,
    internal val preferencesHelper: PreferencesHelper? = null
) : BaseInteractor