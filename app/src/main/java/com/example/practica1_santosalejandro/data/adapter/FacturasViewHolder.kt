package com.example.practica1_santosalejandro.data.adapter



import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import androidx.core.content.ContextCompat.createDeviceProtectedStorageContext
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.example.practica1_santosalejandro.R
import com.example.practica1_santosalejandro.data.model.Factura
import com.example.practica1_santosalejandro.databinding.ItemFacturaBinding
import com.example.practica1_santosalejandro.ui.view.MainActivity
import kotlin.coroutines.coroutineContext


class FacturasViewHolder (view: View): RecyclerView.ViewHolder(view) {

    private var popupactivo : Boolean = false




    //Uso de binding para acceder directamente a la vista
    val binding = ItemFacturaBinding.bind(view)

    //Función que se llama por cada uno de los items del recyclerView
    fun bind(factura: Factura){

        binding.estadoFactura.text = factura.descEstado
        binding.importeFactura.text = factura.importeOrdenacion.toString()
        binding.fechaFactura.text = factura.fecha

        //Hacer click en cada una de las celdas
        itemView.setOnClickListener(View.OnClickListener {
            if (!popupactivo) {
                popupactivo = true
                val popup = PopupWindow(itemView.context)
                val popupView = LayoutInflater.from(itemView.context).inflate(R.layout.popup_factura, null)
                popup.contentView = popupView
                popup.width = ViewGroup.LayoutParams.WRAP_CONTENT
                popup.height = ViewGroup.LayoutParams.WRAP_CONTENT
                popup.showAtLocation(popupView, 1, 0, 0)

                val closeButton = popupView.findViewById<Button>(R.id.buttonsalir)
                closeButton.setOnClickListener {
                    popup.dismiss()
                    popupactivo = false
                }

                popup.showAsDropDown(itemView)
            }
        })

    }

}