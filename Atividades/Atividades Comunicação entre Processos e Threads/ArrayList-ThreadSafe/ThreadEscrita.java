public class ThreadEscrita implements Runnable{
    private String nome;
    int index;
    String elemento;
    Lista arraylist;

    public ThreadEscrita(String nome, Lista arraylist, int index, String elemento){
        this.nome = nome;
        this.arraylist = arraylist;
        this.index = index;
        this.elemento = elemento;
    }

    @Override
    public void run(){
        synchronized(this){
            try{
                this.arraylist.add(this.index, this.elemento);
                System.out.printf("'%s' inserido no index %d%n", this.elemento, this.index);
            }catch(IndexOutOfBoundsException e){ //caso o index de insercao seja maior que o tamanho da lista:
                try{
                this.arraylist.lock.writeLock().unlock(); // libera o objeto para outra thread
                Thread.sleep(100); // espera 1ms
                this.run(); // tenta novamente
                }catch(InterruptedException ie){
                   
                }
            }
        }
    }
}