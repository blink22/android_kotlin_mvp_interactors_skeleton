package com.blink22.mvpinteractorsskeleton.ui.base.view

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), BaseView, BaseFragment.CallBack {

    override fun onFragmentAttached() {}

    override fun onFragmentDetached(tag: String) {}
}