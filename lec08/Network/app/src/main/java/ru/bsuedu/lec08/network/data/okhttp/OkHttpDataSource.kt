package ru.bsuedu.lec08.network.data.okhttp

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.runBlocking
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object OkHttpDataSource {
    private val client = OkHttpClient();

    fun blockGetRequest2(): String {
       val request =  Request.Builder().url("https://publicobject.com/helloworld.txt").build()
        try {
            client.newCall(request).execute().use { response ->
                if(!response.isSuccessful) {
                    throw IOException("${response.code} ${response.message}")
                }
                return  response.body!!.string()
            }
        } catch (e: IOException) {
            throw e;
        }
    }

    fun unBlockGetRequest2(callback: (String) -> Unit) {
        val request =  Request.Builder().url("https://publicobject.com/helloworld.txt").build()
        client.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                throw e
            }

            override fun onResponse(call: Call, response: Response) {
                callback(response.body!!.string())
            }
        })
    }

    suspend fun coroutineGetRequest2():String = suspendCoroutine {
        continuation ->
        val request =  Request.Builder().url("https://publicobject.com/helloworld.txt").build()
        client.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                continuation.resumeWithException(e)
            }
            override fun onResponse(call: Call, response: Response) {
                continuation.resume(response.body!!.string())
            }
        })
    }




    fun blockGetRequest(): String {
        val request = Request.Builder()
            .url("https://publicobject.com/helloworld.txt")
            .build()

        try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    throw IOException(
                        "Запрос к серверу не был успешен:" +
                                " ${response.code} ${response.message}"
                    )
                }
                println("Server: ${response.header("Server")}")
                val body = response.body!!.string()
                println(body)
                return body
            }
        } catch (e: IOException) {
            println("Ошибка подключения: $e");
            throw e;
        }
    }


    fun notBlockGetRequest(callback: (String) -> Unit) {
        val request = Request.Builder()
            .url("https://publicobject.com/helloworld.txt")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Ошибка подключения: $e");
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    throw IOException(
                        "Запрос к серверу не был успешен:" +
                                " ${response.code} ${response.message}"
                    )
                }
                println("Server: ${response.header("Server")}")
                val body = response.body!!.string()
                println(body)
                callback(body)
            }
        })
    }

    suspend fun coroutineGetRequest(): String = suspendCoroutine { continuation ->
        val request = Request.Builder()
            .url("https://publicobject.com/helloworld.txt")
            .build()
        try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    throw IOException(
                        "Запрос к серверу не был успешен:" +
                                " ${response.code} ${response.message}"
                    )
                }
                continuation.resume(response.body!!.string())
            }
        } catch (e: IOException) {
            continuation.resumeWithException(e)
        }
    }

}

fun main() {
    runBlocking {
        println("Start")
        println(OkHttpDataSource.coroutineGetRequest2())
        println("Finish")
    }
}