package fr.vlad.assosschool.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.vlad.assosschool.MainActivity
import fr.vlad.assosschool.MissionModel
import fr.vlad.assosschool.R

class MissionAdapter(
        private val context: MainActivity,
        private val MissionList: List<MissionModel>,
        private val layoutId: Int) : RecyclerView.Adapter<MissionAdapter.ViewHolder>() {

    class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        val plantImage = view.findViewById<ImageView>(R.id.image_item)
        val MissionName: TextView? = view.findViewById(R.id.name_item)
        val MissionDescription: TextView? = view.findViewById(R.id.description_item)
        val starIcon = view.findViewById<ImageView>(R.id.star_icon)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(layoutId,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = MissionList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //recuperer les info de la mission
        val currentMission = MissionList [position]
        //utiliser glide pour recuperer l'image a partir de son lien
        Glide.with(context).load(Uri.parse(currentMission.imageUrl)).into(holder.plantImage)
        //MaJ de la mission
        holder.MissionName?.text = currentMission.name
        //MaJ description Mission
        holder.MissionDescription?.text = currentMission.description
        //verfier si la plante a ete liked
        if(currentMission.liked){
            holder.starIcon.setImageResource(R.drawable.ic_star)
        }
        else {holder.starIcon.setImageResource(R.drawable.ic_unstar)
    }
}}