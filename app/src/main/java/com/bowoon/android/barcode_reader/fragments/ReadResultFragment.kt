package com.bowoon.android.barcode_reader.fragments

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
import kotlinx.android.synthetic.main.read_result_fragment.view.*

class ReadResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.read_result_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireArguments().let { arg ->
            val barcode = arg.getParcelable<Barcode>("barcode")

            if (barcode != null) {
                requireView().barcodeValue.text = barcode.value

                requireView().resultPost.setOnClickListener {
                    Repository.post(barcode)
                }
            }

            if (barcode == null) {
                requireView().resultPost.setOnClickListener {
                    Toast.makeText(requireContext(), "결과 값이 없습니다!", Toast.LENGTH_SHORT).show()
                }
            }

            requireView().barcodeReader.setOnClickListener {
                FragmentFactory.replaceFragment(
                    requireFragmentManager(),
                    BarcodeReaderViewFragment()
                )
            }
        }
    }
}