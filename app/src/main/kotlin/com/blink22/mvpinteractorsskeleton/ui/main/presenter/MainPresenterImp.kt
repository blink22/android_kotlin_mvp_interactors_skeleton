package com.blink22.mvpinteractorsskeleton.ui.main.presenter

import com.blink22.mvpinteractorsskeleton.ui.base.presenter.BasePresenterImp
import com.blink22.mvpinteractorsskeleton.ui.main.interactor.MainInteractor
import com.blink22.mvpinteractorsskeleton.ui.main.view.MainView

class MainPresenterImp<V: MainView, I: MainInteractor>(interactor: I)
    : BasePresenterImp<V, I>(interactor= interactor), MainPresenter<V, I>