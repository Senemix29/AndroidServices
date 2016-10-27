package br.com.natanximenes.servicos;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by natanximenes on 10/25/16.
 */

public class MainThreadService extends Service {

    public void longOperation() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Log.d("Thread", e.getMessage());
        }
        stopSelf();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Thread", "Main Thread service starting..");
        Toast.makeText(this,"Main Thread service starting..", Toast.LENGTH_LONG).show();
        longOperation();
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Thread", "Main Thread service stopping..");
        Toast.makeText(this,"Main Thread service stopping..", Toast.LENGTH_LONG).show();
    }
}
