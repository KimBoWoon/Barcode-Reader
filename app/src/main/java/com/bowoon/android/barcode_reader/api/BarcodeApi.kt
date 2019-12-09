package com.bowoon.android.barcode_reader.api

import com.bowoon.android.barcode_reader.model.Barcode
import com.bowoon.android.barcode_reader.model.Result
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface BarcodeApi {
    @Headers("Content-Type: application/json")
    @POST("/default/android-dev-recruit")
    fun post(@Body barcode: Barcode): Observable<Result>
}