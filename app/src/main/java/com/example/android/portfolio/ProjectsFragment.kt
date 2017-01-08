package com.example.android.portfolio


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.AsyncLayoutInflater
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_projects.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread


/**
 * A simple [Fragment] subclass.
 */
class ProjectsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_projects, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myRecycler.layoutManager = LinearLayoutManager(context)

        val projectsManager: ProjectsManager = ProjectsManager()
        async() {
            val projectsList = projectsManager.getProjects()
            uiThread {
                val adapter = ProjectsAdapter(projectsList){
                }
                myRecycler.adapter = adapter
            }
        }
    }
}// Required empty public constructor
