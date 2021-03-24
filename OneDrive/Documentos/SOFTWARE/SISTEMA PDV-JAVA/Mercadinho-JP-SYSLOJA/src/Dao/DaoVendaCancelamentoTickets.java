package Dao;


import Conexao.Conectar;
import Conexao.Conectar2;
import Conexao.ConexaoMySql;
import Conexao.ConexaoMySql2;
import Model.ModelVendaCancelamentoTickets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
/**
*
* @author monet 
*/ 
public class DaoVendaCancelamentoTickets extends ConexaoMySql2 {
static Conectar cc = new Conectar();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;
    /**
    * grava venda
    * @param pModelvenda
    * return int
    */
    public int salvarvendaDAO(ModelVendaCancelamentoTickets pModelvenda){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_venda_cancelamento_tickets ("
                    + "fk_cliente, "
                    + "fk_usuario, "
                    + "data, "
                    + "hora, "
                    + "valor_liquido, "
                    + "valor_bruto, "
                    + "valor_desconto, "
                    + "fk_venda "
                    
                + ") VALUES ("
                    + "'" + pModelvenda.getCliente() + "',"
                    + "'" + pModelvenda.getUsuario() + "',"
                    + "'" + pModelvenda.getData() + "',"
                    + "'" + pModelvenda.getHora() + "',"                       
                    + "'" + pModelvenda.getValorLiquido() + "',"
                    + "'" + pModelvenda.getValorBruto() + "',"
                    + "'" + pModelvenda.getValorDesconto() + "',"
                     + "'" + pModelvenda.getFkVenda() + "'"
                   
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
    public ModelVendaCancelamentoTickets getvendaDAO(int pIdVenda){
        ModelVendaCancelamentoTickets modelvenda = new ModelVendaCancelamentoTickets();
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
                    + "fk_venda "
                    + " FROM"
                     + " tbl_venda_cancelamento_tickets "
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
                 modelvenda.setFkVenda(this.getResultSet().getInt(10));
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
    public ArrayList<ModelVendaCancelamentoTickets> getListavendaDAO(){
        ArrayList<ModelVendaCancelamentoTickets> listamodelvenda = new ArrayList();
        ModelVendaCancelamentoTickets modelvenda = new ModelVendaCancelamentoTickets();
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
                    + "fk_venda "
                 + " FROM"
                     + " tbl_venda_cancelamento_tickets"
                + ";"
            );

            while(this.getResultSet().next()){
                modelvenda = new ModelVendaCancelamentoTickets();
                modelvenda.setIdVenda(this.getResultSet().getInt(1));
                modelvenda.setCliente(this.getResultSet().getInt(2));
                modelvenda.setUsuario(this.getResultSet().getInt(3));
                modelvenda.setData(this.getResultSet().getString(4));
                modelvenda.setHora(this.getResultSet().getString(5));
                modelvenda.setValorLiquido(this.getResultSet().getDouble(6));
                modelvenda.setValorBruto(this.getResultSet().getDouble(7));
                modelvenda.setValorDesconto(this.getResultSet().getDouble(8));
                modelvenda.setFkVenda(this.getResultSet().getInt(9));
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
    public boolean atualizarvendaDAO(ModelVendaCancelamentoTickets pModelvenda){
    try {
    this.conectar();
    return this.executarUpdateDeleteSQL("UPDATE tbl_venda_cancelamento_tickets SET "
                  
    + "fk_cliente = '" + pModelvenda.getCliente() + "',"
    + "fk_usuario = '" + pModelvenda.getUsuario() + "',"
    + "data = '" + pModelvenda.getData() + "',"
    + "hora = '" + pModelvenda.getHora() + "',"
    + "valor_liquido = '" + pModelvenda.getValorLiquido() + "',"
    + "valor_bruto = '" + pModelvenda.getValorBruto() + "',"
    + "valor_desconto = '" + pModelvenda.getValorDesconto() + "'"
   
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
                "DELETE FROM tbl_venda_cancelamento_tickets "
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
        String sql = ModelVendaCancelamentoTickets.ELIMINAR_TUDO;
        try {
            ps = cn.prepareStatement(sql); 
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
    
    
    public boolean salvarListaVendaProdutoDAO(ArrayList<ModelVendaCancelamentoTickets> pListaModelVendaProduto) {
    try {
            this.conectar();
            int contando = pListaModelVendaProduto.size();
            for (int i = 0; i < contando; i++) {
            this.insertSQL(
                "INSERT INTO tbl_venda_cancelamento_tickets ("
                    + "data,"
                    + "hora,"  
                  
                    + "fk_cliente,"
                    + "fk_venda,"
                        
                    + "fk_usuario,"
                    + "valor_bruto,"
                    + "valor_desconto," 
                    + "valor_liquido "
                   
                + ") VALUES ("
                    + "'" + pListaModelVendaProduto.get(i).getData()+ "',"
                    + "'" + pListaModelVendaProduto.get(i).getHora() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getCliente() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getIdVenda() + "',"
                            
                    + "'" + pListaModelVendaProduto.get(i).getUsuario() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getValorBruto() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getValorDesconto() + "',"
                    + "'" + pListaModelVendaProduto.get(i).getValorLiquido() + "'"
               
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