package edu.fullerton.cpsc411.mini_app04

import android.os.Bundle
//import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.*
import kotlinx.android.synthetic.main.fragment_simple.view.*
import java.util.Locale.US


private const val NET_WORK = "net_work"
private const val FILE_SIZE = "file_size"
private const val RESULT = "result"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SimpleFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SimpleFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class SimpleFragment : Fragment() {
    // TODO: Rename and change types of parameters
//    private var netSpeed: Double = 0.0
//    private var fileSize: Double = 0.0
//    private var result: String? = null
//    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            it.putDouble(NET_WORK, netSpeed)
//            it.putDouble(FILE_SIZE, fileSize)
//            it.putString(RESULT, result)
//        }
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_simple, container, false)
        val fileSizeInput = rootView.FileSizeInput
        val networkSpeedInput = rootView.NetworkSpeedInput
        val resultView = rootView.Result

        val defaultListener = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val notEmpty: TextView.() -> Boolean = { text.isNotEmpty() }

                if (notEmpty(fileSizeInput) and notEmpty(networkSpeedInput)) {
                    val speed = java.lang.Double.valueOf(networkSpeedInput.text.toString())
//                    netSpeed = speed
                    val size = java.lang.Double.valueOf(fileSizeInput.text.toString())
//                    fileSize = size

                    if (size == 0.0) {
                        resultView.text = getString(R.string.invalid_input)
//                        result = resultView.text.toString()
                    } else {
                        val output = resultView.toOneDec(resultView.cal(speed, size)) + " seconds"
                        resultView.text = output
//                        result = output
                    }
                } else {
                    val time = resultView.toOneDec(resultView.cal(100.0, 100.0)) + " seconds"
                    resultView.text = time
//                    result = time
                }
            }

        }
        networkSpeedInput.addTextChangedListener(defaultListener)
        fileSizeInput.addTextChangedListener(defaultListener)

        return rootView
    }

    private fun TextView.cal(networkSpeed: Double?, fileSize: Double?): Double {
        return networkSpeed!! * Math.pow(2.0, 20.0) * 8.0 / (fileSize!! * Math.pow(10.0, 6.0))
    }

    private fun TextView.toOneDec(num: Double?): String {
        return String.format(US, "%.1f", num)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param speed Network speed in Mbps
         * @param size File size in MiB
         * @param result time in seconds
         * @return A new instance of fragment SimpleFragment.
         */
        @JvmStatic
        fun newInstance(speed: Double, size: Double, result: Double) =
                SimpleFragment().apply {
                    arguments = Bundle().apply {
                        putDouble(NET_WORK, speed)
                        putDouble(FILE_SIZE, size)
                        putDouble(RESULT, result)
                    }
                }
    }
}
