package com.blink22.mvpinteractorsskeleton.ui.base.presenter

import com.blink22.mvpinteractorsskeleton.ui.base.interactor.BaseInteractor
import com.blink22.mvpinteractorsskeleton.ui.base.view.BaseView
import com.blink22.mvpinteractorsskeleton.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenterImp<V: BaseView, I: BaseInteractor> (
    internal val interactor: I? = null,
    internal val schedulerProvider: SchedulerProvider? = null,
    internal val compositeDisposable: CompositeDisposable? = null
) : BasePresenter<V, I> {

    private var view: V? = null

    override fun onAttach(view: V?) { this.view = view }

    override fun getView(): V? = view

    override fun onDetach() {
        view = null
        compositeDisposable?.dispose()
    }
}