import java.util.concurrent.*;
public class WorkerThread implements Runnable {
    private int workerNumber;
    public Semaphore semaforo;

    public WorkerThread(int x, Semaphore semaforo) {
        this.workerNumber = x;
        this.semaforo = semaforo;
    }

    public void run() {
        semaforo.release();
        System.out.println("1 Cadeira foi liberada");
        int contador = 0;
        for (int i=0;i<=100;i+=20) {
            // Cortando o cabelo em um tempo aleatorio entre 1 e 10 segundos...
            System.out.println("Cliente numero: "
                + workerNumber
                + ", percentual completo: " + i );
            try {
                int intervalo = (3 + (int)(Math.random() * (10 - 3) + 1))/5;
                Thread.sleep(intervalo * 1000);
                contador = contador + intervalo;
            } catch (InterruptedException e) {
            }
        }
        System.out.printf("Cliente %d finalizado em %d segundos %n", workerNumber, contador);
    }
}