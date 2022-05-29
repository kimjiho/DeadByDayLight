package kr.nyj.jh.deadbydaylight.api

import io.reactivex.rxjava3.core.Observable
import kr.nyj.jh.deadbydaylight.model.Killers
import kr.nyj.jh.deadbydaylight.model.Survivors
import retrofit2.http.GET

interface DbdApi {

    @GET("survivors")
    fun getSurvivors(): Observable<ArrayList<Survivors>>

    @GET("killers")
    fun getKillers(): Observable<ArrayList<Killers>>

    @GET("currencies")
    fun getCurrencies(): Observable<ArrayList<Survivors>>

    @GET("perks")
    fun getPerks(): Observable<ArrayList<Survivors>>

    companion object {
        fun create(): DbdApi {
            val retrofit = RetrofitBuilder().getInstance()
            return retrofit.create(DbdApi::class.java)
        }
    }
}