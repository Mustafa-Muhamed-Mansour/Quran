package com.quran.ui;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SplashViewModel extends ViewModel
{

    private MutableLiveData<Boolean> booleanMutableLiveData;

    public SplashViewModel()
    {
        booleanMutableLiveData = new MutableLiveData<>();
    }

    public LiveData<Boolean> splashScreen()
    {

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                booleanMutableLiveData.postValue(true);
            }
        }, 5000);

        return booleanMutableLiveData;
    }
}