package com.blink22.mvpinteractorsskeleton.ui.main.view

import android.os.Bundle
import com.blink22.mvpinteractorsskeleton.R
import com.blink22.mvpinteractorsskeleton.ui.base.view.BaseActivity

class MainActivity : BaseActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
