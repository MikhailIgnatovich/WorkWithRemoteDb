package com.bulich.misha.workwithremotedb.data.api

import com.bulich.misha.workwithremotedb.data.models.FilmsApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("getFilms.php")
    fun getFilms(): Call<ArrayList<FilmsApiModel>>
}