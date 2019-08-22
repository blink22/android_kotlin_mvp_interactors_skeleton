package com.blink22.mvpinteractorsskeleton.di

import com.blink22.mvpinteractorsskeleton.BuildConfig
import com.blink22.mvpinteractorsskeleton.data.database.DatabaseHelper
import com.blink22.mvpinteractorsskeleton.data.database.DatabaseHelperImp
import com.blink22.mvpinteractorsskeleton.data.network.ApiClient
import com.blink22.mvpinteractorsskeleton.data.network.ApiHelper
import com.blink22.mvpinteractorsskeleton.data.network.ApiHelperImp
import com.blink22.mvpinteractorsskeleton.data.sharedPreferences.PreferencesHelper
import com.blink22.mvpinteractorsskeleton.data.sharedPreferences.PreferencesHelperImp
import com.blink22.mvpinteractorsskeleton.ui.main.interactor.MainInteractor
import com.blink22.mvpinteractorsskeleton.ui.main.interactor.MainInteractorImp
import com.blink22.mvpinteractorsskeleton.ui.main.presenter.MainPresenter
import com.blink22.mvpinteractorsskeleton.ui.main.presenter.MainPresenterImp
import com.blink22.mvpinteractorsskeleton.ui.main.view.MainActivity
import com.blink22.mvpinteractorsskeleton.ui.main.view.MainView
import com.blink22.mvpinteractorsskeleton.utils.AppConstants
import com.blink22.mvpinteractorsskeleton.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    // Global definitions
    single<DatabaseHelper> { DatabaseHelperImp() }

    single<ApiHelper> { ApiHelperImp() }

    single<PreferencesHelper> { PreferencesHelperImp() }

    factory { SchedulerProvider() }

    factory { CompositeDisposable() }

    factory(named("BaseUrl")) { BuildConfig.BASE_URL }

    single {
        val httpLoggingInterceptor = HttpLoggingInterceptor().also { it.level = HttpLoggingInterceptor.Level.BODY }
        return@single OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    single {
        val url: String = get(named("BaseUrl"))
        val okHttpClient: OkHttpClient = get()
        return@single Retrofit.Builder()
            .baseUrl(url)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    single {
        val retrofit: Retrofit = get()
        return@single retrofit.create(ApiClient::class.java)
    }

    single { androidContext().getSharedPreferences(AppConstants.PREFERENCES_NAME, AppConstants.PRIVATE_MODE) }

    // Activity Modules
    scope(named<MainActivity>()) {
        scoped<MainInteractor> { MainInteractorImp(get(), get(), get()) }

        scoped<MainPresenter<MainView, MainInteractor>> { MainPresenterImp(get(), get(), get()) }
    }
}