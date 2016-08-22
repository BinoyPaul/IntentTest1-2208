package com.example.binoypaul.intenttest1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                int i;
                for (i = 0; i < 1000; i++) {
                    Log.i("bTest", "The number is " + i);
                }

            }
        };
        //return super.onStartCommand(intent, flags, startId);
        Thread BinoThread = new Thread(r);
        BinoThread.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i("bTest", "Service is destroyed");
        super.onDestroy();
    }

    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }
}
