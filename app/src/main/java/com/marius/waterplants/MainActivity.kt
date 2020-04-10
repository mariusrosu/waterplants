package com.marius.waterplants

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.marius.waterplants.add.AddPlantFragment
import com.marius.waterplants.drawer.BottomDrawerFragment
import com.marius.waterplants.garden.GardenFragment
import com.marius.waterplants.settings.SettingsFragment
import com.marius.waterplants.ui.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(bottom_app_bar)

        supportFragmentManager.beginTransaction()
            .add(R.id.container_view, GardenFragment.newInstance()).commit()

        new_plant_button.setOnClickListener {
            AddPlantFragment().show(supportFragmentManager, AddPlantFragment.TAG)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> BottomDrawerFragment().show(
                supportFragmentManager, BottomDrawerFragment.TAG
            )
            R.id.app_bar_settings -> SettingsFragment().show(
                supportFragmentManager,
                SettingsFragment.TAG
            )
        }
        return true
    }
}
