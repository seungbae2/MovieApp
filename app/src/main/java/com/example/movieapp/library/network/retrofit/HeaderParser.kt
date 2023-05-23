package com.example.movieapp.library.network.retrofit

import okhttp3.Headers
import java.util.*
import javax.inject.Inject

class HeaderParser @Inject constructor() {
    fun parseHeadersToMap(headers: Headers): Map<String, String> {
        val headerMap: MutableMap<String, String> = mutableMapOf()

        headers.iterator().forEach { (key, value) ->
            if (key.equals("set-cookie", ignoreCase = true)) {
                val keyInLowercase = key.lowercase(Locale.getDefault())

                if (headerMap[keyInLowercase].isNullOrEmpty()) {
                    headerMap[keyInLowercase] = value
                } else {
                    headerMap[keyInLowercase] = "${headerMap[key]}; $value"
                }
            } else {
                headerMap[key] = value
            }
        }

        return headerMap
    }
}