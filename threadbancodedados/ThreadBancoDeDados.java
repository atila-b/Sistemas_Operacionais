package threadbancodedados;

import java.util.ArrayList;
import java.util.concurrent.locks.*;

public class ThreadBancoDeDados {

    public static void main(String[] args) throws InterruptedException {
        int NE = 12;
        int NL = 20;
        int NA = 2;
        ListaBanco buffer = new ListaBanco(NE);
        
        Escritor e[] = new Escritor[NE];
        Leitor l[] = new Leitor[NL];
        Alterador a[] = new Alterador[NA];
        
        e[0] = new Escritor(buffer, 0);
        e[1] = new Escritor(buffer, 1);
        e[2] = new Escritor(buffer, 2);
        e[3] = new Escritor(buffer, 3);
        e[4] = new Escritor(buffer, 4);
        e[5] = new Escritor(buffer, 5);
        e[6] = new Escritor(buffer, 6);
        e[7] = new Escritor(buffer, 7);
        e[8] = new Escritor(buffer, 8);
        e[9] = new Escritor(buffer, 9);
        e[10] = new Escritor(buffer, 10);
        e[11] = new Escritor(buffer, 11);
        
        l[0] = new Leitor(buffer);
        l[1] = new Leitor(buffer);
        l[2] = new Leitor(buffer);
        l[3] = new Leitor(buffer);
        l[4] = new Leitor(buffer);
        l[5] = new Leitor(buffer);
        l[6] = new Leitor(buffer);
        l[7] = new Leitor(buffer);
        l[8] = new Leitor(buffer);
        l[9] = new Leitor(buffer);
        l[10] = new Leitor(buffer);
        l[11] = new Leitor(buffer);
        l[12] = new Leitor(buffer);
        l[13] = new Leitor(buffer);
        l[14] = new Leitor(buffer);
        l[15] = new Leitor(buffer);
        l[16] = new Leitor(buffer);
        l[17] = new Leitor(buffer);
        l[18] = new Leitor(buffer);
        l[19] = new Leitor(buffer);
        
        a[0] = new Alterador(buffer, 99, 0);
        a[1] = new Alterador(buffer, 66, 1);
            
        for (int j=0; j<NE; j++)
            e[j].start();
        for (int j=0; j<NL; j++)
            l[j].start();
        for (int j=0; j<NE; j++)
            e[j].join();
        for (int j=0; j<NL; j++)
            l[j].join();
        
        System.out.println("Arraylist: " + buffer.list);
        
        for (int j=0; j<NA; j++)
            a[j].start();
        for (int j=0; j<NA; j++)
            a[j].join();
        
        System.out.println("Arraylist: " + buffer.list);
        
    }
    
}
