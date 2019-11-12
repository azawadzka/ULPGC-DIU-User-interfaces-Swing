
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.RenderedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.core.Core;

public class practica7JFrame extends javax.swing.JFrame {

    private ArrayList<InternalFrame> internalFrames;
    private InternalFrame parent;
    private File fileToUse;
    private InternalFrame focused;
    int offset = 50;
    
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    
    public practica7JFrame() {
        initComponents();
        internalFrames = new ArrayList();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {             
                if (parent != null) checkAndMove(parent);
                for (InternalFrame frame : internalFrames) {
                      checkAndMove(frame);
                }
            }
            
            private void checkAndMove(InternalFrame frame) {
                int resizedCount = InternalFrame.getResizedFrameCount();
                if (frameOutOfWindow(frame) && frameCanFitInWindow(frame, resizedCount)) {
                    frame.setLocation(offset * resizedCount, offset * resizedCount);
                    InternalFrame.resizedFrameCountIncrease();
                }
            }
            
            private boolean frameOutOfWindow(InternalFrame frame) {
                int xSizeAllowed = (int) jDesktopPane1.getSize().getWidth() - offset;
                int ySizeAllowed = (int) jDesktopPane1.getSize().getHeight() - offset;
                System.out.println(frame.getLocation().getX() > xSizeAllowed || frame.getLocation().getY() > ySizeAllowed);
                return frame.getLocation().getX() > xSizeAllowed || frame.getLocation().getY() > ySizeAllowed;
            }

            private boolean frameCanFitInWindow(InternalFrame frame, int numberOffsets){
                int xSizeAllowed = (int) jDesktopPane1.getSize().getWidth() - offset;
                int ySizeAllowed = (int) jDesktopPane1.getSize().getHeight() - offset;
                System.out.println((offset * numberOffsets < xSizeAllowed) && (offset * numberOffsets < ySizeAllowed));
                return (offset * numberOffsets < xSizeAllowed) && (offset * numberOffsets < ySizeAllowed);
            }
        });
        
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                if (parent == null || closeParent())
                    System.exit(0);
            }
        });
    }

    private void openInternalWindow(ActionEvent e, File file, int valor) {
        try {
            InternalFrame currentFrame = new InternalFrame(file, valor);
            currentFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            currentFrame.addInternalFrameListener(new InternalFrameAdapter() {

                @Override
                public void internalFrameClosing(InternalFrameEvent e) {
                    if (currentFrame.isChild()) 
                        closeChild(currentFrame);
                    else closeParent();
                }
                
                @Override
                public void internalFrameActivated(InternalFrameEvent e) {
                    focused = currentFrame;
                }
            });
            
            currentFrame.setSize(500, 300);
            jDesktopPane1.add(currentFrame);
            if (currentFrame.isChild()) internalFrames.add(currentFrame);
            else parent = currentFrame;
            
            currentFrame.moveToFront();
            currentFrame.setSelected(true);

        }
        catch (PropertyVetoException | IOException ex) {
            System.out.print(ex.getMessage());           
        }
        
    }
    
    private boolean closeChild(InternalFrame frame) {
        if (!frame.isSaved()) {
            frame.moveToFront();
            try {
                frame.setSelected(true);
            } catch (PropertyVetoException ex) {}
            int result = JOptionPane.showConfirmDialog(null, "Este fichero no está guardado. Quiere guardar el fichero?", "Confirmacion salir", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.CANCEL_OPTION) {
                return false;
            } 
            else if (result == JOptionPane.YES_OPTION) {
                saveFile();
            }
        }
        frame.dispose();
        return true;
    }

    private boolean closeParent() {
        boolean canCloseParent = true; //only can close parent if all children have been closed
        ArrayList<InternalFrame> newInternalFrames = new ArrayList<>();
        for (InternalFrame f : internalFrames)
            if (!closeChild(f)) {
                newInternalFrames.add(f);
                canCloseParent = false;
            }
        internalFrames = newInternalFrames;
        if (canCloseParent) {
            InternalFrame temp = parent;
            parent = null;
            temp.dispose();
            return true;
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        myDialog = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        thresholdEdition = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        myDialog.setTitle("Mi ventana");
        myDialog.setBounds(new java.awt.Rectangle(0, 23, 300, 200));
        myDialog.setModal(true);
        myDialog.setResizable(false);
        myDialog.setType(java.awt.Window.Type.POPUP);

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout myDialogLayout = new javax.swing.GroupLayout(myDialog.getContentPane());
        myDialog.getContentPane().setLayout(myDialogLayout);
        myDialogLayout.setHorizontalGroup(
            myDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myDialogLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel2)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        myDialogLayout.setVerticalGroup(
            myDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myDialogLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel2)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(700, 500));

        jMenu1.setText("Fichero");

        openFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFile.setText("Abrir fichero...");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        jMenu1.add(openFile);

        saveFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveFile.setText("Guardar fichero...");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        jMenu1.add(saveFile);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        thresholdEdition.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        thresholdEdition.setText("Umbralizar");
        thresholdEdition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thresholdEditionActionPerformed(evt);
            }
        });
        jMenu2.add(thresholdEdition);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        boolean canOpenNewImage = true;
        if (parent != null) {
            if (internalFrames.isEmpty()) {
                int result = JOptionPane.showConfirmDialog(null, "La imagen se cerrará.", "", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION)
                    canOpenNewImage = closeParent();
                else 
                    canOpenNewImage = false;
            }
            else { // there are internal frames opened
                // if all internal frames have been saved
                boolean allSaved = true;
                for (InternalFrame frame : internalFrames) {
                    if (!frame.isSaved()) 
                        allSaved = false;
                }
                if (allSaved) {
                    int result = JOptionPane.showConfirmDialog(null, "La imagen se cerrará.", "OK", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION)
                        canOpenNewImage = closeParent();
                    else 
                        canOpenNewImage = false;
                } 
                else {
                    int result = JOptionPane.showConfirmDialog(null, "Para abrir nueva imagen tienes que cerrar la imagen anterior.", "", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.CANCEL_OPTION) 
                        canOpenNewImage = false;
                    else 
                        canOpenNewImage = closeParent();
                }
                
            }
        }
        
        if (canOpenNewImage) {
            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg", "gif");
            fc.setFileFilter(filter);
            fc.setAcceptAllFileFilterUsed(false);
            fc.showOpenDialog(this);

            File fichero = fc.getSelectedFile();
            this.openInternalWindow(evt, fichero, -1);
            fileToUse = fichero;
        }
        
    }//GEN-LAST:event_openFileActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        if (!saveFile()) 
            JOptionPane.showMessageDialog(null, "No se ha podido guardar la imagen!");
    }//GEN-LAST:event_saveFileActionPerformed

    private void thresholdEditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thresholdEditionActionPerformed
        try {
            if (fileToUse == null) throw new NoImageOpenedException();
            int valor = Integer.valueOf(JOptionPane.showInputDialog(null, "Introduce  el valor del umbral:"));
            if (valor < 0 || valor > 255) throw new ImpossibleRangeException();
            this.openInternalWindow(evt, this.fileToUse, valor);
        } catch (NumberFormatException e) {
            notIntegerValueIntroducedError();
        } catch (ImpossibleRangeException | NoImageOpenedException | HeadlessException e) {}
    }//GEN-LAST:event_thresholdEditionActionPerformed

    public boolean saveFile() {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
        fc.setFileFilter(filter);
        fc.setAcceptAllFileFilterUsed(false);
        int result = fc.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getAbsolutePath();
            if (!path.endsWith(".jpg")) path += ".jpg";
            File file = new File(path);
            try {
                boolean a = ImageIO.write((RenderedImage) this.focused.getImg(), "jpg", file);
                this.focused.setSaved();
                return true;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "El fichero seleccionado no está correcto.");
                saveFile();
            }
        }
        return false;
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(practica7JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(practica7JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(practica7JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(practica7JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new practica7JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JDialog myDialog;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JMenuItem thresholdEdition;
    // End of variables declaration//GEN-END:variables

    public class ImpossibleRangeException extends Exception {
        public ImpossibleRangeException() {
            JOptionPane.showMessageDialog(null, "Los valores introducidos tienen que ser entre 0 y 255!");
        }
    }
    
    public class NoImageOpenedException extends Exception {
        public NoImageOpenedException() {
            JOptionPane.showMessageDialog(null, "Para realizar el umbralizado, primero debe seleccionar el imagen!");
        }
    }
    
    private void notIntegerValueIntroducedError() {
        JOptionPane.showMessageDialog(null, "Valor incorrecto! Introduce valores tipo entero.");
    }
}