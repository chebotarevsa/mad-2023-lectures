package ru.bsuedu.lec08.network.data.retrofit

import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitCallApi {
    @GET("api.json")
    fun getCards(): Call<List<TermCardModel>>

    @GET("api.json")
    suspend fun getCardsSuspend(): List<TermCardModel>

    companion object {

        fun getInstance(baseUrl: String): RetrofitCallApi =
            Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .build().create(RetrofitCallApi::class.java)
    }
}

object  RetrofitCallDataSource {
    const val url = "https://osa-s3.agroinvest.com/test/lab08/"
    private val api = RetrofitCallApi.getInstance(url);

    fun blockGetRequest(): String {
        return  api.getCards().execute().body().toString()
    }
    fun notBlockGetRequest(callback: (String) -> Unit): Unit {
        return  api.getCards().enqueue(object: Callback<List<TermCardModel>>{
            override fun onResponse(
                call: Call<List<TermCardModel>>,
                response: Response<List<TermCardModel>>
            ) {
                callback(response.body().toString())
            }

            override fun onFailure(call: Call<List<TermCardModel>>, t: Throwable) {
                throw  t;
            }

        } )
    }

    suspend fun coroutineGetRequest():String {
        return  api.getCardsSuspend().toString();
    }
}

fun main() {
//    println(RetrofitCallDataSource.blockGetRequest())
//    RetrofitCallDataSource.notBlockGetRequest {
//        println(it)
//    }

    runBlocking {
        println(RetrofitCallDataSource.coroutineGetRequest())
    }

}
