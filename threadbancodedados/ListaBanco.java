package threadbancodedados;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ListaBanco{

    public ArrayList<String> list;
    public ReentrantReadWriteLock lock;
    int tam;
    int flag;
    
    public ListaBanco(int ne) {
        qtdEscritores = ne;
        fimProcesso = false;
        this.ReadWriteLockList();
        tam = 0;
        flag = 0;
    }
    
    public void ReadWriteLockList(){
        this.lock = new ReentrantReadWriteLock();
        this.list = new ArrayList();

    }

    int qtdEscritores;
    boolean fimProcesso;
    
    public int occupiedCells = 0;

    public int getOccupiedCells() {
        return occupiedCells;
    }

    public void set(String elemento) throws InterruptedException {
        this.lock.writeLock().lock();
        this.list.add(elemento);
        this.lock.writeLock().unlock();
    }
    
    public void alterar(int index, String elemento) throws InterruptedException {
        this.lock.writeLock().lock();
        this.list.add(index, elemento);
        this.list.remove(index+1);
        this.lock.writeLock().unlock();
    }

    public int get() throws InterruptedException {
        flag++;
        while(flag > 10 && !fimProcesso){
            System.out.println("Buffer ocupado, esperando...");
            Thread.sleep(500); 
        }
        this.lock.readLock().lock();
        String aux = this.list.get(list.size()-1);
        int num = parseInt(aux);
        this.lock.readLock().unlock();
        flag--;
        Random gerador = new Random();
        Thread.sleep(gerador.nextInt(1000));
        
        return num;
        
    }
    
    public synchronized void encerrarProdutor(){
        qtdEscritores -= 1;
        if(qtdEscritores <= 0)
            fimProcesso = true;
        notifyAll();
    }
    
}
