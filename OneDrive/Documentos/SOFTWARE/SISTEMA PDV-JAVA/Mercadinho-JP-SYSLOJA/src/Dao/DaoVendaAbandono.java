package Dao;


import Conexao.Conectar;
import Conexao.Conectar2;
import Conexao.ConexaoMySql;
import Conexao.ConexaoMySql2;
import Model.ModelVendaAbandono;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
/**
*
* @author monet 
*/
public class DaoVendaAbandono extends ConexaoMySql {
static Conectar cc = new Conectar();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;
    /**
    * grava venda
    * @param pModelvenda
    * return int
    */
    public int salvarvendaDAO(ModelVendaAbandono pModelvenda){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_venda_abandono ("
                    + "fk_cliente, "
                    + "fk_usuario, "
                    + "data, "
                    + "hora, "
                    + "valor_liquido, "
                    + "valor_bruto, "
                    + "valor_desconto, "
                        + "tipo_pagamento, "
                        + "pk_id_venda "
                    
                + ") VALUES ("
                    + "'" + pModelvenda.getCliente() + "',"
                    + "'" + pModelvenda.getUsuario() + "',"
                    + "'" + pModelvenda.getData() + "',"
                    + "'" + pModelvenda.getHora() + "',"                       
                    + "'" + pModelvenda.getValorLiquido() + "',"
                    + "'" + pModelvenda.getValorBruto() + "',"
                    + "'" + pModelvenda.getValorDesconto() + "',"
                    + "'" + pModelvenda.getPagamento() + "',"
                    + "'" + pModelvenda.getIdVenda() + "'"
                   
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
    public ModelVendaAbandono getvendaDAO(int pIdVenda){
        ModelVendaAbandono modelvenda = new ModelVendaAbandono();
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
                        + "tipo_pagamento"
                    + " FROM"
                     + " tbl_venda_abandono"
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
    public ArrayList<ModelVendaAbandono> getListavendaDAO(){
        ArrayList<ModelVendaAbandono> listamodelvenda = new ArrayList();
        ModelVendaAbandono modelvenda = new ModelVendaAbandono();
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
                    + "tipo_pagamento"
                 + " FROM"
                     + " tbl_venda_abandono"
                + ";"
            );

            while(this.getResultSet().next()){
                modelvenda = new ModelVendaAbandono();
                modelvenda.setIdVenda(this.getResultSet().getInt(1));
                modelvenda.setCliente(this.getResultSet().getInt(2));
                modelvenda.setUsuario(this.getResultSet().getInt(3));
                modelvenda.setData(this.getResultSet().getString(4));
                modelvenda.setHora(this.getResultSet().getString(5));
                modelvenda.setValorLiquido(this.getResultSet().getDouble(6));
                modelvenda.setValorBruto(this.getResultSet().getDouble(7));
                modelvenda.setValorDesconto(this.getResultSet().getDouble(8));
                 modelvenda.setPagamento(this.getResultSet().getString(9));
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
    public boolean atualizarvendaDAO(ModelVendaAbandono pModelvenda){
    try {
    this.conectar();
    return this.executarUpdateDeleteSQL("UPDATE tbl_venda_abandono SET "
                  
    + "fk_cliente = '" + pModelvenda.getCliente() + "',"
    + "fk_usuario = '" + pModelvenda.getUsuario() + "',"
    + "data = '" + pModelvenda.getData() + "',"
    + "hora = '" + pModelvenda.getHora() + "',"
    + "valor_liquido = '" + pModelvenda.getValorLiquido() + "',"
    + "valor_bruto = '" + pModelvenda.getValorBruto() + "',"
    + "valor_desconto = '" + pModelvenda.getValorDesconto() + "',"
    + "tipo_pagamento = '" + pModelvenda.getPagamento() + "'"
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
                "DELETE FROM tbl_venda_abandono "
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
        String sql = ModelVendaAbandono.ELIMINAR_TUDO;
        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
}