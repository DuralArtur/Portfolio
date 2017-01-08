package com.example.android.portfolio

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * Created by Artur on 21-Dec-16.
 */
class ProjectsAdapter(val projectsList: List<Project>, val itemClick: (Project) -> Unit) : RecyclerView.Adapter<ProjectsAdapter.ViewHolder>() {
    override fun getItemCount(): Int = projectsList.size

    var lastPos = -1


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindProject(projectsList[position])
        setAnimation(holder.itemView,position)
    }

    class ViewHolder(view: View, val itemClick: (Project) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindProject(project: Project) {
            with(project) {
                itemView.updatedTextView.text =pushed_at.substring(0,10)
                itemView.projectNameTextView.text = name
                itemView.descriptionTextView.text = description
                itemView.languageTextView.text = language
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    fun setAnimation(view: View, position: Int) {
        if (position > lastPos) {
            val animation: Animation = AnimationUtils.loadAnimation(view.context, android.R.anim.fade_in)
            animation.startOffset = (position.mod(3) * 250).toLong()
            view.startAnimation(animation)
            lastPos = position
        }
    }

}