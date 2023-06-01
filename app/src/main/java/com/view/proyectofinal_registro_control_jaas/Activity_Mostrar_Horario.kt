package com.view.proyectofinal_registro_control_jaas

import android.os.Bundle
import android.util.Log
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.FileNotFoundException
import java.io.IOException

/*
* Autor: Andres Silva y Julian Alba
* Fecha: 15/05/2023
* Comentarios: Desarrollo de proyecto para la asignatura de plataformas.
* */

class Activity_Mostrar_Horario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_horario)

        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)

        try {
            val inputStream = assets.open("horario_estudiante.xlsx")
            val workbook = WorkbookFactory.create(inputStream)
            val sheet = workbook.getSheetAt(0)

            for (rowIndex in 0 until sheet.physicalNumberOfRows) {
                val row = sheet.getRow(rowIndex)
                val tableRow = TableRow(tableLayout.context)

                for (cellIndex in 0 until row.physicalNumberOfCells) {
                    val cell = row.getCell(cellIndex)

                    val textView = TextView(tableLayout.context)
                    textView.text = cell?.toString()
                    tableRow.addView(textView)
                }
                tableLayout.addView(tableRow)
            }

            workbook.close()
            inputStream.close()

        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            Log.e("Excel", "El archivo no se encontró: ${e.message}")

        } catch (e: IOException) {
            e.printStackTrace()
            Log.e("Excel", "Error de entrada/salida: ${e.message}")

        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("Excel", "Error desconocido: ${e.message}")
        }
    }
}