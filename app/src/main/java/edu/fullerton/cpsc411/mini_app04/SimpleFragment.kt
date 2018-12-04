package edu.fullerton.cpsc411.mini_app04

import android.os.Bundle
//import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import edu.fullerton.cpsc411.mini_app04.databinding.FragmentSimpleBinding
import kotlinx.android.synthetic.main.activity_main.*
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

    // Obtain ViewModel from ViewModelProviders
    private val viewModel by lazy { ViewModelProviders.of(this).get(SimpleViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding:FragmentSimpleBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.fragment_simple, container, false)
        binding.viewmodel = viewModel

        return binding.root
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
