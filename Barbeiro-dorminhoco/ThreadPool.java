import java.util.concurrent.*;
public class ThreadPool{
    public void main(String[] args) {
        int numWorkers = Integer.parseInt(args[0]);
        int threadPoolSize = Integer.parseInt(args[1]);
        int blockQueueSize = Integer.parseInt(args[2]);
    
        ExecutorService pool = Executors.newFixedThreadPool(threadPoolSize);
        Semaphore semaforo = new Semaphore(blockQueueSize); // semaforo para controlar o numero de cadeiras disponvieis
        WorkerThread[] workers = new WorkerThread[numWorkers];

        for (int i = 0; i < numWorkers; i++) {
                try{
                    if (semaforo.availablePermits() != 0){ // verificando se ha cadeiras disponiveis
                        semaforo.acquire();
                        int intervalo = (3 + (int)(Math.random() * (5 - 3) + 1));
                        System.out.printf("Novo cliente entrando em %d segundos %n", intervalo);
                        System.out.println("Cadeiras disponiveis = " + semaforo.availablePermits());
                        try{
                            Thread.sleep(intervalo*1000);
                        }catch(InterruptedException ie){}
                        workers[i] = new WorkerThread(i, semaforo);
                        pool.execute(workers[i]);
                    }else{
                        System.out.printf("Fila cheia, cliente %d foi embora %n", i); // se estiver cheio print
                    }
                }catch(InterruptedException ie){
                }
        }
        pool.shutdown();
    }
}