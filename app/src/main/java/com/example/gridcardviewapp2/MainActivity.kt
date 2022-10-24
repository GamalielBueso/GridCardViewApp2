package com.example.gridcardviewapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView

class MainActivity : AppCompatActivity() {
    private var gvTabla:GridView?= null

    var nombre = arrayListOf<String>("Mario", "marta", "Paola", "Victor")
    var departamento = arrayListOf<String>("Sonsonate", "Cabanias", "San Salvador", "La Paz")

    var imagenes= arrayOf(
        R.drawable.perfil,
        R.drawable.perfil,
        R.drawable.perfil,
        R.drawable.perfil
    )

    var imagenesLista = arrayOf(
        ImgItems(imagenes.get(0),nombre.get(0),departamento.get(0)),
        ImgItems(imagenes.get(1),nombre.get(1),departamento.get(1)),
        ImgItems(imagenes.get(2),nombre.get(2),departamento.get(2)),
        ImgItems(imagenes.get(3),nombre.get(3),departamento.get(3))
    )

    var myImagenLista = arrayListOf<ImgItems>()

    var modificadorAdaptador:AdaptadorModificado? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(imagen in imagenesLista){
            myImagenLista.add(imagen)
        }
        gvTabla = findViewById(R.id.gv_Tabla)

        modificadorAdaptador = AdaptadorModificado(myImagenLista, this)
        gvTabla?.adapter = modificadorAdaptador

        gvTabla?.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var ventana:Intent = Intent(applicationContext,Detalle::class.java)
                ventana.putExtra("imagen",imagenes.get(p2))
                ventana.putExtra("nombre",nombre.get(p2))
                ventana.putExtra("Departamento",departamento.get(p2))
                startActivity(ventana)
            }

        }
    }

    fun btnSiguiente(vista:View){
        var ventana:Intent = Intent(applicationContext,WebViewApp::class.java)
        startActivity(ventana)
    }
}