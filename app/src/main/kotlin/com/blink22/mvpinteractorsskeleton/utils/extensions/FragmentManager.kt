package com.blink22.mvpinteractorsskeleton.utils.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.blink22.mvpinteractorsskeleton.R

internal fun FragmentManager.removeFragment(tag: String,
                                            slideIn: Int = R.anim.slide_in_right,
                                            slideOut: Int = R.anim.slide_out_right) {
    this.findFragmentByTag(tag)?.let {
        this.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(slideIn, slideOut)
            .remove(it)
            .commitNow()
    }

}

internal fun FragmentManager.addFragment(containerViewId: Int,
                                         fragment: Fragment,
                                         tag: String,
                                         slideIn: Int = R.anim.slide_in_right,
                                         slideOut: Int = R.anim.slide_out_right) {
    this.beginTransaction().disallowAddToBackStack()
            .setCustomAnimations(slideIn, slideOut)
            .add(containerViewId, fragment, tag)
            .commit()
}

