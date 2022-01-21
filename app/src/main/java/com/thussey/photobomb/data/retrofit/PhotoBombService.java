package com.thussey.photobomb.data.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotoBombService<T> {
    private OkHttpClient okHttpClient;
    private String baseUrl;
    private Class<T> serviceClass;
    private T service = null;

    public PhotoBombService(OkHttpClient okHttpClient, Class<T> serviceClass, String baseUrl) {
        this.serviceClass = serviceClass;
        this.okHttpClient = okHttpClient;
        this.baseUrl = baseUrl;
    }

    public T getRetrofitInstance() {
        Retrofit retrofitClient;
        if (service == null) {
            retrofitClient = buildRetrofitClient(okHttpClient, baseUrl);
            if (retrofitClient != null) {
                service = retrofitClient.create(serviceClass);
            }
        }
        return service;
    }

    private static Retrofit buildRetrofitClient(OkHttpClient okHttpClient, String url) {
        if (url != null) {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            return new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .client(okHttpClient)
                    .build();
        }

        return  null;
    }
}
