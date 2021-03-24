/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.ModelDepartamento;
import Conexao.ConexaoMySql;
import java.util.ArrayList; 
/** 
 *
 * @author Monet
 */
 public class DaoDepartamento extends ConexaoMySql{
    //SALVAR
   public int SalvarDao(ModelDepartamento mod){
   try {
   this.conectar();
   return this.insertSQL("INSERT INTO tbl_departamento ("           
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
    return this.executarUpdateDeleteSQL("DELETE FROM tbl_departamento WHERE pk_id_departamento = '"+id+"'");
    } catch (Exception e) {
    e.printStackTrace();
    return false;
    }finally{ 
    this.fecharConexao();
    }   
    }
    
    
    
    //ALTERAR
   public boolean alterarDao (ModelDepartamento mod){
   try {
   this.conectar();
   return this.executarUpdateDeleteSQL("UPDATE tbl_departamento SET "
   + "nome = '"+mod.getNome()+"'"
   + "WHERE pk_id_departamento = '"+mod.getId()+"'"
   );
   } catch (Exception e) {
   e.printStackTrace();
   return false;
   }finally{
   this.fecharConexao();
   }  
   }
   
   //RETORNAR
  
   
   public ModelDepartamento retornarDao (int id){
   ModelDepartamento mod = new ModelDepartamento();
   try {
   this.conectar();
   this.executarSQL(""
   + "SELECT "
   + "pk_id_departamento, "
   + "nome "
   + "FROM tbl_departamento WHERE pk_id_departamento = '"+id+"'");
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
   
   public ArrayList<ModelDepartamento>retornarLista(){
   ArrayList<ModelDepartamento> lista = new ArrayList<>();
   ModelDepartamento mod = new ModelDepartamento();
   try {
   this.conectar();
   this.executarSQL("SELECT "
   + "pk_id_departamento, "
   + "nome "
   + "FROM tbl_departamento ORDER BY nome;"
   + "");
   while(getResultSet().next()){
   mod = new ModelDepartamento();
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
