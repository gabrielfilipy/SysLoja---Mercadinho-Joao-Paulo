/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao; 
import Conexao.ConexaoMySql;
import Conexao.ConexaoMySql2;
import Model.ModelId;
import java.util.ArrayList; 
/**  
 *
 * @author Monet
 */
 public class DaoId extends ConexaoMySql2{
    //SALVAR
   public int SalvarDao(ModelId mod){
   try {
   this.conectar();
   return this.insertSQL("INSERT INTO tbl_gera_id ("           
   + "id, "
   + "numero "
   + ") VALUES ("
   + "'" +mod.getId() +"',"
   + "'" +mod.getNumero() +"'" 
   
    + ");"   
    );
    } catch (Exception e) {
    e.printStackTrace();
    return 0;
    }finally{
    this.fecharConexao();
    }
    }
    
    //EXCLUIR  
    public boolean excluirDao(int id){
    try {
    this.conectar();
    return this.executarUpdateDeleteSQL("DELETE FROM tbl_cidade WHERE pk_id_cidade = '"+id+"'");
    } catch (Exception e) {
    e.printStackTrace();
    return false;
    }finally{ 
    this.fecharConexao();
    }   
    }
    
    public ModelId retornarDao (int id){
   ModelId mod = new ModelId();
   try {
   this.conectar();
   this.executarSQL(""
   + "SELECT "
   + "fk_turno "
  
   + "FROM tbl_abrir_turno WHERE pk_id_abrir_turno = '"+id+"'");
   while(this.getResultSet().next()){
   mod.setNumero(getResultSet().getInt(1));
   

   }
   } catch (Exception e) {
   }finally{
   this.fecharConexao();
   } return mod;
   }
   }
