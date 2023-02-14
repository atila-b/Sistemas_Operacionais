
package redimensionarimagem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.util.concurrent.locks.*;

public class ThreadRun extends Thread implements Runnable{
    ProcessarImg pi;
    public ReentrantReadWriteLock lock;

    public ThreadRun(ProcessarImg pi) {
        this.pi = pi;
        this.lock = new ReentrantReadWriteLock();
    }
    @Override
    public synchronized void run() {

        while(this.pi.index < this.pi.tamanho){
        try{
            
            String temp = this.pi.path + "\\" + this.pi.arquivos.get(this.pi.index);
            
            File imagem = new File(temp);
            BufferedImage img = ImageIO.read(imagem);
            int w = (int) (img.getWidth() * 0.65);
            int h = (int) (img.getHeight() * 0.65);
            img = null;
            this.pi.redimensionaImg(imagem, w , h, temp);
            this.pi.index++;
        }
        catch(IOException ex){  
        }
        }
    }
    
}
