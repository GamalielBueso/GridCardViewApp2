package com.example.gridcardviewapp2

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.*

class WebViewApp : AppCompatActivity() {

    private val URL_BASE = "https://google.com"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_app)

        var wvPantalla: WebView = findViewById(R.id.wv_Pantalla)

        wvPantalla.webChromeClient = object :WebChromeClient(){

        }
        wvPantalla.webViewClient= object :WebViewClient() {

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }
        }

            val configuracion:WebSettings = wvPantalla.settings
            configuracion.javaScriptEnabled = true
            wvPantalla.loadUrl(URL_BASE)

    }

    override fun onBackPressed() {
        val wvPantalla2: WebView = findViewById(R.id.wv_Pantalla)
        if (wvPantalla2.canGoBack()) {
            wvPantalla2.goBack()
        } else {
            super.onBackPressed()
        }
    }
}