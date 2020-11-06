package com.ecomerce.activity;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecomerce.*
import com.ecomerce.adapter.ImageAdapter
import com.ecomerce.database.SharedPref
import com.ecomerce.model.Image

open class MainActivity : AppCompatActivity() {
    private lateinit var btnOrang: ImageButton
    private lateinit var btnPesanan: ImageButton


    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
        lateinit var imageLis:List<Image>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageLis = arrayListOf(
            Image(
                2131165353,
                1,
                "Nike zoom",
                "RP 200, 00"
            ),
            Image(
                2131165355,
                2,
                "Nike star",
                "Rp 290, 000"
            ),
            Image(
                2131165356,
                3,
                "Nike super",
                "Rp 340, 000"
            ),
            Image(
                2131165357,
                4,
                " Nike wings",
                "Rp 120, 000"
            ),
            Image(
                2131165358,
                5,
                "Adidas boot",
                "Rp 100, 000"
            ),
            Image(
                2131165359,
                6,
                "Casual pria",
                "Rp 230, 000"
            ),
            Image(
                2131165360,
                7,
                "Casual anak",
                "Rp 400, 000"
            ),
            Image(
                2131165361,
                8,
                "Casual remaja",
                "Rp 250, 000"
            ),
            Image(
                2131165362,
                9,
                "Casual spesial",
                "Rp 120, 000"
            ),
            Image(
                2131165354,
                10,
                "Casual super",
                "Rp 300, 000"
            ),

            )

        btnOrang = findViewById(R.id.Btnorang)
        btnOrang.setOnClickListener {
            val intent = Intent(this@MainActivity, DetailProfilActivity::class.java)
            startActivity(intent)
        }
        btnPesanan = findViewById(R.id.Btnpesanan)
        btnPesanan.setOnClickListener {
            val intent = Intent(this@MainActivity, KeranjangActivity::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.MiliaderRv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(this, imageLis) {
            val intent = Intent(this, DetailActivityMain1::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume: " + SharedPref.GetId(this))
    }
}









