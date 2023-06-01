package com.view.proyectofinal_registro_control_jaas
import android.os.Bundle
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.apache.poi.EncryptedDocumentException
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream

class Fragment_Estudiante_Horario : Fragment(R.layout.fragment__estudiante__horario) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fileInputStream = FileInputStream("C:\\Users\\julia\\Desktop\\IX\\Ejercicio cargue excel Kotlin.xlsx")
        val tableLayout = view.findViewById<TableLayout>(R.id.tableLayout)

        try {
            println("Ya se ve el horario")
            val inputStream: InputStream = requireContext().applicationContext.assets.open(fileInputStream)
            try {

                val workbook = WorkbookFactory.create(InputStream)
                val sheet = workbook.getSheetAt(0) // Obtén la primera hoja del archivo

                // Itera a través de las filas y columnas de la hoja
                for (rowIndex in 0 until sheet.physicalNumberOfRows) {
                    val row = sheet.getRow(rowIndex)

                    val tableRow = TableRow(tableLayout.context)

                    // Itera a través de las celdas de la fila actual
                    for (cellIndex in 0 until row.physicalNumberOfCells) {
                        val cell = row.getCell(cellIndex)

                        val textView = TextView(tableLayout.context)
                        textView.text = cell?.toString()
                        tableRow.addView(textView)
                    }

                    tableLayout.addView(tableRow)
                }

                workbook.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        } catch (e: IOException) {
            println("No se pudo leer el documento")
            e.printStackTrace()
        } catch (e: EncryptedDocumentException) {
            println("El archivo Excel está encriptado")
            e.printStackTrace()
        }
    }
}