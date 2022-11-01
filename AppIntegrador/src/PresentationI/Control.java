
package PresentationI;

import Logic.Paciente;
import java.util.List;
import javax.swing.JOptionPane;

public class Control {
    private View view;
    private Model model;

    public Control(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setControl(this);
        view.setModel(model);
    }

    public void agregar(boolean editar, String nom, String ape, String ced, String fe, String vac) {
        Paciente x = new Paciente(nom, ape, ced, fe, vac);
        try {
            if(!editar){
                Data.Hospital.getInstance().addPaciente(x);
                List<Paciente> li = Data.Hospital.getInstance().getPacientes();
                model.setLis(li);
            }else{
                Data.Hospital.getInstance().editar(x);
                cargarTodos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        model.setP(new Paciente());
        model.setEditar(false);
    }

    public void cancelar() {
        model.setP(new Paciente());
    }

    public void buscarPorCedula(String str) {
        try {
            List<Paciente> li = Data.Hospital.getInstance().getPacientesPorcedula(str);
            model.setLis(li);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        model.setP(new Paciente());
    }

    public void cargarTodos() {
        List<Paciente> li = Data.Hospital.getInstance().getPacientes();
        model.setLis(li);
    }

    public void eliminar(int n) {
        Paciente p = model.getRow(n);
        Data.Hospital.getInstance().eliminar(p);
        cargarTodos();
    }

    public void editar(int n) {
        Paciente p = model.getRow(n);
        model.setEditar(true);
        model.setP(p);
    }
    
    
}
