package com.herpestes.kotlinretrofit

import retrofit2.Call
import retrofit2.http.GET

interface KisilerDaoInterface {

    @GET("/kisiler/tum_kisiler.php")
    fun tumKisiler():Call<KisilerCevap>

}