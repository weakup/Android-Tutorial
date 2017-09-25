package com.example.lisiyan.android_tutorial.Handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.lisiyan.android_tutorial.R;

import java.lang.ref.WeakReference;

/**
 * Created by lisiyan on 2017/9/20.
 */

public class HandlerActivity extends AppCompatActivity{

    private final NotifyHandler mHandler = new NotifyHandler(this);

    public static TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_handler);
        mTextView = (TextView) findViewById(R.id.mytext);
        Message message = Message.obtain();
        message.what = 1;
        message.obj ="success";
        mHandler.sendMessageDelayed(message,7000);
        mHandler.removeMessages(1);

    }


    private static class NotifyHandler extends Handler{

        private WeakReference<HandlerActivity> mActivityWeakReference ;

        NotifyHandler(HandlerActivity handlerActivity){

            mActivityWeakReference = new WeakReference<HandlerActivity>(handlerActivity);

        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mActivityWeakReference !=null){

                Log.d("Delay","你的人生已经过了一秒");
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
//        mHandler.removeMessages(1);
    }
}
