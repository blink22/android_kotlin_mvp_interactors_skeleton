package com.blink22.mvpinteractorsskeleton.ui.main.presenter

import com.blink22.mvpinteractorsskeleton.ui.base.presenter.BasePresenterImp
import com.blink22.mvpinteractorsskeleton.ui.main.interactor.MainInteractor
import com.blink22.mvpinteractorsskeleton.ui.main.view.MainView
import com.blink22.mvpinteractorsskeleton.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class MainPresenterImp<V: MainView, I: MainInteractor>(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable
) : BasePresenterImp<V, I>(interactor= interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
    MainPresenter<V, I>