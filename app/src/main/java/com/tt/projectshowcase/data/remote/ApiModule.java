package com.tt.projectshowcase.data.remote;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 */
@Module
public class ApiModule {

    /*private final String baseUrl;

    public ApiModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }*/

    @Singleton
    @Provides
    ApiService provideApiService(){
        return new MockApiService();
    }

    /*@Singleton
    @Provides
    ApiService provideApiService(Gson gson){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .build();

        return retrofit.create(ApiService.class);
    }*/
}
