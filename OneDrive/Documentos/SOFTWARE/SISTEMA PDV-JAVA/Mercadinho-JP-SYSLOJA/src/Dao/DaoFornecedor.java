/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.ModelFornecedor;
import Conexao.ConexaoMySql;
import java.util.ArrayList; 
/**
 *
 * @author Monet
 */
 public class DaoFornecedor extends ConexaoMySql{
    //SALVAR
   public int SalvarDao(ModelFornecedor mod){
   try {
   this.conectar();
   return this.insertSQL("INSERT INTO tbl_fornecedor ("           
   + "nome, "
   + "cnpj, "
   + "rua, "
   + "numero_local, "
   + "bairro, "
   + "cidade, "
   + "telefone, "
   + "email "
   + ") VALUES ("
   + "'" +mod.getNome() +"',"
   + "'" +mod.getCnpj() +"',"
   + "'" +mod.getRua() +"',"
   + "'" +mod.getNumero_local() +"',"        
   + "'" +mod.getBairro() +"',"
   + "'" +mod.getCidade() +"',"   
   + "'" +mod.getTelefone() +"',"
   + "'" +mod.getEmail() +"'"  
   
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
    return this.executarUpdateDeleteSQL("DELETE FROM tbl_fornecedor WHERE pk_id_fornecedor = '"+id+"'");
    } catch (Exception e) {
    e.printStackTrace();
    return false;
    }finally{ 
    this.fecharConexao();
    }   
    }
    
    
    
    //ALTERAR
   public boolean alterarDao (ModelFornecedor mod){
   try {
   this.conectar();
   return this.executarUpdateDeleteSQL("UPDATE tbl_fornecedor SET "
   + "nome = '"+mod.getNome()+"',"
   + "cnpj = '"+mod.getCnpj()+"',"
   + "rua = '"+mod.getRua()+"',"
   + "numero_local = '"+mod.getNumero_local()+"',"          
   + "bairro = '"+mod.getBairro()+"',"
   + "cidade = '"+mod.getCidade()+"',"
   + "telefone = '"+mod.getTelefone()+"',"
   + "email = '"+mod.getEmail()+"'"
   + "WHERE pk_id_fornecedor = '"+mod.getId()+"'"
   );
   } catch (Exception e) {
   e.printStackTrace();
   return false;
   }finally{
   this.fecharConexao();
   }  
   }
   
   //RETORNAR
 
   
   public ModelFornecedor retornarDao (int id){
   ModelFornecedor mod = new ModelFornecedor();
   try {
   this.conectar();
   this.executarSQL(""
   + "SELECT "
   + "pk_id_fornecedor, "
   + "nome, "
   + "cnpj, "
   + "rua, "
   + "numero_local, "
   + "bairro, "
   + "cidade, "
   + "telefone, "
   + "email "
   + "FROM tbl_fornecedor WHERE pk_id_fornecedor = '"+id+"'");
   while(this.getResultSet().next()){
   mod.setId(getResultSet().getInt(1));
   mod.setNome(getResultSet().getString(2));
   mod.setCnpj(getResultSet().getString(3));
   mod.setRua(getResultSet().getString(4));

   mod.setNumero_local(getResultSet().getString(5));
   mod.setBairro(getResultSet().getString(6));
   mod.setCidade(getResultSet().getString(7));
   mod.setTelefone(getResultSet().getString(8));
   mod.setEmail(getResultSet().getString(9));
   }
   } catch (Exception e) {
   }finally{
   this.fecharConexao();
   } return mod;
   }
 
   
   //RETORNAR LISTA
   
   public ArrayList<ModelFornecedor>retornarListaDao(){
   ArrayList<ModelFornecedor> lista = new ArrayList<>();
   ModelFornecedor mod = new ModelFornecedor();
   try {
   this.conectar();
   this.executarSQL("SELECT "
   + "pk_id_fornecedor, "
   + "nome, "
   + "cnpj, "
   + "rua, "
   + "numero_local, "
   + "bairro, "
   + "cidade, "
   + "telefone, "
   + "email "
   + "FROM tbl_fornecedor ORDER BY nome;"
   + "");
   while(getResultSet().next()){
   mod = new ModelFornecedor();
   mod.setId(this.getResultSet().getInt(1));
   mod.setNome(this.getResultSet().getString(2));

   mod.setCnpj(this.getResultSet().getString(3));
   mod.setRua(this.getResultSet().getString(4));
   mod.setNumero_local(this.getResultSet().getString(5));
   
   mod.setBairro(this.getResultSet().getString(6));
   mod.setCidade(this.getResultSet().getString(7));
   mod.setTelefone(this.getResultSet().getString(8));
   mod.setEmail(this.getResultSet().getString(9));
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
