package com.ulan.munduz.manager.di.moduls.uimodules

import android.content.Context
import com.ulan.app.munduz.helpers.SendEmailHelper
import com.ulan.munduz.manager.di.scopes.MainScope
import com.ulan.munduz.manager.ui.message.SendMessageFragment
import com.ulan.munduz.manager.ui.message.SendMessagePresenter
import com.ulan.munduz.manager.ui.message.SendMessagePresenterImpl
import com.ulan.munduz.manager.ui.message.SendMessageView
import dagger.Module
import dagger.Provides

@Module
class MessageModule{

    @MainScope
    @Provides
    fun provideMessageView(fragment: SendMessageFragment): SendMessageView{
        return fragment
    }

    @MainScope
    @Provides
    fun provideMessagePresenter(view: SendMessageView):SendMessagePresenter{
        return SendMessagePresenterImpl(view)
    }

    @MainScope
    @Provides
    fun provideSendEmail(context: Context): SendEmailHelper {
        return SendEmailHelper(context)
    }

}