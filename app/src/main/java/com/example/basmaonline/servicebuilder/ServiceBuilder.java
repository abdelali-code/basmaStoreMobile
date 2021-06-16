package com.example.basmaonline.servicebuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
    // create a logger
    public static HttpLoggingInterceptor logger = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    // create OKHttp
    public static OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder().addInterceptor(logger);
    //public static String url = "https://jsonplaceholder.typicode.com/";
    public static String url = "http://10.0.2.2:8080/";
    public static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(url).
            addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build());

    public static Retrofit retrofit = builder.build();
    public static <S> S buildService(Class<S> service) {
        return retrofit.create(service);
    }
}