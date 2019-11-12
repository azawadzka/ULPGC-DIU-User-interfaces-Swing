
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JInternalFrame;

class InternalFrame extends JInternalFrame {

    //Contador estático que aumenta cada vez que instanciamos una ventana.
    static int openFrameCount = 0;
    static int resizedFrameCount = 0;
    static final int xOffset = 50, yOffset = 50;
    private int posX = 0, posY = 0;
    private boolean child;
    private boolean saved;

    private BufferedImage img;

    public InternalFrame(File file, int valor) throws IOException {
        super(file.getName(),
                true, //Resizable
                true, //Closable
                true, //Maximizable
                true);//Iconifiable
        saved = false;
        child = (valor != -1);
        if (child) super.setTitle("Valor del umbralizado: " + valor);

        setVisible(true);
                
        //Ponemos la localición de la ventana.
        setLocation(xOffset * openFrameCount, yOffset * openFrameCount);

        try {
            img = ImageIO.read(file);
            practica7JPanel panel = new practica7JPanel();
            if(valor>=0) img = panel.ImageThreshold(img, valor);
            panel.setImage(img);
            add(panel);                                  
            pack();
        } catch (Exception e) {}
        openFrameCount++;
        System.out.println(openFrameCount);
    }

    public boolean isChild() {
        return child;
    }

    public boolean isSaved() {
        return saved;
    }

    public BufferedImage getImg() {
        return img;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public static int getResizedFrameCount() {
        return resizedFrameCount;
    }
    
    public static void resizedFrameCountIncrease() {
        resizedFrameCount++;
    }
    
    @Override
    public void dispose() {
        super.dispose();
        openFrameCount--;
    }
    
    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x,y);
        this.posX = x;
        this.posY = y;
    }

    void setSaved() {
        this.saved = true;
    }
}