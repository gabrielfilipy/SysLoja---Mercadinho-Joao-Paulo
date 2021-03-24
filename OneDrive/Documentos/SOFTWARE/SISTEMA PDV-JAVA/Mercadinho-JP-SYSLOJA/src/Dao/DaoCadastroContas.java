/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.ModelCadastroContas;
import Conexao.ConexaoMySql;
import java.util.ArrayList;
/**
 *
 * @author Monet
 */
 public class DaoCadastroContas extends ConexaoMySql{
    //SALVAR
    public int SalvarDao(ModelCadastroContas mod){
    try {
    this.conectar();
    return this.insertSQL("INSERT INTO tbl_cadastrocontas ("           
    + "conta,"
    + "data,"
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
    return this.executarUpdateDeleteSQL("DELETE FROM tbl_cadastrocontas WHERE pk_id_contas = '"+idUsuario+"'");
    } catch (Exception e) {
    e.printStackTrace();
    return false;
    }finally{ 
    this.fecharConexao();
    }   
    }
    
    //ALTERAR
    
   public boolean alterarDao (ModelCadastroContas mod){
   try {
   this.conectar();
   return this.executarUpdateDeleteSQL("UPDATE tbl_cadastrocontas SET "
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
   
   public ModelCadastroContas retornarDao (int id){
   ModelCadastroContas mod = new ModelCadastroContas();
   try {
   this.conectar();
   this.executarSQL(""
   + "SELECT "
   + "pk_id_contas, "
   + "conta, "
   + "data, "
   + "valor "
   + "FROM tbl_cadastrocontas WHERE pk_id_contas = '"+id+"'");
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
   
   public ArrayList<ModelCadastroContas>retornarListaDao(){
   ArrayList<ModelCadastroContas> lista = new ArrayList<>();
   ModelCadastroContas mod = new ModelCadastroContas();
   try {
   this.conectar();
   this.executarSQL("SELECT "
   + "pk_id_contas, "
   + "conta, "
   + "data, "
   + "valor "
   + "FROM tbl_cadastrocontas ORDER BY conta;"
   + "");
   while(getResultSet().next()){
   mod = new ModelCadastroContas();
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
