package alyhuggan.onionarticles.ui

import alyhuggan.onionarticles.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation

private lateinit var navController: NavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initiateNavController()
    }

    private fun initiateNavController() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }
}