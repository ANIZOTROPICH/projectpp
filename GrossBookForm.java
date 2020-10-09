package com.mycompany.mavenproject1;

import static com.mycompany.mavenproject1.CreditCalc.payment;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class GrossBookForm extends javax.swing.JFrame {
    public static CreditCalc creditCalc = new CreditCalc();
        
    

    public GrossBookForm() {
        initComponents();
        String tableText = "";
        try(FileReader reader = new FileReader("table.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
                tableText += (char)c;
            } 
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }   
        
        
        String[] tableMass = tableText.split("\\r?\\n");
        
        
        ArrayList<String[]> tableMassB = new ArrayList<>();
        
        for (String s : tableMass)
        {
         tableMassB.add(s.split(" "));
        }

        System.out.print(tableMassB.get(0)[0]);
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        float tmpD = 0,tmpR = 0;
        for (String[] c : tableMassB)
        {
         model.addRow(new Object[]{c[0], Float.parseFloat(c[1]),Float.parseFloat(c[2])});
         tmpD +=  Float.parseFloat(c[1]);
         tmpR +=  Float.parseFloat(c[2]);
        }
        
         model.addRow(new Object[]{"Итого:   "+(tmpD-tmpR), tmpD,tmpR});
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Валовая книга");

        jButton1.setText("Назад");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Дата", "Доход", "Расход"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTable1FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Добавить запись");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Удалить выделенную запись");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Сохранить");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(1, 1, 1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(140, 140, 140))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainForm mainWindow = new MainForm();
        mainWindow.start();
        this.dispose();

        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if ((jTable1.getSelectedRow() != -1)&&(jTable1.getSelectedRow() != jTable1.getRowCount()-1)) {
        model.removeRow(jTable1.getSelectedRow());}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{jTable1.getModel().getValueAt(jTable1.getRowCount()-1, 0),jTable1.getModel().getValueAt(jTable1.getRowCount()-1, 1),jTable1.getModel().getValueAt(jTable1.getRowCount()-1, 2)});
        jTable1.getModel().setValueAt(null, jTable1.getRowCount()-2, 0);
        jTable1.getModel().setValueAt(null, jTable1.getRowCount()-2, 1);
        jTable1.getModel().setValueAt(null, jTable1.getRowCount()-2, 2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        float tmpD2 = 0,tmpR2 = 0;
        try(FileWriter writer = new FileWriter("table.txt", false))
        {
            for (int i = 0; i < jTable1.getRowCount()-1; i++) {
                if ((jTable1.getModel().getValueAt(i, 0) != null)&&(jTable1.getModel().getValueAt(i, 1)!=null)&&(jTable1.getModel().getValueAt(i, 2)!=null)){
               writer.write(jTable1.getModel().getValueAt(i, 0)+" "+jTable1.getModel().getValueAt(i, 1)+" "+jTable1.getModel().getValueAt(i, 2));
               tmpD2 += Float.parseFloat(jTable1.getModel().getValueAt(i, 1).toString());
               tmpR2 += Float.parseFloat(jTable1.getModel().getValueAt(i, 2).toString());
               writer.append('\n'); 
                }
            }
            
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 

        jTable1.getModel().setValueAt("Итого:   "+(tmpD2-tmpR2), jTable1.getRowCount()-1, 0);
        jTable1.getModel().setValueAt(tmpD2, jTable1.getRowCount()-1, 1);
        jTable1.getModel().setValueAt(tmpR2, jTable1.getRowCount()-1, 2);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusLost


    }//GEN-LAST:event_jTable1FocusLost

    public static void main(String args[]) {
      
        start();
        
    }
    
    public static void start() {
        
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
            java.util.logging.Logger.getLogger(CreditCalcForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreditCalcForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreditCalcForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreditCalcForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int sizeWidth = 980;
                int sizeHeight = 600;
                int locationX = (screenSize.width - sizeWidth) / 2;
                int locationY = (screenSize.height - sizeHeight) / 2;
                javax.swing.JFrame frame = new GrossBookForm();
                frame.setBounds(locationX, locationY, sizeWidth, sizeHeight);
                frame.setVisible(true);
                
                
                                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
