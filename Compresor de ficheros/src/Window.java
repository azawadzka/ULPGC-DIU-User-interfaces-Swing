
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class Window extends javax.swing.JFrame {

    private final int DELAY = 1000;
    private final int BUFFER_SIZE = 1024;
    private SwingWorker worker;

    private String pathOrigin;
    private String pathDestination;
    private List<String> fileList;
    private boolean processing;

    public Window() {
        initComponents();
        this.setTitle("Compresor de catalogos");
        this.setResizable(false);
        processing = false;
        clearAll();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonOrigin = new javax.swing.JButton();
        fileName = new javax.swing.JTextField();
        buttonDestination = new javax.swing.JButton();
        buttonCompress = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        labelOrigin = new javax.swing.JLabel();
        labelDestination = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ExecutePanel = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        buttonCancel = new javax.swing.JButton();
        message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonOrigin.setText("Elegir carpeta de origen...");
        buttonOrigin.setMaximumSize(new java.awt.Dimension(200, 23));
        buttonOrigin.setMinimumSize(new java.awt.Dimension(200, 23));
        buttonOrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOriginActionPerformed(evt);
            }
        });

        fileName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileNameActionPerformed(evt);
            }
        });

        buttonDestination.setText("Elegir carpeta de destinación...");
        buttonDestination.setMaximumSize(new java.awt.Dimension(200, 23));
        buttonDestination.setMinimumSize(new java.awt.Dimension(200, 23));
        buttonDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDestinationActionPerformed(evt);
            }
        });

        buttonCompress.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonCompress.setText("Comprimir");
        buttonCompress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCompressActionPerformed(evt);
            }
        });

        buttonClear.setForeground(new java.awt.Color(255, 0, 0));
        buttonClear.setText("Limpiar");
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre del archivo:");

        jLabel2.setText(".zip");

        jLabel1.setText("Progreso:");

        buttonCancel.setText("Cancelar");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ExecutePanelLayout = new javax.swing.GroupLayout(ExecutePanel);
        ExecutePanel.setLayout(ExecutePanelLayout);
        ExecutePanelLayout.setHorizontalGroup(
            ExecutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExecutePanelLayout.createSequentialGroup()
                .addComponent(buttonCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message)
                .addContainerGap(342, Short.MAX_VALUE))
            .addGroup(ExecutePanelLayout.createSequentialGroup()
                .addGroup(ExecutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ExecutePanelLayout.setVerticalGroup(
            ExecutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExecutePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExecutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(message))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ExecutePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(fileName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonCompress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonClear))
                    .addComponent(buttonDestination, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(buttonOrigin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelOrigin)
                            .addComponent(labelDestination)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelOrigin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDestination)
                    .addComponent(buttonDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCompress)
                    .addComponent(buttonClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ExecutePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCompressActionPerformed
        if (allFieldsCheck()) {
            try {
                worker = new SwingWorkerImpl(jProgressBar1);
                fileList = listFilesForFolder(new File(pathOrigin));
                if (fileList.isEmpty()) throw new DirectoryEmpty();
                worker.execute();

            } catch(DirectoryEmpty ex) {
                JOptionPane.showMessageDialog(null, "El directorio de origen está vacío!");
            } catch(Exception ex) {
                ex.getMessage();
            }
        }
    }//GEN-LAST:event_buttonCompressActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        if (processing) 
            JOptionPane.showMessageDialog(null, "No se puede limpiar los campos porque un proceso está en marcha.");
        else
            clearAll();
    }//GEN-LAST:event_buttonClearActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        worker.cancel(true);
        showMessage("La operación se ha cancellado.");
        System.out.println("sancelled");
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDestinationActionPerformed
        try {
            pathDestination = chooseDirectory();
            labelDestination.setText(cut(pathDestination));
        } catch (DirectorySelectionCancelled e) {
            //ignore, leave the data as they were
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido elegir el archivo ZIP de destinación.");
        }
    }//GEN-LAST:event_buttonDestinationActionPerformed

    private void buttonOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOriginActionPerformed
        try {
            pathOrigin = chooseDirectory();
            labelOrigin.setText(cut(pathOrigin));
            fileName.setText(getNameFromPath(pathOrigin));
        } catch (DirectorySelectionCancelled e) {
            //ignore, leave the data as they were
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido elegir el archivo de origen.");
        }
    }//GEN-LAST:event_buttonOriginActionPerformed

    private void fileNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileNameActionPerformed

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
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ExecutePanel;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonCompress;
    private javax.swing.JButton buttonDestination;
    private javax.swing.JButton buttonOrigin;
    private javax.swing.JTextField fileName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel labelDestination;
    private javax.swing.JLabel labelOrigin;
    private javax.swing.JLabel message;
    // End of variables declaration//GEN-END:variables

    private class SwingWorkerImpl extends SwingWorker<Boolean, Integer> {

        JProgressBar bar;

        public SwingWorkerImpl(JProgressBar bar) {
            this.bar = bar;
            bar.setValue(0);
        }

        @Override
        protected Boolean doInBackground() throws Exception {
            // Background work
            setProgress(0);
            processing = true;
            showExecutePanel();

            // Value transmitted to done()
            return compressFiles(fileList);
        }

        @Override
        protected void process(List<Integer> chunks) {
            // Process results
            int i = chunks.get(chunks.size() - 1);
            bar.setValue(i);
        }

        @Override
        protected void done() {
            // Finish sequence
            System.out.println("Termiando de comprimir todos los ficheros.");
            showMessage("Los ficheros se han comprimido correctamente.");
            buttonCancel.setVisible(false);
            processing = false;
        }

        private boolean compressFiles(List<String> srcFiles) {
            int progressUnit = (int) (100 / srcFiles.size());
            
            try {
                String zipFileName = pathDestination + "\\" + fileName.getText()+ ".zip";
                //System.out.println(zipFileName);
                FileOutputStream fos = new FileOutputStream(zipFileName);
                ZipOutputStream zipOut = new ZipOutputStream(fos);
                for (String srcFile : srcFiles) {
                    if (isCancelled()) break; //close files before exiting
                    Thread.sleep(DELAY);
                    File fileToZip = new File(srcFile);
                    FileInputStream fis = new FileInputStream(fileToZip);
                    ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                    zipOut.putNextEntry(zipEntry);

                    byte[] bytes = new byte[1024];
                    int length;
                    while((length = fis.read(bytes)) >= 0) {
                        zipOut.write(bytes, 0, length);
                    }
                    fis.close();
                    setProgress(getProgress() + progressUnit);
                    publish(getProgress());
                    System.out.println("Comprimido el fichero: " + srcFile);
                }
                zipOut.close();
                fos.close();
            } catch (Exception e) {
                e.getMessage();
            }
            if (isCancelled()) return false;
            publish(100);
            return true;
        }
    }

    private void showExecutePanel() {
        ExecutePanel.setVisible(true);
        buttonCancel.setVisible(true);
        hideMessage();
    }

    private void hideExecutePanel() {
        ExecutePanel.setVisible(false);
    }

    private String chooseDirectory() throws DirectorySelectionCancelled {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fc.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            throw new DirectorySelectionCancelled();
        }
        File file = fc.getSelectedFile();
        return file.getAbsolutePath();
    }

    public class DirectorySelectionCancelled extends Exception {
        public DirectorySelectionCancelled() {
        }
    }
    
    private List listFilesForFolder(File folder) throws DirectoryEmpty {
        List list = new ArrayList();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                list.addAll(listFilesForFolder(fileEntry));
            } else {
                list.add(fileEntry.getAbsolutePath());
            }
        }
        return list;
    }
    
    public class DirectoryEmpty extends Exception {
        public DirectoryEmpty() {
        }
    }
    
    private void showMessage(String str) {
        message.setVisible(true);
        message.setText(str);
    }
    
    private void hideMessage() {
        message.setVisible(false);
    }
    
    private void clearAll() {
        pathOrigin = null;
        pathDestination = null;
        fileList = null;
        hideExecutePanel();
        labelDestination.setText("");
        labelOrigin.setText("");
        fileName.setText("");
    }
    
    private boolean allFieldsCheck() {
        if (pathOrigin == null) {
            JOptionPane.showMessageDialog(null, "No se ha podido elegir el archivo de origen.");
            return false;
        }
        if (pathDestination == null) {
            JOptionPane.showMessageDialog(null, "No se ha podido elegir el archivo de destinación.");
            return false;
        }
        if (pathDestination.equals(pathOrigin)) {
            JOptionPane.showMessageDialog(null, "Los archivos tienen que ser diferentes.");
            return false;
        }
        if (fileName.getText().equals("") || !archiveNameCorrect()) {
            JOptionPane.showMessageDialog(null, "Nombre del nuevo archivo ZIP incorrecto.");
            return false;
        }
        return true;
    }
    
    private boolean archiveNameCorrect() {
        File f = new File(fileName.getText());
        try {
            f.getCanonicalPath();
        } 
        catch (IOException e) {
            return false;
        }
        return true;
    }
    
    private String cut(String str) {
        if (str.length() > 30)
            return "..." + str.substring(str.length()-27, str.length());
        else 
            return str;
    }
    
    private String getNameFromPath(String path) {
        return path.substring(path.lastIndexOf("\\")+1, path.length());
    }
}
