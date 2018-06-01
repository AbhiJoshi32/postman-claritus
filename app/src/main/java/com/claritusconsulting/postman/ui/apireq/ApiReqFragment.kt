package com.claritusconsulting.postman.ui.apireq


import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TableRow

import com.claritusconsulting.postman.R
import com.claritusconsulting.postman.di.Injectable
import kotlinx.android.synthetic.main.fragment_api_req.*
import timber.log.Timber
import javax.inject.Inject




class ApiReqFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var apiReqViewModel: ApiReqViewModel

    val kvhashMap = hashMapOf<EditText,EditText>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_api_req, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        apiReqViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(ApiReqViewModel::class.java)
        initSpinners();
        addHeader.setOnClickListener {
            val t1 = TableRow(activity)
            val e1 = EditText(activity)
            val e2 = EditText(activity)
            val b1 = ImageButton(activity)
            t1.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            e1.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            e1.hint = "Key"
            e2.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            e2.hint = "Value"
            kvhashMap[e1] = e2
            t1.addView(e1)
            t1.addView(e2)
            t1.addView(b1)
            b1.setOnClickListener {
                val row = it.getParent() as View
                val container = row.parent as ViewGroup
                container.removeView(row)
                container.invalidate()
            }
            headerTable.addView(t1)
        }
        sendReq.setOnClickListener{
//            urlText.text
            for ((e1,e2) in kvhashMap) {
                Timber.d("%s %s",e1.text.toString(),e2.text.toString())
            }
        }
    }

    private fun initSpinners() {
        val methods = resources.getStringArray(R.array.method)
        val aa = ArrayAdapter(activity, android.R.layout.simple_spinner_item, methods)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        methodSpinner.adapter = aa
        val body = resources.getStringArray(R.array.body_type)
        val bodyspinneradapter = ArrayAdapter(activity, android.R.layout.simple_spinner_item, body)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        bodySpinner.adapter = bodyspinneradapter
        val raw = resources.getStringArray(R.array.raw_type)
        val rawspinneradapter = ArrayAdapter(activity, android.R.layout.simple_spinner_item, raw)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        bodySpinner.adapter = rawspinneradapter
    }
}
