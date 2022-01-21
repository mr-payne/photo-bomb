package com.thussey.photobomb.di;

import com.thussey.photobomb.data.retrofit.PhotoBombService;
import com.thussey.photobomb.data.datasource.PhotoApiServices;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
@InstallIn(SingletonComponent.class)
public class RetrofitModule {

    private OkHttpClient getClient(int readWriteTimeout) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.readTimeout(readWriteTimeout, TimeUnit.SECONDS);
        httpClient.connectTimeout(10, TimeUnit.SECONDS);
        httpClient.writeTimeout(readWriteTimeout, TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(interceptor);
        return httpClient.build();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        return getClient(20);
    }

    @Provides
    @Singleton
    @Named("PhotoApiBaseUrl")
    public String providePhotoApiBaseUrl() {
        return "https://vp42xw7w6a.execute-api.us-east-1.amazonaws.com/";
    }

    @Provides
    @Singleton
    public PhotoBombService<PhotoApiServices> providePhotoApiServices(
            OkHttpClient okHttpClient, @Named("PhotoApiBaseUrl") String url) {
        return new PhotoBombService<>(okHttpClient, PhotoApiServices.class, url);
    }

}
