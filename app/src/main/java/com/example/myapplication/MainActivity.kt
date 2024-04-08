package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Busca o objeto da tela e atribui na variável kotlin
        val btEntrar: Button = findViewById<Button>(R.id.btEntrar)

        // Seta o evento de listener do click do objeto
        btEntrar.setOnClickListener {
            // Busca os objetos da tela e atribui em suas respectivas variáveis
            val etUsuario = findViewById<EditText>(R.id.etUsuario)
            val etSenha = findViewById<EditText>(R.id.etSenha)

            // Valida se o campo usuário e senha estão preenchidos
            if (etUsuario.text.toString() != "" && etSenha.text.toString() != "") {

                var user = BD.users.firstOrNull() {it -> it.username == etUsuario.text.toString()}

                if(user != null){

                    val sysUser = user.username
                    val sysSenha = user.senha

                    if (etSenha.text.toString() == sysSenha && etUsuario.text.toString() == sysUser) {

                        Toast.makeText(this, "Seja bem vindo " + etUsuario.text.toString(), Toast.LENGTH_LONG).show()
                        val newIntent = Intent(this, CalculadoraActivity::class.java);
                        startActivity(newIntent);

                    } else {
                        //Exibe a mensagem de usuário ou senha inválidos
                        Toast.makeText(this, "Usuario ou senha inválidos!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    //Exibe a mensagem de usuário ou senha inválidos
                    Toast.makeText(this, "Usuario ou senha inválidos!", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Digite o usuário e senha", Toast.LENGTH_SHORT).show()
            }

        }

        // Busca o objeto da tela e atribui na variável kotlin
        val btCadastrar: Button = findViewById<Button>(R.id.btCadastrar)

        // Seta o evento de listener do click do objeto
        btCadastrar.setOnClickListener {
            val newItent = Intent(this, CadastroActivity::class.java)
            startActivity(newItent)
        }


    }
}