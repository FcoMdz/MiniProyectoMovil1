package com.example.viewlists

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var TiendaAux = Tienda("Zegucom", "10,000.00")
        var TiendaAux2 = Tienda("Cyberpuerta", "11,000.00")
        var TiendaAux3 = Tienda("Amazon", "10,500.00")
        var producto = Producto("Procesador Intel i9 13900k",TiendaAux,TiendaAux2,TiendaAux3,"El REY de los mouse calidad-precio en el mercado",R.drawable.i913900k)
        
        TiendaAux = Tienda("Zegucom", "4,000.00")
        TiendaAux2 = Tienda("Cyberpuerta", "5,000.00")
        TiendaAux3 = Tienda("Amazon", "5,700.00")
        val producto2 = Producto("Procesador intel i5 13600k",TiendaAux,TiendaAux2,TiendaAux3,"Gran mouse para el gaming casual",R.drawable.i513600k)
        
        TiendaAux = Tienda("Zegucom", "4,329.00")
        TiendaAux2 = Tienda("Cyberpuerta", "4,309.00")
        TiendaAux3 = Tienda("Amazon", "8,500.00")
        val producto3 = Producto("procesador AMD Ryzen 5 7600x",TiendaAux,TiendaAux2,TiendaAux3,"lo mismo que el g403 pero con PILAS",R.drawable.r7600x)
        
        TiendaAux = Tienda("Zegucom", "10,000.00")
        TiendaAux2 = Tienda("Cyberpuerta", "6,739.00")
        TiendaAux3 = Tienda("Amazon", "10,500.00")
        val producto4 = Producto("procesador AMD Ryzen 7 7800X3D",TiendaAux,TiendaAux2,TiendaAux3,"Menos de 100g para mover ese mouse como un diablo",R.drawable.r7800x3d)
        
        TiendaAux = Tienda("Zegucom", "10,000.00")
        TiendaAux2 = Tienda("Cyberpuerta", "6,739.00")
        TiendaAux3 = Tienda("Amazon", "10,500.00")
        val producto5 = Producto("procesador AMD Ryzen 9 7950X",TiendaAux,TiendaAux2,TiendaAux3,"Menos de 100g para mover ese mouse como un diablo",R.drawable.r7950x)

        val listaProductos = listOf(producto,producto2,producto3, producto4, producto5)

        val adapter = ProductosAdapter(this, listaProductos)
        val  lista: ListView = findViewById(R.id.lista)

        lista.adapter = adapter
        lista.setOnItemClickListener{ parent, view, position, id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProductos[position])
            startActivity(intent)
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

        val producto = intent.getSerializableExtra("producto") as Producto
        val nombre_producto: TextView = findViewById(R.id.nombre_producto)
        val precio_producto: TextView = findViewById(R.id.precio_producto)
        val detalles_producto: TextView = findViewById(R.id.detalles_producto)
        val imagen: ImageView = findViewById(R.id.imagen)
        val listaTienda = listOf(producto.Tienda1,producto.Tienda2,producto.Tienda3)
        val TAdapter = TiendaAdapter(this, listaTienda)
        nombre_producto.text = producto.nombre
        detalles_producto.text = producto.descripcion
        imagen.setImageResource(producto.imagen)
    }
}

class Tienda (val Tnombre:String, val Tprecio:String): Serializable

class TiendaAdapter (private val mContext: Context, private val listaTienda: List<Tienda>) :
    ArrayAdapter <Tienda>(mContext, 0 , listaTienda) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val layout = LayoutInflater.from(context).inflate(R.layout.item_tienda, parent, false)    
            val Tnombre = layout.findViewById<TextView>(R.id.Tnombre)
            val Tprecio = layout.findViewById<TextView>(R.id.Tprecio)
            return layout
        }
    }