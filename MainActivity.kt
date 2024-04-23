package uts.c14210265.app

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        val arrKontak = "ARRKONTAK"
        val counter = "COUNTER"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val _btnTambah = findViewById<Button>(R.id.btnTambah)
        val _uji = findViewById<Button>(R.id.uji)




        var btnsKontak: ArrayList<ImageView> = ArrayList()
        btnsKontak.add(findViewById(R.id.image1))
        btnsKontak.add(findViewById(R.id.image2))
        btnsKontak.add(findViewById(R.id.image3))
        btnsKontak.add(findViewById(R.id.image4))
        btnsKontak.add(findViewById(R.id.image5))
        btnsKontak.add(findViewById(R.id.image6))
        btnsKontak.add(findViewById(R.id.image7))
        btnsKontak.add(findViewById(R.id.image8))
        btnsKontak.add(findViewById(R.id.image9))
        btnsKontak.add(findViewById(R.id.image10))

        var arrName = ArrayList<TextView>()
        arrName.add(findViewById(R.id.nama1))
        arrName.add(findViewById(R.id.nama2))
        arrName.add(findViewById(R.id.nama3))
        arrName.add(findViewById(R.id.nama4))
        arrName.add(findViewById(R.id.nama5))
        arrName.add(findViewById(R.id.nama6))
        arrName.add(findViewById(R.id.nama7))
        arrName.add(findViewById(R.id.nama8))
        arrName.add(findViewById(R.id.nama9))
        arrName.add(findViewById(R.id.nama10))

        var arrTelp = ArrayList<TextView>()
        arrTelp.add(findViewById(R.id.nomor1))
        arrTelp.add(findViewById(R.id.nomor2))
        arrTelp.add(findViewById(R.id.nomor3))
        arrTelp.add(findViewById(R.id.nomor4))
        arrTelp.add(findViewById(R.id.nomor5))
        arrTelp.add(findViewById(R.id.nomor6))
        arrTelp.add(findViewById(R.id.nomor7))
        arrTelp.add(findViewById(R.id.nomor8))
        arrTelp.add(findViewById(R.id.nomor9))
        arrTelp.add(findViewById(R.id.nomor10))

        var arrEmail = ArrayList<TextView>()
        arrEmail.add(findViewById(R.id.email1))
        arrEmail.add(findViewById(R.id.email2))
        arrEmail.add(findViewById(R.id.email3))
        arrEmail.add(findViewById(R.id.email4))
        arrEmail.add(findViewById(R.id.email5))
        arrEmail.add(findViewById(R.id.email6))
        arrEmail.add(findViewById(R.id.email7))
        arrEmail.add(findViewById(R.id.email8))
        arrEmail.add(findViewById(R.id.email9))
        arrEmail.add(findViewById(R.id.email10))




        var arrKontak: ArrayList<Kontak>? = intent.getParcelableArrayListExtra(arrKontak, Kontak::class.java)


        when {
            arrKontak == null -> {
                var arrAwal = ArrayList<Kontak>()
                arrAwal.add(Kontak("Alloysius Steven H", "089686757322", "c14210265@john.petra.ac.id"))
                arrAwal.add(Kontak("Bambang", "089686724525", "c14210266@john.petra.ac.id"))
                arrAwal.add(Kontak("Jacqueline", "089681234175", "c14210267@john.petra.ac.id"))
                arrAwal.add(Kontak("Susi", "089826023847", "c14210268@john.petra.ac.id"))
                arrAwal.add(Kontak("budi", "089686020107", "c14210269@john.petra.ac.id"))
                arrAwal.add(Kontak("Karen", "089982345919", "c14210270@john.petra.ac.id"))
                arrAwal.add(Kontak("Gilbert", "089686757121", "c14210271@john.petra.ac.id"))
                arrAwal.add(Kontak("jessica", "089686098998", "c14210272@john.petra.ac.id"))
                arrAwal.add(Kontak("enzo", "089686755779", "c14210273@john.petra.ac.id"))
                arrAwal.add(Kontak("erick", "089686751345", "c14210274@john.petra.ac.id"))
                arrKontak = arrAwal
            }
        }
        var counter = intent.getIntExtra(counter, arrKontak!!.size)

        for (i in 0 until 9) {
            arrName.get(i).text = arrKontak!!.get(i).nama
            arrTelp.get(i).text = arrKontak!!.get(i).telp
            arrEmail.get(i).text = arrKontak!!.get(i).email

            arrName.get(i).setOnClickListener {
                val intent = Intent(this@MainActivity, Detail::class.java).apply {
                    putExtra(tambah.arrKontak, arrKontak)
                    putExtra(tambah.counter, counter)
                    putExtra(tambah.indexKontak, i)
                }
                startActivity(intent)
            }

            arrTelp.get(i).setOnClickListener {
                val _callIntent = Intent(Intent.ACTION_DIAL)
                _callIntent.data  = Uri.parse("tel:" + arrKontak.get(i).telp)
                startActivity(_callIntent)
            }

            arrEmail.get(i).setOnClickListener {
                Log.d("email", "kepencet")
                val nama1 = arrKontak.get(i).nama
                sendEmail(arrKontak.get(i).email!!,"HI $nama1", "")
            }
        }


        _btnTambah.setOnClickListener {
            val intent = Intent(this@MainActivity, tambah::class.java).apply {
                putExtra(tambah.type, "tambah")
                putExtra(tambah.arrKontak, arrKontak)
                putExtra(tambah.counter, counter)
            }
            startActivity(intent)
        }

//        _uji.setOnClickListener {
//            val intent = Intent(this@MainActivity, UjiTampilan::class.java).apply {
//                putExtra(UjiTampilan.arrKontak, arrKontak)
//                putExtra(UjiTampilan.counter, counter)
//            }
//            startActivity(intent)
//        }

//        for (i in 0 until btnsKontak.size) {
//            btnsKontak.get(i).setOnClickListener {
//                val intent = Intent(this@MainActivity, tambah::class.java).apply {
//                    putExtra(tambah.type, "edit")
//                    putExtra(tambah.indexKontak, i)
//                    putExtra(tambah.arrKontak, arrKontak)
//                    putExtra(tambah.counter, counter)
//                }
//                startActivity(intent)
//            }
//        }

    }

    private fun sendEmail(recipient: String, subject: String, message: String) {
        //call email share method
        val gmailPackage = "com.google.android.gm"
        // return true if gmail is installed
        val isGmailInstalled = isAppInstalled(gmailPackage)

        /*ACTION_SEND action to launch an email client installed on your Android device.*/
        val intent = Intent(Intent.ACTION_SEND)
        // put recipient email in intent
        /* recipient is put as array because you may wanna send email to multiple emails
           so enter comma(,) separated emails, it will be stored in array*/
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        //put subject of email
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        //put message of email in intent
        intent.putExtra(Intent.EXTRA_TEXT, message)
        if (isGmailInstalled) {
            intent.type = "text/html"
            intent.setPackage(gmailPackage)
            startActivity(intent)
        } else {
            // allow user to choose a different app to send email with
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "choose an email client"))
        }
    }

    private fun isAppInstalled(packageName: String): Boolean {
        return try {
            packageManager.getApplicationInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }
}