import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.locks.*;
public class Lista{
    public ArrayList<String> list;
    public ReentrantReadWriteLock lock;
    

    public Lista(){
        this.ReadWriteLockList();
    }

    public void ReadWriteLockList(){
        this.lock = new ReentrantReadWriteLock();
        this.list = new ArrayList();

    }

    public void add(int index, String elemento){
        this.lock.writeLock().lock();
        this.list.add(index, elemento);
        this.lock.writeLock().unlock();
    }
    
    public void remover(int index){
        this.lock.writeLock().lock();
        this.list.remove(index);
        this.lock.writeLock().unlock();
    }

    public String get(int index){
        this.lock.readLock().lock();
        String resultado = this.list.get(index);
        this.lock.readLock().unlock();
        return resultado;

    }


}