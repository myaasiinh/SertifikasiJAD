package com.ecomerce.activity;

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ecomerce.model.Image
import com.ecomerce.R
import com.ecomerce.database.SharedPref

class DetailActivityMain1 : AppCompatActivity() {
    private lateinit var btnbackdetailmain1: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity_main1)

        val image = intent.getParcelableExtra<Image>(MainActivity.INTENT_PARCELABLE)

        val imgSrc = findViewById<ImageView>(R.id.activitymain1circleIv)
        val imgTitle = findViewById<TextView>(R.id.main1namaTv)
        val imgDesc = findViewById<TextView>(R.id.main1hobiTv)
        val imgDesc1 = findViewById<TextView>(R.id.main1kekayaanTv)
        val btnBuy = findViewById<TextView>(R.id.Buybtn)

        if (image != null) {
            imgSrc.setImageResource(image.imageSrc)
        }
        if (image != null) {
            imgTitle.text = image.imageId.toString()
        }
        if (image != null) {
            imgDesc.text = image.imageDesc
        }
        if (image != null) {
            imgDesc1.text = image.imageDesc1
        }

        btnBuy.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Permintaan Konfirmasi")
            builder.setMessage("Apa Anda ingin memasukan ke keranjang?")
            builder.setPositiveButton("Iya") { dialog, which ->
                if (image != null) {
                    SharedPref.SaveId(this, "{\"imageSrc\":\"" + image.imageSrc.toString() + "\", \"imageId\":\"" + image.imageId.toString() + "\", \"imageDesc\":\"" + image.imageDesc + "\", \"imageDesc1\":\"" + image.imageDesc1 + "\"}")
                    val intent = Intent(this@DetailActivityMain1, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this,"terima kasih pesanan anda telah diproses",Toast.LENGTH_LONG).show()
                }
            }

            builder.setNegativeButton("Tidak") { dialog, which ->
                Toast.makeText(
                    applicationContext,
                    "Tidak", Toast.LENGTH_SHORT
                ).show()
            }
            builder.show()

        }


        btnbackdetailmain1 = findViewById(R.id.Activitymain1Ib)
        btnbackdetailmain1.setOnClickListener {
            val intent = Intent(this@DetailActivityMain1, MainActivity::class.java)
            startActivity(intent)
        }

    }
}