package com.vivek.ikgptu

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient


class student_corner : Fragment() {
    private lateinit var stwView:WebView
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val sv = inflater.inflate(R.layout.fragment_student_corner, container, false)


        stwView = sv.findViewById(R.id.stwView)
        stwView.settings.javaScriptEnabled = true
        stwView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }
        // Load a URL into the WebView
        stwView.loadUrl("https://brpaper.com/ptu")

        return sv
    }


}