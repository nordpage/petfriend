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
import xyz.mobcoder.petfriend.Pet
import xyz.mobcoder.petfriend.model.Response
import xyz.mobcoder.petfriend.model.Token
import java.util.concurrent.TimeUnit


interface ApiService {

    @POST("register")
    fun registerUser(
        @Query("name") name: String,
        @Query("email") email: String,
        @Query("password") password: String,
        @Query("c_password") c_password: String
    ): Observable<Response<Token>>

    @POST("login")
    fun loginUser(
        @Query("email") email: String,
        @Query("password") password: String
    ) : Observable<Response<Token>>

    @GET("pets")
    fun getPets(
        @Header("Authorization") authHeader: String
    ) : Observable<Response<List<Pet>>>

    companion object {
        private const val BASE_URL = "https://quiet-retreat-54376.herokuapp.com/api/"

        fun create(): ApiService {
            val logger = HttpLoggingInterceptor().apply { level = Level.BODY }
            val client = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .callTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
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