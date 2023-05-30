package com.view.proyectofinal_registro_control_jaas
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.FileInputStream

class Fragment_Estudiante_Horario : Fragment(R.layout.fragment__estudiante__horario) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RUTA DE ARCHIVO
        //val filePath = "C:\\Users\\jose3\\AndroidStudioProjects\\Proyecto_Plataformas_2.0\\app\\src\\main\\res\\drawable\\HORARIO ESTUDIANTE.xlsx"
        val filePath = " assets/HORARIO ESTUDIANTE.xlsx"
        try {
            // Crear un FileInputStream para leer el archivo Excel
            val fis = FileInputStream(filePath)

            // Crear un Workbook a partir del FileInputStream
            val workbook = WorkbookFactory.create(fis)

            // Obtener la hoja de trabajo deseada (por índice o nombre)
            val sheet = workbook.getSheetAt(0) // Obtener la primera hoja de trabajo

            // Crear una lista para almacenar los valores del archivo Excel
            val dataList = ArrayList<String>()

            // Recorrer las filas de la hoja de trabajo
            for (row in sheet) {
                // Recorrer las celdas de cada fila
                for (cell in row) {
                    // Obtener el valor de la celda como String
                    val cellValue = cell.toString()
                    // Agregar el valor a la lista
                    dataList.add(cellValue)
                }
            }

            // Cerrar el FileInputStream y liberar recursos
            fis.close()

            // Obtener el RecyclerView del diseño
            val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

            // Crear un adaptador para el RecyclerView y asignarlo
            val adapter = ExcelAdapter(dataList)
            recyclerView.adapter = adapter

            // Configurar el diseño del RecyclerView
            val layoutManager = LinearLayoutManager(requireContext())
            recyclerView.layoutManager = layoutManager

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
