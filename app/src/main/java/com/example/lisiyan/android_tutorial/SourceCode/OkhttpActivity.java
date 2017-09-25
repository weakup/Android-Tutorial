package com.example.lisiyan.android_tutorial.SourceCode;

import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.lisiyan.android_tutorial.R;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
    }


    private void getHttp(){

        OkHttpClient okHttpClient =new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://www.baidu.com/")
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()){

                Log.d("response",response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
