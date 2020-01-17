package app.harry.core.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit

object RetrofitFactory {

    fun builder(url: String, okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(url)

}