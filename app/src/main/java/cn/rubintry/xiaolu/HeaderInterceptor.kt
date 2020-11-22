package cn.rubintry.xiaolu

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("X-LC-Id" , "Yy0KkiAKVVHrrpuSqFJEOCiV-gzGzoHsz")
            .addHeader("X-LC-Key" , "fXfDRwvCpXRzPFi52GA6zkbl")
            .build()

        return chain.proceed(request)
    }

}