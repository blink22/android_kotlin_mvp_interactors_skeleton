package com.blink22.mvpinteractorsskeleton.di

import com.blink22.mvpinteractorsskeleton.data.database.DatabaseHelper
import com.blink22.mvpinteractorsskeleton.data.database.DatabaseHelperImp
import com.blink22.mvpinteractorsskeleton.data.network.ApiHelper
import com.blink22.mvpinteractorsskeleton.data.network.ApiHelperImp
import com.blink22.mvpinteractorsskeleton.data.network.NetworkUtil
import com.blink22.mvpinteractorsskeleton.data.sharedPreferences.PreferencesHelper
import com.blink22.mvpinteractorsskeleton.data.sharedPreferences.PreferencesHelperImp
import com.blink22.mvpinteractorsskeleton.ui.main.interactor.MainInteractor
import com.blink22.mvpinteractorsskeleton.ui.main.interactor.MainInteractorImp
import com.blink22.mvpinteractorsskeleton.ui.main.presenter.MainPresenter
import com.blink22.mvpinteractorsskeleton.ui.main.presenter.MainPresenterImp
import com.blink22.mvpinteractorsskeleton.ui.main.view.MainActivity
import com.blink22.mvpinteractorsskeleton.ui.main.view.MainView
import com.blink22.mvpinteractorsskeleton.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    // Global definitions
    single<DatabaseHelper> { DatabaseHelperImp() }

    single<ApiHelper> { ApiHelperImp() }

    single<PreferencesHelper> { PreferencesHelperImp() }

    factory { SchedulerProvider() }

    factory { CompositeDisposable() }

    // Activity Modules
    scope(named<MainActivity>()) {
        scoped<MainInteractor> { MainInteractorImp(get(), get(), get()) }

        scoped<MainPresenter<MainView, MainInteractor>> { MainPresenterImp(get(), get(), get()) }
    }
}