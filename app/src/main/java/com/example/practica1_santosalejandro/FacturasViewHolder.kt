package com.example.practica1_santosalejandro


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.practica1_santosalejandro.databinding.ItemFacturaBinding

class FacturasViewHolder (view: View): RecyclerView.ViewHolder(view) {

    //val estadoFac = view.findViewById(R.id.estadoFactura) as TextView
    //val importeFac = view.findViewById(R.id.importeFactura) as TextView
    //val fechaFac = view.findViewById(R.id.fechaFactura) as TextView

    //Uso de binding para acceder directamente a la vista
    val binding = ItemFacturaBinding.bind(view)

    //Función que se llama por cada uno de los items del recyclerView
    fun bind(factura: Factura){
        binding.estadoFactura.text = factura.descEstado
        binding.importeFactura.text = factura.importeOrdenacion.toString()
        binding.fechaFactura.text = factura.fecha

        //Hacer click en cada una de las celdas
        /*itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, superhero.superhero, Toast.LENGTH_SHORT).show() })
        avatar.loadUrl(superhero.photo)*/
    }

}