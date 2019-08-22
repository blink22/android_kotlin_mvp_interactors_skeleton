package com.blink22.mvpinteractorsskeleton.ui.main.interactor

import com.blink22.mvpinteractorsskeleton.data.database.DatabaseHelper
import com.blink22.mvpinteractorsskeleton.data.network.ApiHelper
import com.blink22.mvpinteractorsskeleton.data.sharedPreferences.PreferencesHelper
import com.blink22.mvpinteractorsskeleton.ui.base.interactor.BaseInteractorImp

class MainInteractorImp(databaseHelper: DatabaseHelper, apiHelper: ApiHelper, preferencesHelper: PreferencesHelper)
    : BaseInteractorImp(databaseHelper= databaseHelper, apiHelper= apiHelper, preferencesHelper= preferencesHelper), MainInteractor