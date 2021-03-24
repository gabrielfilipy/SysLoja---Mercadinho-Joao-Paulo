package Dao;


import Conexao.ConexaoMySql;
import Conexao.ConexaoMySql2;
import Model.ModelVendaCartao2;
import java.util.ArrayList;
/**
*
* @author monet 
*/
public class DaoVendaCartao2 extends ConexaoMySql2 {

    /**
    * grava venda
    * @param pModelvenda
    * return int
    */
    public int salvarvendaDAO(ModelVendaCartao2 pModelvenda){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_venda_cartao2 ("
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
                    + "'" + pModelvenda.getValorLiquido() + "',"
                    + "'" + pModelvenda.getValorBruto() + "',"
                    + "'" + pModelvenda.getValorDesconto()+ "',"
                    + "'" + pModelvenda.getDataRelatorio()+ "',"
                    + "'" + pModelvenda.getDataAnual()+ "',"
                    + "'" + pModelvenda.getTurno()+ "'"
                   
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
    public ModelVendaCartao2 getvendaDAO(int pIdVenda){
        ModelVendaCartao2 modelvenda = new ModelVendaCartao2();
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
                    + "valor_desconto,"
                    + "data_relatorio,"
                    + "turno "
                    + " FROM"
                     + " tbl_venda_cartao2"
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
                modelvenda.setData_relatorio(this.getResultSet().getString(9));
                modelvenda.setTurno(this.getResultSet().getInt(10));
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
    public ArrayList<ModelVendaCartao2> getListavendaDAO(){
        ArrayList<ModelVendaCartao2> listamodelvenda = new ArrayList();
        ModelVendaCartao2 modelvenda = new ModelVendaCartao2();
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
                    + "valor_desconto,"
                    + "data_relatorio,"
                     + "turno "
                 + " FROM"
                     + " tbl_venda_cartao2"
                + ";"
            );

            while(this.getResultSet().next()){
                modelvenda = new ModelVendaCartao2();
                modelvenda.setIdVenda(this.getResultSet().getInt(1));
                modelvenda.setCliente(this.getResultSet().getInt(2));
                modelvenda.setUsuario(this.getResultSet().getInt(3));
                modelvenda.setData(this.getResultSet().getString(4));
                modelvenda.setHora(this.getResultSet().getString(5));
                modelvenda.setValorLiquido(this.getResultSet().getDouble(6));
                modelvenda.setValorBruto(this.getResultSet().getDouble(7));
                modelvenda.setValorDesconto(this.getResultSet().getDouble(8));
                modelvenda.setData_relatorio(this.getResultSet().getString(9));
                modelvenda.setTurno(this.getResultSet().getInt(10));
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
    public boolean atualizarvendaDAO(ModelVendaCartao2 pModelvenda){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_venda_cartao2 SET "
                    
                    + "fk_cliente = '" + pModelvenda.getCliente() + "',"
                    + "fk_usuario = '" + pModelvenda.getUsuario() + "',"
                    + "data = '" + pModelvenda.getData() + "',"
                    + "hora = '" + pModelvenda.getHora() + "',"
                    + "valor_liquido = '" + pModelvenda.getValorLiquido() + "',"
                    + "valor_bruto = '" + pModelvenda.getValorBruto() + "',"
                    + "valor_desconto = '" + pModelvenda.getValorDesconto() + "',"
                    + "data_relatorio = '" + pModelvenda.getData_relatorio() + "',"
                    + "turno = '" + pModelvenda.getData_relatorio() + "'"
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
                "DELETE FROM tbl_venda_cartao2 "
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
    
    
    
    public boolean salvarListaVendaProdutoDAO(ArrayList<ModelVendaCartao2> pListaModelVendaProduto) {
    try {
            this.conectar();
            int contando = pListaModelVendaProduto.size();
            for (int i = 0; i < contando; i++) {
            this.insertSQL(
                "INSERT INTO tbl_venda_cartao2 ("
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