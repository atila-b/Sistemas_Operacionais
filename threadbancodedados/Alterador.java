package threadbancodedados;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Alterador extends Thread implements Runnable {
    public ListaBanco bufferCompartilhado;
    int data;
    int index;
    
    public Alterador( ListaBanco buffer, int cd, int id){
        bufferCompartilhado = buffer;
        data = cd;
        index = id;
    }
    
    public void run() {
            try
            {
                String aux = Integer.toString(data);
                bufferCompartilhado.alterar(index, aux);
                System.out.println("Alterando valor no index " + index + " para: " + data);
            } 
            catch (InterruptedException exception) {
            }
            try {
                Random gerador = new Random();
                Thread.sleep(gerador.nextInt(1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Alterador.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
}
