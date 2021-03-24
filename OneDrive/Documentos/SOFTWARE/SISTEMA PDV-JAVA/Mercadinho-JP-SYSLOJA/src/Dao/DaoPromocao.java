/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Conexao.Conectar;
import Conexao.ConexaoMySql;
import Model.ModelPromocao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList; 
/**
 *
 * @author Monet
 */
 public class DaoPromocao extends ConexaoMySql{
     static Conectar cc = new Conectar();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;
    //SALVAR
   public int SalvarDao(ModelPromocao mod){
   try {
   this.conectar();
   return this.insertSQL("INSERT INTO tbl_promoção ("           
   + "apartir, "
   + "valor "
   + ") VALUES ("
   + "'" +mod.getApartir() +"',"
   + "'" +mod.getValor()+"'"
  
   
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
    return this.executarUpdateDeleteSQL("DELETE FROM tbl_promocao WHERE id = '"+id+"'");
    } catch (Exception e) {
    e.printStackTrace();
    return false;
    }finally{ 
    this.fecharConexao();
    }   
    }
    public static int eliminaTodos() {
        
        int rsu = 0; 
        String sql = ModelPromocao.ELIMINAR_TUDO;
        try {
            ps = cn.prepareStatement(sql); 
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
    
    
     //RETORNAR LISTA
   
   public ArrayList<ModelPromocao>retornarListaDeUsuario(){
   ArrayList<ModelPromocao> lista = new ArrayList<>();
   ModelPromocao mod = new ModelPromocao();
   try {
   this.conectar();
   this.executarSQL("SELECT "
   + "id, "
   + "apartir, "
   + "valor "
   + "FROM tbl_promoção"
   + "");
   while(getResultSet().next()){
   mod = new ModelPromocao();
   mod.setId(this.getResultSet().getInt(1));
   mod.setApartir(this.getResultSet().getDouble(2));
   mod.setValor(this.getResultSet().getDouble(3));
  
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
