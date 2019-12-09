package com.bowoon.android.barcode_reader.repository

import android.util.Log
import com.bowoon.android.barcode_reader.api.provideResultApi
import com.bowoon.android.barcode_reader.model.Barcode
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

object Repository {
    fun post(barcode: Barcode) {
        provideResultApi()
            .post(barcode)
            .observeOn(Schedulers.io())
            .subscribe(
                { Log.i("POST", it.toString()) },
                { e -> e.printStackTrace()
                },
                { Log.i("POST", "Done") }
            ).addTo(CompositeDisposable())
    }
}