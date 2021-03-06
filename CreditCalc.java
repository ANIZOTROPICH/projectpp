package com.mycompany.mavenproject1;

import java.util.Arrays;

public class CreditCalc {
    
    public static void main(String[] args) {
        

        

System.out.println(Arrays.toString(paymentList3(1000000, 20, 36)));
          
    }
    
    public static float payment(int sum, int percentYear, int daysMonth, int daysYears){
        
        float percentMonth = ((float) percentYear/100)*((float) daysMonth/daysYears) ;
        
        float payment = sum*percentMonth;
        
        return payment;
    }
    
    public static float[] paymentList(int sum, int percentYear, int term){
        int cost = sum;
        
        float percentMonth = ((float) percentYear/100)*((float) 30/365) ;
        
        float[] paymentList = new float[term];
        
        float tmpSum = (float) sum/term;
        
        for (int i = 0; i < term; i++) {
            paymentList[i] = sum*percentMonth + tmpSum;
            sum -= cost/term;
        }
        
        return paymentList;
    }
    
    public static float[] paymentList3(int sum, int percentYear, int term){
        int cost = sum;
        
        float stav = ((float) ((float) percentYear/12)/100) ;
        
        
        
        float annuity = ((stav*(float)Math.pow(1+stav, term))/((float)Math.pow(1+stav, term)-1));
        float[] paymentList = new float[1];
        
        paymentList[0] = annuity*sum;
            
        
        return paymentList;
    }
    
    
    public static float[] paymentList2(int sum, int percentYear, String termStart, String termEnd){
        int cost = sum;
        int yearR = -1, monthR=-1, dayR=-1;
        try {
        yearR = Integer.parseInt(termEnd.substring(6,10))- Integer.parseInt(termStart.substring(6,10));
        monthR = Integer.parseInt(termEnd.substring(3,5))- Integer.parseInt(termStart.substring(3,5));
        dayR = Integer.parseInt(termEnd.substring(0,2))- Integer.parseInt(termStart.substring(0,2));

        } catch (Exception e) {
            
        }
        
        
        int term = 0;
        if (((yearR>=0)&&(monthR>=0)))
        {
            
            term += (yearR*12) + monthR;
            if (dayR>0) term +=1;
            if (dayR<0) term -=1;
        }
        
                
        
        float tmpSum = (float) sum/term;
        
        
        
        float percentMonth = ((float) percentYear/100)*((float) 30/365) ;
        
        float[] paymentList = new float[term];
        
        for (int i = 0; i < term; i++) {
            paymentList[i] =tmpSum + sum*percentMonth;
            sum -= cost/term;
        }
        
        return paymentList;
    }
    
    public static float overpayment(int sum, int percentYear, int term){
        
        float percentMonth = ((float) percentYear/100)*((float) 30/365) ;
        
        float overpayment = percentMonth*((float)(term+1)/2)*sum;
        
        return overpayment;
    }
    
    public static float sumPayment(int sum, int percentYear, int term){
        
        float sumPayment = sum+overpayment(sum, percentYear, term);
        
        return sumPayment;
    }
            
    
}
