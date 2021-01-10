package com.djambulat69.amongusguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ImpostorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ImpostorFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private val viewModel: AmongUsFragmentActivityViewModel by activityViewModels()

    private lateinit var navController: NavController

    private lateinit var recyclerView: RecyclerView

    private lateinit var toolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        navController = findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_impostor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.crewmate_dest, R.id.impostor_dest))

        toolbar = view.findViewById<MaterialToolbar>(R.id.impostor_toolbar)
        toolbar.setupWithNavController(navController, appBarConfiguration)

        recyclerView = view.findViewById(R.id.impostor_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ImpostorTipAdapter(viewModel.impostorTipsList)
    }

    inner class ImpostorTipAdapter(private val tipsList: List<AmongUsTip>)
        : RecyclerView.Adapter<ImpostorTipAdapter.ImpostorTipViewHolder>() {
        inner class ImpostorTipViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val titleTextView: TextView = itemView.findViewById(R.id.card_title_text_view)
            val imageView: ImageView = itemView.findViewById(R.id.card_image_view)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImpostorTipViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.card_item_amongus_tip, parent, false)
            val holder = ImpostorTipViewHolder(view)
            view.setOnClickListener {
                val tipNumber = holder.adapterPosition
                val isCrewmate = false
                val action = ImpostorFragmentDirections
                        .actionImpostorDestToCrewmateTipDest(tipNumber, isCrewmate)
                navController.navigate(action)
            }
            return holder
        }

        override fun onBindViewHolder(holder: ImpostorTipViewHolder, position: Int) {
            val tip = tipsList[position]
            holder.titleTextView.text = getString(tip.title)
            holder.imageView.setImageDrawable(ResourcesCompat
                    .getDrawable(resources, tip.imageId, null))
        }

        override fun getItemCount(): Int = tipsList.size
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ImpostorFragment.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ImpostorFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}