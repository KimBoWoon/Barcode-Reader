package com.bowoon.android.barcode_reader.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.bowoon.android.barcode_reader.R

object FragmentFactory {
    fun replaceFragment(fragmentManager: FragmentManager, fragment: Fragment) {
        fragmentManager
            .beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
    }
}