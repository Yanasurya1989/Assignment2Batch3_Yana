package com.example.batch3_assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_hitung_umur.*
import kotlinx.android.synthetic.main.activity_kalkulator_b_b_i.*
import java.text.SimpleDateFormat
import java.util.*

class HitungUmur : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_umur)

        btnmovetoListview.setOnClickListener {
            val moveListview = Intent(this, ListviewActivity::class.java)
            startActivity(moveListview)
        }

        btnHitug.setOnClickListener {
            var tahunlahir = tahunLahir.text.toString()
            var tahunnow = Calendar.getInstance().get(Calendar.YEAR)
            var umur: Int

            if (tahunlahir.toIntOrNull() != null) {

                if (tahunlahir.toInt() <= tahunnow) {
                    umur = tahunlahir.toInt() - tahunnow
                    AlertDialog.Builder(this).apply {
                        setTitle("Menghitung Usia")
                        setMessage("Usia anda adalah : $umur")
                        setPositiveButton("OK"){dialog, _->
                            Toast.makeText(applicationContext, "sampai jumpa..", Toast.LENGTH_SHORT).show()
                            dialog.dismiss()
                        }
                    }.show()

                } else {
                    AlertDialog.Builder(this).apply {
                        setTitle("Menghitung usia")
                        setMessage("Tahun lahir ttidak boleh melebihi tahun berjalan")
                        setPositiveButton("OK"){dialog, _->
                            Toast.makeText(applicationContext, "masukan tahun lahir", Toast.LENGTH_SHORT).show()
                            dialog.dismiss()
                        }
                    }.show()
                }
            }else{
                Toast.makeText(this, "tahun blm diisi", Toast.LENGTH_SHORT).show()
            }
        }

    }
}