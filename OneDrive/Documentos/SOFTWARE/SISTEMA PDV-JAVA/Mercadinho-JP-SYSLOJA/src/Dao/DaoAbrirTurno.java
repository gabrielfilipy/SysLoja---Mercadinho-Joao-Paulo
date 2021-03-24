/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexao.Conectar;
import Conexao.Conectar2;
import Conexao.ConexaoMySql;
import Conexao.ConexaoMySql2;
import Model.ModelAbrirTurno; 
import View.GerarNumero;
import View.ViewAbrirTurnoo;
import View.ViewFecharTurno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger; 
/**
 *
 * @author Monet
 */ 
 public class DaoAbrirTurno extends ConexaoMySql{
      static Conectar cc = new Conectar();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;
    //SALVAR
    public int SalvarAbrirTurnoDao(ModelAbrirTurno modelAbrirTurno){
    try {
    this.conectar();
    return this.insertSQL("INSERT INTO tbl_abrir_turno ("           
    + "fk_usuario,"
    + "nome,"
    + "data,"
    + "hora,"
    + "valor,"
    + "estado "
    + ") VALUES ("
    + "'" +modelAbrirTurno.getId() +"',"
    + "'" +modelAbrirTurno.getNome() +"',"
    + "'" +modelAbrirTurno.getData() +"',"
    + "'" +modelAbrirTurno.getHora() +"',"
    + "'" +modelAbrirTurno.getValor() +"',"
    + "'" +modelAbrirTurno.getEstado() +"'"
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
    
    public boolean excluirUsuarioDao(int idUsuario){
    try {
    this.conectar();
    return this.executarUpdateDeleteSQL("DELETE FROM tbl_usuario WHERE pk_id_usuario = '"+idUsuario+"'");
    } catch (Exception e) {
    e.printStackTrace();
    return false;
    }finally{ 
    this.fecharConexao();
    }   
    }
    
   
   //RETORNAR
   
   public ModelAbrirTurno retornarAbrirTurnoDao (int idUsuario){
   ModelAbrirTurno modelAbrirTurno = new ModelAbrirTurno();
   try {
   this.conectar();  
   this.executarSQL(""
   + "SELECT "
   + "fk_usuario, "
   + "nome, "
   + "data, "
   + "hora, "
   + "valor, "
   + "pk_id_abrir_turno, "
   + "fk_turno "
   + "FROM tbl_abrir_turno WHERE fk_usuario = '"+idUsuario+"'");
   while(this.getResultSet().next()){
   modelAbrirTurno.setId(getResultSet().getInt(1));
   modelAbrirTurno.setNome(getResultSet().getString(2));
   modelAbrirTurno.setData(getResultSet().getString(3));
   modelAbrirTurno.setHora(getResultSet().getString(4)); 
   modelAbrirTurno.setValor(getResultSet().getDouble(5));
   modelAbrirTurno.setPk_id_abrir_turno(getResultSet().getInt(6));
   modelAbrirTurno.setFkTurno(getResultSet().getInt(7));
   }
   } catch (Exception e) {
   }finally{
   this.fecharConexao();
   } return modelAbrirTurno; 
   }
   
  
   
  // public static String LISTAR = "SELECT * FROM tbl_usuario ORDER BY nome";
   
   
   
   //RETORNAR LISTA
   
   public ArrayList<ModelAbrirTurno>retornarListaDeUsuario(){
   ArrayList<ModelAbrirTurno> lista = new ArrayList<>();
   ModelAbrirTurno mod = new ModelAbrirTurno();
   try { 
   this.conectar();
   this.executarSQL("SELECT "
   + "fk_usuario, " 
   + "nome, "
   + "data, "  
   + "hora, "
   + "valor, "
   + "pk_id_abrir_turno, "
   + "estado, "
   + "fk_turno "
   
   
   + "FROM tbl_abrir_turno;"
   + "");
   while(getResultSet().next()){
   mod = new ModelAbrirTurno();
   mod.setId(this.getResultSet().getInt(1));
   mod.setNome(this.getResultSet().getString(2));
    mod.setData(this.getResultSet().getString(3));
     mod.setHora(this.getResultSet().getString(4));
      mod.setValor(this.getResultSet().getDouble(5)); 
      mod.setPk_id_abrir_turno(this.getResultSet().getInt(6));
      mod.setEstado(this.getResultSet().getString(7));
       mod.setFkTurno(this.getResultSet().getInt(8));
   lista.add(mod);
   
   }

   
   } catch (Exception e) {
   e.printStackTrace();
   }finally{
   this.fecharConexao();
   } 
   return lista;
   } 
     
    
    //ALTERAR
   public boolean alterarDao (ModelAbrirTurno mod){
   try {
   this.conectar();
   return this.executarUpdateDeleteSQL("UPDATE tbl_abrir_turno SET "
   + "fk_usuario = '"+mod.getId()+"',"
   + "nome = '"+mod.getNome()+"',"
   + "data = '"+mod.getData()+"',"
   + "hora = '"+mod.getHora()+"',"           
   + "valor = '"+mod.getValor()+"',"
   + "pk_id_abrir_turno = '"+mod.getPk_id_abrir_turno()+"',"
   + "estado = '"+mod.getEstado()+"',"
   + "fk_turno = '"+mod.getFkTurno()+"'"
   
  
   + "WHERE pk_id_abrir_turno = '"+mod.getPk_id_abrir_turno()+"'"
   );
   } catch (Exception e) {
   e.printStackTrace();
   return false;
   }finally{
   this.fecharConexao();
   }  
   }
    public static void numeros() {
        int j;
        int cont = 1;
        String num = "";
        String c = "";
        String SQL = "SELECT MAX(fk_turno) FROM tbl_abrir_turno";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                ViewAbrirTurnoo.numFac.setText("00000001");
            } else {
                j = Integer.parseInt(c);
                GerarNumero gen = new GerarNumero();
                gen.gerar(j);
                ViewAbrirTurnoo.numFac.setText(gen.serie());

            }

        } catch (SQLException ex) {
            Logger.getLogger(ViewAbrirTurnoo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public static void numeros2() {
        int j;
        int cont = 1;
        String num = "";
        String c = "";
        String SQL = "SELECT MAX(fk_turno) FROM tbl_abrir_turno";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                ViewFecharTurno.tfNovoTurno.setText("00000001");
            } else {
                j = Integer.parseInt(c);
                GerarNumero gen = new GerarNumero();
                gen.gerar(j);
                 ViewFecharTurno.tfNovoTurno.setText(gen.serie());

            }

        } catch (SQLException ex) {
            Logger.getLogger(ViewFecharTurno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   }
