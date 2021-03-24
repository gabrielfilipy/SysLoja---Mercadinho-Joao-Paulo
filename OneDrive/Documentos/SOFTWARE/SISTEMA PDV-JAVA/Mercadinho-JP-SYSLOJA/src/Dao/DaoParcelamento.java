package Dao;

import Model.ModelParcelamento;
import Conexao.ConexaoMySql;
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
 * @author monet
 */
public class DaoParcelamento extends ConexaoMySql {

    /**
     * grava venda
     *
     * @param pModelvenda return int
     */
    public int salvarvendaDAO(ModelParcelamento pModelvenda) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tbl_parcela_venda ("
                    + "fk_venda, "
                    + "valor_venda, "
                    + "data, "
                    + "quantidade_parcelas, "
                    + "valor_parcela, "
                    + "valor_total, "
                    + "estado, "
                    + "fk_cliente, "
                    + "nome, "
                    + "cpf "
                    + ") VALUES ("
                    + "'" + pModelvenda.getCodVenda() + "',"
                    + "'" + pModelvenda.getValorVenda() + "',"
                    + "'" + pModelvenda.getDataVenc() + "',"
                    + "'" + pModelvenda.getNumeroParc() + "',"
                    + "'" + pModelvenda.getValorParcela() + "',"
                    + "'" + pModelvenda.getValorTotal() + "',"
                    + "'" + pModelvenda.getEstado() + "',"
                    + "'" + pModelvenda.getCliente() + "',"
                    + "'" + pModelvenda.getNomeClie() + "',"
                    + "'" + pModelvenda.getCpfCli() + "'"
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
    public ModelParcelamento getvendaDAO(int pIdVenda) {
        ModelParcelamento modelvenda = new ModelParcelamento();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_parcela,"
                    + "fk_venda, "
                    + "valor_venda, "
                    + "data, "
                    + "quantidade_parcelas, "
                    + "valor_parcela, "
                    + "valor_total "
                    + " FROM"
                    + " tbl_parcela_venda"
                    + " WHERE"
                    + " pk_id_parcela = '" + pIdVenda + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelvenda.setId(this.getResultSet().getInt(1));
                modelvenda.setCodVenda(this.getResultSet().getInt(2));
                modelvenda.setValorVenda(this.getResultSet().getInt(3));
                modelvenda.setDataVenc(this.getResultSet().getString(4));
                modelvenda.setNumeroParc(this.getResultSet().getInt(5));
                modelvenda.setValorParcela(this.getResultSet().getFloat(6));
                modelvenda.setValorTotal(this.getResultSet().getFloat(7));

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
    public ArrayList<ModelParcelamento> getListavendaDAO() {
        ArrayList<ModelParcelamento> listamodelvenda = new ArrayList();
        ModelParcelamento modelvenda = new ModelParcelamento();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_parcela,"
                    + "fk_venda, "
                    + "valor_venda, "
                    + "data, "
                    + "quantidade_parcelas, "
                    + "valor_parcela, "
                    + "valor_total "
                    + " FROM"
                    + " tbl_parcela_venda"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelvenda = new ModelParcelamento();
                modelvenda.setId(this.getResultSet().getInt(1));
                modelvenda.setCodVenda(this.getResultSet().getInt(2));
                modelvenda.setValorVenda(this.getResultSet().getInt(3));
                modelvenda.setDataVenc(this.getResultSet().getString(4));
                modelvenda.setNumeroParc(this.getResultSet().getInt(5));
                modelvenda.setValorParcela(this.getResultSet().getFloat(6));
                modelvenda.setValorTotal(this.getResultSet().getFloat(7));

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
    public boolean atualizarvendaDAO(ModelParcelamento pModelvenda) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_venda SET "
                    + "pk_id_parcela = '" + pModelvenda.getId() + "',"
                    + "fk_venda = '" + pModelvenda.getCodVenda() + "',"
                    + "valor_venda = '" + pModelvenda.getValorVenda() + "',"
                    + "data = '" + pModelvenda.getDataVenc() + "',"
                    + "quantidade_parcelas = '" + pModelvenda.getNumeroParc() + "',"
                    + "valor_parcela = '" + pModelvenda.getValorParcela() + "',"
                    + "valor_total = '" + pModelvenda.getValorTotal() + "'"
                    + " WHERE "
                    + "pk_id_venda = '" + pModelvenda.getId() + "'"
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
                    "DELETE FROM tbl_venda "
                    + " WHERE "
                    + "pk_id_venda = '" + pIdVenda + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean gerarRelatorio(int cod) {
        try {
            this.conectar();
            this.executarSQL("SELECT" 
                    + "     tbl_parcela_venda.pk_id_parcela AS tbl_parcela_venda_pk_id_parcela,"
                    + "     tbl_parcela_venda.fk_venda AS tbl_parcela_venda_fk_venda,"
                    + "     tbl_parcela_venda.valor_venda AS tbl_parcela_venda_valor_venda,"
                    + "     tbl_parcela_venda.data AS tbl_parcela_venda_data,"
                    + "     tbl_parcela_venda.quantidade_parcelas AS tbl_parcela_venda_quantidade_parcelas,"
                    + "     tbl_parcela_venda.valor_parcela AS tbl_parcela_venda_valor_parcela,"
                    + "     tbl_parcela_venda.valor_total AS tbl_parcela_venda_valor_total,"
                    + "     tbl_parcela_venda.estado AS tbl_parcela_venda_estado,"
                    + "     tbl_parcela_venda.fk_cliente AS tbl_parcela_venda_fk_cliente,"
                    + "     tbl_parcela_venda.nome AS tbl_parcela_venda_nome,"
                    + "     tbl_parcela_venda.cpf AS tbl_parcela_venda_cpf"
                    + " FROM"
                    + "     tbl_parcela_venda WHERE fk_venda = '" + cod + "'");

            JRResultSetDataSource jrRs = new JRResultSetDataSource(getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("Relatorios/parcelas.jasper");
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
}
