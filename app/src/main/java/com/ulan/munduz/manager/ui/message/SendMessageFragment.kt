package com.ulan.munduz.manager.ui.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ulan.app.munduz.helpers.SendEmailHelper
import com.ulan.app.munduz.helpers.convertLongToTime
import com.ulan.app.munduz.helpers.showEditTextEmpty
import com.ulan.app.munduz.data.models.Message
import com.ulan.munduz.manager.R
import kotlinx.android.synthetic.main.message_layout.*

class SendMessageFragment : DialogFragment(), SendMessageView{

    private lateinit var sendMail: SendEmailHelper
    private lateinit var mPresenter: SendMessagePresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.message_layout, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter = SendMessagePresenterImpl(this)

        send.setOnClickListener{
            mPresenter.sendButtonClicked()
        }
        cancel.setOnClickListener{
            mPresenter.cancelButtonClicked()
        }
    }

    override fun getInputMessage(): Message {
        var message = Message()
        var timeLong = System.currentTimeMillis()
        var timeString = timeLong.convertLongToTime(timeLong)
        message.email = "uulanerkinbaev@gmail.com"
        message.subject = message_subject.text.toString()
        message.body = message_body.text.toString()
        message.time = timeString
        return  message
    }

    override fun sendMessage(message: Message) {
        sendMail = SendEmailHelper(
            activity!!.applicationContext,
            message.email,
            message.subject,
            message.body,
            message.time)
        sendMail.execute()
        dialog!!.dismiss()
    }

    override fun cancelDialog() {
        dialog!!.dismiss()
    }

    override fun isEmptyFields() : Boolean {
        if(message_body.text.toString() == "" ||
            message_subject.text.toString() == ""){
            return true
        }
        return false
    }

    override fun showEmptyFields() {
        showEditTextEmpty(activity!!)
    }

    override fun onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu()
        mPresenter.detachView()
    }
}