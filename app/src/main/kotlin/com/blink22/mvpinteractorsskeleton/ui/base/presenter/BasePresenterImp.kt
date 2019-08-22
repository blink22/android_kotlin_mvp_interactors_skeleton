package com.blink22.mvpinteractorsskeleton.ui.base.presenter

import com.blink22.mvpinteractorsskeleton.ui.base.interactor.BaseInteractor
import com.blink22.mvpinteractorsskeleton.ui.base.view.BaseView

abstract class BasePresenterImp<V: BaseView, I: BaseInteractor> (internal val interactor: I? = null) : BasePresenter<V, I>