/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.ModelBairro;
import Conexao.ConexaoMySql;
import java.util.ArrayList; 
/** 
 *
 * @author Monet
 */
 public class DaoBairro extends ConexaoMySql{
    //SALVAR
   public int SalvarDao(ModelBairro mod){
   try {
   this.conectar();
   return this.insertSQL("INSERT INTO tbl_bairro ("           
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
    return this.executarUpdateDeleteSQL("DELETE FROM tbl_bairro WHERE pk_id_bairro = '"+id+"'");
    } catch (Exception e) {
    e.printStackTrace();
    return false;
    }finally{ 
    this.fecharConexao();
    }   
    }
    
    
    
    //ALTERAR
   public boolean alterarDao (ModelBairro mod){
   try {
   this.conectar();
   return this.executarUpdateDeleteSQL("UPDATE tbl_bairro SET "
   + "nome = '"+mod.getNome()+"',"
   + "cep = '"+mod.getCep()+"'" 
   + "WHERE pk_id_bairro = '"+mod.getId()+"'"
   );
   } catch (Exception e) {
   e.printStackTrace();
   return false;
   }finally{
   this.fecharConexao();
   }  
   }
   
   //RETORNAR
  
   
   public ModelBairro retornarDao (int id){
   ModelBairro mod = new ModelBairro();
   try {
   this.conectar();
   this.executarSQL(""
   + "SELECT "
   + "pk_id_bairro, "
   + "nome, "
   + "cep "
   + "FROM tbl_bairro WHERE pk_id_bairro = '"+id+"'");
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
   
   public ArrayList<ModelBairro>retornarLista(){
   ArrayList<ModelBairro> lista = new ArrayList<>();
   ModelBairro mod = new ModelBairro();
   try {
   this.conectar();
   this.executarSQL("SELECT "
   + "pk_id_bairro, "
   + "nome, "
   + "cep "
   + "FROM tbl_bairro ORDER BY nome;"
   + "");
   while(getResultSet().next()){
   mod = new ModelBairro();
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
