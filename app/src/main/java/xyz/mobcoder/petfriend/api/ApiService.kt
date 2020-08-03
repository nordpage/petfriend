package xyz.mobcoder.petfriend.api

import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query
import xyz.mobcoder.petfriend.Login
import xyz.mobcoder.petfriend.Response

interface ApiService {

    @POST("register")
    suspend fun registerUser(
        @Query("name") name: String,
        @Query("email") email: String,
        @Query("password") password: String,
        @Query("c_password") c_password: String
    ): Observable<Response<Login>>

    @POST("login")
    suspend fun loginUser(
        @Query("email") email: String,
        @Query("password") password: String
    ) : Observable<Response<Login>>

    @GET("pets")
    suspend fun getPets(
        @Header("Authorization") authHeader: String
    ) : Observable<Response<Login>>

    companion object {
        private const val BASE_URL = "https://quiet-retreat-54376.herokuapp.com/api/"

        fun create(): ApiService {
            val logger = HttpLoggingInterceptor().apply { level = Level.BODY }
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }

    }
}