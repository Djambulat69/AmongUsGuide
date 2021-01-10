package com.djambulat69.amongusguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG = "CrewmateTipFragment"

/**
 * A simple [Fragment] subclass.
 * Use the [AmongUsTipFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AmongUsTipFragment : Fragment() {

    private val safeArgs: AmongUsTipFragmentArgs by navArgs()


    private lateinit var navController: NavController
    private lateinit var toolBar: MaterialToolbar
    private val viewModel: AmongUsFragmentActivityViewModel by activityViewModels()
    private lateinit var tip: AmongUsTip
    private lateinit var tipTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
        val isCrewmate = safeArgs.isCrewmate

        tip =  if (isCrewmate) viewModel.crewmateTipsList[safeArgs.tipNumber]
        else viewModel.impostorTipsList[safeArgs.tipNumber]
        navController = findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amongus_tip, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        tipTextView = view.findViewById(R.id.tip_text_view)
        tipTextView.text = getString(tip.text)

        toolBar = view.findViewById(R.id.crewmate_tip_toolbar)
        toolBar.setupWithNavController(navController)
        toolBar.title = getString(tip.title)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CrewmateTipFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AmongUsTipFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}