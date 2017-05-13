package com.example.yls.ad0227;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private WebView contentWeView;
    private Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  contentWeView.loadUrl("javascript:javacalljs()");
            }
        });

        button2= (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentWeView.loadUrl("javascript:javacalljswith('你好！！！！')");
            }
        });

        contentWeView= (WebView) findViewById(R.id.webview);
        contentWeView.getSettings().setJavaScriptEnabled(true);
        contentWeView.addJavascriptInterface(MainActivity.this,"android");
        contentWeView.loadUrl("file:///android_asset/web.html");
    }
    @JavascriptInterface
    public void startFntion(){
        Toast.makeText(MainActivity.this,"JS调用Android方法",Toast.LENGTH_LONG).show();
    }
}
