/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */  
package View;  
 
import Controller.ControllerAbrirTuur;
import Controller.ControllerAbrirTuur2; 
import Controller.ControllerCliente;
import Controller.ControllerId;
import Controller.ControllerProduto;
import Controller.ControllerProdutoVendaProduto;
import Controller.ControllerSangria;
import Controller.ControllerVendaCliente; 
import Controller.ControllerVendaProduto2; 
import Controller.ControllerVendaProdutoAbandono;
import Controller.ControllerVendaProdutoAbandono2;
import Controller.ControllerVendaProdutoCartao;
import Controller.ControllerVendaProdutoCartao2;
import Controller.ControllerVendaProdutoTickets;
import Controller.ControllerVendaProdutoTickets2;
import Model.ModelCliente;
import Model.ModelProduto;
import Model.ModelProdutoVendaProduto;
import Model.ModelVendaCliente;
import Controller.ControllerVendaProduto;  
import Controller.Controllervenda; 
import Controller.Controllervenda2;
import Controller.ControllervendaAbandono;
import Controller.ControllervendaAbandono2;
import Controller.ControllervendaCancelada;
import Controller.ControllervendaCancelamento2;
import Controller.ControllervendaCancelamentoCartao;
import Controller.ControllervendaCancelamentoCartao2;
import Controller.ControllervendaCancelamentoTickets;
import Controller.ControllervendaCancelamentoTickets2;
import Controller.ControllervendaCartao;
import Controller.ControllervendaCartao2;
import Controller.ControllervendaTickets;
import Controller.ControllervendaTickets2;
import Dao.DaoVenda;
import Dao.DaoVendaProduto;
import Dao.DaoAbrirTurno;
import Dao.DaoSangria;
import Dao.DaoVendaAbandono;
import Dao.DaoVendaAbandono2; 
import Dao.DaoVendaCancelamento;
import Dao.DaoVendaCancelamento2;
import Dao.DaoVendaCancelamentoCartao;
import Dao.DaoVendaCancelamentoCartao2;
import Dao.DaoVendaCancelamentoTickets;
import Dao.DaoVendaCartao;
import Dao.DaoVendaProdutoAbandono;       
import Dao.DaoVendaProdutoCartao;
import Dao.DaoVendaProdutoTickets; 
import Dao.DaoVendaTickts;
import Model.ModelAbrirTurno;
import Model.ModelAbrirTurno2;
import Model.ModelId;
import Model.ModelSangria;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.ModelVenda;
import Model.ModelVenda2;
import Model.ModelVendaAbandono;
import Model.ModelVendaAbandono2;
import Model.ModelVendaCancelamento;
import Model.ModelVendaCancelamento2;
import Model.ModelVendaCancelamentoCartao;
import Model.ModelVendaCancelamentoCartao2;
import Model.ModelVendaCancelamentoTickets;
import Model.ModelVendaCancelamentoTickets2;
import Model.ModelVendaCartao;
import Model.ModelVendaCartao2;
import Model.ModelVendaProduto;
import Model.ModelVendaProduto2;
import Model.ModelVendaProdutoAbandono;
import Model.ModelVendaProdutoAbandono2;
import Model.ModelVendaProdutoCartao;
import Model.ModelVendaProdutoCartao2;
import Model.ModelVendaProdutoTickets;
import Model.ModelVendaProdutoTickets2;
import Model.ModelVendaTickets;
import Model.ModelVendaTickets2;
import Util.Formatador;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat; 
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttribute;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.Timer;
 
/**  
 * 
 * @author Monet
 */
public class ViewFecharTurno extends javax.swing.JFrame {
    
    
    ModelId modelId = new ModelId();
    ControllerId controllerId = new ControllerId();
    
    DecimalFormat df = new DecimalFormat("#.00");
    Formatador formatador = new Formatador(); 
    ModelCliente modelCliente = new ModelCliente();
    ControllerCliente controllerCliente = new ControllerCliente();
    ArrayList<ModelCliente> listaModelCliente = new ArrayList<>();
    
    ModelProduto modelProduto = new ModelProduto();
    ControllerProduto controllerProduto = new ControllerProduto();
    ArrayList<ModelProduto> listaModelProduto = new ArrayList<>(); 
    
    
    ModelVenda modelVenda = new ModelVenda();
    Controllervenda controllervenda = new Controllervenda();
    ArrayList<ModelVenda> listaModelVenda = new ArrayList<>();
     
    ModelVendaCartao modelVendaCartao = new ModelVendaCartao();
    ControllervendaCartao controllervendaCartao = new ControllervendaCartao();
    ArrayList<ModelVendaCartao> listaModelVendaCartao = new ArrayList<>();
    
    
    
   
    
    ModelVendaTickets modelVendaTickets = new ModelVendaTickets();
    ControllervendaTickets controllerVendaTickets = new ControllervendaTickets();
    ArrayList<ModelVendaTickets> listaModelVendaTickets=new ArrayList<>();   
    ControllerProdutoVendaProduto controllerProdutoVendaProduto = new ControllerProdutoVendaProduto();
    ArrayList<ModelProdutoVendaProduto> listaProdutoVendaProduto = new ArrayList<>();
    
    ModelVenda2 modelVenda2 = new ModelVenda2();
    Controllervenda2 controllervenda2 = new Controllervenda2();
    ArrayList<ModelVenda2> listaModelVenda2 = new ArrayList<>();
    
  
    
    //excluimdo as tabelas do terminal
    DaoVendaProduto daoVendaProduto = new DaoVendaProduto();
    DaoVendaProdutoCartao daoVendaProdutocartao = new DaoVendaProdutoCartao();
    DaoVendaProdutoTickets daoVendaProdutoTickets = new DaoVendaProdutoTickets();
    DaoVenda daoVenda = new DaoVenda();
    DaoVendaCartao daoVendaCartao = new DaoVendaCartao();
    DaoVendaTickts daoVendaTickets = new DaoVendaTickts();
    DaoSangria daoSangria = new DaoSangria();
    DaoVendaAbandono daoVendaAbandono = new DaoVendaAbandono();
    DaoVendaProdutoAbandono daoVendaProdutoAbandoono = new DaoVendaProdutoAbandono();
    DaoVendaCancelamentoCartao daoVendaCancelamentoCartao2 = new DaoVendaCancelamentoCartao();
    DaoVendaCancelamentoTickets daoVendaCancelamentoTickets = new DaoVendaCancelamentoTickets();
    //alterando o estado do turno
     ModelAbrirTurno modelAbrirTurno = new ModelAbrirTurno();
     ControllerAbrirTuur controllerAbrirTuur = new ControllerAbrirTuur();
    
    
    String alteraOuSalva;  
    public ViewFecharTurno() {
         
       initComponents();   
       setIcon();
       DaoAbrirTurno.numeros2();
       listandoVendasCanceladaTickets();
       listandoVendasCanceladaCartao();
       listarSangria();
       listandoVendas();
       listandoVendasCartao();
       listandoVendasTickets();
       listandoVendasAbandonadas(); 
       listandoVendasCanceladas();
       listandoVendasProdutotickets(); 
       listandoVendasProdutoCartao();
       listandoVendasParcelas();      
       listandoVendasNormal();
       listandoVendasProdutoAbandono();
       listandoVendasDinheiroProduto();
    } 
    
   
    private void troco(){
        ModelAbrirTurno modelAbrirTurno = new ModelAbrirTurno();
        ControllerAbrirTuur controllerAbrirtuurr = new ControllerAbrirTuur();
     
        modelAbrirTurno = controllerAbrirtuurr.retornarTurnoController(Integer.parseInt(tfIdOperador.getText()));
        tfTroco.setText(String.valueOf(modelAbrirTurno.getValor()));
        tfNumeroTurno.setText(modelAbrirTurno.getFkTurno()+"");
    }
    
     class hora implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Date sistemaHora = new Date();
            String pmAm = "HH:mm:ss";
            SimpleDateFormat formato = new SimpleDateFormat(pmAm);
            Calendar now = Calendar.getInstance();
            tfFecharTurnoHora.setText(String.format(formato.format(sistemaHora), now));
        }
    }
    
    
    private void listandoVendasNormal(){
      DefaultTableModel modelo = (DefaultTableModel) tabelaVendasParcelaAvista.getModel();
    listaModelVenda = controllervenda.getListavendaController();
    int cont = listaModelVenda.size();
    modelo.setNumRows(0);
    for (int i = 0; i< cont;i++){ 
     
        modelo.addRow(new Object[]{    
        
       listaModelVenda.get(i).getIdVenda(),
       listaModelVenda.get(i).getCliente(),
       listaModelVenda.get(i).getHora(),
       listaModelVenda.get(i).getData(), 
       listaModelVenda.get(i).getValorBruto(), 
       listaModelVenda.get(i).getValorDesconto(),
       listaModelVenda.get(i).getValorLiquido(),
       listaModelVenda.get(i).getUsuario(),
       listaModelVenda.get(i).getPagamento(),
       listaModelVenda.get(i).getData_relatorio(),
       listaModelVenda.get(i).getAno()
     
               });
     
    }
    }
    private void listandoVendas(){
      DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
    listaModelVenda = controllervenda.getListavendaController();
    int cont = listaModelVenda.size();
    modelo.setNumRows(0);
    for (int i = 0; i< cont;i++){
       if(listaModelVenda.get(i).getPagamento().equals("À vista")){
        modelo.addRow(new Object[]{
         
       listaModelVenda.get(i).getIdVenda(),
       listaModelVenda.get(i).getCliente(),
       listaModelVenda.get(i).getHora(),
       listaModelVenda.get(i).getData(),
       listaModelVenda.get(i).getValorBruto(),
       listaModelVenda.get(i).getValorDesconto(), 
       listaModelVenda.get(i).getValorLiquido(),
       listaModelVenda.get(i).getUsuario(),
       listaModelVenda.get(i).getPagamento()
     
       
      
               
               });
    }
    }
    }
    private void listandoVendasAbandonadas(){
        
        ModelVendaAbandono modelVendaAbandono = new ModelVendaAbandono();
        ControllervendaAbandono controllervendaAbandono = new ControllervendaAbandono();
        ArrayList<ModelVendaAbandono> listaModelVendaAbandono = new ArrayList<>();
         
      DefaultTableModel modelo = (DefaultTableModel) tabelaAbandono.getModel();
    listaModelVendaAbandono = controllervendaAbandono.getListavendaController();
    int cont = listaModelVendaAbandono.size();
    modelo.setNumRows(0);
    for (int i = 0; i< cont;i++){
      
        modelo.addRow(new Object[]{
       
       listaModelVendaAbandono.get(i).getIdVenda(),
       listaModelVendaAbandono.get(i).getCliente(),
       listaModelVendaAbandono.get(i).getHora(),
       listaModelVendaAbandono.get(i).getData(),
       listaModelVendaAbandono.get(i).getValorBruto(),
       listaModelVendaAbandono.get(i).getValorDesconto(),
       listaModelVendaAbandono.get(i).getValorLiquido(),
       listaModelVendaAbandono.get(i).getUsuario(),
       listaModelVendaAbandono.get(i).getPagamento()
               
               });
    
    }
    }
    private void listandoVendasCanceladas(){
         
        ModelVendaCancelamento modelVendaCancelamento = new ModelVendaCancelamento();
        ControllervendaCancelada controllervendaCancelada = new ControllervendaCancelada();
        ArrayList<ModelVendaCancelamento> listaVendaCancelada = new ArrayList<>();
        
      DefaultTableModel modelo = (DefaultTableModel) tabelaCancelamento.getModel();
    listaVendaCancelada = controllervendaCancelada.getListavendaController();
    int cont = listaVendaCancelada.size();
    modelo.setNumRows(0);
    for (int i = 0; i< cont;i++){
      
        modelo.addRow(new Object[]{
       
       listaVendaCancelada.get(i).getFkVenda(),
       listaVendaCancelada.get(i).getCliente(),
       listaVendaCancelada.get(i).getHora(),
       listaVendaCancelada.get(i).getData(),
       listaVendaCancelada.get(i).getValorBruto(),
       listaVendaCancelada.get(i).getValorDesconto(),
       listaVendaCancelada.get(i).getValorLiquido(),
       listaVendaCancelada.get(i).getUsuario(),
       listaVendaCancelada.get(i).getPagamento()
               
               });
    
    }
    }
    private void listandoVendasCartao(){
      DefaultTableModel modelo = (DefaultTableModel) tabelaCartao.getModel();
    listaModelVendaCartao = controllervendaCartao.getListavendaController();
    int cont = listaModelVendaCartao.size();
    modelo.setNumRows(0);
    for (int i = 0; i< cont;i++){
        modelo.addRow(new Object[]{
        
       listaModelVendaCartao.get(i).getIdVenda(),
       listaModelVendaCartao.get(i).getCliente(),
       listaModelVendaCartao.get(i).getHora(),
       listaModelVendaCartao.get(i).getData(),
       listaModelVendaCartao.get(i).getValorBruto(),
       listaModelVendaCartao.get(i).getValorDesconto(),
       listaModelVendaCartao.get(i).getValorLiquido(),
       listaModelVendaCartao.get(i).getUsuario(),
       listaModelVendaCartao.get(i).getData_relatorio(),
       listaModelVendaCartao.get(i).getDataAnual()
        });
        
        
    }   
    }
     private void listandoVendasCanceladaCartao(){
     ModelVendaCancelamentoCartao modelVendaProdutoAbandono = new ModelVendaCancelamentoCartao();
     ControllervendaCancelamentoCartao controllerProdutoAbandono = new ControllervendaCancelamentoCartao();
     ArrayList<ModelVendaCancelamentoCartao> listaProdutooAbandono = new ArrayList<>();
     DefaultTableModel modelo = (DefaultTableModel) tabelaCancelamentoCartao.getModel();
    listaProdutooAbandono = controllerProdutoAbandono.getListavendaController();
    int cont = listaProdutooAbandono.size();
    modelo.setNumRows(0);
    for (int i = 0; i< cont;i++){
        modelo.addRow(new Object[]{ 
        
       listaProdutooAbandono.get(i).getFkVenda(),
       listaProdutooAbandono.get(i).getCliente(),
       listaProdutooAbandono.get(i).getHora(),
       listaProdutooAbandono.get(i).getData(),
       listaProdutooAbandono.get(i).getValorBruto(),
       listaProdutooAbandono.get(i).getValorDesconto(),
       listaProdutooAbandono.get(i).getValorLiquido(),
       listaProdutooAbandono.get(i).getUsuario()
        });
        
        
    }   
    }
     
     
        private void listandoVendasCanceladaTickets(){
            ModelVendaCancelamentoTickets modelVendaProdutoAbandono = new ModelVendaCancelamentoTickets();
            ControllervendaCancelamentoTickets controllerProdutoAbandono = new ControllervendaCancelamentoTickets();
     ArrayList<ModelVendaCancelamentoTickets> listaProdutooAbandono = new ArrayList<>();
     DefaultTableModel modelo = (DefaultTableModel) tabelaCancelamentoTickets.getModel();
    listaProdutooAbandono = controllerProdutoAbandono.getListavendaController();
    int cont = listaProdutooAbandono.size();
    modelo.setNumRows(0);
    for (int i = 0; i< cont;i++){
        modelo.addRow(new Object[]{ 
        
       listaProdutooAbandono.get(i).getFkVenda(),
       listaProdutooAbandono.get(i).getCliente(),
       listaProdutooAbandono.get(i).getHora(),
       listaProdutooAbandono.get(i).getData(),
       listaProdutooAbandono.get(i).getValorBruto(),
       listaProdutooAbandono.get(i).getValorDesconto(),
       listaProdutooAbandono.get(i).getValorLiquido(),
       listaProdutooAbandono.get(i).getUsuario()
        });
        
        
    }   
    }
     
     
     
     
     
    private void listandoVendasTickets(){
      DefaultTableModel modelo = (DefaultTableModel) tabelaTickets.getModel();
    listaModelVendaTickets = controllerVendaTickets.getListavendaController();
    int cont = listaModelVendaTickets.size();
    modelo.setNumRows(0);
    for (int i = 0; i< cont;i++){ 
        modelo.addRow(new Object[]{ 
        
       listaModelVendaTickets.get(i).getIdVenda(),
       listaModelVendaTickets.get(i).getCliente(),
       listaModelVendaTickets.get(i).getHora(),
       listaModelVendaTickets.get(i).getData(),
       listaModelVendaTickets.get(i).getValorBruto(),
       listaModelVendaTickets.get(i).getValorDesconto(),
       listaModelVendaTickets.get(i).getValorLiquido(),
       listaModelVendaTickets.get(i).getUsuario(), 
       listaModelVendaTickets.get(i).getData_relatorio(),
       listaModelVendaTickets.get(i).getDataAnual()
    
        });
         
         
    }    
    }
       private void listandoVendasProdutotickets(){
    ModelVendaProdutoTickets modelVendaProdutoTickets = new ModelVendaProdutoTickets();
    ControllerVendaProdutoTickets controllerVendaProdutoTickets = new ControllerVendaProdutoTickets();
    ArrayList<ModelVendaProdutoTickets> listaModelProdutosTickets = new ArrayList<>();
      DefaultTableModel modelo = (DefaultTableModel) tabelaProdutoTickets.getModel();
    listaModelProdutosTickets = controllerVendaProdutoTickets.getListaVendaProdutoController();
    int cont = listaModelProdutosTickets.size();
    modelo.setNumRows(0);
    for (int i = 0; i< cont;i++){
        modelo.addRow(new Object[]{
        
       listaModelProdutosTickets.get(i).getIdVendaDinheiroPro(),
       listaModelProdutosTickets.get(i).getProduto(),
       listaModelProdutosTickets.get(i).getQuantidade(),
       listaModelProdutosTickets.get(i).getUsuario(),
       listaModelProdutosTickets.get(i).getValorVenda(),
       listaModelProdutosTickets.get(i).getVenda(),
       listaModelProdutosTickets.get(i).getNome_produto(), 
       listaModelProdutosTickets.get(i).getAno(),
       listaModelProdutosTickets.get(i).getMesAno()
     
        }); 
        
        
    }   
    }
    private void listandoVendasProdutoCartao(){
    ModelVendaProdutoCartao modelVendaProdutoCartao = new ModelVendaProdutoCartao();
    ControllerVendaProdutoCartao controllerVendaProdutoCartao = new ControllerVendaProdutoCartao();
    ArrayList<ModelVendaProdutoCartao> listaCartao=new ArrayList<>();
    DefaultTableModel modelo = (DefaultTableModel) tabelaProdutoCartao.getModel();
    listaCartao = controllerVendaProdutoCartao.getListaVendaProdutoController();
    int cont = listaCartao.size();
    modelo.setNumRows(0);   
    for (int i = 0; i< cont;i++){
        modelo.addRow(new Object[]{
        
       listaCartao.get(i).getIdVendaDinheiroPro(), 
       listaCartao.get(i).getProduto(),
       listaCartao.get(i).getQuantidade(), 
       listaCartao.get(i).getUsuario(), 
       listaCartao.get(i).getValorVenda(),
       listaCartao.get(i).getVenda(),
       listaCartao.get(i).getNome_produto(),
       listaCartao.get(i).getMes(),
       listaCartao.get(i).getAno() 
      
        });
        
        
    }   
    }
     
    
    
      private void listandoVendasProdutoAbandono(){ 
          
          ModelVendaProdutoAbandono modelVendaProdutoAbandono = new ModelVendaProdutoAbandono();
          ControllerVendaProdutoAbandono controllerProdutoAbandono = new ControllerVendaProdutoAbandono();
          ArrayList<ModelVendaProdutoAbandono> listaProdutooAbandono = new ArrayList<>();
          
      DefaultTableModel modelo = (DefaultTableModel) tabelaVendaAbandonoProduto.getModel();
    listaProdutooAbandono = controllerProdutoAbandono.getListaVendaProdutoController();
    int cont = listaProdutooAbandono.size();
    modelo.setNumRows(0);   
    for (int i = 0; i< cont;i++){
        modelo.addRow(new Object[]{
        
       listaProdutooAbandono.get(i).getIdVendaDinheiroPro(),
       listaProdutooAbandono.get(i).getProduto(),
       listaProdutooAbandono.get(i).getQuantidade(), 
       listaProdutooAbandono.get(i).getUsuario(), 
       listaProdutooAbandono.get(i).getValorVenda(),
       listaProdutooAbandono.get(i).getVenda(), 
       listaProdutooAbandono.get(i).getNome_produto()
     
        });
        
        
    }   
    } 
       
    private void listandoVendasDinheiroProduto(){
    ModelVendaProduto modelVendaProduto = new ModelVendaProduto();
    ControllerVendaProduto controllerVendaProduto = new ControllerVendaProduto();
    ArrayList<ModelVendaProduto> listaModelVendaProduto = new ArrayList<>();
    
    listaModelVendaProduto = new ArrayList<>();
    DefaultTableModel modelo = (DefaultTableModel) tabelaVendaProdutoDinheiro.getModel();
    listaModelVendaProduto = controllerVendaProduto.getListaVendaProdutoController();
    int cont = listaModelVendaProduto.size();
    modelo.setNumRows(0);
    for (int i = 0; i< cont;i++){
        modelo.addRow(new Object[]{
        
       listaModelVendaProduto.get(i).getVenda(),
       listaModelVendaProduto.get(i).getProduto(),
       listaModelVendaProduto.get(i).getQuantidade(),
       listaModelVendaProduto.get(i).getUsuario(), 
       listaModelVendaProduto.get(i).getValorVenda(),
       listaModelVendaProduto.get(i).getNome_produto(),
       
       listaModelVendaProduto.get(i).getAno(),
       listaModelVendaProduto.get(i).getMesAno()
       
     
        });
        
        
    }   
    }
  private void listandoVendasParcelas(){
      DefaultTableModel modelo = (DefaultTableModel) tabelaParcelas.getModel();
    listaModelVenda = controllervenda.getListavendaController();
    int cont = listaModelVenda.size();
    modelo.setNumRows(0);
    for (int i = 0; i< cont;i++){
        if(listaModelVenda.get(i).getPagamento().equals("Parcelamento")){
        modelo.addRow(new Object[]{
       
       listaModelVenda.get(i).getIdVenda(),
       listaModelVenda.get(i).getCliente(),
       listaModelVenda.get(i).getHora(),
       listaModelVenda.get(i).getData(),
       listaModelVenda.get(i).getValorBruto(),
       listaModelVenda.get(i).getValorDesconto(), 
       listaModelVenda.get(i).getValorLiquido()
               
               });
    }
    }
    
    }
 private void listandoVendasProdutoDinheiroParcelado(){
      ModelVendaProduto modelVendaProduto = new ModelVendaProduto();
    ControllerVendaProduto controllerVendaProduto = new ControllerVendaProduto();
    ArrayList<ModelVendaProduto> listaModelVendaProduto = new ArrayList<>();
      DefaultTableModel modelo = (DefaultTableModel) tabelaVendaProdutoDinheiro.getModel();
    listaModelVendaProduto = controllerVendaProduto.getListaVendaProdutoController();
    int cont = listaModelVendaProduto.size();
    modelo.setNumRows(0);
    for (int i = 0; i< cont;i++){
        modelo.addRow(new Object[]{
        
       listaModelVendaProduto.get(i).getIdVendaDinheiroPro(),
       listaModelVendaProduto.get(i).getProduto(),
       listaModelVendaProduto.get(i).getQuantidade(),
       listaModelVendaProduto.get(i).getUsuario(),
       listaModelVendaProduto.get(i).getValorVenda(),
       listaModelVendaProduto.get(i).getVenda()
     
        });
        
        
    }   
    }
 
    private float calculandoValorDinheiro(){
    int cont = tabela.getRowCount();
    float valor=0, soma=0;        
    for (int i = 0; i < cont; i++) {
    valor = Float.parseFloat(String.valueOf(tabela.getValueAt(i, 6)));
    soma +=valor;
    tfValorDinheiro.setText(formatador.arredondamentoValoresFloat(soma)+"");
    }
    return soma;
    }
    
    private int calculandoNumeroVendaDinheiro(){
    int cont = tabela.getRowCount();
      
    for (int i = 0; i < cont; i++) {
    
    tfNumeroVendasAvista.setText(cont+"");  
    } 
    return cont;
    }
     private int calculandoNumeroCancelCartao(){
    int cont = tabelaCancelamentoCartao.getRowCount();
      
    for (int i = 0; i < cont; i++) {
    
    tfNumeroCancelCartao.setText(cont+"");  
    } 
    return cont;
    }
     
      private int calculandoNumeroCancelTickets(){
    int cont = tabelaCancelamentoTickets.getRowCount();
      
    for (int i = 0; i < cont; i++) {
    
    tfNumeroCancelTickets.setText(cont+"");  
    } 
    return cont;
    }
     
     
    private int calculandoNumeroVendaParcelas(){
    int cont = tabelaParcelas.getRowCount();
       
    for (int i = 0; i < cont; i++) {
    
    tfNumeroVendaParcelada.setText(cont+"");  
    } 
    return cont;
    }
    
     private int calculandoNumeroVendaCartao(){
    int cont = tabelaCartao.getRowCount();
       
    for (int i = 0; i < cont; i++) {
    
    tfNumeroVendasCartao.setText(cont+"");  
    } 
    return cont;
    }
     private int calculandoNumeroVendaTickets(){
    int cont = tabelaTickets.getRowCount();
       
    for (int i = 0; i < cont; i++) {
    
    tfNumeroVendaTickets.setText(cont+"");  
    } 
    return cont;
    }
     private float calculandoValorSangria(){
    int cont = tabelaSangria.getRowCount();
    float valor=0, soma=0;        
    for (int i = 0; i < cont; i++) {
    valor = Float.parseFloat(String.valueOf(tabelaSangria.getValueAt(i, 1)));
    soma +=valor;
    df.format(soma);
    tfSangria.setText(soma+"");
    tfSangriaValor.setText(soma+"");
    }
    return soma;
    }
    
    
    
    private float calculandoValorCartao(){
    int cont = tabelaCartao.getRowCount();
    float valor=0, soma=0;        
    for (int i = 0; i < cont; i++) {
    valor = Float.parseFloat(String.valueOf(tabelaCartao.getValueAt(i, 6)));
    soma +=valor;
    df.format(soma);
    tfCartaoTotal.setText(formatador.arredondamentoValoresFloat(soma)+"");   
    }
    return soma;
    }
    
     private float calculandoValorAbandono(){
    int cont = tabelaAbandono.getRowCount();
    float valor=0, soma=0;        
    for (int i = 0; i < cont; i++) {
    valor = Float.parseFloat(String.valueOf(tabelaAbandono.getValueAt(i, 4)));
    soma +=valor; 
    df.format(soma);
    tfAbandono.setText(formatador.arredondamentoValoresFloat(soma)+"");
    }
    return soma;
    }
       private float calculandoValorCancelamento(){
    int cont = tabelaCancelamento.getRowCount();
    float valor=0, soma=0;        
    for (int i = 0; i < cont; i++) {
    valor = Float.parseFloat(String.valueOf(tabelaCancelamento.getValueAt(i, 4)));
    soma +=valor; 
    df.format(soma);
    tfValorCancelamentosDinheiro.setText(soma+"");
    }
    return soma;
    }
      private float calculandoValorCancelamentoTickets(){
    int cont = tabelaCancelamentoTickets.getRowCount();
    float valor=0, soma=0;        
    for (int i = 0; i < cont; i++) {
    valor = Float.parseFloat(String.valueOf(tabelaCancelamentoTickets.getValueAt(i, 4)));
    soma +=valor; 
    df.format(soma);
    tfValorCancelamentoTickets.setText(soma+"");
    }
    return soma;
    }
     private int calculandoNumeroAbandono(){
    int cont = tabelaAbandono.getRowCount();
      
    for (int i = 0; i < cont; i++) {
    
    tfNumeroAbandono.setText(cont+"");  
    } 
    return cont;
    }
     
       private int calculandoNumeroCancelamentos(){
    int cont = tabelaCancelamento.getRowCount();
      
    for (int i = 0; i < cont; i++) {
    
    tfNumeroCancelamentos.setText(cont+"");  
    } 
    return cont;
    }
     
     private float calculandoValorTickets(){
    int cont = tabelaTickets.getRowCount();
    float valor=0, soma=0;        
    for (int i = 0; i < cont; i++) {
    valor = Float.parseFloat(String.valueOf(tabelaTickets.getValueAt(i, 6)));
    soma =valor;
    df.format(soma);
    tfTickets.setText(formatador.arredondamentoValoresFloat(soma)+""); 
    }
    return soma;
    }
     
      private float calculandoValorParcelado(){
    int cont = tabelaParcelas.getRowCount();
    float valor=0, soma=0;        
    for (int i = 0; i < cont; i++) {
    valor = Float.parseFloat(String.valueOf(tabelaParcelas.getValueAt(i, 6)));
    soma +=valor;
    df.format(soma);
    tfVendaParcelada.setText(formatador.arredondamentoValoresFloat(soma)+"");
    }
    return soma;
    }
      
         private float calculandoValorVendaParcelasAvista(){
    int cont = tabelaVendasParcelaAvista.getRowCount();
    float valor=0, soma=0;        
    for (int i = 0; i < cont; i++) {
    valor = Float.parseFloat(String.valueOf(tabelaVendasParcelaAvista.getValueAt(i, 6)));
    soma +=valor;
    df.format(soma);
    tfVendaParcelaAvista.setText(formatador.arredondamentoValoresFloat(soma)+"");
    
    }
    return soma;
    }  
         
           
      private float calculandoValorDasVendas(){
          float valorDinheiro, valorCartao, valorTickets, total = 0;
          valorDinheiro = Float.parseFloat(tfVendaParcelaAvista.getText());
          valorCartao = Float.parseFloat(tfCartaoTotal.getText());
          valorTickets = Float.parseFloat(tfTickets.getText());
          total += valorDinheiro+valorCartao+valorTickets; 
          df.format(total);

          return total; 
      }    
      
          private float calculandoValorFinal(){
          float valorDinheiro, valorCartao, valorTickets, sangria, troco, total=0;
          try {    
              
          valorDinheiro = Float.parseFloat(tfVendaParcelaAvista.getText());
          valorCartao = Float.parseFloat(tfCartaoTotal.getText());
          valorTickets = Float.parseFloat(tfTickets.getText());
          sangria = Float.parseFloat(tfSangria.getText());
          troco = Float.parseFloat(tfTroco.getText());
          total = (valorDinheiro+valorCartao+valorTickets)-sangria+troco; 
          df.format(total); 
          tfValorFinal.setText(df.format(total)); 
          } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Você não é o usuário que iniciou este turno!");
              }
          return total; 
      }   
          
            private float calculandoValorFinal2(){
          float valorDinheiro, valorCartao, valorTickets, sangria, troco, total=0, parcela;
          try {    
              parcela = Float.parseFloat(tfVendaParcelada.getText());
          valorDinheiro = Float.parseFloat(tfVendaParcelaAvista.getText());
          valorCartao = Float.parseFloat(tfCartaoTotal.getText());
          valorTickets = Float.parseFloat(tfTickets.getText());
          sangria = Float.parseFloat(tfSangria.getText());
          troco = Float.parseFloat(tfTroco.getText());
          total = (valorDinheiro+valorCartao+valorTickets-parcela)-sangria+troco; 
          df.format(total); 
          tfValorFinal2.setText(df.format(total)); 
          } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Você não é o usuário que iniciou este turno!");
              }
          return total; 
      }   
      
       
      
         private float calculandoValorTotal(){
          float valorDinheiro, valorCartao, valorTickets, parcelas, total = 0, sub = 0, sangria = 0, troco = 0;
           
          
          valorDinheiro = Float.parseFloat(tfVendaParcelaAvista.getText());
          valorCartao = Float.parseFloat(tfCartaoTotal.getText());
          valorTickets = Float.parseFloat(tfTickets.getText());
          parcelas = Float.parseFloat(tfVendaParcelada.getText());
          total = (valorDinheiro+valorCartao+valorTickets)-parcelas;  
          tfTotal.setText(String.valueOf(df.format(total)));
          return total;
      }      
      private float calculandoValorSangriaTotal(){
          float valorDinheiro, valorCartao, valorTickets, sangria, total = 0;
          valorDinheiro = Float.parseFloat(tfVendaParcelaAvista.getText());
          valorCartao = Float.parseFloat(tfCartaoTotal.getText());
          valorTickets = Float.parseFloat(tfTickets.getText());
          sangria = Float.parseFloat(tfSangria.getText());        
          total = (valorDinheiro+valorCartao+valorTickets)-sangria;          
          tfSomandoSangria.setText(df.format(total)+"");
          return total; 
      }  
      
      
     private int somaaQuantiadadeParcelaAvista(){
           int parcela, avista, soma, total;
           parcela = Integer.parseInt(tfNumeroVendaParcelada.getText());
           avista = Integer.parseInt(tfNumeroVendasAvista.getText());
           soma = avista+parcela;
           return soma;
       }  
    private void salvarVendasDoDinheiro(){
    int percorrer;
      
      
    percorrer = tabelaVendasParcelaAvista.getRowCount(); 
        for (int i = 0; i < percorrer; i++) {
        modelVenda2 = new ModelVenda2();       
        modelVenda2.setIdVenda(Integer.parseInt(String.valueOf(tabelaVendasParcelaAvista.getValueAt(i, 0))));
        modelVenda2.setCliente(Integer.parseInt(String.valueOf(tabelaVendasParcelaAvista.getValueAt(i, 1))));      
        modelVenda2.setHora(String.valueOf(tabelaVendasParcelaAvista.getValueAt(i, 2)));
        modelVenda2.setData(String.valueOf(tabelaVendasParcelaAvista.getValueAt(i, 3)));
        modelVenda2.setValorBruto(Double.parseDouble(String.valueOf(tabelaVendasParcelaAvista.getValueAt(i, 4))));
        modelVenda2.setValorDesconto(Double.parseDouble(String.valueOf(tabelaVendasParcelaAvista.getValueAt(i, 5))));
        modelVenda2.setValorLiquido(Double.parseDouble(String.valueOf(tabelaVendasParcelaAvista.getValueAt(i, 6))));
        modelVenda2.setUsuario(Integer.parseInt(String.valueOf(tabelaVendasParcelaAvista.getValueAt(i, 7))));
        modelVenda2.setPagamento(String.valueOf(tabelaVendasParcelaAvista.getValueAt(i, 8)));
        modelVenda2.setData_relatorio(String.valueOf(tabelaVendasParcelaAvista.getValueAt(i, 9)));    
        modelVenda2.setdataAnual(String.valueOf(tabelaVendasParcelaAvista.getValueAt(i, 10)));
        modelVenda2.setTurno(Integer.parseInt(String.valueOf(tfNumeroTurno.getText()))); //

        modelVenda2.setQuantidade(somaaQuantiadadeParcelaAvista());
        modelVenda2.setValorTotal(tfVendaParcelaAvista.getText()); 
        listaModelVenda2.add(modelVenda2);     
        } 
        if(controllervenda2.salvarVendaProdutoController(listaModelVenda2)){   
        
        }
    }
     
    
     private void salvarVendasAbandonada(){
         ModelVendaAbandono2 modelVendaAbandono2 = new ModelVendaAbandono2();
         ControllervendaAbandono2 controllervendaAbandono2 = new ControllervendaAbandono2();
         ArrayList<ModelVendaAbandono2> listaAbandono2 = new ArrayList<>();
         
         int percorrer;    
    percorrer = tabelaAbandono.getRowCount();
        for (int i = 0; i < percorrer; i++) {
        modelVendaAbandono2 = new ModelVendaAbandono2();
        
        modelVendaAbandono2.setFkVenda(Integer.parseInt(String.valueOf(tabelaAbandono.getValueAt(i, 0))));
        modelVendaAbandono2.setCliente(Integer.parseInt(String.valueOf(tabelaAbandono.getValueAt(i, 1))));      
        modelVendaAbandono2.setHora(String.valueOf(tabelaAbandono.getValueAt(i, 2)));
        modelVendaAbandono2.setData(String.valueOf(tabelaAbandono.getValueAt(i, 3)));
        modelVendaAbandono2.setValorBruto(Double.parseDouble(String.valueOf(tabelaAbandono.getValueAt(i, 4))));
        modelVendaAbandono2.setValorDesconto(Double.parseDouble(String.valueOf(tabelaAbandono.getValueAt(i, 5))));
        modelVendaAbandono2.setValorLiquido(Double.parseDouble(String.valueOf(tabelaAbandono.getValueAt(i, 6))));
        modelVendaAbandono2.setUsuario(Integer.parseInt(String.valueOf(tabelaAbandono.getValueAt(i, 7))));
        modelVendaAbandono2.setPagamento(String.valueOf(tabelaAbandono.getValueAt(i, 8)));
        
        listaAbandono2.add(modelVendaAbandono2);    
        }  
        if(controllervendaAbandono2.salvarVendaProdutoController(listaAbandono2)){
     
        }
    }
     
    private void salvarCancelamento(){
    int percorrer;
        ModelVendaCancelamento2 modelVendaCancelamento = new ModelVendaCancelamento2();
        ControllervendaCancelamento2 controllervendaCancelada = new ControllervendaCancelamento2();
        ArrayList<ModelVendaCancelamento2> listaVendaCancelada = new ArrayList<>();
        
        
    percorrer = tabelaCancelamento.getRowCount(); 
        for (int i = 0; i < percorrer; i++) {
        modelVendaCancelamento = new ModelVendaCancelamento2();
        
        modelVendaCancelamento.setFkVenda(Integer.parseInt(String.valueOf(tabelaCancelamento.getValueAt(i, 0))));
        modelVendaCancelamento.setCliente(Integer.parseInt(String.valueOf(tabelaCancelamento.getValueAt(i, 1))));      
        modelVendaCancelamento.setHora(String.valueOf(tabelaCancelamento.getValueAt(i, 2)));
        modelVendaCancelamento.setData(String.valueOf(tabelaCancelamento.getValueAt(i, 3)));
        modelVendaCancelamento.setValorBruto(Double.parseDouble(String.valueOf(tabelaCancelamento.getValueAt(i, 4))));
        modelVendaCancelamento.setValorDesconto(Double.parseDouble(String.valueOf(tabelaCancelamento.getValueAt(i, 5))));
        modelVendaCancelamento.setValorLiquido(Double.parseDouble(String.valueOf(tabelaCancelamento.getValueAt(i, 6))));
        modelVendaCancelamento.setUsuario(Integer.parseInt(String.valueOf(tabelaCancelamento.getValueAt(i, 7))));
        modelVendaCancelamento.setPagamento(String.valueOf(tabelaCancelamento.getValueAt(i, 8)));
        
        listaVendaCancelada.add(modelVendaCancelamento);    
        }   
        if(controllervendaCancelada.salvarVendaProdutoController(listaVendaCancelada)){
       
        }
        
        
       
    }
       
    private void salvarCancelamentoCartao(){
    int percorrer;
        ModelVendaCancelamentoCartao2 modelVendaCancelamento = new ModelVendaCancelamentoCartao2();
        ControllervendaCancelamentoCartao2 controllervendaCancelada = new ControllervendaCancelamentoCartao2();
        ArrayList<ModelVendaCancelamentoCartao2> listaVendaCancelada = new ArrayList<>();
        
        
    percorrer = tabelaCancelamentoCartao.getRowCount(); 
        for (int i = 0; i < percorrer; i++) {
        modelVendaCancelamento = new ModelVendaCancelamentoCartao2();
        
        modelVendaCancelamento.setFkVenda(Integer.parseInt(String.valueOf(tabelaCancelamentoCartao.getValueAt(i, 0))));
        modelVendaCancelamento.setCliente(Integer.parseInt(String.valueOf(tabelaCancelamentoCartao.getValueAt(i, 1))));      
        modelVendaCancelamento.setHora(String.valueOf(tabelaCancelamentoCartao.getValueAt(i, 2)));
        modelVendaCancelamento.setData(String.valueOf(tabelaCancelamentoCartao.getValueAt(i, 3)));
        modelVendaCancelamento.setValorBruto(Double.parseDouble(String.valueOf(tabelaCancelamentoCartao.getValueAt(i, 4))));
        modelVendaCancelamento.setValorDesconto(Double.parseDouble(String.valueOf(tabelaCancelamentoCartao.getValueAt(i, 5))));
        modelVendaCancelamento.setValorLiquido(Double.parseDouble(String.valueOf(tabelaCancelamentoCartao.getValueAt(i, 6))));
        modelVendaCancelamento.setUsuario(Integer.parseInt(String.valueOf(tabelaCancelamentoCartao.getValueAt(i, 7))));
           
        listaVendaCancelada.add(modelVendaCancelamento);    
        }   
        if(controllervendaCancelada.salvarVendaProdutoController(listaVendaCancelada)){
       
        }
        
        
       
    }
    
     private void salvarCancelamentoTickets(){
         
    int percorrer;
         ModelVendaCancelamentoTickets2 modelVendaCancelamento = new ModelVendaCancelamentoTickets2();
         ControllervendaCancelamentoTickets2 controllervendaCancelada = new ControllervendaCancelamentoTickets2();
        ArrayList<ModelVendaCancelamentoTickets2> listaVendaCancelada = new ArrayList<>();
        
        
    percorrer = tabelaCancelamentoTickets.getRowCount(); 
        for (int i = 0; i < percorrer; i++) {
        modelVendaCancelamento = new ModelVendaCancelamentoTickets2();
        
        modelVendaCancelamento.setFkVenda(Integer.parseInt(String.valueOf(tabelaCancelamentoTickets.getValueAt(i, 0))));
        modelVendaCancelamento.setCliente(Integer.parseInt(String.valueOf(tabelaCancelamentoTickets.getValueAt(i, 1))));      
        modelVendaCancelamento.setHora(String.valueOf(tabelaCancelamentoTickets.getValueAt(i, 2)));
        modelVendaCancelamento.setData(String.valueOf(tabelaCancelamentoTickets.getValueAt(i, 3)));
        modelVendaCancelamento.setValorBruto(Double.parseDouble(String.valueOf(tabelaCancelamentoTickets.getValueAt(i, 4))));
        modelVendaCancelamento.setValorDesconto(Double.parseDouble(String.valueOf(tabelaCancelamentoTickets.getValueAt(i, 5))));
        modelVendaCancelamento.setValorLiquido(Double.parseDouble(String.valueOf(tabelaCancelamentoTickets.getValueAt(i, 6))));
        modelVendaCancelamento.setUsuario(Integer.parseInt(String.valueOf(tabelaCancelamentoTickets.getValueAt(i, 7))));
        
        listaVendaCancelada.add(modelVendaCancelamento);    
        }   
        if(controllervendaCancelada.salvarVendaProdutoController(listaVendaCancelada)){
        
        }
        
        
       
    }
    private void salvarVendasDoCartao(){ 
        ModelVendaCartao2 modelVendaCartao2 = new ModelVendaCartao2();
        ControllervendaCartao2 controllerVendaCartao2 = new ControllervendaCartao2();
        ArrayList<ModelVendaCartao2> listaModelVendaCartao2 = new ArrayList<>();
        
    int percorrer;
    percorrer = tabelaCartao.getRowCount();
    for (int i = 0; i < percorrer; i++) { 
    modelVendaCartao2 = new ModelVendaCartao2();     
    modelVendaCartao2.setIdVenda(Integer.parseInt(String.valueOf(tabelaCartao.getValueAt(i, 0))));
    modelVendaCartao2.setCliente(Integer.parseInt(String.valueOf(tabelaCartao.getValueAt(i, 1))));      
    modelVendaCartao2.setHora(String.valueOf(tabelaCartao.getValueAt(i, 2)));
    modelVendaCartao2.setData(String.valueOf(tabelaCartao.getValueAt(i, 3)));
    modelVendaCartao2.setValorBruto(Double.parseDouble(String.valueOf(tabelaCartao.getValueAt(i, 4))));
    modelVendaCartao2.setValorDesconto(Double.parseDouble(String.valueOf(tabelaCartao.getValueAt(i, 5))));
    modelVendaCartao2.setValorLiquido(Double.parseDouble(String.valueOf(tabelaCartao.getValueAt(i, 6))));
    modelVendaCartao2.setUsuario(Integer.parseInt(String.valueOf(tabelaCartao.getValueAt(i, 7))));
    modelVendaCartao2.setData_relatorio(String.valueOf(tabelaCartao.getValueAt(i, 8)));
    modelVendaCartao2.setDataRelatorio(tfDataRelatorio.getText());
    modelVendaCartao2.setDataAnual(String.valueOf(tabelaCartao.getValueAt(i, 9))); 
    modelVendaCartao2.setTurno(Integer.parseInt(tfNumeroTurno.getText())); 
    listaModelVendaCartao2.add(modelVendaCartao2);     
        } 
        if(controllerVendaCartao2.salvarVendaProdutoController(listaModelVendaCartao2)){
       
        }
    }
      
    
     private void salvarVendasDoTickets(){
         ModelVendaTickets2 modelVendaCartao2 = new ModelVendaTickets2();
         ControllervendaTickets2 controllerVendaCartao2 = new ControllervendaTickets2();
        ArrayList<ModelVendaTickets2> listaModelVendaCartao2 = new ArrayList<>();
        
    int percorrer;
    percorrer = tabelaTickets.getRowCount();  
    for (int i = 0; i < percorrer; i++) {
    modelVendaCartao2 = new ModelVendaTickets2();     
    modelVendaCartao2.setIdVenda(Integer.parseInt(String.valueOf(tabelaTickets.getValueAt(i, 0))));
    modelVendaCartao2.setCliente(Integer.parseInt(String.valueOf(tabelaTickets.getValueAt(i, 1))));      
    modelVendaCartao2.setHora(String.valueOf(tabelaTickets.getValueAt(i, 2)));
    modelVendaCartao2.setData(String.valueOf(tabelaTickets.getValueAt(i, 3)));
    modelVendaCartao2.setValorBruto(Double.parseDouble(String.valueOf(tabelaTickets.getValueAt(i, 4))));
    modelVendaCartao2.setValorDesconto(Double.parseDouble(String.valueOf(tabelaTickets.getValueAt(i, 5))));
    modelVendaCartao2.setValorLiquido(Double.parseDouble(String.valueOf(tabelaTickets.getValueAt(i, 6))));
    modelVendaCartao2.setUsuario(Integer.parseInt(String.valueOf(tabelaTickets.getValueAt(i, 7))));
    modelVendaCartao2.setData_relatorio(String.valueOf(tabelaTickets.getValueAt(i, 8)));
    modelVendaCartao2.setDataAnual(String.valueOf(tabelaTickets.getValueAt(i, 9))); 
    modelVendaCartao2.setTurno(Integer.parseInt(tfNumeroTurno.getText()));
        
        listaModelVendaCartao2.add(modelVendaCartao2);    
        } 
        if(controllerVendaCartao2.salvarVendaProdutoController(listaModelVendaCartao2)){
       
        }  
    }
    
    
    
    
    private void salvarVendasProdutoDoDinheiro(){
    ModelVendaProduto2 modelVendaProduto2 = new ModelVendaProduto2();
    ControllerVendaProduto2 controllerVendaProduto2 = new ControllerVendaProduto2();
    ArrayList<ModelVendaProduto2> listaModelVendaProduto2 = new ArrayList<>();    
        try {
    int percorrer;     
    percorrer = tabelaVendaProdutoDinheiro.getRowCount();
     
    for (int i = 0; i < percorrer; i++) {
    modelVendaProduto2 = new ModelVendaProduto2();   
    //listaModelVendaProduto2 = new ArrayList<>();
    modelVendaProduto2.setVenda(Integer.parseInt(String.valueOf(tabelaVendaProdutoDinheiro.getValueAt(i, 0))));
    modelVendaProduto2.setProduto(Integer.parseInt(String.valueOf(tabelaVendaProdutoDinheiro.getValueAt(i, 1))));      
    modelVendaProduto2.setQuantidade(Integer.parseInt(String.valueOf(tabelaVendaProdutoDinheiro.getValueAt(i, 2))));
    modelVendaProduto2.setUsuario(Integer.parseInt(String.valueOf(tabelaVendaProdutoDinheiro.getValueAt(i, 3)))); 
    modelVendaProduto2.setValorVenda(Double.parseDouble(String.valueOf(tabelaVendaProdutoDinheiro.getValueAt(i, 4))));     
    modelVendaProduto2.setNom_produto(String.valueOf(tabelaVendaProdutoDinheiro.getValueAt(i, 5)));
    modelVendaProduto2.setAno(String.valueOf(tabelaVendaProdutoDinheiro.getValueAt(i, 6)));
    modelVendaProduto2.setMesAno(String.valueOf(tabelaVendaProdutoDinheiro.getValueAt(i, 7)));

    listaModelVendaProduto2.add(modelVendaProduto2);     
    }
    
    if(controllerVendaProduto2.salvarVendaProdutoController(listaModelVendaProduto2)){
    
    }
      } catch (Exception e) {
        }
    }
    
    
    
       private void salvarVendasProdutoDoCartao(){
           ModelVendaProdutoCartao2 modelVendaProdutoCartao2 = new ModelVendaProdutoCartao2();
           ControllerVendaProdutoCartao2 controllerVendaProdutoCartao2 = new ControllerVendaProdutoCartao2();
           ArrayList<ModelVendaProdutoCartao2> listaProdutoCartao = new ArrayList<>();
           
    int percorrer;     
    percorrer = tabelaProdutoCartao.getRowCount();
    for (int i = 0; i < percorrer; i++) {
        
    modelVendaProdutoCartao2 = new ModelVendaProdutoCartao2();      
    modelVendaProdutoCartao2.setProduto(Integer.parseInt(String.valueOf(tabelaProdutoCartao.getValueAt(i, 1))));
    modelVendaProdutoCartao2.setQuantidade(Integer.parseInt(String.valueOf(tabelaProdutoCartao.getValueAt(i, 2))));      
    modelVendaProdutoCartao2.setUsuario(Integer.parseInt(String.valueOf(tabelaProdutoCartao.getValueAt(i, 3))));
    modelVendaProdutoCartao2.setVenda(Integer.parseInt(String.valueOf(tabelaProdutoCartao.getValueAt(i, 5))));
    modelVendaProdutoCartao2.setValorVenda(Double.parseDouble(String.valueOf(tabelaProdutoCartao.getValueAt(i, 4))));      
    modelVendaProdutoCartao2.setNome_produto(String.valueOf(tabelaProdutoCartao.getValueAt(i, 6)));
    modelVendaProdutoCartao2.setMes(String.valueOf(tabelaProdutoCartao.getValueAt(i, 7)));
    modelVendaProdutoCartao2.setAno(String.valueOf(tabelaProdutoCartao.getValueAt(i, 8)));
 
    listaProdutoCartao.add(modelVendaProdutoCartao2);    
    }
    if(controllerVendaProdutoCartao2.salvarVendaProdutoController(listaProdutoCartao)){
   
    }
    } 
       
       
       private void salvarVendasProdutoDoTickets(){
           ModelVendaProdutoTickets2 modelVendaProdutoCartao2 = new ModelVendaProdutoTickets2();
           ControllerVendaProdutoTickets2 controllerVendaProdutoCartao2 = new ControllerVendaProdutoTickets2();
           ArrayList<ModelVendaProdutoTickets2>listaProdutoCartao = new ArrayList<>();
           
    int percorrer;     
    percorrer = tabelaProdutoTickets.getRowCount();
    for (int i = 0; i < percorrer; i++) {
    modelVendaProdutoCartao2 = new ModelVendaProdutoTickets2();      
    modelVendaProdutoCartao2.setProduto(Integer.parseInt(String.valueOf(tabelaProdutoTickets.getValueAt(i, 1))));
    modelVendaProdutoCartao2.setQuantidade(Integer.parseInt(String.valueOf(tabelaProdutoTickets.getValueAt(i, 2))));      
    modelVendaProdutoCartao2.setUsuario(Integer.parseInt(String.valueOf(tabelaProdutoTickets.getValueAt(i, 3))));
    modelVendaProdutoCartao2.setVenda(Integer.parseInt(String.valueOf(tabelaProdutoTickets.getValueAt(i, 5))));
    modelVendaProdutoCartao2.setValorVenda(Double.parseDouble(String.valueOf(tabelaProdutoTickets.getValueAt(i, 4))));      
    modelVendaProdutoCartao2.setNome_produto(String.valueOf(tabelaProdutoTickets.getValueAt(i, 6)));
      
    modelVendaProdutoCartao2.setAno(String.valueOf(tabelaProdutoTickets.getValueAt(i, 7)));      
    modelVendaProdutoCartao2.setMes(String.valueOf(tabelaProdutoTickets.getValueAt(i, 8)));
    
    listaProdutoCartao.add(modelVendaProdutoCartao2);    
    }
    if(controllerVendaProdutoCartao2.salvarVendaProdutoController(listaProdutoCartao)){
    
    }
    } 
        private void salvarVendasProdutoAbandono(){
            ModelVendaProdutoAbandono2 modelVendaProdutoCartao2 = new ModelVendaProdutoAbandono2();
            ControllerVendaProdutoAbandono2 controllerVendaProdutoCartao2 = new ControllerVendaProdutoAbandono2();
           ArrayList<ModelVendaProdutoAbandono2>listaProdutoCartao = new ArrayList<>();
           
    int percorrer;     
    percorrer = tabelaVendaAbandonoProduto.getRowCount();
    for (int i = 0; i < percorrer; i++) {
    modelVendaProdutoCartao2 = new ModelVendaProdutoAbandono2();      
    modelVendaProdutoCartao2.setProduto(Integer.parseInt(String.valueOf(tabelaVendaAbandonoProduto.getValueAt(i, 1))));
    modelVendaProdutoCartao2.setQuantidade(Integer.parseInt(String.valueOf(tabelaVendaAbandonoProduto.getValueAt(i, 2))));      
    modelVendaProdutoCartao2.setUsuario(Integer.parseInt(String.valueOf(tabelaVendaAbandonoProduto.getValueAt(i, 3))));
    modelVendaProdutoCartao2.setVenda(Integer.parseInt(String.valueOf(tabelaVendaAbandonoProduto.getValueAt(i, 5))));
    modelVendaProdutoCartao2.setValorVenda(Double.parseDouble(String.valueOf(tabelaVendaAbandonoProduto.getValueAt(i, 4))));      
    modelVendaProdutoCartao2.setNome_produto(String.valueOf(tabelaVendaAbandonoProduto.getValueAt(i, 6)));
     
    listaProdutoCartao.add(modelVendaProdutoCartao2);    
    }
    if(controllerVendaProdutoCartao2.salvarVendaProdutoController(listaProdutoCartao)){
   
    }    
    }             
        
     private void salvarTurno(){
         try {
             
         
         ModelAbrirTurno2 modelAbrirTuurno2 = new ModelAbrirTurno2();
         ControllerAbrirTuur2 controllerAbrirTuur2 = new ControllerAbrirTuur2();
         
         
         modelAbrirTuurno2.setFkTurno(Integer.parseInt(tfNumeroTurno.getText()));
         modelAbrirTuurno2.setId(Integer.parseInt(tfIdOperador.getText()));
         modelAbrirTuurno2.setNome(tfNomeoperador.getText());
         modelAbrirTuurno2.setData(tfDataAbertura.getText()); 
         modelAbrirTuurno2.setDataRelatorio(tfDataRelatorio.getText());
         modelAbrirTuurno2.setHora(tfHoraAbertura.getText());  
         modelAbrirTuurno2.setHora2(tfFecharTurnoHora.getText()); 
         modelAbrirTuurno2.setValor(tfValorFinal.getText());
         modelAbrirTuurno2.setData_fechar(tfFechardata.getText()); 
         modelAbrirTuurno2.setDataAnual(tfDataAnual.getText());
          
         controllerAbrirTuur2.salvarAbrirTurnoController(modelAbrirTuurno2);
         } catch (Exception e) {
         }
     }   
       
       private void listarSangria(){
           ModelSangria modelSangria = new ModelSangria();
           ControllerSangria controllerSangria = new ControllerSangria();
           ArrayList<ModelSangria> listaModelSangria = new ArrayList<>();
           
           modelSangria = new ModelSangria();
           DefaultTableModel modelo = (DefaultTableModel) tabelaSangria.getModel();
           modelo.setNumRows(0);
           listaModelSangria = controllerSangria.listaModelController();
           for (int i = 0; i < listaModelSangria.size(); i++) {        
           modelo.addRow(new Object[]{
           listaModelSangria.get(i).getId(),
               listaModelSangria.get(i).getValor()
               
           });
           }
       }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked") 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnFecharTurno = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaParcelas = new javax.swing.JTable();
        tfVendaParcelada = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tabelaVendasParcelaAvista = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        tfVendaParcelaAvista = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        tfNumeroVendaParcelada = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaTickets = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        tabelaProdutoTickets = new javax.swing.JTable();
        tfTickets = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        tfNumeroVendaTickets = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tabelaProdutoCartao = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaCartao = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        tfCartaoTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        tfNumeroVendasCartao = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelaVendaProdutoDinheiro = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        tfValorDinheiro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        tfNumeroVendasAvista = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfValorFinal = new javax.swing.JLabel();
        tfSangria = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaSangria = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tfSangriaValor = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfTroco = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfNumeroTurno = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tfNomeoperador = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tfIdOperador = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tfDataAbertura = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tfHoraAbertura = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tfEstado = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaAbandono = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        tfAbandono = new javax.swing.JLabel();
        tfNumeroAbandono = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tabelaCancelamento = new javax.swing.JTable();
        tfValorCancelamentosDinheiro = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        tfNumeroCancelamentos = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tabelaVendaAbandonoProduto = new javax.swing.JTable();
        jScrollPane14 = new javax.swing.JScrollPane();
        tabelaCancelamentoCartao = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        tfValorCancelamentoCartao = new javax.swing.JLabel();
        tfNumeroCancelCartao = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tabelaCancelamentoTickets = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        tfValorCancelamentoTickets = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        tfNumeroCancelTickets = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        numFac = new javax.swing.JLabel();
        tfNovoTurno = new javax.swing.JTextField();
        tfDataFechamento = new javax.swing.JLabel();
        tfHoraFechamento = new javax.swing.JLabel();
        tfSomandoSangria = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        tfTotalBrutoDasVenda = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        tfNumrTotalDeVendas = new javax.swing.JLabel();
        tfFecharTurnoHora = new javax.swing.JLabel();
        tfFechardata = new javax.swing.JLabel();
        tfDataRelatorio = new javax.swing.JLabel();
        tfDataAnual = new javax.swing.JLabel();
        tfValorFinal2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FECHAR TURNO");
        setResizable(false);
        setState(6);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnFecharTurno.setText("FECHAR TURNO");
        btnFecharTurno.setEnabled(false);
        btnFecharTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharTurnoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("VENDAS PARCELADAS/TOTAL DE VENDAS"));

        tabelaParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CLIENTE", "HORA", "DATA", "V.BRUTO", "V.DESCONTO", "V.LIQUIDO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tabelaParcelas);
        if (tabelaParcelas.getColumnModel().getColumnCount() > 0) {
            tabelaParcelas.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        tfVendaParcelada.setEditable(false);
        tfVendaParcelada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfVendaParcelada.setText("00.0");

        jLabel10.setText("PARCELADAS:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("$");

        tabelaVendasParcelaAvista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CLIENTE", "HORA", "DATA", "V.BRUTO", "V.DESCONTO", "V.LIQUIDO", "usuario", "pagamento", "dataReala", "ano", "turno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(tabelaVendasParcelaAvista);
        if (tabelaVendasParcelaAvista.getColumnModel().getColumnCount() > 0) {
            tabelaVendasParcelaAvista.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        jLabel15.setText("PARCELADAS&À VISTA:");

        tfVendaParcelaAvista.setEditable(false);
        tfVendaParcelaAvista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfVendaParcelaAvista.setText("0.00");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("$");

        jLabel28.setText("Nmr. Venda");

        tfNumeroVendaParcelada.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(tfNumeroVendaParcelada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(tfVendaParcelada, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfVendaParcelaAvista, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfVendaParcelada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(tfNumeroVendaParcelada))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(tfVendaParcelaAvista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("VENDAS NO TICKETS"));

        tabelaTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CLIENTE", "HORA", "DATA", "V.BRUTO", "V. DESCONTO", "V.LIQUIDO", "usuario", "dataRela", "dataAnual"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaTicketsMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabelaTickets);
        if (tabelaTickets.getColumnModel().getColumnCount() > 0) {
            tabelaTickets.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        tabelaProdutoTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "produto", "quantidade", "usuario", "V.venda", "id_venda", "nome_prduto", "ano", "mes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProdutoTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutoTicketsMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tabelaProdutoTickets);
        if (tabelaProdutoTickets.getColumnModel().getColumnCount() > 0) {
            tabelaProdutoTickets.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        tfTickets.setEditable(false);
        tfTickets.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfTickets.setText("0.00");

        jLabel9.setText("VALOR:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("$");

        jLabel27.setText("Nmr. Vendass:");

        tfNumeroVendaTickets.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNumeroVendaTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tfTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNumeroVendaTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(25, 25, 25))
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("VENDAS NOS CARTÕES"));

        tabelaProdutoCartao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "PRODUTO", "QUANTIDADE", "USUARIO", "V. VENDA", "ID_VENDA", "nome_pro", "mes", "ano"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProdutoCartao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutoCartaoMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tabelaProdutoCartao);
        if (tabelaProdutoCartao.getColumnModel().getColumnCount() > 0) {
            tabelaProdutoCartao.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        tabelaCartao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CLIENTE", "HORA", "DATA", "V. BRUTO", "V. DESCONTO", "V. LIQUIDO", "usuario", "dataRela", "ano"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCartao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCartaoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabelaCartao);
        if (tabelaCartao.getColumnModel().getColumnCount() > 0) {
            tabelaCartao.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("$");

        tfCartaoTotal.setEditable(false);
        tfCartaoTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfCartaoTotal.setText("0.00");
        tfCartaoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCartaoTotalActionPerformed(evt);
            }
        });

        jLabel8.setText("VENDAS NOS CARTÕES:");

        jLabel26.setText("Nmr. Vendas:");

        tfNumeroVendasCartao.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tfCartaoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfNumeroVendasCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCartaoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(tfNumeroVendasCartao))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("VENDAS À VISTA"));

        tabelaVendaProdutoDinheiro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "PRODUTO", "QUANTIDADE", "USUARIO", "V.MVENDA", "nome_pro", "ano", "mes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tabelaVendaProdutoDinheiro);
        if (tabelaVendaProdutoDinheiro.getColumnModel().getColumnCount() > 0) {
            tabelaVendaProdutoDinheiro.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CLIENTE", "HORA", "DATA", "V. BRUTO", "V. DESCONTO", "V. LIQUIDO", "Usuario", "pagamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        tfValorDinheiro.setEditable(false);
        tfValorDinheiro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfValorDinheiro.setText("0.00");

        jLabel7.setText("VENDAS ÀVISTA:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("$");

        jLabel25.setText("Nmr. Vendas:");

        tfNumeroVendasAvista.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(tfValorDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNumeroVendasAvista, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfValorDinheiro, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(tfNumeroVendasAvista))
                .addGap(23, 44, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jLabel1.setText("SANGRIA:");

        jLabel2.setText("VALOR/VENDAS:");

        tfValorFinal.setText("0.00");

        tfSangria.setText("0.00");

        jLabel3.setText("TOTAL:");

        tfTotal.setText("0.00");

        tabelaSangria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "VALOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaSangria);

        jLabel4.setText("SANGRIA:");

        tfSangriaValor.setEditable(false);
        tfSangriaValor.setText("0.00");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("$");

        jLabel5.setText("TROCO:");

        tfTroco.setText("0.00");

        jButton1.setText("PREPARAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Abertura desse turno"));

        jLabel6.setText("TURNO:");

        tfNumeroTurno.setText("1222");

        jLabel18.setText("OPERADOR:");

        tfNomeoperador.setText("LOIANE");

        jLabel20.setText("ID:");

        tfIdOperador.setText("44");

        jLabel21.setText("DATA:");

        tfDataAbertura.setText("19/05/2019");

        jLabel23.setText("HORA:");

        tfHoraAbertura.setText("15a:33:09");

        jLabel19.setText("ESTADO:");

        tfEstado.setText("FECHADO");

        tabelaAbandono.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CLIENTE", "HORA", "DATA", "V.BRUTO", "V.DESCONTO", "V.LIQUIDO", "USUARIO", "PAGAMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabelaAbandono);

        jLabel24.setText("ABANDONO:");

        tfAbandono.setText("0.00");

        tfNumeroAbandono.setText("0");

        jLabel30.setText("Numero abandono:");

        tabelaCancelamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CLIENTE", "HORA", "DATA", "V.BRUTO", "V.DESCONTO", "V.LIQUIDO", "USUARIO", "PAGAMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(tabelaCancelamento);
        if (tabelaCancelamento.getColumnModel().getColumnCount() > 0) {
            tabelaCancelamento.getColumnModel().getColumn(7).setHeaderValue("USUARIO");
            tabelaCancelamento.getColumnModel().getColumn(8).setHeaderValue("PAGAMENTO");
        }

        tfValorCancelamentosDinheiro.setText("0.00");

        jLabel31.setText("CANCEL");

        jLabel32.setText("Numero abandono:");

        tfNumeroCancelamentos.setText("0");

        tabelaVendaAbandonoProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "COD.PRO", "QUANT.", "USUARIO", "V.VENDA", "COD.VENDA", "NOME.PRO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane13.setViewportView(tabelaVendaAbandonoProduto);

        tabelaCancelamentoCartao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CLIENTE", "HORA", "DATA", "V.BRUTO", "V.DESCONTO", "V.LIQUIDO", "USUARIO", "PAGAMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane14.setViewportView(tabelaCancelamentoCartao);
        if (tabelaCancelamentoCartao.getColumnModel().getColumnCount() > 0) {
            tabelaCancelamentoCartao.getColumnModel().getColumn(7).setHeaderValue("USUARIO");
            tabelaCancelamentoCartao.getColumnModel().getColumn(8).setHeaderValue("PAGAMENTO");
        }

        jLabel33.setText("Numero abandono:");

        jLabel34.setText("CANCEL. car");

        tfValorCancelamentoCartao.setText("0.00");

        tfNumeroCancelCartao.setText("0");

        tabelaCancelamentoTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CLIENTE", "HORA", "DATA", "V.BRUTO", "V.DESCONTO", "V.LIQUIDO", "USUARIO", "PAGAMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane15.setViewportView(tabelaCancelamentoTickets);
        if (tabelaCancelamentoTickets.getColumnModel().getColumnCount() > 0) {
            tabelaCancelamentoTickets.getColumnModel().getColumn(7).setHeaderValue("USUARIO");
            tabelaCancelamentoTickets.getColumnModel().getColumn(8).setHeaderValue("PAGAMENTO");
        }

        jLabel36.setText("CANCEL. car");

        tfValorCancelamentoTickets.setText("0.00");

        jLabel37.setText("Numero abandono:");

        tfNumeroCancelTickets.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfAbandono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfNumeroAbandono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel32)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel33))))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfValorCancelamentosDinheiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfNumeroCancelamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfNumeroCancelCartao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfValorCancelamentoCartao, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                                .addGap(32, 32, 32))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfValorCancelamentoTickets, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(tfNumeroCancelTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(tfAbandono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(tfNumeroAbandono)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(tfValorCancelamentosDinheiro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(tfNumeroCancelamentos)))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(tfValorCancelamentoCartao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(tfNumeroCancelCartao)))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(tfValorCancelamentoTickets))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(tfNumeroCancelTickets)))
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );

        jLabel38.setText("num. prox. turno:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNumeroTurno)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNomeoperador, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfIdOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDataAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfHoraAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(235, 235, 235)
                        .addComponent(numFac, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(27, 27, 27)
                        .addComponent(tfNovoTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfNumeroTurno)
                    .addComponent(jLabel18)
                    .addComponent(tfNomeoperador)
                    .addComponent(jLabel20)
                    .addComponent(tfIdOperador))
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numFac, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(tfEstado))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(tfDataAbertura)
                        .addComponent(jLabel23)
                        .addComponent(tfHoraAbertura)))
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNovoTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tfDataFechamento.setText("jLabel22");

        tfHoraFechamento.setText("jLabel22");

        tfSomandoSangria.setText("jLabel22");

        jLabel22.setText("DESCONTO COM A SANGRIA:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel29.setText("Total Numero Vendas:");

        tfTotalBrutoDasVenda.setText("0");

        jLabel35.setText("numero vendas total:");

        tfNumrTotalDeVendas.setText("0");

        tfFecharTurnoHora.setText("jLabel39");

        tfFechardata.setText("jLabel39");

        tfDataRelatorio.setText("dataRel");

        tfDataAnual.setText("dataAnual");

        tfValorFinal2.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfDataFechamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(tfSangriaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel17))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(tfHoraFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel35)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(tfNumrTotalDeVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel29))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(2, 2, 2)
                                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel1)
                                            .addGap(11, 11, 11)
                                            .addComponent(tfSangria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnFecharTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tfTotalBrutoDasVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfSomandoSangria))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tfValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tfTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(17, 17, 17)
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tfValorFinal2))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(tfDataAnual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfDataRelatorio)
                        .addGap(87, 87, 87)
                        .addComponent(tfFechardata)
                        .addGap(43, 43, 43)
                        .addComponent(tfFecharTurnoHora)
                        .addGap(532, 532, 532))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tfTotal))
                    .addComponent(jLabel1)
                    .addComponent(tfSangria)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tfValorFinal2))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(tfTroco)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFecharTurno)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(tfValorFinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfSomandoSangria)
                            .addComponent(jLabel22))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(tfTotalBrutoDasVenda)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35)
                        .addComponent(tfNumrTotalDeVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfFecharTurnoHora)
                        .addComponent(tfFechardata)
                        .addComponent(tfDataRelatorio)
                        .addComponent(tfDataAnual)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tfSangriaValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDataFechamento)
                    .addComponent(tfHoraFechamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBounds(0, 0, 690, 99);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTicketsMouseClicked
        
    }//GEN-LAST:event_tabelaTicketsMouseClicked

    private void tabelaCartaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCartaoMouseClicked
       
    }//GEN-LAST:event_tabelaCartaoMouseClicked

    private void tabelaProdutoCartaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutoCartaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaProdutoCartaoMouseClicked

    private void tabelaProdutoTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutoTicketsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaProdutoTicketsMouseClicked
  
    private void btnFecharTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharTurnoActionPerformed
    try {          
    salvarTurno(); 
    salvarCancelamentoCartao();   
    salvarCancelamentoTickets();   
    salvarVendasDoDinheiro();
    salvarVendasProdutoDoDinheiro();
    salvarVendasDoCartao(); 
    salvarVendasProdutoDoCartao();
    salvarVendasDoTickets();    
    salvarVendasProdutoDoTickets(); 
    salvarCancelamento();   
    salvarVendasAbandonada();  
    salvarVendasProdutoAbandono();
    
    daoVendaProdutoAbandoono.eliminaTodos();
      
    daoVendaCancelamentoTickets.eliminaTodos();
    daoVendaProduto.eliminaTodos();
    daoVendaAbandono.eliminaTodos(); 
    DaoVendaCancelamento.eliminaTodos(); 
    daoVendaProdutocartao.eliminaTodos();
    daoVendaProdutoTickets.eliminaTodos();
    daoVenda.eliminaTodos();
    daoVendaCartao.eliminaTodos(); 
    daoVendaTickets.eliminaTodos();
    daoSangria.eliminaTodos();
    daoVendaCancelamentoCartao2.eliminaTodos(); 
    troco();
    
   
    
     
    modelAbrirTurno.setData("0/0/0000");
    modelAbrirTurno.setEstado("Liberado");
    modelAbrirTurno.setFkTurno(Integer.parseInt(tfNovoTurno.getText()));
    modelAbrirTurno.setHora("00:00:00");
    modelAbrirTurno.setId(2);
    modelAbrirTurno.setNome("Null");
    modelAbrirTurno.setPk_id_abrir_turno(2);
    modelAbrirTurno.setValor(0.00);
    controllerAbrirTuur.alterarController(modelAbrirTurno);
    JOptionPane.showMessageDialog(null, "Fechamento de turno efetuado com sucesso!");

    modelAbrirTurno.setEstado("Liberado");
    controllerAbrirTuur.alterarController(modelAbrirTurno);
      
   
    imprimirFecharTurno();
    dispose(); 
    ViewPrincipal v = new ViewPrincipal();
    v.dispose();
    ViewLogin viewLogin = new ViewLogin();
    viewLogin.setVisible(true);
    viewLogin.setLocationRelativeTo(null);
     
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Erro ao gerar relatório!");
    }     
      
    
    }//GEN-LAST:event_btnFecharTurnoActionPerformed
    
    private void tfCartaoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCartaoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCartaoTotalActionPerformed
    private void imprimirFecharTurno(){
     String conteudoImprimir ="";   
   
     this.imprimir("     \n\r"
     + "==========================================\n\r"    
     + "          MERCADINHO JOAO PAULO I          \n\r"    
     + "         CNPJ: 26.635.415/0001-25         \n\r" 
     + "==========================================\n\r"
     + "           FECHAMENTO DE TURNO            \n\r"
     + "             TURNO No.  "+String.valueOf(tfNumeroTurno.getText())+"\n\r"                  
     + "------------------------------------------\n\r" 
     + "          IDENTIFICADOR DO TURNO          \n\r" 
     + "------------------------------------------\n\r" 
     + "Turno........: "+String.valueOf(tfNumeroTurno.getText())+"\n\r" 
     + "Identificacao: "+String.valueOf(tfNomeoperador.getText())+"\n\r"         
     + "Estado.......: "+String.valueOf(tfEstado.getText())+"\n\r"       
     + "Abertura.....: "+String.valueOf(tfDataAbertura.getText())+"  "+String.valueOf(tfHoraAbertura.getText())+"\n\r"
     + "Usuario Abert: "+String.valueOf(tfNomeoperador.getText())+"\n\r"
     + "Fechamento...: "+String.valueOf(tfFechardata.getText())+"  "+String.valueOf(tfFecharTurnoHora.getText())+"\n\r"         
     + "Usuario Fecha: "+String.valueOf(tfNomeoperador.getText())+"\n\r"         
     + "------------------------------------------\n\r"  
     + "          DETALHAMENTO FINANCEIRO         \n\r"
     + "------------------------------------------\n\r"        
     + "Tota Vendas/Servicos.....:  "+String.valueOf(tfTotal.getText())+"\n\r"        
     + "Sangria..................:  "+String.valueOf(tfSangria.getText())+"\n\r" 
     + "\n\r"
     + "Saldo Caixa..............:  "+String.valueOf(tfSomandoSangria.getText())+"\n\r"
     + "------------------------------------------\n\r"         
     + "Total de Vendas Avista...:  "+String.valueOf(tfValorDinheiro.getText())+"\n\r"         
     + "Total de Vendas a Prazo..:  "+String.valueOf(tfVendaParcelada.getText())+"\n\r"      
     + "Total de Vendas Abandono.:  "+String.valueOf(tfAbandono.getText())+"\n\r" 
     + "------------------------------------------\n\r"        
     + "Valor. Cancel. Dinheiro..:  "+String.valueOf(tfValorCancelamentosDinheiro.getText())+"\n\r" 
     + "Valor. Cancel. Cartao....:  "+String.valueOf(tfValorCancelamentoCartao.getText())+"\n\r"
     + "Valor. Cancel. Ticket....:  "+String.valueOf(tfValorCancelamentoTickets.getText())+"\n\r"
     + "------------------------------------------\n\r"           
     + "Nro. de Vendas Avista....:  "+String.valueOf(tfNumeroVendasAvista.getText())+"\n\r"  
     + "Nro. de Vendas a Prazo...:  "+String.valueOf(tfNumeroVendaParcelada.getText())+"\n\r"
     + "Nro. de Vendas no Ticket.:  "+String.valueOf(tfNumeroVendaTickets.getText())+"\n\r"
     + "Nro. de Vendas no Cartao.:  "+String.valueOf(tfNumeroVendasCartao.getText())+"\n\r"
     + "Nro. Abandono de Vendas..:  "+String.valueOf(tfNumeroAbandono.getText())+"\n\r"
     + "Nro. Cancel. Dinheiro....:  "+String.valueOf(tfNumeroCancelamentos.getText())+"\n\r"
     + "Nro. Cancel. Cartao......:  "+String.valueOf(tfNumeroCancelCartao.getText())+"\n\r"
     + "Nro. Cancel. Ticket......:  "+String.valueOf(tfNumeroCancelTickets.getText())+"\n\r"
     + "Nro. de Vendas Total.....:  "+String.valueOf(tfNumrTotalDeVendas.getText())+"\n\r"        
     +"\n\r \n\r \f"
     + "------------------------------------------\n\r"  
     + "     SALDOS POR FORMAS DE PAGAMENTOS      \n\r"  
     + "------------------------------------------\n\r" 
     + "01 DINHEIRO                 "+String.valueOf(tfValorDinheiro.getText())+"\n\r"   
     + "03 CARTAO                   "+String.valueOf(tfCartaoTotal.getText())+"\n\r" 
     + "07 A PRAZO                  "+String.valueOf(tfVendaParcelada.getText())+"\n\r"        
     + "08 TICKETS                  "+String.valueOf(tfTickets.getText())+"\n\r" 
     + "   ENTRADA                  "+String.valueOf(tfTroco.getText())+"\n\r" 
     + "   TOTAL BRUTO              "+String.valueOf(tfValorFinal.getText())+"\n\r" 
     + "------------------------------------------\n\r" 
     + "01 DINHEIRO                 "+String.valueOf(tfValorDinheiro.getText())+"\n\r"
     + "   ENTRADA                  "+String.valueOf(tfTroco.getText())+"\n\r"
     + "   TOTAL LIQUIDO            "+String.valueOf(somaLiquida())+"\n\r"  
     + "------------------------------------------\n\r" 
               
     + "                            \n\r"        
     +"\n\r \n\r \f" 
     +"\n\r \n\r \f"
     +"\n\r \n\r \f"
     +"\n\r \n\r \f"  
     +"\n\r \n\r \f"
     +"\n\r \n\r \f" 
     );
     
    }
    
    private float somaLiquida(){ 
          float dinheiro, troco, soma, total;
           dinheiro = Float.parseFloat(tfValorDinheiro.getText());
           troco = Float.parseFloat(tfTroco.getText());
           soma = dinheiro+troco;
           df.format(soma);
           return soma;
       } 
     private int calculandoTotalNumeroVendas(){
          int tickets, avista, cartao, pacela, total = 0;
          tickets = Integer.parseInt(tfNumeroVendaTickets.getText());
          avista = Integer.parseInt(tfNumeroVendasAvista.getText());
          cartao = Integer.parseInt(tfNumeroVendasCartao.getText());
          pacela = Integer.parseInt(tfNumeroVendaParcelada.getText());
          
          total = pacela+cartao+avista+tickets; 
          tfNumrTotalDeVendas.setText(total+"");
          return total; 
      }    
    
    public void imprimir(String pTexto){
        try {
            InputStream prin = new ByteArrayInputStream(pTexto.getBytes());
            DocFlavor doqFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            SimpleDoc documentoTexto = new SimpleDoc(prin, doqFlavor, null);
            PrintService impressora = PrintServiceLookup.lookupDefaultPrintService();
            //pega a impressora padrao
            PrintRequestAttributeSet printAtribut = new HashPrintRequestAttributeSet();
            printAtribut.add(new JobName("Impressao", null));
            printAtribut.add(OrientationRequested.PORTRAIT);
            printAtribut.add(MediaSizeName.ISO_A4);
            
            //informe o tipo da folha 
            DocPrintJob printJob = impressora.createPrintJob();
            try {
            printJob.print(documentoTexto, (PrintRequestAttributeSet) printAtribut);
            //tenta imprimir
            } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Nao foi possivel realizar essa impressao!!!");
            }
            prin.close(); 
        } catch (Exception e) {
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     modelId = controllerId.buscaIdController(2);    
     tfNumeroTurno.setText(modelId.getNumero()+"");  
     troco(); 
     calculandoValorSangria();
     calculandoValorDinheiro();
     calculandoValorCartao();
     calculandoValorParcelado();
     calculandoValorVendaParcelasAvista();
     calculandoValorDasVendas();
     calculandoValorAbandono();
     calculandoValorTickets();
     calculandoValorFinal();
     calculandoValorFinal2();
     calculandoValorTotal();
     calculandoNumeroVendaParcelas();
     calculandoNumeroVendaCartao();
     calculandoNumeroVendaTickets(); 
     calculandoValorSangriaTotal();
     calculandoNumeroAbandono(); 
     calculandoNumeroVendaDinheiro();
     calculandoNumeroCancelamentos();
     calculandoValorCancelamento();
     calculandoTotalNumeroVendas(); 
     calculandoNumeroCancelCartao();
     calculandoNumeroCancelTickets();
     calculandoValorCancelamentoTickets();
     btnFecharTurno.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed
 
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    Date sistemaData = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato2 = new SimpleDateFormat("MM/yyyy");
         SimpleDateFormat formato3 = new SimpleDateFormat("yyyy");
        tfFechardata.setText(formato.format(sistemaData));
        tfDataRelatorio.setText(formato2.format(sistemaData));
        tfDataAnual.setText(formato3.format(sistemaData)); 
        //HORA DO SISTEMA
        Timer hr = new Timer(100, new hora()); 
        hr.start(); 
    }//GEN-LAST:event_formWindowOpened
   
    
   
   
    /**  
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewFecharTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewFecharTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewFecharTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewFecharTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewFecharTurno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFecharTurno;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    public static javax.swing.JLabel numFac;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabelaAbandono;
    private javax.swing.JTable tabelaCancelamento;
    private javax.swing.JTable tabelaCancelamentoCartao;
    private javax.swing.JTable tabelaCancelamentoTickets;
    private javax.swing.JTable tabelaCartao;
    private javax.swing.JTable tabelaParcelas;
    private javax.swing.JTable tabelaProdutoCartao;
    private javax.swing.JTable tabelaProdutoTickets;
    private javax.swing.JTable tabelaSangria;
    private javax.swing.JTable tabelaTickets;
    private javax.swing.JTable tabelaVendaAbandonoProduto;
    private javax.swing.JTable tabelaVendaProdutoDinheiro;
    private javax.swing.JTable tabelaVendasParcelaAvista;
    private javax.swing.JLabel tfAbandono;
    private javax.swing.JTextField tfCartaoTotal;
    public static javax.swing.JLabel tfDataAbertura;
    private javax.swing.JLabel tfDataAnual;
    private javax.swing.JLabel tfDataFechamento;
    private javax.swing.JLabel tfDataRelatorio;
    private javax.swing.JLabel tfEstado;
    private javax.swing.JLabel tfFecharTurnoHora;
    private javax.swing.JLabel tfFechardata;
    public static javax.swing.JLabel tfHoraAbertura;
    private javax.swing.JLabel tfHoraFechamento;
    public static javax.swing.JLabel tfIdOperador;
    public static javax.swing.JLabel tfNomeoperador;
    public static javax.swing.JTextField tfNovoTurno;
    private javax.swing.JLabel tfNumeroAbandono;
    private javax.swing.JLabel tfNumeroCancelCartao;
    private javax.swing.JLabel tfNumeroCancelTickets;
    private javax.swing.JLabel tfNumeroCancelamentos;
    public static javax.swing.JLabel tfNumeroTurno;
    private javax.swing.JLabel tfNumeroVendaParcelada;
    private javax.swing.JLabel tfNumeroVendaTickets;
    private javax.swing.JLabel tfNumeroVendasAvista;
    private javax.swing.JLabel tfNumeroVendasCartao;
    private javax.swing.JLabel tfNumrTotalDeVendas;
    private javax.swing.JLabel tfSangria;
    private javax.swing.JTextField tfSangriaValor;
    private javax.swing.JLabel tfSomandoSangria;
    private javax.swing.JTextField tfTickets;
    private javax.swing.JLabel tfTotal;
    private javax.swing.JLabel tfTotalBrutoDasVenda;
    private javax.swing.JLabel tfTroco;
    private javax.swing.JLabel tfValorCancelamentoCartao;
    private javax.swing.JLabel tfValorCancelamentoTickets;
    private javax.swing.JLabel tfValorCancelamentosDinheiro;
    private javax.swing.JTextField tfValorDinheiro;
    private javax.swing.JLabel tfValorFinal;
    private javax.swing.JLabel tfValorFinal2;
    private javax.swing.JTextField tfVendaParcelaAvista;
    private javax.swing.JTextField tfVendaParcelada;
    // End of variables declaration//GEN-END:variables

private void setIcon() {
setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagem/comp.png"))); 
    }

} 
