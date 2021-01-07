package com.example.teacherassistant.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.teacherassistant.R
import kotlinx.android.synthetic.main.fragment_main_menu.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainMenu : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoursesButton.setOnClickListener { x -> x.findNavController().navigate(R.id.action_mainMenu_to_coursesList) }
        ReportButton.setOnClickListener { x -> x.findNavController().navigate(R.id.action_mainMenu_to_report) }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                MainMenu().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}