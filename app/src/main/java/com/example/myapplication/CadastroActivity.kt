package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val btVoltar: ImageView = findViewById<ImageView>(R.id.btVoltar)
        val btCadastrar: Button = findViewById<Button>(R.id.btCadCadastrar)

        btVoltar.setOnClickListener{
            finish()
        }

        btCadastrar.setOnClickListener{

            val etNome = findViewById<EditText>(R.id.etCadNome)
            val etUsuario = findViewById<EditText>(R.id.etCadUsuario)
            val etSenha = findViewById<EditText>(R.id.etCadSenha)
            val etConfSenha = findViewById<EditText>(R.id.etCadConfirmeSenha)

            if (etUsuario.text.toString() != "" && etSenha.text.toString() != "" && etNome.text.toString() != "" && etConfSenha.text.toString() != "") {

                if (etSenha.text.toString() == etConfSenha.text.toString()){
                    var user = UserModel()
                    user.nome = etNome.text.toString()
                    user.username = etUsuario.text.toString()
                    user.senha = etSenha.text.toString()

                    BD.users.add(user)

                    Toast.makeText(this, "Usuario cadastrado", Toast.LENGTH_SHORT).show()
                    finish()

                }else{
                    Toast.makeText(this, "As senhas não conferem", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(this, "Digite em todos os campos", Toast.LENGTH_SHORT).show()
            }

        }
    }
}