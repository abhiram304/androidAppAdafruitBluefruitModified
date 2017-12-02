package com.adafruit.bluefruit.le.connect;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.net.http.*; //added this import statement
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.SslErrorHandler;
import android.net.http.SslError;
public class Analytics extends AppCompatActivity {

    WebView WebViewRPI;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);

        WebViewRPI=(WebView)findViewById(R.id.webview_Analytics);

        // Progress dialog
        progressDialog = new ProgressDialog(Analytics.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading the Analytics");


        // Enable Javascript
        WebSettings webSettings = WebViewRPI.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        webSettings.setJavaScriptEnabled(false);


        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
//        webSettings.setDisplayZoomControls(true);


        showDialog();

        Log.v("Analytics","--------------------------");

        WebViewRPI.getSettings().setDomStorageEnabled(true);
        WebViewRPI.getSettings().setUseWideViewPort(true);
        WebViewRPI.getSettings().setLoadWithOverviewMode(true);
        WebViewRPI.getSettings().setAllowFileAccess(true);
        WebViewRPI.getSettings().setAllowContentAccess(true);

        /*WebViewRPI.getSettings().setDomStorageEnabled(true);
        WebViewRPI.setInitialScale(1);
        WebViewRPI.getSettings().setLoadWithOverviewMode(true);
        WebViewRPI.getSettings().setUseWideViewPort(true);
        WebViewRPI.getSettings().setJavaScriptEnabled(false);
        WebViewRPI.getSettings().setAllowFileAccess(true);
        WebViewRPI.getSettings().setAllowContentAccess(true);
        WebViewRPI.setScrollbarFadingEnabled(false);*/



        WebViewRPI.setWebViewClient(new WebViewClient()
                                    {
                                        @Override
                                        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
                                            handler.proceed();
                                            Log.v("-------Analytics-------","SSL ERROR");
                                        }
                                        public void onPageFinished(WebView view, String url)
                                        {
                                            // DISMISS PROGRESS DIALOG HERE
                                            hideDialog();
                                        }

                                        @Override
                                        public boolean shouldOverrideUrlLoading(WebView view, String url) {

                                            view.loadUrl(url);
                                            return true;
                                        }

                                    }
        );

//        WebViewRPI.setWebChromeClient(new WebViewClient()
//
//        );
//
//        WebViewRPI.setWebChromeClient(new WebChromeClient());
//        WebViewRPI.setWebViewClient(new WebViewClient());


//        WebViewRPI.loadUrl("https://mobilewebview.herokuapp.com/serviceexecutivehomepagetest#/records");

        WebViewRPI.loadUrl("https://falldetectiondashboard.herokuapp.com/dashboard");

        Analytics.this.setTitle("Analytics");


    }
    private void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }
    private void hideDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }
}
