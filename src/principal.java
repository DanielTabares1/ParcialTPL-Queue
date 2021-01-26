import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class principal {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"El consultorio está abierto.");

        Queue<Paciente> cola = new LinkedList<>(); // se crea la cola que usaremos en el aplicativo

        boolean cerrar = false;              //una variable para controlar la salida
        byte opcion;                         //una variable para controlar las opciones que ingresa el usuario
        String mensaje = "digite:\n" +      //mensaje con las opciones
                "1. si llegó un paciente nuevo\n" +
                "2. para hacer pasar al siguiente\n" +
                "3. para ver los datos del siguiente";
        while (!cerrar){                  //un ciclo hasta que pasen todos los pacientes
            opcion=Byte.parseByte(JOptionPane.showInputDialog(mensaje));
            switch (opcion){
                case 1: String nombre, documento;
                cola.add(new Paciente(JOptionPane.showInputDialog("Nombre del paciente: "),JOptionPane.showInputDialog("Documento del paciente")));
                    System.out.println("Paciente agregado a la cola");
                break;
                case 2: if(!cola.isEmpty()){
                    Paciente actual = cola.poll();
                    JOptionPane.showMessageDialog(null,"En atención "+ actual.getNombre() + " con documento: "+actual.getDocumento());
                }
                else{
                    JOptionPane.showMessageDialog(null,"No hay más pacientes en cola\nCerrando consultorio...");
                    cerrar = true;
                }
                break;
                case 3:if(!cola.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Siguiente paciente: "+cola.peek().getNombre()+
                            "\nDocumento: "+cola.peek().getDocumento());
                }
                else{
                    JOptionPane.showMessageDialog(null,"No hay más pacientes en cola");
                }
                break;
                default:JOptionPane.showMessageDialog(null,"Opción no válida");break;
            }
        }
    }
}
