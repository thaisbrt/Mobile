package com.example.myapplication

class BD {

    companion object{
        var users: ArrayList<UserModel> = ArrayList()

        fun preencheUsers(){
            var user = UserModel()
            user.nome = "Thais"
            user.username = "admin"
            user.senha = "123456"

            users.add(user)
        }
    }
}