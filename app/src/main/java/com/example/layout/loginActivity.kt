package com.example.layout

import android.content.Intent
import android.os.Bundle
import android.text.method.Touch
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.layout.databinding.ActivityLoginBinding
import android.util.Log;
import android.widget.Toast

class loginActivity : AppCompatActivity() , View.OnClickListener{

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        //criando a intenção de navegando
        val intent: Intent = Intent(this, HomeActivity::class.java)

        if(v?.id == R.id.button_login){
            var email = binding.editTextEmail.text.toString()
            var password = binding.editTextPassword.text.toString()
            Log.d("LoginActivity", "Email: $email senha: $password")

            //criando o bundle para enviar dados entre activities
            val bundle : Bundle = Bundle()
            bundle.putString("Email", email)


            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,R.string.campos_vazios, Toast.LENGTH_SHORT).show()
            }else{
                //mandando a informação com a intencao
                intent.putExtras(bundle)
                startActivity(intent)
            }

        }
    }
}