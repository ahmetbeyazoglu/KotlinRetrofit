package com.herpestes.kotlinretrofit

class ApiUtils {

    companion object{
        val BASE_URL = "http://ahmet.com/"

        fun getKisilerGetInterface(): KisilerDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(KisilerDaoInterface::class.java)
        }
    }

}