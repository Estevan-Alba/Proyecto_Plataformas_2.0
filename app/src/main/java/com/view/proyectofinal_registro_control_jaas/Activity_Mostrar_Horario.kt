package com.view.proyectofinal_registro_control_jaas

import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.File
import java.io.FileInputStream

class Activity_Mostrar_Horario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_horario)

        val filePath = " app/src/main/assets/HORARIO ESTUDIANTE.xlsx"
        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)
        readExcelFile(filePath, tableLayout)
    }

    fun readExcelFile(filePath: String, tableLayout: TableLayout) {
        try {
            val workbook = WorkbookFactory.create(FileInputStream(File(filePath)))
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
    }
}