package com.shamim.patho.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.shamim.patho.activity.Homepage;

public class CountingService extends Service {

    public static final String TAG="CountingService";
    @Override

    public void onCreate() {
        //This method is work first when compiler  run
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //this method works for services
        //what we will do there,that work will run

        Thread countThread = new Thread(new Runnable() {
            @Override
            public void run() {
                startingservice();
            }
        });
        countThread.start();


        return super.onStartCommand(intent, flags, startId);


    }

    private void startingservice() {
        int i=1;
        while(true){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "Count: i= "+i);

            i++;
        }
    }

    @Override
    public void onDestroy() {
        //this method works for services stop

        super.onDestroy();
    }
}
