package threadbancodedados;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leitor extends Thread implements Runnable{
    
    public ListaBanco bufferCompartilhado;
    
    public Leitor(ListaBanco buffer) {
        bufferCompartilhado = buffer;
    }
    
    public void run(){
        int resultado;
        while(!bufferCompartilhado.fimProcesso){
            try
            {
                resultado = bufferCompartilhado.get();
                System.out.println("ultimo valor do buffer: " + resultado);
            } 
            catch (InterruptedException | ArrayIndexOutOfBoundsException exception) {
                break;
            }
            try {
                Random gerador = new Random();
                Thread.sleep(gerador.nextInt(1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Leitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
