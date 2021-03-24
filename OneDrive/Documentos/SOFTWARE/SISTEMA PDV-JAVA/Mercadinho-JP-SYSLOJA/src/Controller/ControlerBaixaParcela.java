/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Conexao.ConexaoMySql;
import Model.ModelBaixaParcela;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Monet 
 */
public class ControlerBaixaParcela{
      ConexaoMySql con = new ConexaoMySql();
      public ModelBaixaParcela BuscaParcela(ModelBaixaParcela mod){
        con.conectar();
          try {
        con.executarSQL("SELECT *FROM tbl_parcela_venda WHERE pk_id_parcela="+mod.getCodParc());
        con.getResultSet().first();
        mod.setCodParc(con.getResultSet().getInt("pk_id_parcela"));
        mod.setCodVen(con.getResultSet().getInt("fk_venda"));
        mod.setDataVen(con.getResultSet().getString("data"));
        mod.setValor(con.getResultSet().getFloat("valor_parcela"));
        return mod;
          } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar parcela!");
          }
        con.fecharConexao();
          return mod; 
      }
          public void baixarParcela(ModelBaixaParcela mod){
          con.conectar();
          con.executarSQL("SELECT *FROM tbl_parcela_venda WHERE pk_id_parcela='"+mod.getCodParc()+"' and estado='PAGO'");
          try {
              PreparedStatement pst = con.conectar().prepareStatement("UPDATE tbl_parcela_venda SET estado=? WHERE pk_id_parcela=?");
              pst.setString(1, "PAGO");
              pst.setInt(2, mod.getCodParc());
              pst.executeUpdate();
              JOptionPane.showMessageDialog(null, "Parcela paga com sucesso!");
          } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao efetuar pagamento dessa Parcela!");   
          }
          con.fecharConexao();
      }
      
       
    
      
}
