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
            if (result.contents == null) {
                Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                val barcode = Barcode(result.contents, "김보운", "010-4742-0181")
                val bundle = Bundle().apply {
                    putParcelable("barcode", barcode)
                }
                val fragment = ReadResultFragment().apply {
                    arguments = bundle
                }
                FragmentFactory.replaceFragment(requireFragmentManager(), fragment)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}