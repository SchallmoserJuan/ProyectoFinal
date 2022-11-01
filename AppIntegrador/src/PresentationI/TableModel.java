package PresentationI;

import Logic.Paciente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{
        private List<Paciente> row;
        private int[] col;
        private String[] colsName = {"Nombre","Apellido","Cedula","Fecha de entrada","Vacuna"};

    public TableModel(List<Paciente> row, int[] col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public int getRowCount() {
        return row.size();
    }

    @Override
    public int getColumnCount() {
        return col.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Paciente p = row.get(i);
        switch(i1){
            case 0:return p.getNombre();
            case 1:return p.getApellido();
            case 2:return p.getCedula();
            case 3:return p.getFecha();
            case 4:return p.getTipo();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int i) {
        return colsName[i];
    }

    public Paciente getRowAt(int n) {
        return row.get(n);
    }
        
        
        
}
