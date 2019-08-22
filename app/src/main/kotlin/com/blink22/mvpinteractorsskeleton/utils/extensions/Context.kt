package com.blink22.mvpinteractorsskeleton.utils.extensions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

internal fun <T> AppCompatActivity.openActivity(cls: Class<T>) {
    val intent = Intent(this, cls)
    startActivity(intent)
}