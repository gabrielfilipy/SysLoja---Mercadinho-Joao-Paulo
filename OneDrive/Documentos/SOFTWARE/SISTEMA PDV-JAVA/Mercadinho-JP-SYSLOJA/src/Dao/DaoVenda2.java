package Dao;

import Conexao.Conectar;
import Conexao.Conectar2;
import Conexao.ConexaoMySql;
import Conexao.ConexaoMySql2;
import Model.ModelVenda2;
import View.GerarNumero;
import View.ViewAbrirTurnoo;
import View.ViewPdv555;
import View.ViewPrincipal;
import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author monet
 */
public class DaoVenda2 extends ConexaoMySql2 { 

    static Conectar2 cc = new Conectar2();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;
    /**
     * grava venda
     *
     * @param pModelvenda return int
     */
    public int salvarvendaDAO(ModelVenda2 pModelvenda) {
        try {
            this.conectar();
            return this.insertSQL(
                     "INSERT INTO tbl_venda2 ("
                        + "data,"
                        + "hora,"
                        + "tipo_pagamento,"
                        + "fk_cliente," 
                        + "fk_venda,"
                        + "fk_usuario,"
                        + "valor_bruto,"
                        + "valor_desconto," 
                        + "valor_liquido,"
                        + "data_relatorio,"
                        + "data_anual,"
                        + "valor_total,"  
                        + "quantidade,"
                        + "turno" 
                    + ") VALUES ("
                    + "'" + pModelvenda.getData() + "',"
                    + "'" + pModelvenda.getHora() + "',"
                    + "'" + pModelvenda.getPagamento() + "',"
                    + "'" + pModelvenda.getCliente() + "',"
                    + "'" + pModelvenda.getIdVenda() + "',"
                    + "'" + pModelvenda.getUsuario() + "',"
                    + "'" + pModelvenda.getValorBruto() + "',"
                    + "'" + pModelvenda.getValorDesconto()+ "',"
                    + "'" + pModelvenda.getValorLiquido() + "',"
                    + "'" + pModelvenda.getData_relatorio() + "',"
                    + "'" + pModelvenda.getdataAnual() + "',"
                    + "'" + pModelvenda.getValorTotal() + "',"
                    + "'" + pModelvenda.getQuantidade() + "',"
                    + "'" + pModelvenda.getTurno() + "'"
                    
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera venda
     *
     * @param pIdVenda return Modelvenda
     */
    public ModelVenda2 getvendaDAO(int pIdVenda) {
        ModelVenda2 modelvenda = new ModelVenda2();
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
                    + "turno "
                    + " FROM"
                    + " tbl_venda2"
                    + " WHERE"
                    + " fk_venda = '" + pIdVenda + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
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
                modelvenda.setTurno(this.getResultSet().getInt(11));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelvenda;
    }

    /**
     * recupera uma lista de venda return ArrayList
     */
    public ArrayList<ModelVenda2> getListavendaDAO() {
        ArrayList<ModelVenda2> listamodelvenda = new ArrayList();
        ModelVenda2 modelvenda = new ModelVenda2();
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
                    + "tipo_pagamento,"
                    + "data_relatorio,"
                    + "turno "
                    + " FROM"
                    + " tbl_venda2"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelvenda = new ModelVenda2();
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
                modelvenda.setTurno(this.getResultSet().getInt(11));
                listamodelvenda.add(modelvenda);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelvenda;
    }

    /**
     * atualiza venda
     *
     * @param pModelvenda return boolean
     */
    public boolean atualizarvendaDAO(ModelVenda2 pModelvenda) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbl_venda2 SET "
                    + "fk_cliente = '" + pModelvenda.getCliente() + "',"
                    + "fk_usuario = '" + pModelvenda.getUsuario() + "',"
                    + "data = '" + pModelvenda.getData() + "',"
                    + "hora = '" + pModelvenda.getHora() + "',"
                    + "valor_liquido = '" + pModelvenda.getValorLiquido() + "',"
                    + "valor_bruto = '" + pModelvenda.getValorBruto() + "',"
                    + "valor_desconto = '" + pModelvenda.getValorDesconto() + "',"
                    + "tipo_pagamento = '" + pModelvenda.getPagamento() + "',"
                    + "turno = '" + pModelvenda.getTurno() + "'"
                    + " WHERE pk_id_venda = '" + pModelvenda.getIdVenda() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui venda
     *
     * @param pIdVenda return boolean
     */
    public boolean excluirvendaDAO(int pIdVenda) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_venda2 "
                    + " WHERE "
                    + "fk_venda = '" + pIdVenda + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean salvarListaVendaProdutoDAO(ArrayList<ModelVenda2> pListaModelVendaProduto) {
        try {
            this.conectar();
            int contando = pListaModelVendaProduto.size();
            for (int i = 0; i < contando; i++) {
                this.insertSQL(
                        "INSERT INTO tbl_venda2 ("
                        + "data,"
                        + "hora,"
                        + "tipo_pagamento,"
                        + "fk_cliente," 
                        + "fk_venda,"
                        + "fk_usuario,"
                        + "valor_bruto,"
                        + "valor_desconto," 
                        + "valor_liquido,"
                        + "data_relatorio,"
                        + "data_anual,"
                        + "valor_total,"  
                        + "quantidade,"
                        + "turno" 
                       
                        + ") VALUES ("
                        + "'" + pListaModelVendaProduto.get(i).getData() + "',"
                        + "'" + pListaModelVendaProduto.get(i).getHora() + "',"
                        + "'" + pListaModelVendaProduto.get(i).getPagamento() + "',"
                        + "'" + pListaModelVendaProduto.get(i).getCliente() + "',"
                        + "'" + pListaModelVendaProduto.get(i).getIdVenda() + "',"
                        + "'" + pListaModelVendaProduto.get(i).getUsuario() + "',"
                        + "'" + pListaModelVendaProduto.get(i).getValorBruto() + "',"
                        + "'" + pListaModelVendaProduto.get(i).getValorDesconto() + "',"
                        + "'" + pListaModelVendaProduto.get(i).getValorLiquido() + "',"
                        + "'" + pListaModelVendaProduto.get(i).getData_relatorio() + "',"
                        + "'" + pListaModelVendaProduto.get(i).getdataAnual() + "',"
                        + "'" + pListaModelVendaProduto.get(i).getValorTotal() + "',"
                        + "'" + pListaModelVendaProduto.get(i).getQuantidade() + "',"
                        + "'" + pListaModelVendaProduto.get(i).getTurno() + "'" 
                      
                        + ");"
                );
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }

    public boolean gerarRelatorio(String data) {
        try {
            this.conectar();
            this.executarSQL("SELECT"
                    + "     tbl_venda2.pk_id_venda AS tbl_venda2_pk_id_venda,"
                    + "     tbl_venda2.fk_venda AS tbl_venda2_fk_venda,"
                    + "     tbl_venda2.fk_cliente AS tbl_venda2_fk_cliente,"
                    + "     tbl_venda2.fk_usuario AS tbl_venda2_fk_usuario,"
                    + "     tbl_venda2.data AS tbl_venda2_data," 
                    + "     tbl_venda2.hora AS tbl_venda2_hora," 
                    + "     tbl_venda2.valor_liquido AS tbl_venda2_valor_liquido,"
                    + "     tbl_venda2.valor_bruto AS tbl_venda2_valor_bruto,"
                    + "     tbl_venda2.valor_desconto AS tbl_venda2_valor_desconto,"
                    + "     tbl_venda2.tipo_pagamento AS tbl_venda2_tipo_pagamento,"
                    + "     tbl_venda2.data_relatorio AS tbl_venda2_data_relatorio"
                    + " FROM"
                    + "     tbl_venda2 WHERE data_relatorio = '"+data+"'");

            JRResultSetDataSource jrRs = new JRResultSetDataSource(getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("Relatorios/RelatorioMensal.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRs);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\relatorio\\rel.rel.pdf");
            File file = new File("C:\\relatorio\\rel.rel.pdf");
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro ao gerar pdf");
            }
            file.deleteOnExit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao(); 
        }
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
   

public static void numerosTurnos() { 
        int j;
        int cont = 1;
        String num = ""; 
        String c = "";
        String SQL = "SELECT MAX(fk_turno) FROM tbl_abrir_turno2";
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



public static void numerosTurnos2() { 
        int j;
        int cont = 1;
        String num = ""; 
        String c = "";
        String SQL = "SELECT MAX(fk_turno) FROM tbl_abrir_turno2";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) { 
                ViewPrincipal.tfTurno.setText("00000001");
                
            } else {
                j = Integer.parseInt(c);
                GerarNumero gen = new GerarNumero();
                gen.gerar(j);
                ViewPrincipal.tfTurno.setText(gen.serie());

            }

        } catch (SQLException ex) {
            Logger.getLogger(ViewPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   



}
