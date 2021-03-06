package com.example.teacherassistant.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.teacherassistant.R
import com.example.teacherassistant.viewmodel.GradeViewModel
import com.example.teacherassistant.viewmodel.StudentListViewModel
import kotlinx.android.synthetic.main.fragment_add_grade.*
import kotlinx.android.synthetic.main.fragment_add_student.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private  lateinit var viewmodel: GradeViewModel

class AddGrade : Fragment() {
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
        viewmodel = ViewModelProvider(requireActivity()).get(GradeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_add_grade, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        BackButtonAddGrade.setOnClickListener { x -> x.findNavController().navigate(R.id.action_addGrade_to_studentInfo) }
        SaveButtonAddGrade.setOnClickListener { x ->
            //viewmodel.addGrade(addGradeGrade.text.toString().toDouble(), addGradeNote.text.toString())
            x.findNavController().navigate(R.id.action_addGrade_to_studentInfo) }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddGrade().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}