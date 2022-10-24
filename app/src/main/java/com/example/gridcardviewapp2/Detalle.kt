package com.example.gridcardviewapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Detalle : AppCompatActivity() {
    lateinit var tvNombre:TextView
    lateinit var tvDepartamento:TextView
    lateinit var ivImgFoto:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        tvNombre = findViewById(R.id.tv_Nombre2)
        tvDepartamento = findViewById(R.id.tv_Departamento2)
        ivImgFoto = findViewById(R.id.iv_ImgFoto)

        var bundle:Bundle = getIntent().getExtras()!!

        tvNombre.setText(bundle.getString("nombre"))
        tvDepartamento.setText(bundle.getString("Departamento"))
        ivImgFoto.setImageResource(bundle.getInt("imagen"))

    }
}