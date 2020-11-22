
package com.mycompany.mavenproject1;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class VisualGrossBook extends javax.swing.JFrame {
    ArrayList<Color> colorList = new ArrayList<>();
    static float[] incomeList = new float[]{1,2,3};
    static float[] conList = new float[]{1,2,3};
    static float[] difList = new float[]{1,2,3};
    static String[] dateList = new String[]{"1","2","3"};
    float offsetDiagram = 2;
    float opacityDiagram = 0;
    int parts = 0;
    float partsPercent = 0;
    private BufferedImage bufferImage;
  
    public VisualGrossBook(float[] incomeListTmp, float[] conListTmp, float[] difListTmp, String[] dateListTmp) {
        initComponents();
        incomeList = incomeListTmp;
        conList = conListTmp;
        difList = difListTmp;
        dateList = dateListTmp;
        
        Color[] exp = new Color[]{ new Color(4,224,200), new Color(4,7,200), new Color(80,7,8)
        , new Color(248,12,253), new Color(82,254,10), new Color(217,252,15)
        , new Color(242,136,134), new Color(15,252,239), new Color(112,7,107)
        , new Color( 112,6,1), new Color(252,248,1), new Color(252,95,1)
        , new Color(0,8,252), new Color(102,8,252), new Color(242,235,216)
        , new Color(179,136,20), new Color(0,136,20), new Color(0,136,134)
        , new Color(252,15,241), new Color(242,136,6), new Color(12,8,146)
        , new Color(12,250,146), new Color(71,0,128), new Color(121,127,126)
        , new Color(6,127,126), new Color(144,176,16), new Color(144,252,16) };


        for (int i = 0; i < 27; i++) {
            colorList.add(exp[i]);
        }
        

        


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
      
        
        
       
        java.awt.EventQueue.invokeLater(() -> {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int sizeWidth = 980;
            int sizeHeight = 600;
            int locationX = (screenSize.width - sizeWidth) / 2;
            int locationY = (screenSize.height - sizeHeight) / 2;
            javax.swing.JFrame frame = new VisualGrossBook(incomeList,conList,difList,dateList);
            frame.setBounds(locationX, locationY, sizeWidth, sizeHeight);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }
    
    public void start() {
        java.awt.EventQueue.invokeLater(() -> {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int sizeWidth = 980;
            int sizeHeight = 600;
            int locationX = (screenSize.width - sizeWidth) / 2;
            int locationY = (screenSize.height - sizeHeight) / 2;
            javax.swing.JFrame frame = new VisualGrossBook(incomeList,conList,difList,dateList);
            frame.setBounds(locationX, locationY, sizeWidth, sizeHeight);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
        
    }
    
    public void chang() {
    offsetDiagram -= 0.01;
    opacityDiagram += 0.004;
    }
       
    public void paint2(Graphics2D gr) {
    Graphics2D g2 = (Graphics2D) gr;        
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    int width = getWidth();
    int height = getHeight();
    g2.setColor(new Color(214,217,223));
    g2.fillRect(0, 0, width, height);
    
    for (int i = 0; i < dateList.length; i++) {
        g2.setColor(colorList.get(i));
        g2.fillRect(width/30, (height/(dateList.length+1))*(i+1), width/50, width/50);
        g2.setColor(Color.BLACK);
        g2.drawString(" - "+dateList[i],width/17,(height/(dateList.length+1))*(i+1) + height/45);
    }
    
    paintDiagram(g2, incomeList, 0, offsetDiagram, "Доход", opacityDiagram, parts, partsPercent);
    paintDiagram(g2, conList, 1, offsetDiagram, "Расход" , opacityDiagram, parts, partsPercent);
    paintDiagram(g2, difList, 2, offsetDiagram, "Прибыль", opacityDiagram, parts, partsPercent);

               			
                   
    }
    
    @Override
    public void paint(Graphics g) {      
    BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = bufferedImage.createGraphics();
    paint2(g2d);
    Graphics2D g2dComponent = (Graphics2D) g;
    g2dComponent.drawImage(bufferedImage, null, 0, 0);  
    }
   
    public void paintDiagram(Graphics2D g2, float[] list, int num, float offsetY, String label, float opacity, int partsD, float partsPercentD) {
        
        int width = getWidth();
        int height = getHeight();
        float listTmp = 0;
        
        for (float f : list) {
            listTmp+= f;
        }    
        

        g2.setComposite( AlphaComposite.SrcOver.derive( opacity ) );
        
        int tmpSum = 0,tmpCur;
        for (int i = 0; i < partsD-1; i++) {
            g2.setColor(colorList.get(i));
            tmpCur =(int)(360*list[i]/listTmp);
            if ((i != list.length-1)&&(tmpSum+tmpCur < 360 )){
            g2.fillArc(width/5+(width/4)*num, (int) ((height/3)*(1+offsetY)), width/5, width/5, tmpSum, tmpCur);
            } else  {
                g2.fillArc(width/5+(width/4)*num, (int) ((height/3)*(1+offsetY)), width/5, width/5, tmpSum, tmpCur+(360-(tmpSum+tmpCur)));
            }
            tmpSum+=tmpCur;
        }
        
        if ((partsD != 0)) {
        g2.setColor(colorList.get(partsD-1));
        tmpCur =(int)(360*list[partsD-1]/listTmp*partsPercentD);
        if ((partsD-1 != list.length-1)&&(tmpSum+tmpCur < 360 )) {       
        g2.fillArc(width/5+(width/4)*num, (int) ((height/3)*(1+offsetY)), width/5, width/5, tmpSum, tmpCur);
        } else {
            tmpCur =(int)((360-tmpSum)*partsPercentD);
            g2.fillArc(width/5+(width/4)*num, (int) ((height/3)*(1+offsetY)), width/5, width/5, tmpSum, tmpCur);
        }
        
        }
        
        g2.setColor(Color.BLACK);
        g2.drawArc(width/5+(width/4)*num, (int) ((height/3)*(1+offsetY)), width/5, width/5, 0, 360);
        
        g2.setComposite( AlphaComposite.SrcOver.derive( 1.0f ) );
        
        Font currentFont = g2.getFont();
        Font newFont = currentFont.deriveFont(width/30F);
        g2.setFont(newFont); 
        g2.drawString(label,width/5+width/18+(width/4)*num-(width/80)*num,height/4+height/20 );
        g2.setFont(currentFont); 
        
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}




