/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ModelProduto;
import Conexao.ConexaoMySql;
import Conexao.ConexaoMySql2;
import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * 
 * @author Monet
 */
public class DaoProduto extends ConexaoMySql2{

    //SALVAR
    public int SalvarDao(ModelProduto mod) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_produto ("
                    + "nome, "
                    + "cod_barras, "
                    + "departamento, "
                    + "prazo_validade, "
                    + "estoque, "
                    + "atributo, "
                    + "ind_atributo, "
                    + "ncm, "
                    + "fornecedor, "
                    + "preco_custo, "
                    + "preco_venda "
                    + ") VALUES ("
                    + "'" + mod.getNome() + "',"
                    + "'" + mod.getCod_barras() + "',"
                    + "'" + mod.getDepartamento() + "',"
                    + "'" + mod.getValidade() + "',"
                    + "'" + mod.getEstoque() + "',"
                    + "'" + mod.getAtributo() + "',"
                    + "'" + mod.getInd_atributo() + "',"
                    + "'" + mod.getNcm() + "',"
                    + "'" + mod.getFornecedor() + "',"
                    + "'" + mod.getPreco_custo() + "',"
                    + "'" + mod.getPreco_venda() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }
    public static String LISTAR = "SELECT * FROM tbl_produto ORDER BY nome";

    //EXCLUIR  
    public boolean excluirDao(int id) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbl_produto WHERE pk_id_produto = '" + id + "'");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    //ALTERAR
    public boolean alterarDao(ModelProduto mod) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbl_produto SET "
                    + "nome = '" + mod.getNome() + "',"
                    + "cod_barras = '" + mod.getCod_barras() + "',"
                    + "departamento = '" + mod.getDepartamento() + "',"
                    + "prazo_validade = '" + mod.getValidade() + "',"
                    + "estoque = '" + mod.getEstoque() + "',"
                    + "atributo = '" + mod.getAtributo() + "',"
                    + "ind_atributo = '" + mod.getInd_atributo() + "',"
                    + "ncm = '" + mod.getNcm() + "',"
                    + "fornecedor = '" + mod.getFornecedor() + "',"
                    + "preco_custo = '" + mod.getPreco_custo() + "',"
                    + "preco_venda = '" + mod.getPreco_venda() + "'"
                    + "WHERE pk_id_produto = '" + mod.getId() + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    //RETORNAR
    public ModelProduto retornarDao(int id) {
        ModelProduto mod = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL(""
                    + "SELECT "
                    + "pk_id_produto, "
                    + "nome, "
                    + "cod_barras, "
                    + "departamento, "
                    + "prazo_validade, "
                    + "estoque, "
                    + "atributo, "
                    + "ind_atributo, "
                    + "ncm, "
                    + "fornecedor, "
                    + "preco_custo, "
                    + "preco_venda "
                    + "FROM tbl_produto WHERE pk_id_produto = '" + id + "'");
            while (this.getResultSet().next()) {
                mod.setId(getResultSet().getInt(1));
                mod.setNome(getResultSet().getString(2));
                mod.setCod_barras(getResultSet().getString(3));
                mod.setDepartamento(getResultSet().getString(4));

                mod.setValidade(getResultSet().getString(5));
                mod.setEstoque(getResultSet().getInt(6));
                mod.setAtributo(getResultSet().getString(7));
                mod.setInd_atributo(getResultSet().getString(8));
                mod.setNcm(getResultSet().getString(9));
                mod.setFornecedor(getResultSet().getString(10));
                mod.setPreco_custo(getResultSet().getDouble(11));
                mod.setPreco_venda(getResultSet().getDouble(12));
            }
        } catch (Exception e) {
        } finally {
            this.fecharConexao();
        }
        return mod;
    }

    //RETORNAR PELO CODIGO DE BARRAS
    public ModelProduto retornarDaoPeloCodigoBarras(String id) {
        ModelProduto mod = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL(""
                    + "SELECT "
                    + "pk_id_produto, "
                    + "nome, "
                    + "cod_barras, "
                    + "departamento, "
                    + "prazo_validade, "
                    + "estoque, "
                    + "atributo, "
                    + "ind_atributo, "
                    + "ncm, "
                    + "fornecedor, "
                    + "preco_custo, "
                    + "preco_venda "
                    + "FROM tbl_produto WHERE cod_barras = '" + id + "'");
            while (this.getResultSet().next()) {
                mod.setId(getResultSet().getInt(1));
                mod.setNome(getResultSet().getString(2));
                mod.setCod_barras(getResultSet().getString(3));
                mod.setDepartamento(getResultSet().getString(4));

                mod.setValidade(getResultSet().getString(5));
                mod.setEstoque(getResultSet().getInt(6));
                mod.setAtributo(getResultSet().getString(7));
                mod.setInd_atributo(getResultSet().getString(8));
                mod.setNcm(getResultSet().getString(9));
                mod.setFornecedor(getResultSet().getString(10));
                mod.setPreco_custo(getResultSet().getDouble(11));
                mod.setPreco_venda(getResultSet().getDouble(12));
            }
        } catch (Exception e) {
        } finally {
            this.fecharConexao();
        }
        return mod;
    }

    //RETORNAR
    public ModelProduto retornarPeloNomeDao(String Nome) {
        ModelProduto mod = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL(""
                    + "SELECT "
                    + "pk_id_produto, "
                    + "nome, "
                    + "cod_barras, "
                    + "departamento, "
                    + "prazo_validade, "
                    + "estoque, "
                    + "atributo, "
                    + "ind_atributo, "
                    + "ncm, "
                    + "fornecedor, "
                    + "preco_custo, "
                    + "preco_venda "
                    + "FROM tbl_produto WHERE nome = '" + Nome + "'");
            while (this.getResultSet().next()) {
                mod.setId(getResultSet().getInt(1));
                mod.setNome(getResultSet().getString(2));
                mod.setCod_barras(getResultSet().getString(3));
                mod.setDepartamento(getResultSet().getString(4));

                mod.setValidade(getResultSet().getString(5));
                mod.setEstoque(getResultSet().getInt(6));
                mod.setAtributo(getResultSet().getString(7));
                mod.setInd_atributo(getResultSet().getString(8));
                mod.setNcm(getResultSet().getString(9));
                mod.setFornecedor(getResultSet().getString(10));
                mod.setPreco_custo(getResultSet().getDouble(11));
                mod.setPreco_venda(getResultSet().getDouble(12));
            }
        } catch (Exception e) {
        } finally {
            this.fecharConexao();
        }
        return mod;
    }

    //RETORNAR LISTA
    public ArrayList<ModelProduto> retornarListaDeUsuario() {
        ArrayList<ModelProduto> lista = new ArrayList<>();
        ModelProduto mod = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_produto, "
                    + "nome, "
                    + "cod_barras, "
                    + "departamento, "
                    + "prazo_validade, "
                    + "estoque, "
                    + "atributo, "
                    + "ind_atributo, "
                    + "ncm, "
                    + "fornecedor, "
                    + "preco_custo, "
                    + "preco_venda "
                    + "FROM tbl_produto ORDER BY nome;"
                    + "");
            while (getResultSet().next()) {
                mod = new ModelProduto();
                mod.setId(this.getResultSet().getInt(1));
                mod.setNome(this.getResultSet().getString(2));
                mod.setCod_barras(this.getResultSet().getString(3));
                mod.setDepartamento(this.getResultSet().getString(4));

                mod.setValidade(this.getResultSet().getString(5));
                mod.setEstoque(this.getResultSet().getInt(6));
                mod.setAtributo(this.getResultSet().getString(7));
                mod.setInd_atributo(this.getResultSet().getString(8));
                mod.setNcm(this.getResultSet().getString(9));
                mod.setFornecedor(this.getResultSet().getString(10));
                mod.setPreco_custo(this.getResultSet().getDouble(11));
                mod.setPreco_venda(this.getResultSet().getDouble(12));
                lista.add(mod);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return lista;
    }

    public boolean alterarEstoque(ArrayList<ModelProduto> listaModelProduto) {
        try {
            this.conectar();
            for (int i = 0; i < listaModelProduto.size(); i++) {
                this.executarUpdateDeleteSQL("UPDATE tbl_produto SET "
                        + "estoque = '" + listaModelProduto.get(i).getEstoque() + "'"
                        + "WHERE pk_id_produto = '" + listaModelProduto.get(i).getId() + "'"
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

    public boolean gerarRelatorio() {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     tbl_venda_produto2.nome_produto AS tbl_venda_produto2_nome_produto,"
                    + "     SUM(tbl_venda_produto2.quantidade) AS tbl_venda_produto2_quantidade"
                    + " FROM"
                    + "     tbl_venda_produto2 GROUP BY nome_produto ORDER BY SUM(tbl_venda_produto2.quantidade) DESC");

            JRResultSetDataSource jrRs = new JRResultSetDataSource(getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("Relatorios/produtosmaisVendidos.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRs);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\relatorio\\rel.rel2.pdf");
            File file = new File("C:\\relatorio\\rel.rel2.pdf");
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

    public boolean gerarRelatorioMes(String data) {
        try {
            this.conectar();
            this.executarSQL("SELECT"
                    + "     SUM(tbl_venda_produto2.quantidade) AS tbl_venda_produto2_quantidade,"
                    + "     tbl_venda_produto2.nome_produto AS tbl_venda_produto2_nome_produto,"
                    + "     tbl_venda_produto2.ano AS tbl_venda_produto2_ano,"
                    + "     tbl_venda_produto2.mes AS tbl_venda_produto2_mes,"
                    + "     tbl_venda_produto2.fk_produto AS tbl_venda_produto2_fk_produto"
                    + " FROM"
                    + "     tbl_venda_produto2 WHERE mes = '" + data + "' GROUP BY nome_produto ORDER BY SUM(tbl_venda_produto2.quantidade) DESC");

            JRResultSetDataSource jrRs = new JRResultSetDataSource(getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("Relatorios/produtoMaisVendPorMes.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRs);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\relatorio\\rel.rel2.pdf");
            File file = new File("C:\\relatorio\\rel.rel2.pdf");
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

    public boolean gerarRelatorioANO(String data) {
        try {
            this.conectar();
            this.executarSQL("SELECT"
                    + "     SUM(tbl_venda_produto2.quantidade) AS tbl_venda_produto2_quantidade,"
                    + "     tbl_venda_produto2.nome_produto AS tbl_venda_produto2_nome_produto,"
                    + "     tbl_venda_produto2.ano AS tbl_venda_produto2_ano,"
                    + "     tbl_venda_produto2.mes AS tbl_venda_produto2_mes,"
                    + "     tbl_venda_produto2.fk_produto AS tbl_venda_produto2_fk_produto"
                    + " FROM"
                    + "     tbl_venda_produto2 WHERE ano = '" + data + "' GROUP BY nome_produto ORDER BY SUM(tbl_venda_produto2.quantidade) DESC");

            JRResultSetDataSource jrRs = new JRResultSetDataSource(getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("Relatorios/produtoMaisVendPoAno.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRs);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\relatorio\\rel.rel2.pdf");
            File file = new File("C:\\relatorio\\rel.rel2.pdf");
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

    public boolean gerarRelatorioMesCARTAO(String data) {
        try {
            this.conectar();
            this.executarSQL("SELECT"
                    + "     SUM(tbl_venda_cartao_produto2.quantidade) AS tbl_venda_cartao_produto2_quantidade,"
                    + "     tbl_venda_cartao_produto2.nome_produto AS tbl_venda_cartao_produto2_nome_produto,"
                    + "     tbl_venda_cartao_produto2.mes AS tbl_venda_cartao_produto2_mes,"
                    + "     tbl_venda_cartao_produto2.ano AS tbl_venda_cartao_produto2_ano,"
                    + "     tbl_venda_cartao_produto2.fk_produto AS tbl_venda_cartao_produto2_fk_produto"
                    + " FROM"
                    + "     tbl_venda_cartao_produto2 WHERE mes = '" + data + "' GROUP BY nome_produto ORDER BY SUM(tbl_venda_cartao_produto2.quantidade) DESC");

            JRResultSetDataSource jrRs = new JRResultSetDataSource(getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("Relatorios/produtosMaisVendCartao.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRs);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\relatorio\\rel.rel2.pdf");
            File file = new File("C:\\relatorio\\rel.rel2.pdf");
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

    public boolean gerarRelatorioAnoCARTAO(String data) {
        try {
            this.conectar();
            this.executarSQL("SELECT"
                    + "     SUM(tbl_venda_cartao_produto2.quantidade) AS tbl_venda_cartao_produto2_quantidade,"
                    + "     tbl_venda_cartao_produto2.nome_produto AS tbl_venda_cartao_produto2_nome_produto,"
                    + "     tbl_venda_cartao_produto2.mes AS tbl_venda_cartao_produto2_mes,"
                    + "     tbl_venda_cartao_produto2.ano AS tbl_venda_cartao_produto2_ano,"
                    + "     tbl_venda_cartao_produto2.fk_produto AS tbl_venda_cartao_produto2_fk_produto"
                    + " FROM"
                    + "     tbl_venda_cartao_produto2 WHERE ano = '" + data + "' GROUP BY nome_produto ORDER BY SUM(tbl_venda_cartao_produto2.quantidade) DESC");

            JRResultSetDataSource jrRs = new JRResultSetDataSource(getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("Relatorios/produtosMaisVendAnoCartao.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRs);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\relatorio\\rel.rel2.pdf");
            File file = new File("C:\\relatorio\\rel.rel2.pdf");
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

    public boolean gerarRelatorioComPletoCARTAO() {
        try {
            this.conectar();
            this.executarSQL("SELECT"
                    + "     SUM(tbl_venda_cartao_produto2.quantidade) AS tbl_venda_cartao_produto2_quantidade,"
                    + "     tbl_venda_cartao_produto2.nome_produto AS tbl_venda_cartao_produto2_nome_produto,"
                    + "     tbl_venda_cartao_produto2.mes AS tbl_venda_cartao_produto2_mes,"
                    + "     tbl_venda_cartao_produto2.ano AS tbl_venda_cartao_produto2_ano,"
                    + "     tbl_venda_cartao_produto2.fk_produto AS tbl_venda_cartao_produto2_fk_produto"
                    + " FROM"
                    + "     tbl_venda_cartao_produto2 GROUP BY nome_produto ORDER BY SUM(tbl_venda_cartao_produto2.quantidade) DESC");

            JRResultSetDataSource jrRs = new JRResultSetDataSource(getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("Relatorios/produtosMaisVendListaCompletaCartao.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRs);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\relatorio\\rel.rel2.pdf");
            File file = new File("C:\\relatorio\\rel.rel2.pdf");
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

    //RELATORIO DE PRODUTOS MAIS VENDIDOS POR MES NO TICKET
    public boolean gerarRelatorioMesTICKETS(String data) {
        try {
            this.conectar();
            this.executarSQL("SELECT"
                    + "     tbl_venda_tickets_produto2.fk_produto AS tbl_venda_tickets_produto2_fk_produto,"
                    + "     SUM(tbl_venda_tickets_produto2.quantidade) AS tbl_venda_tickets_produto2_quantidade,"
                    + "     tbl_venda_tickets_produto2.nome_produto AS tbl_venda_tickets_produto2_nome_produto,"
                    + "     tbl_venda_tickets_produto2.ano AS tbl_venda_tickets_produto2_ano,"
                    + "     tbl_venda_tickets_produto2.mes AS tbl_venda_tickets_produto2_mes"
                    + " FROM"
                    + "     tbl_venda_tickets_produto2 tbl_venda_tickets_produto2 WHERE mes = '" + data + "' GROUP BY nome_produto ORDER BY SUM(tbl_venda_tickets_produto2.quantidade) DESC");

            JRResultSetDataSource jrRs = new JRResultSetDataSource(getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("Relatorios/produtosMaisVendiMesTicket.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRs);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\relatorio\\rel.rel2.pdf");
            File file = new File("C:\\relatorio\\rel.rel2.pdf"); 
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

     public boolean gerarRelatorioAnoTICKETS(String data) {
        try {
            this.conectar();
            this.executarSQL("SELECT"
                    + "     tbl_venda_tickets_produto2.fk_produto AS tbl_venda_tickets_produto2_fk_produto,"
                    + "     SUM(tbl_venda_tickets_produto2.quantidade) AS tbl_venda_tickets_produto2_quantidade,"
                    + "     tbl_venda_tickets_produto2.nome_produto AS tbl_venda_tickets_produto2_nome_produto,"
                    + "     tbl_venda_tickets_produto2.ano AS tbl_venda_tickets_produto2_ano,"
                    + "     tbl_venda_tickets_produto2.mes AS tbl_venda_tickets_produto2_mes"
                    + " FROM"
                    + "     tbl_venda_tickets_produto2 tbl_venda_tickets_produto2 WHERE ano = '" + data + "' GROUP BY nome_produto ORDER BY SUM(tbl_venda_tickets_produto2.quantidade) DESC");

            JRResultSetDataSource jrRs = new JRResultSetDataSource(getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("Relatorios/produtosMaisVendiAnoTicket.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRs);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\relatorio\\rel.rel2.pdf");
            File file = new File("C:\\relatorio\\rel.rel2.pdf"); 
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
     
      public boolean gerarRelatorioCompletoTICKETS() {
        try {
            this.conectar();
            this.executarSQL("SELECT"
                    + "     tbl_venda_tickets_produto2.mes AS tbl_venda_tickets_produto2_mes,"
                    + "     tbl_venda_tickets_produto2.fk_produto AS tbl_venda_tickets_produto2_fk_produto,"
                    + "     SUM(tbl_venda_tickets_produto2.quantidade) AS tbl_venda_tickets_produto2_quantidade,"
                    + "     tbl_venda_tickets_produto2.nome_produto AS tbl_venda_tickets_produto2_nome_produto,"
                    + "     tbl_venda_tickets_produto2.ano AS tbl_venda_tickets_produto2_ano"
                    
                    + " FROM"
                    + "     tbl_venda_tickets_produto2 GROUP BY nome_produto ORDER BY SUM(tbl_venda_tickets_produto2.quantidade) DESC");

            JRResultSetDataSource jrRs = new JRResultSetDataSource(getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("Relatorios/produtosMaisVendiCompletTicket.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRs);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\relatorio\\rel.rel2.pdf");
            File file = new File("C:\\relatorio\\rel.rel2.pdf"); 
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
    
}
