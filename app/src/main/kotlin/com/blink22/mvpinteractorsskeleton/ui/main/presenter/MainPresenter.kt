package com.blink22.mvpinteractorsskeleton.ui.main.presenter

import com.blink22.mvpinteractorsskeleton.ui.base.presenter.BasePresenter
import com.blink22.mvpinteractorsskeleton.ui.main.interactor.MainInteractor
import com.blink22.mvpinteractorsskeleton.ui.main.view.MainView

interface MainPresenter<V: MainView, I: MainInteractor> : BasePresenter<V, I>