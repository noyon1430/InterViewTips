package com.example.noyon.interviewtips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static com.example.noyon.interviewtips.TopicsCategory.MyWebValue;

public class webView extends AppCompatActivity {

    WebView MyWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        MyWeb = findViewById(R.id.webView);
        if(MyWebValue==1)
        {
            MyWeb.loadUrl("https://www.javatpoint.com/android-interview-questions");
            MyWeb.setWebViewClient(new WebViewClient());
        }
        else if(MyWebValue==2)
        {
            MyWeb.loadUrl("https://www.javatpoint.com/corejava-interview-questions");
            MyWeb.setWebViewClient(new WebViewClient());
        }
        else if(MyWebValue==3)
        {
            MyWeb.loadUrl("https://www.javatpoint.com/python-interview-questions");
            MyWeb.setWebViewClient(new WebViewClient());
        }
        else if(MyWebValue==4)
        {
            MyWeb.loadUrl("https://www.javatpoint.com/cpp-interview-questions");
            MyWeb.setWebViewClient(new WebViewClient());
        }
        else if(MyWebValue==5)
        {
            MyWeb.loadUrl("https://www.javatpoint.com/dot-net-interview-questions");
            MyWeb.setWebViewClient(new WebViewClient());
        }
        else if(MyWebValue==6)
        {
            MyWeb.loadUrl("https://www.javatpoint.com/html-interview-questions");
            MyWeb.setWebViewClient(new WebViewClient());
        }
        else if(MyWebValue==7)
        {
            MyWeb.loadUrl("https://www.javatpoint.com/css-interview-questions");
            MyWeb.setWebViewClient(new WebViewClient());
        }
        else if(MyWebValue==8)
        {
            MyWeb.loadUrl("https://www.javatpoint.com/javascript-interview-questions");
            MyWeb.setWebViewClient(new WebViewClient());
        }
        else if(MyWebValue==9)
        {
            MyWeb.loadUrl("https://www.javatpoint.com/operating-system-interview-questions");
            MyWeb.setWebViewClient(new WebViewClient());
        }
        else if(MyWebValue==10)
        {
            MyWeb.loadUrl("https://www.javatpoint.com/dbms-interview-questions");
            MyWeb.setWebViewClient(new WebViewClient());
        }
        else if(MyWebValue==11)
        {
            MyWeb.loadUrl("https://www.javatpoint.com/digital-electronics-interview-questions");
            MyWeb.setWebViewClient(new WebViewClient());
        }
    }
}
