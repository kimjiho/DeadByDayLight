package kr.nyj.jh.deadbydaylight.api

import io.reactivex.rxjava3.core.Observable
import kr.nyj.jh.deadbydaylight.model.Survivors
import retrofit2.http.GET

interface DbdApi {

    @GET("survivors")
    fun getSurvivors(): Observable<ArrayList<Survivors>>

//    @GET("v2/list?limit=20")
//    fun getPhotoListByPage(@Query("page")pageNum:Int): Observable<ArrayList<Photo>>
//
//    @GET("public/v1/users")
//    fun getUserList(@Query("page")pageNum:Int): Observable<UserList>

    companion object {
        fun create(): DbdApi {
            val retrofit = RetrofitBuilder().getInstance()
            return retrofit.create(DbdApi::class.java)
        }
    }
}