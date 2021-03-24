/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.ModelTipoContas;
import Conexao.ConexaoMySql;
import java.util.ArrayList; 
/** 
 *
 * @author Monet
 */
 public class DaoTipoContas extends ConexaoMySql{
    //SALVAR
   public int SalvarDao(ModelTipoContas mod){
   try {
   this.conectar();
   return this.insertSQL("INSERT INTO tbl_tipocontas ("           
   + "nome "
   + ") VALUES ("
   + "'" +mod.getNome() +"'"
   
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
    return this.executarUpdateDeleteSQL("DELETE FROM tbl_tipocontas WHERE pk_id_contas = '"+id+"'");
    } catch (Exception e) {
    e.printStackTrace();
    return false;
    }finally{ 
    this.fecharConexao();
    }   
    }
    
    
    
    //ALTERAR
   public boolean alterarDao (ModelTipoContas mod){
   try {
   this.conectar();
   return this.executarUpdateDeleteSQL("UPDATE tbl_tipocontas SET "
   + "nome = '"+mod.getNome()+"'"
   + "WHERE pk_id_contas = '"+mod.getId()+"'"
   );
   } catch (Exception e) {
   e.printStackTrace();
   return false;
   }finally{
   this.fecharConexao();
   }  
   }
   
   //RETORNAR
  
   
   public ModelTipoContas retornarDao (int id){
   ModelTipoContas mod = new ModelTipoContas();
   try {
   this.conectar();
   this.executarSQL(""
   + "SELECT "
   + "pk_id_contas, "
   + "nome "
   + "FROM tbl_tipocontas WHERE pk_id_contas = '"+id+"'");
   while(this.getResultSet().next()){
   mod.setId(getResultSet().getInt(1));
   mod.setNome(getResultSet().getString(2));

   }
   } catch (Exception e) {
   }finally{
   this.fecharConexao();
   } return mod;
   }
 
   
   //RETORNAR LISTA
   
   public ArrayList<ModelTipoContas>retornarLista(){
   ArrayList<ModelTipoContas> lista = new ArrayList<>();
   ModelTipoContas mod = new ModelTipoContas();
   try {
   this.conectar();
   this.executarSQL("SELECT "
   + "pk_id_contas, "
   + "nome "
   + "FROM tbl_tipocontas ORDER BY nome;"
   + "");
   while(getResultSet().next()){
   mod = new ModelTipoContas();
   mod.setId(this.getResultSet().getInt(1));
   mod.setNome(this.getResultSet().getString(2));
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
