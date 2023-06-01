package com.view.proyectofinal_registro_control_jaas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*
* Autor: Andres Silva y Julian Alba
* Fecha: 22/04/2023
* Comentarios: Desarrollo de proyecto para la asignatura de plataformas.
* */

class ExcelAdapter(private val dataList: ArrayList<String>) : RecyclerView.Adapter<ExcelAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewCellValue: TextView = itemView.findViewById(R.id.textViewCellValue)

        fun bindData(data: String) {
            textViewCellValue.text = data
        }
    }
}

