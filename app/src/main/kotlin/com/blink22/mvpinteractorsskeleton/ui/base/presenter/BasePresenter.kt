package com.blink22.mvpinteractorsskeleton.ui.base.presenter

import com.blink22.mvpinteractorsskeleton.ui.base.interactor.BaseInteractor
import com.blink22.mvpinteractorsskeleton.ui.base.view.BaseView

interface BasePresenter<V: BaseView, I: BaseInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?
}