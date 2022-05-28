package kr.nyj.jh.deadbydaylight.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    private var retrofit: Retrofit? = null
    private val baseDomain: String = "https://dbd-api.herokuapp.com/"

    fun getInstance(): Retrofit {
        if(retrofit == null)
        {
            retrofit = Retrofit.Builder()
                .baseUrl(baseDomain)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit!!
    }
}