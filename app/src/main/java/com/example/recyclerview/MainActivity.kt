package com.example.recyclerview

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.recyclerview.adapter.AdapterTeamBola
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.model.Pemain
import org.intellij.lang.annotations.JdkConstants

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain =ArrayList<Pemain>()
        listPemain.add((Pemain("Thibaut Cortois",R.drawable.courtois,"Penjaga Gawang","2.00","Bree Belgia","11 Mei 1992")))
        listPemain.add((Pemain("Karim Benzema(wak haji)",R.drawable.benzema,"Penyerang","1.85","Lyon Prancis","19 Desember 1988")))
        listPemain.add((Pemain("Marcelo Viera Da Silva",R.drawable.marcello,"Belakang","1.74","Rio De Janeiro Brazil","12 Mei 1988")))
        listPemain.add((Pemain("Sergio Ramos Garcia",R.drawable.ramos,"Belakang","1.84","Camas Sevilla","30 Maret 1986")))
        listPemain.add((Pemain("Zinedine Yazid Zidane",R.drawable.zidan,"Pelatih","1.85","Marseille Prancis","23 Juni 1972")))

        binding.list.adapter =AdapterTeamBola(this,listPemain,object :AdapterTeamBola.OnClickListener{
            override fun detailData(item: Pemain?) {
                    Dialog(this@MainActivity).apply {
                        requestWindowFeature(Window.FEATURE_NO_TITLE)
                        setCancelable(true)
                        setContentView(R.layout.detai_data_pemain)

                        val image =this.findViewById<ImageView>(R.id.image_pemain)
                        val nama =this.findViewById<TextView>(R.id.txtnamapemain)
                        val posisi =this.findViewById<TextView>(R.id.txtposisi)
                        val tinggi =this.findViewById<TextView>(R.id.txttinggibadan)
                        val tempatlahir =this.findViewById<TextView>(R.id.txttempatlahir)
                        val tgllahir =this.findViewById<TextView>(R.id.txttanggallahir)
                        val btn =this.findViewById<Button>(R.id.btnclose)

                        image.setImageResource(item?.foto?:0)
                        nama.text="${item?.nama}"
                        posisi.text ="${item?.posisi}"
                        tinggi.text ="${item?.tinggi}"
                        tempatlahir.text ="${item?.tempatlahir}"
                        tgllahir.text ="${item?.tgllahir}"

                        btn.setOnClickListener {
                            this.dismiss()
                        }

                    }.show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private  fun setMode(selectedMode: Int){
        when (selectedMode){
            R.id.myprofile->{
                val intent = Intent ( this,Profile::class.java)
                startActivity(intent)
            }
        }
    }
}