package com.example.appcrud.data.remote

import android.content.Context
import com.example.appcrud.data.local.SessionStorage
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceFactory private constructor(
    private val retrofit: Retrofit
) {
    fun create(): ApiService = retrofit.create(ApiService::class.java)

    companion object {
        private const val BASE_URL = "http://10.0.2.2:3000/"

        fun create(context: Context): ApiServiceFactory {
            val sessionStorage = SessionStorage.getInstance(context)

            val client = OkHttpClient.Builder()
                .addInterceptor(object : Interceptor {
                    override fun intercept(chain: Interceptor.Chain): Response {
                        val request: Request = chain.request()
                        val token = sessionStorage.getToken()
                        val authenticatedRequest = if (token != null) {
                            request.newBuilder()
                                .addHeader("Authorization", "Bearer $token")
                                .build()
                        } else {
                            request
                        }
                        return chain.proceed(authenticatedRequest)
                    }
                })
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return ApiServiceFactory(retrofit)
        }
    }
}