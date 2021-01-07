package com.example.teacherassistant.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.viewmodel.CoursesListViewModel
import com.example.teacherassistant.viewmodel.CourseAdapter
import kotlinx.android.synthetic.main.fragment_courses_list.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CoursesList : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var courseAdapter: CourseAdapter
    private lateinit var viewModel: CoursesListViewModel

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
        viewModel = ViewModelProvider(requireActivity()).get(CoursesListViewModel::class.java)
        viewManager = LinearLayoutManager(requireContext())

        courseAdapter = CourseAdapter(viewModel.courses, viewModel)

        viewModel.courses.observe(viewLifecycleOwner, Observer { _ ->
            courseAdapter.notifyDataSetChanged()
        })

        return inflater.inflate(R.layout.fragment_courses_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        BackButtonCoursesList.setOnClickListener { x -> x.findNavController().navigate(R.id.action_coursesList_to_mainMenu) }
        AddCourseButton.setOnClickListener { x -> x.findNavController().navigate(R.id.action_coursesList_to_addCourse) }

        coursesListRecyclerView.apply {
            adapter = courseAdapter
            layoutManager = viewManager
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CoursesList().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}