package lk.ac.kln.stu.project1.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import lk.ac.kln.stu.project1.database.car.Car
import lk.ac.kln.stu.project1.database.car.CarResponseData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://myfakeapi.com/api/"

private val moshi = Moshi
    .Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface RetrofitApiService {
    @GET("cars")
    fun getCars(): Call<CarResponseData>
}

object RetrofitApi {
    val retofitService: RetrofitApiService by lazy {
        retrofit.create(RetrofitApiService::class.java)
    }
}