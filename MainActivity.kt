package fr.vlad.assosschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.vlad.assosschool.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //charger notre repository
        val repo = MissionRepository()
        //MaJ Liste de mission
        repo.updateData {
            // injecter le framgent dans notre boite (fragment_container)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, HomeFragment(this))
        transaction.addToBackStack(null)
        transaction.commit()
    } }
}