/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao; 


import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/** 
 *
 * @author hugov
 */
public class Conectar2 {

    /**
     * @return the us
     */
    public static String getUs() {
        return us;
    }

    /**
     * @param aUs the us to set
     */
    public static void setUs(String aUs) {
        us = aUs;
    }
 
    /**
     * @return the pas
     */
    public static String getPas() {
        return pas;
    }
   
    /**
     * @param aPas the pas to set
     */
    public static void setPas(String aPas) {
        pas = aPas;
    }

    /**
     * @return the bd
     */
    public static String getBd() {
        return bd;
    }

    /**
     * @param aBd the bd to set
     */
    public static void setBd(String aBd) { 
        bd = aBd;
    }
    private static String us = "root";
    private static String pas = "admin";
    private static String bd = "sistem";
     Connection conect = null;

     
     //CONEXAO LOCAL
   /* public Connection conexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/pontovenda", "root", ""); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar!!" + e);
        }
        return conect;
    }   */      
           
     
     //CONEXAO HOSPEDADA     
    public Connection conexao() { 
        try {   
            Class.forName("com.mysql.jdbc.Driver");
        conect = DriverManager.getConnection("jdbc:mysql://localhost/sistem", "root", "admin");
        //conect = DriverManager.getConnection("jdbc:mysql://192.168.0.101/sistem", "cliente", "123"); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao BANCO: SERVIDOR!");
        }
        return conect;
    }          
      
     
    
    public static Connection faz_conexao() throws SQLException{ 
        try {
         Class.forName("com.mysql.jdbc.Driver");
       return DriverManager.getConnection("jdbc:mysql://localhost/sistem", "root", "admin");
       //return DriverManager.getConnection("jdbc:mysql://192.168.0.101/sistem", "cliente", "123");
    
        } catch (ClassNotFoundException e) {
            throw new SQLDataException(e.getException());
        }
    }
      
}
