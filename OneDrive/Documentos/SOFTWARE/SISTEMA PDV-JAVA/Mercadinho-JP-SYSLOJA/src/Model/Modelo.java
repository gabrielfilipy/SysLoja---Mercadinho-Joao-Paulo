/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** 
 * 
 * @author Monet
 */
public class Modelo extends AbstractTableModel{
   private ArrayList linhas =null;
   private String[] colunas=null;
   
    public Modelo(ArrayList lin, String[] col){
       setLinhas(lin);
       setColunas(col);
    }
    public ArrayList getLinhas(){
      return linhas;  
    }
    public void setLinhas(ArrayList dados){
     linhas =dados;   
    }
    
    public String[] getColunas(){
        return colunas;
    }
    
    public void setColunas(String[] nome){
        colunas=nome;
    }
    
    public int getColumnCount(){
        return colunas.length;
    }
    
    
    
    public String getColumnName(int numColumn){
        return colunas[numColumn];
    }
    
    public Object getValueat(int numLinhas, int numColunas){
    Object[] linhas = (Object[])getLinhas().get(numLinhas);
    return linhas[numColunas];
    }

   
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
