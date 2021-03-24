/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Conexao.Conectar;
import Conexao.Conectar2;
import Conexao.ConexaoMySql;
import Conexao.ConexaoMySql2;
import Model.ModelSangria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;  
import java.util.ArrayList;

/**
 *
 * @author Monet
 */
public class DaoSangria extends ConexaoMySql{
    static Conectar cc = new Conectar();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;    
    //ALTERAR 
   public boolean alterarDao (ModelSangria mod){
   try {
   this.conectar();
   return this.executarUpdateDeleteSQL("UPDATE tbl_sangria SET "
   + "pk_id_sangria = '"+mod.getId()+"',"
   + "valor = '"+mod.getValor()+"'" 
   + "WHERE pk_id_sangria = '"+mod.getId()+"'"
   );
   } catch (Exception e) {
   e.printStackTrace();
   return false;
   }finally{
   this.fecharConexao();
   }  
   }
   
   
     //SALVAR
   public int SalvarDao(ModelSangria mod){
   try {
   this.conectar();
   return this.insertSQL("INSERT INTO tbl_sangria ("           
   + "valor "
  
   + ") VALUES ("
   + "'" +mod.getValor() +"'"
  
   
    + ");"
    );
    } catch (Exception e) {
    e.printStackTrace();
    return 0;
    }finally{
    this.fecharConexao();
    }
    }
   
   
   
   
   //RETORNAR LISTA
   
   public ArrayList<ModelSangria>retornarLista(){
   ArrayList<ModelSangria> lista = new ArrayList<>();
   ModelSangria mod = new ModelSangria();
   try {
   this.conectar();
   this.executarSQL("SELECT "
   + "pk_id_sangria, "
   + "valor "

   + "FROM tbl_sangria;"
   + "");
   while(getResultSet().next()){
   mod = new ModelSangria();
   mod.setId(this.getResultSet().getInt(1));
   mod.setValor(this.getResultSet().getDouble(2));
  
   lista.add(mod);
   
   } 
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return lista;
   }
    
    public static int eliminaTodos() {
        
        int rsu = 0;
        String sql = ModelSangria.ELIMINAR_TUDO;
        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
   
}
