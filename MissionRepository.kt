package fr.vlad.assosschool

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fr.vlad.assosschool.MissionRepository.Singleton.MissionList
import fr.vlad.assosschool.MissionRepository.Singleton.databaseRef

class MissionRepository {

    object Singleton {
        val databaseRef = FirebaseDatabase.getInstance().getReference("Missions")
        val MissionList = arrayListOf<MissionModel>() }

    fun updateData(callback : () -> Unit){
        //absorber les données depuis la databaseRef
        databaseRef.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                MissionList.clear()
                for (ds in snapshot.children) {
                    val mission = ds.getValue(MissionModel::class.java)
                    if (mission != null){
                        MissionList.add(mission)
                    }
                }
                //actionner le callback
                callback()

            }
            override fun onCancelled(error: DatabaseError) {}

        })

    }
}