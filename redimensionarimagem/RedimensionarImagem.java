package redimensionarimagem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RedimensionarImagem {
    
    
    public static ArrayList findAllFilesInFolder(File folder, ArrayList arquivos) {
	for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
		arquivos.add(file.getName());
                //System.out.println(file.getName());
            } else {
		findAllFilesInFolder(file, arquivos);
            }
        }
        return arquivos;
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {        
        
        ArrayList<String> arquivos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        //String path = "C:\\Imagens";
        String path;
        
        System.out.println("Digite o caminho da sua pasta contendo as imagens:");
        path = sc.nextLine();
        sc.close();
        
        File pasta = new File(path);
        arquivos = findAllFilesInFolder(pasta, arquivos);
        

        ProcessarImg pi = new ProcessarImg(path, arquivos);
        Thread t1 = new ThreadRun(pi);
        Thread t2 = new ThreadRun(pi);
        Thread t3 = new ThreadRun(pi);
        Thread t4 = new ThreadRun(pi);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        
        System.out.println("Imagens redimensionadas com sucesso!");
    }
    
}
