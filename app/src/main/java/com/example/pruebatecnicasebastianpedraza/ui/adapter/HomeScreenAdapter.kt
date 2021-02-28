package com.example.pruebatecnicasebastianpedraza.ui.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatecnicasebastianpedraza.core.BaseViewHolder
import com.example.pruebatecnicasebastianpedraza.data.model.Project
import com.example.pruebatecnicasebastianpedraza.databinding.ProjectRvItemBinding

//RecyclerView that uses the list of projects
class HomeScreenAdapter(
    private val projectList: List<Project>,

    ) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ProjectRvItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is PostViewHolder -> holder.bind(projectList[position])
        }
    }

    override fun getItemCount(): Int = projectList.size

    private inner class PostViewHolder(
        val binding: ProjectRvItemBinding,
    ) : BaseViewHolder<Project>(binding.root) {

        override fun bind(item: Project) {
            binding.projectName.text = item.project_name
            //assigning the colors to the columns
            Log.d("Firebase1", "El color es:" + item.color_background)
            when (item.color_background) {
                "Red" -> binding.projectColor.setBackgroundColor(Color.parseColor("#E72828"))
                "grey" -> binding.projectColor.setBackgroundColor(Color.parseColor("#7E7D7E"))
                "Blue" -> binding.projectColor.setBackgroundColor(Color.parseColor("#2F9CC4"))
            }


        }
    }

}