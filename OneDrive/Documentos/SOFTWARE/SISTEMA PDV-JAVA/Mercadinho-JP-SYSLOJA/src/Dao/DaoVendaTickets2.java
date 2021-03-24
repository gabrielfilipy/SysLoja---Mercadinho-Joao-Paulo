package Dao;


import Conexao.ConexaoMySql;
import Conexao.ConexaoMySql2;
import Model.ModelVendaTickets2;

import java.util.ArrayList;
/**
*
* @author monet 
*/
public class DaoVendaTickets2 extends ConexaoMySql2 {

    /**
    * grava venda
    * @param pModelvenda
    * return int
    */
    public int salvarvendaDAO(ModelVendaTickets2 pModelvenda){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_venda_tickets2 ("
                    + "fk_venda, "
                    + "fk_cliente, "
                    + "fk_usuario, "
                    + "data, "
                    + "hora, "
                    + "valor_liquido, "
                    + "valor_bruto, "
                    + "valor_desconto, "
                    + "data_relatorio, "
                    + "data_anual, "
                    + "turno "
                    
                + ") VALUES ("
                    + "'" + pModelvenda.getIdVenda() + "',"
                    + "'" + pModelvenda.getCliente() + "',"
                    + "'" + pModelvenda.getUsuario() + "',"
                    + "'" + pModelvenda.getData() + "',"                       
                    + "'" + pModelvenda.getHora() + "',"
                    + "'" + pModelvenda.getValorLiquido()+ "',"
                    + "'" + pModelvenda.getValorBruto() + "',"
                    + "'" + pModelvenda.getValorDesconto() + "',"
                    + "'" + pModelvenda.getData_relatorio() + "',"
                    + "'" + pModelvenda.getDataAnual() + "',"
                    + "'" + pModelvenda.getTurno() + "'"
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
    public ModelVendaTickets2 getvendaDAO(int pIdVenda){
        ModelVendaTickets2 modelvenda = new ModelVendaTickets2();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                   + "fk_venda,"
                    + "fk_cliente,"
                    + "fk_usuario,"
                    + "data,"
                    + "hora,"
                    + "valor_liquido,"
                    + "valor_bruto,"
                    + "valor_desconto"
                    + " FROM"
                     + " tbl_venda_tickets2"
                    + " WHERE"
                     + " fk_venda = '" + pIdVenda + "'"
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
    public ArrayList<ModelVendaTickets2> getListavendaDAO(){
        ArrayList<ModelVendaTickets2> listamodelvenda = new ArrayList();
        ModelVendaTickets2 modelvenda = new ModelVendaTickets2();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "fk_venda,"
                    + "fk_cliente," 
                    + "fk_usuario,"
                    + "data,"
                    + "hora,"
                    + "valor_liquido,"
                    + "valor_bruto,"
                    + "valor_desconto"
                 + " FROM"
                     + " tbl_venda_tickets2"
                + ";"
            );

            while(this.getResultSet().next()){
                modelvenda = new ModelVendaTickets2();
                modelvenda.setIdVenda(this.getResultSet().getInt(1));
                modelvenda.setCliente(this.getResultSet().getInt(2));
                modelvenda.setUsuario(this.getResultSet().getInt(3));
                modelvenda.setData(this.getResultSet().getString(4));
                modelvenda.setHora(this.getResultSet().getString(5));
                modelvenda.setValorLiquido(this.getResultSet().getDouble(6));
                modelvenda.setValorBruto(this.getResultSet().getDouble(7));
                modelvenda.setValorDesconto(this.getResultSet().getDouble(8));
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
    public boolean atualizarvendaDAO(ModelVendaTickets2 pModelvenda){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_venda_tickets2 SET "
                    
                    + "fk_cliente = '" + pModelvenda.getCliente() + "',"
                    + "fk_usuario = '" + pModelvenda.getUsuario() + "',"
                    + "data = '" + pModelvenda.getData() + "',"
                    + "hora = '" + pModelvenda.getHora() + "',"
                    + "valor_liquido = '" + pModelvenda.getValorLiquido() + "',"
                    + "valor_bruto = '" + pModelvenda.getValorBruto() + "',"
                    + "valor_desconto = '" + pModelvenda.getValorDesconto() + "'"
                + " WHERE "
                    + "fk_venda = '" + pModelvenda.getIdVenda() + "'"
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
                "DELETE FROM tbl_venda_tickets2 "
                + " WHERE "
                    + "fk_venda = '" + pIdVenda + "'"
                + ";"
            ); 
        }catch(Exception e){ 
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    
     
    
    public boolean salvarListaVendaProdutoDAO(ArrayList<ModelVendaTickets2> pListaModelVendaProduto) {
    try {
            this.conectar();
            int contando = pListaModelVendaProduto.size();
            for (int i = 0; i < contando; i++) {
            this.insertSQL(
                "INSERT INTO tbl_venda_tickets2 ("
                   + "fk_venda," 
                    + "fk_cliente," 
                    + "fk_usuario,"
                    + "data,"
                    + "hora,"
                    + "valor_liquido,"
                    + "valor_bruto,"
                    + "valor_desconto,"
                    + "data_relatorio," 
                    + "data_anual,"
                     + "turno"
                + ") VALUES (" 
                    + "'" + pListaModelVendaProduto.get(i).getIdVenda() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getCliente() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getUsuario() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getData()+ "',"
                    + "'" + pListaModelVendaProduto.get(i).getHora() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getValorLiquido() + "',"             
                    + "'" + pListaModelVendaProduto.get(i).getValorBruto() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getValorDesconto() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getData_relatorio() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getDataAnual() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getTurno() + "'"
               
                + ");" 
            );
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }    
     
    }
    
    
}