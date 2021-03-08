package fr.vlad.assosschool.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.vlad.assosschool.MainActivity
import fr.vlad.assosschool.MissionModel
import fr.vlad.assosschool.MissionRepository.Singleton.MissionList
import fr.vlad.assosschool.R
import fr.vlad.assosschool.adapter.MissionAdapter
import fr.vlad.assosschool.adapter.MissionItemDecoration

class HomeFragment (
        private val context: MainActivity
)
    : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)


         //recuperer le recyclerview
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = MissionAdapter(context, MissionList, R.layout.item_horizontal_mission)
        //recuperer le second recyclerview
        val verticalRecyclerView=view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = MissionAdapter(context, MissionList, R.layout.item_vertical_mission)
        verticalRecyclerView.addItemDecoration(MissionItemDecoration())


        return view
    }
}