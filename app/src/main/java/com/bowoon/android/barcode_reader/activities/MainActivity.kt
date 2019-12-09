package com.bowoon.android.barcode_reader.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bowoon.android.barcode_reader.fragments.BarcodeReaderViewFragment
import com.bowoon.android.barcode_reader.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.frameContainer,
                BarcodeReaderViewFragment()
            )
            .addToBackStack(null)
            .commit()
    }
}
