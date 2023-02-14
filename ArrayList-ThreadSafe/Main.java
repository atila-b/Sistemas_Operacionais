import java.util.Arrays;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        Lista l1 = new Lista();

        ThreadLeitura threadL1 = new ThreadLeitura("Thread L1", l1, 0);
        ThreadLeitura threadL2 = new ThreadLeitura("Thread L1", l1, 1);
        ThreadLeitura threadL3 = new ThreadLeitura("Thread L1", l1, 2);
        
        ThreadEscrita threadE1 = new ThreadEscrita("Thread E1", l1, 0, "elemento 1");
        ThreadEscrita threadE2 = new ThreadEscrita("Thread E2", l1, 1, "elemento 2");
        ThreadEscrita threadE3 = new ThreadEscrita("Thread E3", l1, 2, "elemento 3");
        
        ThreadRemocao threadR1 = new ThreadRemocao("Thread R1", l1, 1);
        
        Thread a1 = new Thread(threadL1);
        Thread a2 = new Thread(threadL2);
        Thread a3 = new Thread(threadL3);
        
        Thread b = new Thread(threadE1);
        Thread c = new Thread(threadE2);
        Thread d = new Thread(threadE3);
        
        Thread r1 = new Thread(threadR1);

        //inicializando as threads de escrita
        b.start();
        c.start();
        d.start();
        
        try{  //primeiro termina de criar o array para depois ler
            b.join();
            c.join();
            d.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        //depois do array ser criado, inicia as threads de leitura
        a1.start();
        a2.start();
        a3.start();
        
        try{
            a2.join(); // espera a thread a2 acabar para nao remover antes de ler
            r1.start(); 
            r1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        System.out.println("ArrayList :" + l1.list);

    }
}