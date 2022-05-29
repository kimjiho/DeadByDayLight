package kr.nyj.jh.deadbydaylight.repository

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.nyj.jh.deadbydaylight.api.DbdApi
import kr.nyj.jh.deadbydaylight.model.Killers
import kr.nyj.jh.deadbydaylight.model.Survivors

class DbdRepo {

    private val api = DbdApi.create()

    fun getSurvivors(): Observable<ArrayList<Survivors>> =
        api.getSurvivors()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getKillers(): Observable<ArrayList<Killers>> =
        api.getKillers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}