package com.bowoon.android.barcode_reader.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bowoon.android.barcode_reader.R
import com.bowoon.android.barcode_reader.model.Barcode
import com.bowoon.android.barcode_reader.repository.Repository
import com.bowoon.android.barcode_reader.utils.FragmentFactory
import com.google.zxing.integration.android.IntentIntegrator


class BarcodeReaderViewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.bacode_reader_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        IntentIntegrator.forSupportFragment(this).initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            val fragment = ReadResultFragment()

            if (result.contents == null) {
                fragment.apply {
                    arguments = Bundle().apply {
                        putParcelable("barcode", null)
                    }
                }
            } else {
                val barcode = Barcode(result.contents, "김보운", "010-4742-0181")
                fragment.apply {
                    arguments = Bundle().apply {
                        putParcelable("barcode", barcode)
                    }
                }
            }

            requireFragmentManager().popBackStack()
            FragmentFactory.replaceFragment(requireFragmentManager(), fragment)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}