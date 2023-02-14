
package redimensionarimagem;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import java.util.concurrent.locks.*;

public class ProcessarImg extends Thread implements Runnable {
    
    String path;
    ArrayList<String> arquivos;
    int tamanho;
    int index;
    public ReentrantReadWriteLock lock;
    
    public ProcessarImg(String path, ArrayList<String> arq) {
        this.path = path;
        arquivos = arq;
        tamanho = arq.size();
        index = 0;
        this.lock = new ReentrantReadWriteLock();
        
    }
    
    public synchronized ImageIcon redimensionaImg(File image, int new_w, int new_h, String tempPath) throws IOException {
        try {
            BufferedImage imagem = ImageIO.read(image);
            BufferedImage new_img = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);

            Graphics2D g = new_img.createGraphics();
            g.drawImage(imagem, 0, 0, new_w, new_h, null);
            g.dispose();
            ImageIO.write(new_img, "JPG", new File(tempPath));
            return new ImageIcon(new_img);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
