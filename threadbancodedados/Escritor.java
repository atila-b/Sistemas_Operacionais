package threadbancodedados;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Escritor extends Thread implements Runnable {
    public ListaBanco bufferCompartilhado;
    int data;
    
    public Escritor( ListaBanco buffer, int cd){
        bufferCompartilhado = buffer;
        data = cd;
    }
    
    public void run() {
            try
            {
                String aux = Integer.toString(data);
                bufferCompartilhado.set(aux);
                System.out.println("Inserindo " + data);
            } 
            catch (InterruptedException exception) {
            }
            try {
                Random gerador = new Random();
                Thread.sleep(gerador.nextInt(1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
            bufferCompartilhado.encerrarProdutor();   
    }
}
