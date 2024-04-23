package uts.c14210265.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.sql.Struct

class tambah : AppCompatActivity() {
    companion object {
        val type = "TYPE"
        val indexKontak = "INDEXKONTAK"
        val arrKontak = "ARRKONTAK"
        val counter = "COUNTER"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)
        val typeForm = intent.getStringExtra(type)
        val arrKontak = intent.getParcelableArrayListExtra(arrKontak, Kontak::class.java)
        val indexKontak = intent.getIntExtra(indexKontak, -1)
        var counter = intent.getIntExtra(counter, arrKontak!!.size)

        Log.d("index", counter.toString())

        val _titleForm = findViewById<TextView>(R.id.titleForm)
        val _btnAksi = findViewById<Button>(R.id.btnForm)
        val _namafield = findViewById<EditText>(R.id.nameField)
        val _nomorfield = findViewById<EditText>(R.id.nomorField)
        val _emailfield = findViewById<EditText>(R.id.emailField)
        val _berandaBtn = findViewById<Button>(R.id.berandaBtn)
        _titleForm.text = "$typeForm"

        _berandaBtn.setOnClickListener {
            val intent = Intent(this@tambah, MainActivity::class.java).apply {
                putExtra(MainActivity.arrKontak, arrKontak)
                putExtra(MainActivity.counter, counter)
            }
            startActivity(intent)
        }

        when {
            typeForm == "tambah" -> {
               _btnAksi.text = "tambah"

                _btnAksi.setOnClickListener {

                    if (!_namafield.text.toString().equals("") && !_nomorfield.text.toString().equals("")) {
                        val newKontak = Kontak(
                            _namafield.text.toString(),
                            _nomorfield.text.toString(),
                            _emailfield.text.toString()
                        )
                        if (counter >= 10) {
                            val index = counter % 10
                            Log.d("index counter", index.toString())
                            arrKontak!!.set(index, newKontak)
                            counter++
                        } else {
                            arrKontak!!.add(newKontak)
                            counter++
                        }
                        val intent = Intent(this@tambah, MainActivity::class.java).apply {
                            putExtra(MainActivity.arrKontak, arrKontak)
                            putExtra(MainActivity.counter, counter)
                        }
                        startActivity(intent)
                    }
                }
            }

            typeForm == "edit" -> {

                _namafield.setText(arrKontak!!.get(indexKontak).nama)
                _nomorfield.setText(arrKontak!!.get(indexKontak).telp)
                _emailfield.setText(arrKontak!!.get(indexKontak).email)
                _btnAksi.text = "save"
                _btnAksi.setOnClickListener {
                    arrKontak.set(indexKontak, Kontak(_namafield.text.toString(), _nomorfield.text.toString(), _emailfield.text.toString()))
                    val intent = Intent(this@tambah, MainActivity::class.java).apply {
                        putExtra(MainActivity.arrKontak, arrKontak)
                        putExtra(MainActivity.counter, counter)
                    }
                    startActivity(intent)
                }
            }
        }


    }
}