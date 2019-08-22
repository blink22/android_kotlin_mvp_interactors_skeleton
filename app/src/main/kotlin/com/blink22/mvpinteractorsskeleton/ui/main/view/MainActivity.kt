package com.blink22.mvpinteractorsskeleton.ui.main.view

import android.os.Bundle
import com.blink22.mvpinteractorsskeleton.R
import com.blink22.mvpinteractorsskeleton.ui.base.view.BaseActivity
import com.blink22.mvpinteractorsskeleton.ui.main.interactor.MainInteractor
import com.blink22.mvpinteractorsskeleton.ui.main.presenter.MainPresenter
import org.koin.androidx.scope.currentScope

class MainActivity : BaseActivity(), MainView {

    private val presenter: MainPresenter<MainView, MainInteractor> by currentScope.inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
