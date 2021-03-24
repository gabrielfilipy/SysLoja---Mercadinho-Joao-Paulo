/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.text.DecimalFormat;

/**
 *
 * @author Monet
 */
public class Formatador {
     public String converterPontos(String pString){
     String retorno = new String();
     int tamanhoString = pString.length();
         for (int i = 0; i < tamanhoString; i++) {
         if(pString.charAt(i) == ','){
             retorno += '.';
         }else{
             retorno+= pString.charAt(i);
         }   
         } 
         return retorno;
     }
 
     public float arredondamentoValores(float pValor){
         DecimalFormat df = new DecimalFormat("#.00");
         return Float.parseFloat(this.converterPontos(df.format(pValor)));
     }
     
     //converte String para Float
     public String arredondamentoValoresFloat(float pValor){
         DecimalFormat df = new DecimalFormat("#.00");
         return this.converterPontos(df.format(pValor));
     }
     
      public String arredondamentoValoresDouble(Double pValor){
         DecimalFormat df = new DecimalFormat("#.00");
         return this.converterPontos(df.format(pValor));
     }
  
}
