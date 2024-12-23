package com.vivek.ikgptu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebView.FindListener
import android.webkit.WebViewClient
import android.widget.TextView


class ptu_exam : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var ptuexamWV:WebView
    private lateinit var txtexam:TextView





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment





      var v = inflater.inflate(R.layout.fragment_ptu_exam, container, false)


        txtexam = v.findViewById(R.id.txt_exam)
        ptuexamWV = v.findViewById(R.id.exam_webview)


        ptuexamWV.settings.javaScriptEnabled = true
        ptuexamWV.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }

        // Load a URL into the WebView
        ptuexamWV.loadUrl("https://www.ptuexam.com/")




        return v
    }







}