
package Data;

//Va a recibir doctores y pacientes

import Logic.Funcionario;
import Logic.Paciente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hospital {
    private static Hospital instance = null;
    private Map<String, Paciente> pacientes; //Llamamos a los datos de Logic
    private Map<String, Funcionario> funcionarios; //Llamamos a los datos de Logic
    
    private Hospital(){
        pacientes = new HashMap<String, Paciente>();
        funcionarios = new HashMap<String, Funcionario>();
    }
    
    public static Hospital getInstance(){
        if(instance == null){
            instance = new Hospital();
        }
        return instance;
    }
    
    //Funcion para agregar a los pacientes
    public void addPaciente(Paciente x) throws Exception{
        Paciente p = pacientes.get(x.getCedula());//Verificar que el paciente no exista
        if(p == null){
            pacientes.put(x.getCedula(), x);
        }else {
            throw new Exception("Paciente ya existe");
        }
    }
    
    //Funcion para agregar un funcionario
        public void addFuncionario(Funcionario x) throws Exception{
        Funcionario p = funcionarios.get(x.getCedula());//Verificar que el funcionario no exista
        if(p == null){
            funcionarios.put(x.getCedula(), x);
        }else {
            throw new Exception("Funcionario ya existe");
        }
    }
        
        //Funcion que retorna lista de pacientes
        public List<Paciente> getPacientes(){
            List<Paciente> li = new ArrayList<>();
            for (Map.Entry<String, Paciente> entry : pacientes.entrySet()) {
                li.add(entry.getValue());
                
            }
            return li;
        }
        
            public List<Funcionario> getFuncionarios(){
            List<Funcionario> li = new ArrayList<>();
            for (Map.Entry<String, Funcionario> entry : funcionarios.entrySet()) {
                li.add(entry.getValue());
                
            }
            return li;
        }
            
            public List<Paciente> getPacientesPorcedula(String ced) throws Exception{
                List<Paciente> li = new ArrayList<>();
                Paciente p = pacientes.get(ced);
                if(p != null){
                    li.add(p);
                    return li;
                }else{
                    throw new Exception("Paciente no existe");
                }
            }
            
                public List<Funcionario> getFuncionarioPorcedula(String ced) throws Exception{
                List<Funcionario> li = new ArrayList<>();
                Funcionario p = funcionarios.get(ced);
                if(p != null){
                    li.add(p);
                    return li;
                }else{
                    throw new Exception("Funcionario no existe");
                }
            }

    public void eliminar(Paciente p) {
        pacientes.remove(p.getCedula());
    }

    public void editar(Paciente x) {
        Paciente p = pacientes.get(x.getCedula());
        p.setApellido(x.getApellido());
        p.setNombre(x.getNombre());
        p.setFecha(x.getFecha());
        p.setTipo(x.getTipo());
    }
}
