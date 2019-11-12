
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Window1 extends javax.swing.JFrame {

    int values[][] = new int[10][10];
    String valuesFiltered[][] = new String[10][10];
    private int max;
    private int min;
    private int filterValue;
    private final int size = 10;
    private final int maxNumber = 99999;
    private final int numberLabels = 5;

    public Window1() {
       this.setResizable(false);
        initComponents();
        this.max = Integer.parseInt(maxLimitInput.getText());
        this.min = Integer.parseInt(minLimitInput.getText());
        this.filterValue = this.min;
        updateTicksAndLabels();
        resetRandomValues();
        refilterDisplay();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        minLimitInput = new javax.swing.JTextField();
        maxLimitInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        slider = new javax.swing.JSlider();
        filterInput = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        jScrollPane2.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Filtrado de matriz");

        minLimitInput.setText("0");
        minLimitInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minLimitInputActionPerformed(evt);
            }
        });

        maxLimitInput.setText("100");
        maxLimitInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxLimitInputActionPerformed(evt);
            }
        });

        jLabel3.setText("Introduzca los valores mínimos y máximos de los números:");

        jLabel4.setText("min:");

        jLabel5.setText("max: ");

        jLabel6.setText("Seleccione el valor del filtro: ");

        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setValue(0);
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });

        filterInput.setText("0");
        filterInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(5, 5, 5)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(minLimitInput)
                            .addComponent(maxLimitInput, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(slider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(filterInput, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(minLimitInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(maxLimitInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filterInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(8, 8, 8)
                .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Courier New", 0, 9)); // NOI18N
        textArea.setRows(10);
        jScrollPane1.setViewportView(textArea);

        jLabel2.setText("Resultado:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
        updateFilter(slider.getValue());
        refilterDisplay();
    }//GEN-LAST:event_sliderStateChanged

    private void maxLimitInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxLimitInputActionPerformed
        try {
            max = Integer.parseInt(maxLimitInput.getText());
            if (!isWithinRange(max)) throw new OutOfRangeException();
            if (min >= max) throw new ImpossibleRangeException();
            slider.setMaximum(max);
            updateTicksAndLabels();
            updateFilter(min);
            resetRandomValues();
            refilterDisplay();
        } catch (NumberFormatException e) {
            notIntegerValueIntroducedError();
        } catch (ImpossibleRangeException | OutOfRangeException e) {}
        
    }//GEN-LAST:event_maxLimitInputActionPerformed

    private void minLimitInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minLimitInputActionPerformed
        try {
            min = Integer.parseInt(minLimitInput.getText());
            if (!isWithinRange(min)) throw new OutOfRangeException();
            if (min >= max) throw new ImpossibleRangeException();
            slider.setMinimum(min);
            updateTicksAndLabels();
            updateFilter(min);
            resetRandomValues();
            refilterDisplay();
        } catch (NumberFormatException e) {
            notIntegerValueIntroducedError();
        } catch (ImpossibleRangeException | OutOfRangeException e) {}
    }//GEN-LAST:event_minLimitInputActionPerformed

    private void filterInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterInputActionPerformed
        try {
            updateFilter(Integer.parseInt(filterInput.getText()));
            refilterDisplay();
        } catch (NumberFormatException e) {
            //notIntegerValueIntroducedError();
        }
    }//GEN-LAST:event_filterInputActionPerformed

    private void updateFilter(int value) {
        try {
            if (!isWithinRange(value)) throw new OutOfRangeException();
            if (value < min || value > max) throw new ImpossibleFilterException();
            filterValue = value;
            slider.setValue(value);
            filterInput.setText(Integer.toString(filterValue));
        } 
        catch (ImpossibleFilterException | OutOfRangeException e) {}
        
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
            java.util.logging.Logger.getLogger(Window1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window1().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField filterInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField maxLimitInput;
    private javax.swing.JTextField minLimitInput;
    private javax.swing.JSlider slider;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables

    private void printTable() {
        clearTextArea();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                textArea.append(String.format("%6s ", valuesFiltered[i][j]));
            }
            textArea.append("\n");
        }
    }

    private void resetRandomValues() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                values[i][j] = (int) (Math.random() * (max - min) + min);
            }
        }
    }

    private void clearTextArea() {
        textArea.setText("");
    }

    private void useFilter() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                valuesFiltered[i][j] = 
                        filterValue <= values[i][j] ? Integer.toString(values[i][j]) : "-";
            }
        }
    }

    private void refilterDisplay() {
        useFilter();
        printTable();
    }
    
    private void updateTicksAndLabels() {
        int space = (max - min) / numberLabels - 1;
        slider.setMajorTickSpacing(space);
        slider.setLabelTable(slider.createStandardLabels(space));
    }
    
    private boolean isWithinRange(int value) {
        if (value < -maxNumber | value > maxNumber) return false;
        return true;
    }
    
    private void notIntegerValueIntroducedError() throws HeadlessException {
        JOptionPane.showMessageDialog(new JFrame(), 
                "Introduzca valores enteros.");
    }

    public class ImpossibleRangeException extends RuntimeException {
        public ImpossibleRangeException() {
            JOptionPane.showMessageDialog(new JFrame(), 
                    "El valor mínimo no puede superar el valor máximo.");
        }
    }
    
    public class OutOfRangeException extends RuntimeException {
        public OutOfRangeException() {
            JOptionPane.showMessageDialog(new JFrame(), 
                    "El valor es demasiado grande o pequeño.");
        }
    }
    
    public class ImpossibleFilterException extends RuntimeException {
        public ImpossibleFilterException() {
            JOptionPane.showMessageDialog(new JFrame(), 
                    "El valor del filtro debe situarse entre los valores mínimo y máximo.");
        }
    }   
}
