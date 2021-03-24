/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexao.ConexaoMySql;
import Model.ModelPagarConta;
import java.util.ArrayList;
/**
 *
 * @author Monet
 */
 public class DaoPagarContas extends ConexaoMySql{
    //SALVAR
    public int SalvarDao(ModelPagarConta mod){
    try {
    this.conectar();
    return this.insertSQL("INSERT INTO  tbl_pagar_conta ("           
    + "nome,"
    + "validade,"
    + "valor"
    + ") VALUES ("
    + "'" +mod.getNome() +"',"
    + "'" +mod.getData() +"',"
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
    
    //EXCLUIR
    
    public boolean excluirDao(int idUsuario){
    try {
    this.conectar();
    return this.executarUpdateDeleteSQL("DELETE FROM  tbl_pagar_conta WHERE pk_id_contas = '"+idUsuario+"'");
    } catch (Exception e) {
    e.printStackTrace();
    return false;
    }finally{ 
    this.fecharConexao();
    }    
    }
    
    //ALTERAR
    
   public boolean alterarDao (ModelPagarConta mod){
   try {
   this.conectar();
   return this.executarUpdateDeleteSQL("UPDATE  tbl_pagar_conta SET "
   + "conta = '"+mod.getNome()+"',"
   + "data = '"+mod.getData()+"',"
   + "valor = '"+mod.getValor()+"'"
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
   
   public ModelPagarConta retornarDao (int id){
   ModelPagarConta mod = new ModelPagarConta();
   try {
   this.conectar();
   this.executarSQL(""
   + "SELECT "
   + "pk_id_contas, "
   + "conta, "
   + "data, "
   + "valor "
   + "FROM tbl_pagar_conta WHERE pk_id_contas = '"+id+"'");
   while(this.getResultSet().next()){
   mod.setId(getResultSet().getInt(1));
   mod.setNome(getResultSet().getString(2));
   mod.setData(getResultSet().getString(3));
   mod.setValor(getResultSet().getString(4));

   }
   } catch (Exception e) {
   }finally{
   this.fecharConexao();
   } return mod; 
   }
    
   //RETORNAR LISTA
   
   public ArrayList<ModelPagarConta>retornarListaDao(){
   ArrayList<ModelPagarConta> lista = new ArrayList<>();
   ModelPagarConta mod = new ModelPagarConta();
   try {
   this.conectar();
   this.executarSQL("SELECT "
   + "pk_id_contas, " 
   + "nome, "
   + "validade, "
   + "valor"
   + " FROM tbl_pagar_conta ORDER BY nome"
   + "");
   while(getResultSet().next()){
   mod = new ModelPagarConta();
   mod.setId(this.getResultSet().getInt(1));
   mod.setNome(this.getResultSet().getString(2));
   mod.setData(this.getResultSet().getString(3));
   mod.setValor(this.getResultSet().getString(4));
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
