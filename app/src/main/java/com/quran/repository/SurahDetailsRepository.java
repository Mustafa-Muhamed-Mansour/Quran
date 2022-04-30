package com.quran.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.quran.network.SurahClient;
import com.quran.network.SurahServices;
import com.quran.response.SurahDetailsResponse;
import com.quran.response.SurahResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurahDetailsRepository
{

    private SurahServices surahServices;
    private MutableLiveData<SurahDetailsResponse> surahDetailsResponseMutableLiveData;
    private MutableLiveData<String> stringMutableLiveData;

    public SurahDetailsRepository()
    {
        surahServices = new SurahClient().getInstance().create(SurahServices.class);
        surahDetailsResponseMutableLiveData = new MutableLiveData<>();
        stringMutableLiveData = new MutableLiveData<>();
    }

    public LiveData<SurahDetailsResponse> getSurahDetails(String lan, int id)
    {

        surahServices
                .getSurahDetails(lan, id)
                .enqueue(new Callback<SurahDetailsResponse>()
                {
                    @Override
                    public void onResponse(Call<SurahDetailsResponse> call, Response<SurahDetailsResponse> response)
                    {
                        surahDetailsResponseMutableLiveData.setValue(response.body());
                        stringMutableLiveData.setValue("Sucess");
                    }

                    @Override
                    public void onFailure(Call<SurahDetailsResponse> call, Throwable t)
                    {
                        surahDetailsResponseMutableLiveData.setValue(null);
                        stringMutableLiveData.setValue(t.toString());
                    }
                });

        return surahDetailsResponseMutableLiveData;
    }
}
