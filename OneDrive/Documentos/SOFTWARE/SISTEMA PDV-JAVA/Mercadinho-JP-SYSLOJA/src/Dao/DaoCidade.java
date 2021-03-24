/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.ModelCidade;
import Conexao.ConexaoMySql;
import java.util.ArrayList; 
/** 
 *
 * @author Monet
 */
 public class DaoCidade extends ConexaoMySql{
    //SALVAR
   public int SalvarDao(ModelCidade mod){
   try {
   this.conectar();
   return this.insertSQL("INSERT INTO tbl_cidade ("           
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
    return this.executarUpdateDeleteSQL("DELETE FROM tbl_cidade WHERE pk_id_cidade = '"+id+"'");
    } catch (Exception e) {
    e.printStackTrace();
    return false;
    }finally{ 
    this.fecharConexao();
    }   
    }
    
    
    
    //ALTERAR
   public boolean alterarDao (ModelCidade mod){
   try {
   this.conectar();
   return this.executarUpdateDeleteSQL("UPDATE tbl_cidade SET "
   + "nome = '"+mod.getNome()+"',"
   + "cep = '"+mod.getCep()+"'" 
   + "WHERE pk_id_cidade = '"+mod.getId()+"'"
   );
   } catch (Exception e) {
   e.printStackTrace();
   return false;
   }finally{
   this.fecharConexao();
   }  
   }
   
   //RETORNAR
  
   
   public ModelCidade retornarDao (int id){
   ModelCidade mod = new ModelCidade();
   try {
   this.conectar();
   this.executarSQL(""
   + "SELECT "
   + "pk_id_cidade, "
   + "nome, "
   + "cep "
   + "FROM tbl_cidade WHERE pk_id_cidade = '"+id+"'");
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
   
   public ArrayList<ModelCidade>retornarLista(){
   ArrayList<ModelCidade> lista = new ArrayList<>();
   ModelCidade mod = new ModelCidade();
   try {
   this.conectar();
   this.executarSQL("SELECT "
   + "pk_id_cidade, "
   + "nome, "
   + "cep "
   + "FROM tbl_cidade ORDER BY nome;"
   + "");
   while(getResultSet().next()){
   mod = new ModelCidade();
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
