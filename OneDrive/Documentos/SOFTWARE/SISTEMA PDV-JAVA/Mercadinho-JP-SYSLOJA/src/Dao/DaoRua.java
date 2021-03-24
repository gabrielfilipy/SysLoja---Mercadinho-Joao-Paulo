/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.ModelRua;
import Conexao.ConexaoMySql;
import java.util.ArrayList; 
/** 
 *
 * @author Monet
 */
 public class DaoRua extends ConexaoMySql{
    //SALVAR
   public int SalvarDao(ModelRua mod){
   try {
   this.conectar();
   return this.insertSQL("INSERT INTO tbl_rua ("           
   + "nome, "
   + "cep "
   + ") VALUES ("
   + "'" +mod.getNome() +"',"
   + "'" +mod.getCep() +"'" 
   
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
    return this.executarUpdateDeleteSQL("DELETE FROM tbl_rua WHERE pk_id_rua = '"+id+"'");
    } catch (Exception e) {
    e.printStackTrace();
    return false;
    }finally{ 
    this.fecharConexao();
    }   
    }
    
    
    
    //ALTERAR
   public boolean alterarDao (ModelRua mod){
   try {
   this.conectar();
   return this.executarUpdateDeleteSQL("UPDATE tbl_rua SET "
   + "nome = '"+mod.getNome()+"',"
   + "cep = '"+mod.getCep()+"'" 
   + "WHERE pk_id_rua = '"+mod.getId()+"'"
   );
   } catch (Exception e) {
   e.printStackTrace();
   return false;
   }finally{
   this.fecharConexao();
   }  
   }
   
   //RETORNAR
  
   
   public ModelRua retornarDao (int id){
   ModelRua mod = new ModelRua();
   try {
   this.conectar();
   this.executarSQL(""
   + "SELECT "
   + "pk_id_rua, "
   + "nome, "
   + "cep "
   + "FROM tbl_rua WHERE pk_id_rua = '"+id+"'");
   while(this.getResultSet().next()){
   mod.setId(getResultSet().getInt(1));
   mod.setNome(getResultSet().getString(2));
   mod.setCep(getResultSet().getString(3));

   }
   } catch (Exception e) {
   }finally{
   this.fecharConexao();
   } return mod;
   }
 
   
   //RETORNAR LISTA
   
   public ArrayList<ModelRua>retornarLista(){
   ArrayList<ModelRua> lista = new ArrayList<>();
   ModelRua mod = new ModelRua();
   try {
   this.conectar();
   this.executarSQL("SELECT "
   + "pk_id_rua, "
   + "nome, "
   + "cep "
   + "FROM tbl_rua ORDER BY nome;"
   + "");
   while(getResultSet().next()){
   mod = new ModelRua();
   mod.setId(this.getResultSet().getInt(1));
   mod.setNome(this.getResultSet().getString(2));
   mod.setCep(this.getResultSet().getString(3));
   lista.add(mod);
   
   } 
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   }
   return lista;
   }
   }
