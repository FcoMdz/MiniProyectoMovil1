package com.example.viewlists

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import java.io.Serializable
import android.content.SharedPreferences

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var TiendaAux = Tienda("Zegucom", "10,000.00", "https://www.zegucom.com.mx/producto/procesadores/procesadores-intel-socket-1700-13a-gen/procesador-intel-core-i9-13900k-lga-1700-cache-36-mb-nucleos-24-hilos/Qlg4MDcxNTEzOTAwSw==")
        var TiendaAux2 = Tienda("Cyberpuerta", "11,419.00", "https://www.cyberpuerta.mx/Computo-Hardware/Componentes/Procesadores/Procesadores-para-PC/Procesador-Intel-Core-i9-13900K-S-1700-24-Core-36MB-36MB-Smart-Cache-13va-Generacion-Raptor-Lake.html?srsltid=AfmBOoq4bViojZJU6yOJaRTbWV7ysSut_MUyTWJh2R9ynrXMnA0lgDH_uW4")
        var TiendaAux3 = Tienda("Amazon", "12,166.00", "https://www.amazon.com.mx/Intel-BX8071513900K/dp/B0BCF54SR1/ref=sr_1_1?keywords=intel%2Bi9%2B13900k&qid=1694885585&sr=8-1&ufe=app_do%3Aamzn1.fos.a9e70178-7411-4f75-8d83-e6796a165895&th=1")
        var producto = Producto("Procesador Intel i9 13900k",TiendaAux,TiendaAux2,TiendaAux3,"El Procesador Intel Core i9-13900K es ideal para usuarios que requieren potencia informática extrema tanto en gaming como creación contenido profesional",R.drawable.i913900k)

        TiendaAux = Tienda("Zegucom", "4,000.00","https://www.zegucom.com.mx/producto/procesadores/procesadores-intel-socket-1700-12a-gen/procesador-intel-core-i5-12600k-12va-gen-socket-lga1700-4-90ghz-6-4-n/Qlg4MDcxNTEyNjAwSw==")
        TiendaAux2 = Tienda("Cyberpuerta", "6,219.00","https://www.cyberpuerta.mx/Computo-Hardware/Componentes/Procesadores/Procesadores-para-PC/Procesador-Intel-Core-i5-13600K-S-1700-3-50GHz-14-Core-24MB-Smart-Cache-13va-Generacion-Raptor-Lake.html?srsltid=AfmBOopTRIIHiYKXckBnyDfAnZkUUqzsYCZAqDZGzRUn1u6cI9dSbpmDNDM")
        TiendaAux3 = Tienda("Amazon", "6,551.00","https://www.amazon.com.mx/Intel-i5-13600K-LGA1700-Desktop-Processor/dp/B0BG63WLG3")
        val producto2 = Producto("Procesador intel i5 13600k",TiendaAux,TiendaAux2,TiendaAux3,"El procesador Intel Core i5-13600K 3.50GHz 14-Core BX8071513600K es un componente de alta gama para equipos de escritorio y gaming.",R.drawable.i513600k)

        TiendaAux = Tienda("Zegucom", "4,329.00","https://www.zegucom.com.mx/producto/procesadores/procesadores-amd-socket-am5/procesador-amd-ryzen-5-7600x-socket-am5-4-7ghz-5-3ghz-38mb-cache-graf/MTAwLTEwMDAwMDU5M1dPRg==")
        TiendaAux2 = Tienda("Cyberpuerta", "4,289.00","https://www.cyberpuerta.mx/Computo-Hardware/Componentes/Procesadores/Procesadores-para-PC/Procesador-AMD-Ryzen-5-7600X-S-AM5-4-70GHz-Six-Core-32MB-L3-Cache-no-Incluye-Disipador.html?srsltid=AfmBOooaNWk2E3w2Ku_5JAQAQN5j3bQLafFuiyYQfcm3F5hYt5QRn9Vi2PQ")
        TiendaAux3 = Tienda("Amazon", "8,313.00","https://www.amazon.com.mx/Components-Procesador-100-000000593-Enfriador-Technology/dp/B0C28386RH")
        val producto3 = Producto("Procesador AMD Ryzen 5 7600x",TiendaAux,TiendaAux2,TiendaAux3,"El procesador AMD Ryzen 5 7600X S-AM5 es un componente de alta gama diseñado para ofrecer un rendimiento excepcional en aplicaciones exigentes",R.drawable.r7600x)

        TiendaAux = Tienda("Zegucom", "8,371.00","https://www.zegucom.com.mx/producto/procesadores/procesadores-amd-socket-am5/procesador-amd-ryzen-7-7800x3d-amd-ryzen-7-skt-am5-5nm-4-2-ghz-8-core/MTAwLTEwMDAwMDkxMFdPRg==")
        TiendaAux2 = Tienda("Cyberpuerta", "4,289.00","https://www.cyberpuerta.mx/Computo-Hardware/Componentes/Procesadores/Procesadores-para-PC/Procesador-AMD-Ryzen-7-7800X3D-S-AM5-4-20GHz-8-Core-96MB-L3-Cache-No-Incluye-Disipador.html?srsltid=AfmBOopegFRf7hYX1d_3HpqgABLZuX-5TA1qO9gUOJLwE-eBa01uO-ZeVZw")
        TiendaAux3 = Tienda("Amazon", "7,532.00","https://www.amazon.com.mx/AMD-7800X3D-Radeon-Graphics-100-100000910WOF/dp/B0BTZB7F88")
        val producto4 = Producto("Procesador AMD Ryzen 7 7800X3D",TiendaAux,TiendaAux2,TiendaAux3,"El procesador AMD Ryzen 7 7800X3D es un componente de la familia de procesadores AMD Ryzen™ 7, diseñado para su uso en equipos de escritorio.",R.drawable.r7800x3d)

        TiendaAux = Tienda("Zegucom", "10,000.00","https://www.zegucom.com.mx/producto/procesadores/procesadores-amd-socket-am5/procesador-amd-ryzen-9-7950x-socket-am5-4-5-ghz-5-7-ghz-max-boost-80m/MTAwLTEwMDAwMDUxNFdPRg==")
        TiendaAux2 = Tienda("Cyberpuerta", "10,279.00","https://www.cyberpuerta.mx/Computo-Hardware/Componentes/Procesadores/Procesadores-para-PC/Procesador-AMD-Ryzen-9-7950X-Radeon-Graphics-S-AM5-4-50GHz-16-Core-64MB-Cache-No-Incluye-Disipador.html?srsltid=AfmBOoo1xPSx0UW4UHqmfM5t-6d1qDLW_llKTC-uEZSOC1GwRpFL6Xppc9Q")
        TiendaAux3 = Tienda("Amazon", "11,664..00","https://www.amazon.com.mx/AMD-RyzenTM-9-7950X-Procesador/dp/B0BBHD5D8Y")
        val producto5 = Producto("Procesador AMD Ryzen 9 7950X",TiendaAux,TiendaAux2,TiendaAux3,"El procesador AMD Ryzen 9 7950X Radeon Graphics es un componente de alta gama diseñado para ofrecer un rendimiento excepcional en aplicaciones exigentes",R.drawable.r7950x)

        val listaProductos = listOf(producto,producto2,producto3, producto4, producto5)

        val adapter = ProductosAdapter(this, listaProductos)
        val  lista: ListView = findViewById(R.id.lista)
        val config: Button = findViewById(R.id.configuracion)

        config.setOnClickListener{ parent ->
            val intent = Intent(this, ConfiguracionActivity::class.java)
            startActivity(intent)
        }

        lista.adapter = adapter
        lista.setOnItemClickListener{ parent, view, position, id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProductos[position])
            startActivity(intent)
        }
    }

}

class ConfiguracionActivity : AppCompatActivity(){
    private val PREFS_NAME = "rolUsuario"
    private lateinit var sharedPreferences: SharedPreferences
    private fun guardarSeleccion(seleccion: String) {
        val editor = sharedPreferences.edit()
        editor.putString("rol", seleccion)
        editor.apply()
    }
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val seleccionGuardada = sharedPreferences.getString("rol", null)

        val opc = findViewById<RadioGroup>(R.id.opcRol)

        if (seleccionGuardada != null) {
            when (seleccionGuardada) {
                "Estudiante" -> opc.check(R.id.opcEstudiante)
                "Funcionario" -> opc.check(R.id.opcFuncionario)
                "Obrero" -> opc.check(R.id.opcObrero)
            }
        }


        opc.setOnCheckedChangeListener{
            _, checkedId ->
            when(checkedId){
                R.id.opcEstudiante -> {
                    guardarSeleccion("Estudiante")
                }
                R.id.opcFuncionario -> {
                    guardarSeleccion("Funcionario")
                }
                R.id.opcObrero -> {
                    guardarSeleccion("Obrero")
                }
            }
        }

        val regresar = findViewById<Button>(R.id.regresar)
        regresar.setOnClickListener{
            finish()
        }

    }
}

class Producto (val nombre:String, val Tienda1:Tienda,val Tienda2:Tienda,val Tienda3:Tienda,val descripcion:String, val imagen:Int): Serializable

class ProductosAdapter (private val mContext: Context, private val listaProductos: List<Producto>) :
    ArrayAdapter<Producto>(mContext, 0, listaProductos) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_producto, parent, false)
        val nombreTextView = layout.findViewById<TextView>(R.id.nombre)
        val precioTextView = layout.findViewById<TextView>(R.id.precio)
        val imageView = layout.findViewById<ImageView>(R.id.imageView)
        val producto = listaProductos[position]
        nombreTextView.text = producto.nombre
        precioTextView.text = "clic para conocer los precios disponibles"
        imageView.setImageResource(producto.imagen)

        return layout
    }

}

class ProductoActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        val regresar = findViewById<Button>(R.id.regresar)
        regresar.setOnClickListener{
            finish()
        }

        val producto = intent.getSerializableExtra("producto") as Producto
        val nombre_producto: TextView = findViewById(R.id.nombre_producto)
        val detalles_producto: TextView = findViewById(R.id.detalles_producto)
        val imagen: ImageView = findViewById(R.id.imagen)
        val listaTienda = listOf(producto.Tienda1,producto.Tienda2,producto.Tienda3)
        val TAdapter = TiendaAdapter(this, listaTienda)
        val Tlista : ListView = findViewById(R.id.Tlista)
        Tlista.adapter = TAdapter
        Tlista.setOnItemClickListener{ parent, view, position, id ->
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(listaTienda[position].url))
            if (listaTienda[position].url != "") {
                startActivity(intent)
            }
            else{
                // La URL no se pudo abrir, muestra un Toast de error
                Toast.makeText(this, "Error al abrir la página web", Toast.LENGTH_SHORT).show()
            }
        }
        nombre_producto.text = producto.nombre
        detalles_producto.text = producto.descripcion
        imagen.setImageResource(producto.imagen)
    }
}

class Tienda (val Tnombre:String, val Tprecio:String, val url: String): Serializable

class TiendaAdapter (private val mContext: Context, private val listaTienda: List<Tienda>) :
    ArrayAdapter <Tienda>(mContext, 0 , listaTienda) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val layout = LayoutInflater.from(context).inflate(R.layout.item_tienda, parent, false)

            val Tnombre = layout.findViewById<TextView>(R.id.Tnombre)
            val Tprecio = layout.findViewById<TextView>(R.id.Tprecio)
            val Tienda = listaTienda[position]
            Tnombre.text = Tienda.Tnombre
            Tprecio.text = Tienda.Tprecio
            return layout
        }
    }