package com.view.proyectofinal_registro_control_jaas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.FileInputStream

class Fragment_Estudiante_Horario : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment__estudiante__horario, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tableLayout: TableLayout = view.findViewById(R.id.tableLayout)
        // archivo Excel
        val filePath = "C:\\Users\\jose3\\OneDrive\\Documentos\\Ingenieria_Sistemas\\Plataformas\\horario.xlsx"
        try {
            val inputStream = FileInputStream(filePath)
            val workbook = WorkbookFactory.create(inputStream)
            val sheet = workbook.getSheetAt(0) // Obtiene la primera hoja del archivo

            for (rowIndex in 0 until sheet.physicalNumberOfRows) {
                val row = sheet.getRow(rowIndex)

                val tableRow = TableRow(requireContext())

                for (cellIndex in 0 until row.physicalNumberOfCells) {
                    val cell = row.getCell(cellIndex)
                    val cellValue = when (cell.cellType) {
                        CellType.NUMERIC -> cell.numericCellValue.toString()
                        CellType.STRING -> cell.stringCellValue
                        else -> ""
                    }

                    val textView = TextView(requireContext())
                    textView.text = cellValue
                    textView.setPadding(8, 8, 8, 8)
                    tableRow.addView(textView)
                }

                tableLayout.addView(tableRow)
            }

            workbook.close()
            inputStream.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
