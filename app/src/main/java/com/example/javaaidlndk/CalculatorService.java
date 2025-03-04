package com.example.javaaidlndk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class CalculatorService extends Service {
    public CalculatorService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    IBinder mBinder = new ICalculator.Stub() {

        @Override
        public int add(int a, int b) throws RemoteException {
            return a + b;
        }
    };
}