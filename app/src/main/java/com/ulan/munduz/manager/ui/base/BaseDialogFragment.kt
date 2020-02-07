package com.ulan.munduz.manager.ui.base

import android.app.Activity
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerAppCompatDialogFragment

abstract class BaseDialogFragment : DaggerAppCompatDialogFragment(){

    override fun onAttach(activity: Activity) {
        AndroidSupportInjection.inject(this)
        super.onAttach(activity)
    }
}