/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexao.Conectar;
import Conexao.ConexaoMySql;
import Conexao.ConexaoMySql2;
import Model.ModelAbrirTurno2;
import View.GerarNumero;
import View.ViewAbrirTurnoo;

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
 * @author Monet
 */
public class DaoAbrirTurno2 extends ConexaoMySql2 {

    static Conectar cc = new Conectar();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;

    //SALVAR
    public int SalvarAbrirTurnoDao(ModelAbrirTurno2 modelAbrirTurno) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_abrir_turno2 ("
                    + "fk_usuario,"
                    + "nome,"
                    + "data,"       
                    + "hora,"
                    + "valor,"
                    + "fk_turno,"
                    + "data_fechar,"
                    + "hora_fechar,"
                    + "data_relatorio, "
                    + "data_anual "
                    + ") VALUES ("
                    + "'" + modelAbrirTurno.getId() + "',"
                    + "'" + modelAbrirTurno.getNome() + "',"
                    + "'" + modelAbrirTurno.getData() + "',"
                    + "'" + modelAbrirTurno.getHora() + "',"
                    + "'" + modelAbrirTurno.getValor() + "',"
                    + "'" + modelAbrirTurno.getFkTurno() + "',"
                    + "'" + modelAbrirTurno.getData_fechar() + "',"
                    + "'" + modelAbrirTurno.getHora2() + "',"
                    + "'" + modelAbrirTurno.getDataRelatorio() + "',"
                    + "'" + modelAbrirTurno.getDataAnual() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    //EXCLUIR
    public boolean excluirUsuarioDao(int idUsuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbl_usuario WHERE pk_id_usuario = '" + idUsuario + "'");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    //RETORNAR
    public ModelAbrirTurno2 retornarAbrirTurnoDao(int idUsuario) {
        ModelAbrirTurno2 modelAbrirTurno = new ModelAbrirTurno2();
        try {
            this.conectar();
            this.executarSQL(""
                    + "SELECT "
                    + "fk_turno, "
                    + "nome, "
                    + "data, "
                    + "hora, "
                    + "valor, "
                    + "pk_id_abrir_turno, "
                    + "fk_turno "
                    + "FROM tbl_abrir_turno2 WHERE fk_turno = '" + idUsuario + "'");
            while (this.getResultSet().next()) {
                modelAbrirTurno.setFkTurno(getResultSet().getInt(1));
                modelAbrirTurno.setNome(getResultSet().getString(2));
                modelAbrirTurno.setData(getResultSet().getString(3));
                modelAbrirTurno.setHora(getResultSet().getString(4));
                modelAbrirTurno.setValor(getResultSet().getString(5));
                modelAbrirTurno.setPk_id_abrir_turno(getResultSet().getInt(6));
                modelAbrirTurno.setFkTurno(getResultSet().getInt(7));
            }
        } catch (Exception e) {
        } finally {
            this.fecharConexao();
        }
        return modelAbrirTurno;
    }

    // public static String LISTAR = "SELECT * FROM tbl_usuario ORDER BY nome";
    //RETORNAR LISTA
    public ArrayList<ModelAbrirTurno2> retornarListaDeUsuario() {
        ArrayList<ModelAbrirTurno2> lista = new ArrayList<>();
        ModelAbrirTurno2 mod = new ModelAbrirTurno2();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "fk_usuario, "
                    + "nome, "
                    + "data, "
                    + "hora, "
                    + "valor, "
                    + "fk_turno, "
                    + "data_fechar, "
                    + "hora_fechar "
                    + "FROM tbl_abrir_turno2;"
                    + "");
            while (getResultSet().next()) {
                mod = new ModelAbrirTurno2();
                mod.setId(this.getResultSet().getInt(1));
                mod.setNome(this.getResultSet().getString(2));
                mod.setData(this.getResultSet().getString(3));
                mod.setHora(this.getResultSet().getString(4));
                mod.setValor(this.getResultSet().getString(5));
                mod.setFkTurno(this.getResultSet().getInt(6));
                mod.setData_fechar(this.getResultSet().getString(7));
                mod.setHora2(this.getResultSet().getString(8));
                lista.add(mod);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return lista;
    }

    //ALTERAR
    public boolean alterarDao(ModelAbrirTurno2 mod) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbl_abrir_turno2 SET "
                    + "fk_usuario = '" + mod.getId() + "',"
                    + "nome = '" + mod.getNome() + "',"
                    + "data = '" + mod.getData() + "',"
                    + "hora = '" + mod.getHora() + "',"
                    + "valor = '" + mod.getValor() + "',"
                    + "pk_id_abrir_turno = '" + mod.getPk_id_abrir_turno() + "',"
                    + "estado = '" + mod.getEstado() + "',"
                    + "fk_turno = '" + mod.getFkTurno() + "'"
                    + "WHERE pk_id_abrir_turno = '" + mod.getPk_id_abrir_turno() + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
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

    public boolean gerarRelatorio(String data) {
        try {
            this.conectar(); 
            this.executarSQL("SELECT"
                    + "     tbl_abrir_turno2.pk_id_abrir_turno AS tbl_abrir_turno2_pk_id_abrir_turno,"
                    + "     tbl_abrir_turno2.fk_turno AS tbl_abrir_turno2_fk_turno,"
                    + "     tbl_abrir_turno2.fk_usuario AS tbl_abrir_turno2_fk_usuario,"
                    + "     tbl_abrir_turno2.nome AS tbl_abrir_turno2_nome,"
                    + "     tbl_abrir_turno2.data AS tbl_abrir_turno2_data," 
                    + "     tbl_abrir_turno2.hora AS tbl_abrir_turno2_hora," 
                    + "     tbl_abrir_turno2.valor AS tbl_abrir_turno2_valor,"
                    + "     tbl_abrir_turno2.data_fechar AS tbl_abrir_turno2_data_fechar,"
                    + "     tbl_abrir_turno2.hora_fechar AS tbl_abrir_turno2_hora_fechar,"
                    + "     tbl_abrir_turno2.data_relatorio AS tbl_abrir_turno2_data_relatorio,"
                    + "     tbl_abrir_turno2.data_anual AS tbl_abrir_turno2_data_anual"
                    + " FROM "
                    + "     tbl_abrir_turno2 WHERE data_relatorio = '" + data + "'");

            JRResultSetDataSource jrRs = new JRResultSetDataSource(getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("Relatorios/turnoMensal.jasper");
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
    
    public boolean gerarRelatorioaNUAL(String data) {
        try {
            this.conectar(); 
            this.executarSQL("SELECT"
                    + "     tbl_abrir_turno2.pk_id_abrir_turno AS tbl_abrir_turno2_pk_id_abrir_turno,"
                    + "     tbl_abrir_turno2.fk_turno AS tbl_abrir_turno2_fk_turno,"
                    + "     tbl_abrir_turno2.fk_usuario AS tbl_abrir_turno2_fk_usuario,"
                    + "     tbl_abrir_turno2.nome AS tbl_abrir_turno2_nome,"
                    + "     tbl_abrir_turno2.data AS tbl_abrir_turno2_data," 
                    + "     tbl_abrir_turno2.hora AS tbl_abrir_turno2_hora," 
                    + "     tbl_abrir_turno2.valor AS tbl_abrir_turno2_valor,"
                    + "     tbl_abrir_turno2.data_fechar AS tbl_abrir_turno2_data_fechar,"
                    + "     tbl_abrir_turno2.hora_fechar AS tbl_abrir_turno2_hora_fechar,"
                    + "     tbl_abrir_turno2.data_relatorio AS tbl_abrir_turno2_data_relatorio,"
                    + "     tbl_abrir_turno2.data_anual AS tbl_abrir_turno2_data_anual"
                    + " FROM "
                    + "     tbl_abrir_turno2 WHERE data_anual = '" + data + "'"); 

            JRResultSetDataSource jrRs = new JRResultSetDataSource(getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("Relatorios/relatorioAnualTurno.jasper");
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
