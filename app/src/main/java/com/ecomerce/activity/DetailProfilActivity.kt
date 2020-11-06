package com.ecomerce.activity;

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton

import androidx.appcompat.app.AppCompatActivity
import com.ecomerce.R


class DetailProfilActivity : AppCompatActivity(){
    private lateinit var btnbackdetailprofil: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_profil_activity)
        Log.d("TAG", "onCreate: " + MainActivity.imageLis)

        btnbackdetailprofil = findViewById(R.id.detailProfilIb)
        btnbackdetailprofil.setOnClickListener {
            val intent = Intent(this@DetailProfilActivity, MainActivity::class.java)
            startActivity(intent)
        }

        val BtnLok = findViewById<Button>(R.id.lokasitokoBtn)
        BtnLok.setOnClickListener {
            val url = "https://maps.app.goo.gl/giFvSbkVhE2vnksu8"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)

        }

    }

}
