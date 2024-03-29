package kynt.fpt.demopaginglibrary.xsplash.retrofit

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

import java.io.IOException

class HeaderInterceptor(private val clientId: String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Authorization", "Client-ID $clientId")
            .build()
        return chain.proceed(request)
    }
}
