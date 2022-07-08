package com.muhammadfatchulhuda.tokohindonesia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhammadfatchulhuda.tokohindonesia.databinding.ActivityLoginBinding
private lateinit var binding: ActivityLoginBinding
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialisasi binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        //memanggil layout dengan menggunakkan binding.root
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val dataLogin=ModelLogin(binding.txtUserName.text.toString(),binding.txtPassword.text.toString())
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("data",dataLogin)
            startActivity(intent)
            finish()
        }
    }
}