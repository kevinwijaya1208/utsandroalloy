package uts.c14210265.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val arrKontak = intent.getParcelableArrayListExtra(tambah.arrKontak, Kontak::class.java)
        val indexKontak = intent.getIntExtra(tambah.indexKontak, -1)
        var counter = intent.getIntExtra(tambah.counter, arrKontak!!.size)

        val _nama = findViewById<TextView>(R.id.namaTxt)
        val _nomor = findViewById<TextView>(R.id.nomorTxt)
        val _email = findViewById<TextView>(R.id.emailTxt)
        val _profilePic = findViewById<ImageView>(R.id.prodilePic)
        val _backBtn = findViewById<Button>(R.id.backBtn)
        val _editBtn  =findViewById<Button>(R.id.editBtn)

        val nama = arrKontak!!.get(indexKontak).nama
        val nomor = arrKontak!!.get(indexKontak).telp
        val email = arrKontak!!.get(indexKontak).email
        _nama.text = "Nama: $nama"
        _nomor.text = "Nomor Telp: $nomor"
        _email.text = "Email: $email"

        _profilePic.setOnClickListener {
            val intent = Intent(this@Detail, tambah::class.java).apply {
                putExtra(tambah.type, "edit")
                putExtra(tambah.indexKontak, indexKontak)
                putExtra(tambah.arrKontak, arrKontak)
                putExtra(tambah.counter, counter)
            }
            startActivity(intent)
        }

        _backBtn.setOnClickListener {
            val intent = Intent(this@Detail, MainActivity::class.java).apply {
                putExtra(tambah.arrKontak, arrKontak)
                putExtra(tambah.counter, counter)
            }
            startActivity(intent)
        }

        _editBtn.setOnClickListener {
            val intent = Intent(this@Detail, tambah::class.java).apply {
                putExtra(tambah.type, "edit")
                putExtra(tambah.indexKontak, indexKontak)
                putExtra(tambah.arrKontak, arrKontak)
                putExtra(tambah.counter, counter)
            }
            startActivity(intent)
        }
    }
}