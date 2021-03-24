package Dao;


import Conexao.Conectar;
import Conexao.Conectar2;
import Model.ModelVenda;
import Conexao.ConexaoMySql;
import Conexao.ConexaoMySql2;
import View.GerarNumero;
import View.ViewPdv555;
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
* @author monet 
*/   
public class DaoVenda extends ConexaoMySql {  
    static Conectar cc = new Conectar();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;
    
    
    /**
    * grava venda
    * @param pModelvenda
    * return int
    */
    public int salvarvendaDAO(ModelVenda pModelvenda){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_venda ("
                    + "pk_id_venda, "
                    + "fk_cliente, "
                    + "fk_usuario, "
                    + "data, "   
                    + "hora, "
                    + "valor_liquido, "
                    + "valor_bruto, "
                    + "valor_desconto, "
                    + "tipo_pagamento, " 
                    + "data_relatorio, "
                    + "ano "
              
                + ") VALUES ("
                    + "'" + pModelvenda.getIdVenda() + "',"
                    + "'" + pModelvenda.getCliente() + "',"
                    + "'" + pModelvenda.getUsuario() + "',"
                    + "'" + pModelvenda.getData() + "',"
                    + "'" + pModelvenda.getHora() + "',"                       
                    + "'" + pModelvenda.getValorLiquido() + "',"
                    + "'" + pModelvenda.getValorBruto() + "',"
                    + "'" + pModelvenda.getValorDesconto() + "',"
                    + "'" + pModelvenda.getPagamento() + "',"
                    + "'" + pModelvenda.getData_relatorio() + "',"
                    + "'" + pModelvenda.getAno()+ "'"
                  
                   
                   
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera venda
    * @param pIdVenda
    * return Modelvenda
    */
    public ModelVenda getvendaDAO(int pIdVenda){
        ModelVenda modelvenda = new ModelVenda();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                   + "pk_id_venda,"
                    + "fk_cliente," 
                    + "fk_usuario,"
                    + "data,"
                    + "hora,"
                    + "valor_liquido,"
                    + "valor_bruto,"
                    + "valor_desconto,"
                    + "tipo_pagamento,"
                    + "data_relatorio,"
                    + "ano "
           
                    + " FROM"
                     + " tbl_venda"
                    + " WHERE"
                     + " pk_id_venda = '" + pIdVenda + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelvenda.setIdVenda(this.getResultSet().getInt(1));
                modelvenda.setCliente(this.getResultSet().getInt(2));
                modelvenda.setUsuario(this.getResultSet().getInt(3));
                modelvenda.setData(this.getResultSet().getString(4));
                modelvenda.setHora(this.getResultSet().getString(5));
                modelvenda.setValorLiquido(this.getResultSet().getDouble(6));
                modelvenda.setValorBruto(this.getResultSet().getDouble(7));
                modelvenda.setValorDesconto(this.getResultSet().getDouble(8));
                modelvenda.setPagamento(this.getResultSet().getString(9));
                modelvenda.setData_relatorio(this.getResultSet().getString(10));
                modelvenda.setAno(this.getResultSet().getString(11));
             
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelvenda;
    }

    /**
    * recupera uma lista de venda
        * return ArrayList
    */
    public ArrayList<ModelVenda> getListavendaDAO(){
        ArrayList<ModelVenda> listamodelvenda = new ArrayList();
        ModelVenda modelvenda = new ModelVenda();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_venda,"
                    + "fk_cliente," 
                    + "fk_usuario,"
                    + "data,"
                    + "hora,"
                    + "valor_liquido," 
                    + "valor_bruto,"
                    + "valor_desconto,"
                    + "tipo_pagamento,"
                    + "data_relatorio,"
                    + "ano"
                   
                 + " FROM"
                     + " tbl_venda"
                + ";"
            );

            while(this.getResultSet().next()){
                modelvenda = new ModelVenda();
                modelvenda.setIdVenda(this.getResultSet().getInt(1));
                modelvenda.setCliente(this.getResultSet().getInt(2));
                modelvenda.setUsuario(this.getResultSet().getInt(3));
                modelvenda.setData(this.getResultSet().getString(4));
                modelvenda.setHora(this.getResultSet().getString(5));
                modelvenda.setValorLiquido(this.getResultSet().getDouble(6));
                modelvenda.setValorBruto(this.getResultSet().getDouble(7));
                modelvenda.setValorDesconto(this.getResultSet().getDouble(8));
                modelvenda.setPagamento(this.getResultSet().getString(9));
                modelvenda.setData_relatorio(this.getResultSet().getString(10));
                modelvenda.setAno(this.getResultSet().getString(11));
               
                listamodelvenda.add(modelvenda);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelvenda;
    }

    /**
    * atualiza venda
    * @param pModelvenda
    * return boolean
    */
    public boolean atualizarvendaDAO(ModelVenda pModelvenda){
    try {
    this.conectar();
    return this.executarUpdateDeleteSQL("UPDATE tbl_venda SET "
                  
    + "fk_cliente = '" + pModelvenda.getCliente() + "',"
    + "fk_usuario = '" + pModelvenda.getUsuario() + "',"
    + "data = '" + pModelvenda.getData() + "',"
    + "hora = '" + pModelvenda.getHora() + "',"
    + "valor_liquido = '" + pModelvenda.getValorLiquido() + "',"
    + "valor_bruto = '" + pModelvenda.getValorBruto() + "',"
    + "valor_desconto = '" + pModelvenda.getValorDesconto() + "',"
    + "tipo_pagamento = '" + pModelvenda.getPagamento() + "',"
    + "data_relatorio = '" + pModelvenda.getData_relatorio() + "',"
    + "ano = '" + pModelvenda.getAno() + "'"
          
    + " WHERE pk_id_venda = '" + pModelvenda.getIdVenda() + "'"
    + ";"
    );
    }catch(Exception e){
    e.printStackTrace();
    return false; 
    }finally{
    this.fecharConexao();
    }
    }

    /**
    * exclui venda
    * @param pIdVenda
    * return boolean
    */
    public boolean excluirvendaDAO(int pIdVenda){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_venda "
                + " WHERE "
                    + "pk_id_venda = '" + pIdVenda + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    
    public static int eliminaTodos() { 
        
        int rsu = 0;
        String sql = ModelVenda.ELIMINAR_TUDO;
        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
    
    
    
    public static void numeros() { 
        int j;
        int cont = 1;
        String num = ""; 
        String c = "";
        String SQL = "SELECT MAX(id) FROM tbl_gera_id";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                ViewPdv555.tfVenda.setText("00000001");
            } else {
                j = Integer.parseInt(c);
                GerarNumero gen = new GerarNumero();
                gen.gerar(j);
                ViewPdv555.tfVenda.setText(gen.serie());

            }

        } catch (SQLException ex) {
            Logger.getLogger(ViewPdv555.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   
} 