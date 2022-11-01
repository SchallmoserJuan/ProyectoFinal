
package PresentationI;

import Logic.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable {
    private TableModel tablita;
    private int[] col = {0,1,2,3,4};
    private Paciente p;
    private List<Paciente> lis;
    private boolean editar; //Variable para editar los registros

    public Model() {
        p = new Paciente();
        lis = new ArrayList<>();
        tablita = new TableModel(lis, col);
        editar = false;
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }    

    public Paciente getP() {
        return p;
    }

    public void setP(Paciente p) {
        this.p = p;
        refresh();
    }

    public List<Paciente> getLis() {
        return lis;
    }

    public void setLis(List<Paciente> lis) {
        this.lis = lis;
        setTablita(lis);
        refresh();
    }

    public TableModel getTablita() {
        return tablita;
    }

    public void setTablita(List<Paciente> l) {
        tablita = new TableModel(l, col);
    }
    
    
    
    
    
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        refresh();
    }
    
    private void refresh(){
        setChanged();
        notifyObservers();
    }

    public Paciente getRow(int n) {
        return tablita.getRowAt(n);
    }
}
