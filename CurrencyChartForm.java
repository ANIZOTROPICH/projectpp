
package com.mycompany.mavenproject1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.Date;


public class CurrencyChartForm extends javax.swing.JFrame {

    public CurrencyChartForm() {
        initComponents();
    }
    public static int calculateDifferenceDays(Date a, Date b) {
    int tempDifference = 0;
    int difference = 0;
    Calendar earlier = Calendar.getInstance();
    Calendar later = Calendar.getInstance();

    if (a.compareTo(b) < 0) {
        earlier.setTime(a);
        later.setTime(b);
    } else {
        earlier.setTime(b);
        later.setTime(a);
    }

    while (earlier.get(Calendar.YEAR) != later.get(Calendar.YEAR)) {
        tempDifference = 365 * (later.get(Calendar.YEAR) -
            earlier.get(Calendar.YEAR));
        difference += tempDifference;

        earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
    }

    if (earlier.get(Calendar.DAY_OF_YEAR) != later.get(Calendar.DAY_OF_YEAR)) {
        tempDifference = later.get(Calendar.DAY_OF_YEAR) -
            earlier.get(Calendar.DAY_OF_YEAR);
        difference += tempDifference;

        earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
    }

    return difference;
    }
       public void paint2(Graphics2D gr) {
        
        String[] dolDate = difference;
        float[] dolVal = dolValGlobal;
        
        int width = getWidth();
        int height = getHeight();
        gr.setColor(new Color(214,217,223));
        gr.fillRect(0, 0, width, height);
        
        gr.setColor(Color.BLACK);
        int offsetX = 70;
        int offsetX_2 = getWidth()-70;
        int offsetY = 70;
        int offsetY_2 = this.getHeight()-70;
        int lengthX = offsetX_2 - offsetX;
        int lengthY = offsetY_2 - offsetY;
        Font currentFont = gr.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * getWidth()/1500F);
        gr.setFont(newFont);
        int[] xPoints = new int[(dolDate.length)];
        
        for (int i = 0; i <= (dolDate.length-1); i++) {
            gr.setColor(Color.GRAY);
            gr.drawLine(offsetX - grafOffset +(lengthX/(dolDate.length-1))*i*2 , offsetY_2, offsetX - grafOffset +(lengthX/(dolDate.length-1))*i*2 , offsetY);
            gr.setColor(Color.BLACK);
            gr.drawLine(offsetX - grafOffset +(lengthX/(dolDate.length-1))*i*2 , offsetY_2-5, offsetX - grafOffset +(lengthX/(dolDate.length-1))*i*2 , offsetY_2+5);
            if (i != 0){
            gr.drawString(dolDate[(dolDate.length-1)-i], offsetX - grafOffset +(lengthX/(dolDate.length-1))*i*2 - lengthX/((dolDate.length-1)*2), offsetY_2 + lengthY/((dolDate.length-1)*2));}
            xPoints[(dolDate.length-1) - i]=offsetX - grafOffset +(lengthX/(dolDate.length-1))*i*2;
        }
        float min = -1, max = 0;
        for (float f : dolVal) {
            if ((f < min)||(min == -1)){min = f;}
            if (f > max){max = f;}
        }

        int minInt = (int) Math.floor(min);
        int maxInt = (int) Math.floor(max+1);
        int difInt = (maxInt - minInt);
        double difDem;
        double difDemZero;
        if ((difInt >= 3)&&(difInt <= 10)){
          difInt *=2;
          difDem = 0.5;
          difDemZero = 0.0;
        } else if (difInt >= 2) {
          difInt *=4;
          difDem = 0.25;  
          difDemZero = 0.00;
        } else {
          difInt *=8;
          difDem = 0.125;
          difDemZero = 0.000;
        }
        if (curDoubleBol){
            minInt = 0;
            maxInt = 2;
            difInt = 4;
            difDem = 0.5;
            difDemZero = 0.0;
        }
        int tmpMin=offsetY, tmpMax, tmpDif;
        
        for (int i = 1; i <= difInt; i++) {
            tmpMin = offsetY_2-(lengthY/difInt)*i;
        }
        gr.drawLine(offsetX-5, offsetY_2, offsetX+5, offsetY_2);
        gr.drawString(String.valueOf(minInt+difDemZero), offsetX - (lengthX/30) , offsetY_2 );
        tmpMax = offsetY_2;
        tmpDif = tmpMax - tmpMin;
        gr.drawLine(offsetX, offsetY, offsetX, offsetY_2);
        gr.drawLine(offsetX, offsetY_2, offsetX_2, offsetY_2);     
        int[] yPoints = new int[dolVal.length];
        for (int i = 0; i < dolVal.length; i++) {
              yPoints[i] = (int) (tmpMax - ((tmpDif/(maxInt - minInt))*(dolVal[i] - minInt)));   
        }
        for (int i = 1; i <= difInt; i++) {
            gr.setColor(Color.GRAY);
            gr.drawLine(offsetX, offsetY_2-(lengthY/difInt)*i, offsetX_2, offsetY_2-(lengthY/difInt)*i);
            gr.setColor(Color.LIGHT_GRAY);
            gr.drawLine(offsetX, offsetY_2-(lengthY/difInt)*i+(lengthY/(difInt*2)), offsetX_2, offsetY_2-(lengthY/difInt)*i+(lengthY/(difInt*2)));
        }
        gr.setColor(Color.BLUE);
        Graphics2D g2 = (Graphics2D) gr;   
        g2.setStroke(new BasicStroke(1.5f));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawPolyline(xPoints, yPoints, xPoints.length);
        
        gr.setColor(new Color(214,217,223));
        gr.fillRect(0, 0, offsetX, height);
        gr.fillRect(offsetX_2, 0, width, height);
            if (grafOffset == getWidth()-139){
                gr.setColor(Color.BLACK);
            gr.drawString(dolDate[(dolDate.length-1)-(dolDate.length-1)], offsetX - grafOffset +(lengthX/(dolDate.length-1))*(dolDate.length-1)*2 - lengthX/((dolDate.length-1)*2), offsetY_2 + lengthY/((dolDate.length-1)*2));}
        for (int i = 1; i <= difInt; i++) {
            gr.setColor(Color.BLACK);
            gr.drawLine(offsetX-5, offsetY_2-(lengthY/difInt)*i, offsetX+5, offsetY_2-(lengthY/difInt)*i);
            gr.drawString(String.valueOf(minInt+difDem*i), offsetX - (lengthX/30) , offsetY_2-(lengthY/difInt)*i );
        }
        gr.drawLine(offsetX-5, offsetY_2, offsetX+5, offsetY_2);
        gr.drawString(String.valueOf(minInt+difDemZero), offsetX - (lengthX/30) , offsetY_2 );
        gr.dispose(); 
    }
    @Override
    public void paint(Graphics g) {
    BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = bufferedImage.createGraphics();
    paint2(g2d);
    Graphics2D g2dComponent = (Graphics2D) g;
    g2dComponent.drawImage(bufferedImage, null, 0, 0);       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurrencyChartForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
