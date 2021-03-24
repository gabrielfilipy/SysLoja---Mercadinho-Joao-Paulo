/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.ModelCliente;
import Conexao.ConexaoMySql;
import java.util.ArrayList; 
/**
 *
 * @author Monet
 */
 public class DaoCliente extends ConexaoMySql{
    //SALVAR
   public int SalvarDao(ModelCliente mod){
   try {
   this.conectar();
   return this.insertSQL("INSERT INTO tbl_clinte ("           
   + "nome, "
   + "nascimento, "
   + "bairro, "
   + "rua, "
   + "cidade, "
   + "rg, "
   + "telefone, "
   + "numero_casa "
   + ") VALUES ("
   + "'" +mod.getNome() +"',"
   + "'" +mod.getNascimento() +"',"
   + "'" +mod.getBairro() +"',"
   + "'" +mod.getRua() +"',"        
   + "'" +mod.getCidade() +"',"
   + "'" +mod.getRg() +"',"   
   + "'" +mod.getTelefone() +"',"
   + "'" +mod.getNumero_casa() +"'"  
   
    + ");"
    );
    } catch (Exception e) {
    e.printStackTrace();
    return 0;
    }finally{
    this.fecharConexao();
    }
    }
    public static String LISTAR = "SELECT * FROM tbl_clinte ORDER BY nome";

    //EXCLUIR  
    public boolean excluirDao(int id){
    try {
    this.conectar();
    return this.executarUpdateDeleteSQL("DELETE FROM tbl_clinte WHERE pk_id_cliente = '"+id+"'");
    } catch (Exception e) {
    e.printStackTrace();
    return false;
    }finally{ 
    this.fecharConexao();
    }   
    }
    
    
    
    //ALTERAR
   public boolean alterarDao (ModelCliente mod){
   try {
   this.conectar();
   return this.executarUpdateDeleteSQL("UPDATE tbl_clinte SET "
   + "nome = '"+mod.getNome()+"',"
   + "nascimento = '"+mod.getNascimento()+"',"
   + "bairro = '"+mod.getBairro()+"',"
   + "rua = '"+mod.getRua()+"',"          
   + "cidade = '"+mod.getCidade()+"',"
   + "rg = '"+mod.getRg()+"',"
   + "telefone = '"+mod.getTelefone()+"',"
   + "numero_casa = '"+mod.getNumero_casa()+"'"
   + "WHERE pk_id_cliente = '"+mod.getId()+"'"
   );
   } catch (Exception e) {
   e.printStackTrace();
   return false;
   }finally{
   this.fecharConexao();
   }  
   }
   
   //RETORNAR
 
   
   public ModelCliente retornarDao (int id){
   ModelCliente mod = new ModelCliente();
   try {
   this.conectar();
   this.executarSQL(""
   + "SELECT "
   + "pk_id_cliente, "
   + "nome, "
   + "nascimento, "
   + "bairro, "
   + "rua, "
   + "cidade, "
   + "rg, "
   + "telefone, "
   + "numero_casa "
   + "FROM tbl_clinte WHERE pk_id_cliente = '"+id+"'");
   while(this.getResultSet().next()){
   mod = new ModelCliente();
   mod.setId(getResultSet().getInt(1));
   mod.setNome(getResultSet().getString(2));
   mod.setNascimento(getResultSet().getString(3));
   mod.setBairro(getResultSet().getString(4));

   mod.setRua(getResultSet().getString(5));
   mod.setCidade(getResultSet().getString(6));
   mod.setRg(getResultSet().getString(7));
   mod.setTelefone(getResultSet().getString(8));
   mod.setNumero_casa(getResultSet().getString(9));
   }
   } catch (Exception e) {
   }finally{
   this.fecharConexao();
   } return mod;
   }
 
    //RETORNAR POR NOME
 
   
   public ModelCliente retornarDao (String nome){
   ModelCliente mod = new ModelCliente();
   try {
   this.conectar();
   this.executarSQL(""
   + "SELECT "
   + "pk_id_cliente, "
   + "nome, "
   + "nascimento, "
   + "bairro, "
   + "rua, "
   + "cidade, " 
   + "rg, "
   + "telefone, "
   + "numero_casa "
   + "FROM tbl_clinte WHERE nome = '"+nome+"'");
   while(this.getResultSet().next()){
   mod.setId(getResultSet().getInt(1));
   mod.setNome(getResultSet().getString(2));
   mod.setNascimento(getResultSet().getString(3));
   mod.setBairro(getResultSet().getString(4));

   mod.setRua(getResultSet().getString(5));
   mod.setCidade(getResultSet().getString(6));
   mod.setRg(getResultSet().getString(7));
   mod.setTelefone(getResultSet().getString(8));
   mod.setNumero_casa(getResultSet().getString(9));
   }
   } catch (Exception e) {
   }finally{
   this.fecharConexao();
   } return mod;
   }
   //RETORNAR LISTA
   
   public ArrayList<ModelCliente>retornarListaDeUsuario(){
   ArrayList<ModelCliente> lista = new ArrayList<>();
   ModelCliente mod = new ModelCliente();
   try {
   this.conectar();
   this.executarSQL("SELECT "
   + "pk_id_cliente, "
   + "nome, "
   + "nascimento, "
   + "bairro, "
   + "rua, "
   + "cidade, "
   + "rg, "
   + "telefone, " 
   + "numero_casa "
   + "FROM tbl_clinte WHERE pk_id_cliente > 3 ORDER BY nome;"
   + "");
   while(getResultSet().next()){
   mod = new ModelCliente();
   mod.setId(this.getResultSet().getInt(1));
   mod.setNome(this.getResultSet().getString(2));
   mod.setNascimento(this.getResultSet().getString(3));
   mod.setBairro(this.getResultSet().getString(4));   
   mod.setRua(this.getResultSet().getString(5));
   mod.setCidade(this.getResultSet().getString(6));
   mod.setRg(this.getResultSet().getString(7));
   mod.setTelefone(this.getResultSet().getString(8));
   mod.setNumero_casa(this.getResultSet().getString(9));
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
