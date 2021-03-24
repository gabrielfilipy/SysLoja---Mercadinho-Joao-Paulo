/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerAbrirTuur;
import Controller.ControllerId;
import Controller.ControllerProduto;
import Controller.ControllerVendaProduto;
import Controller.ControllerVendaProduto2;
import Controller.ControllerVendaProdutoAbandono;
import Controller.ControllerVendaProdutoCartao;
import Controller.ControllerVendaProdutoCartao2;
import Controller.ControllerVendaProdutoTickets;
import Controller.ControllerVendaProdutoTickets2;
import Controller.Controllervenda;
import Controller.Controllervenda2;
import Controller.ControllervendaAbandono;
import Controller.ControllervendaCartao;
import Controller.ControllervendaCartao2;
import Controller.ControllervendaTickets;
import Controller.ControllervendaTickets2;
import Dao.DaoVenda2;
import Model.ModelAbrirTurno;
import Model.ModelId;
import Model.ModelProduto;
import Model.ModelVenda;
import Model.ModelVenda2;
import Model.ModelVendaAbandono;
import Model.ModelVendaCartao;
import Model.ModelVendaCartao2;
import Model.ModelVendaProduto;
import Model.ModelVendaProduto2;
import Model.ModelVendaProdutoAbandono;
import Model.ModelVendaProdutoCartao;
import Model.ModelVendaProdutoCartao2;
import Model.ModelVendaProdutoTickets;
import Model.ModelVendaProdutoTickets2;
import Model.ModelVendaTickets;
import Model.ModelVendaTickets2;
import Util.Formatador;
import java.awt.Color;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Monet
 */
public class ViewPdv555 extends javax.swing.JFrame {
    
    //salvar no banco de dados
    ModelVenda2 modelVenda2 = new ModelVenda2();
    Controllervenda2 controllervenda2 = new Controllervenda2();
    ArrayList<ModelVenda2> listaModelVenda2 = new ArrayList<>();
    ModelVendaProduto2 modelVendaProduto2 = new ModelVendaProduto2();
    ControllerVendaProduto2 controllerVendaProduto2 = new ControllerVendaProduto2();
    ArrayList<ModelVendaProduto2> listaModelVendaProduto2 = new ArrayList<>(); 
    //salvar no banco de daos
    
    Formatador formatador = new Formatador(); 
    String pagamento ="";
    ModelProduto modelProduto = new ModelProduto();
    ControllerProduto controllerProduto = new ControllerProduto();
    ArrayList<ModelProduto> listaModelProduto = new ArrayList<>();
    int quantidade =1;
    //VENDA DINHEIRO
    ModelVenda modelVenda = new ModelVenda();
    Controllervenda controller = new Controllervenda();
    ArrayList<ModelVenda> listaModelVenda = new ArrayList<>();
    //VENDA DINHEIRO
    
    //VENDA PRODUTO DINHEIRO
    ModelVendaProduto modelVendaProduto = new ModelVendaProduto();
    ControllerVendaProduto controllerVendaProduto = new ControllerVendaProduto();
    ArrayList<ModelVendaProduto> listaModelVendaProduto = new ArrayList<>();
    //VENDA PRODUTO DINHEIRO
    
     //VENDA CARTAO
    ModelVendaCartao modelVendaCartao = new ModelVendaCartao();
    ControllervendaCartao controllervendaCartao = new ControllervendaCartao();
    ArrayList<ModelVendaCartao> listaModelVendaCartao = new ArrayList<>();
    //VENDA CARTAO
    
    //VENDA PRODUTO CARTAO
    ModelVendaProdutoCartao modelVendaProdutoCartao = new ModelVendaProdutoCartao();
    ControllerVendaProdutoCartao controllerVendaProdutoCartao = new ControllerVendaProdutoCartao();
    ArrayList<ModelVendaProdutoCartao> listaModelVendaProdutoCartao = new ArrayList<>();
    //VENDA PRODUTO CARTAO
    
    //VENDA TICKETS
    ModelVendaTickets modelVendaTickets = new ModelVendaTickets();
    ControllervendaTickets controllervendaTickets = new ControllervendaTickets();
    ArrayList<ModelVendaTickets> listaModelVendaTickets = new ArrayList<>();
    //VENDA TICKETS
      
    //venda produto tickets 
    ModelVendaProdutoTickets modelVendaProdutoTickets = new ModelVendaProdutoTickets();
    ControllerVendaProdutoTickets controllerVendaProdutoTickets = new     ControllerVendaProdutoTickets();
    ArrayList<ModelVendaProdutoTickets>listaModelVendaProdutoTickets= new ArrayList<>();
    //venda produto tickets
    private ViewPagamentoPDV viewPagamentoPDV; 
    private ViewPagamentoPDVParcela viewPagamentopParcelaPDV;
    private ViewPagamentoPDVCartao viewPagamentoPDVCartao;
    private ViewPagamentoPDVCartaoNormal viewPagamentoPDVCartaoNormal;
    private ViewPagamentoPDVTickets viewPagamentoPDVTickets;
    private ViewListaClientes viewListaClientes;   
    DecimalFormat df = new DecimalFormat("#.00");
    int percorrertabela,codigoProduto, codCliente; 
    /**   
     * Creates new form ViewPdv555
     */   
    public ViewPdv555() {  
        initComponents();
        //setIcon();  
        tfBarras.requestFocus();
        DaoVenda2.numeros();    
        limparFormulario();
        tfValorBruto.setText("0.00");
        tfValorPago.setText("0.00");
        tfTrocoCliente.setText("0.00");
        tabela.getTableHeader().setDefaultRenderer(new View.EstiloTabelaHeader());
        tabela.setDefaultRenderer(Object.class, new View.EstiloTabelaRenderer()); 
        this.viewPagamentoPDV = new ViewPagamentoPDV(this, true);
        this.viewPagamentopParcelaPDV = new ViewPagamentoPDVParcela(this, true);
        this.viewPagamentoPDVCartao = new ViewPagamentoPDVCartao(this, true);  
        this.viewPagamentoPDVCartaoNormal = new ViewPagamentoPDVCartaoNormal(this, true);
        this.viewPagamentoPDVTickets = new ViewPagamentoPDVTickets(this, true);
        this.viewListaClientes = new ViewListaClientes();
        jScrollPane3.getViewport().setBackground(Color.WHITE);
    } 
         
    private void limparFormulario(){  
    //tfNomeProduto.setText("SUB-TOTAL");
    tfIdCliente.setText("id Cliente");
    tfNomeCliente.setText("");
    tfNomeProduto.setText("- CAIXA LIVRE");
    tfCpfCliente.setText("CPF Cliente");
    //tfValorBruto.setText("0,00");
    //tfValorPago.setText("0,00");
    DefaultTableModel modelo=(DefaultTableModel) tabela.getModel();
    modelo.setNumRows(0);
    tfNomeProduto.setForeground(Color.BLACK);
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tfNomeProduto = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tfValorBruto = new javax.swing.JLabel();
        tfValorBruto1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfBarras = new javax.swing.JTextField();
        tfData = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfHora = new javax.swing.JLabel();
        tfAno = new javax.swing.JLabel();
        tfMes = new javax.swing.JLabel();
        tfTipo = new javax.swing.JLabel();
        tfUsuarioID = new javax.swing.JLabel();
        tfusuarionome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        tfValorBruto2 = new javax.swing.JLabel();
        tfValorPago = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfNomeCliente = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfTurno = new javax.swing.JLabel();
        tfIdCliente = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfCpfCliente = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfVenda = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        tfValorBruto3 = new javax.swing.JLabel();
        tfTrocoCliente = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setExtendedState(6);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 3));

        tfNomeProduto.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        tfNomeProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfNomeProduto.setText("1x Mocoquinha = 2,50");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfNomeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfNomeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        tfValorBruto.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        tfValorBruto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfValorBruto.setText("999,23");
        tfValorBruto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        tfValorBruto1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        tfValorBruto1.setForeground(new java.awt.Color(255, 255, 255));
        tfValorBruto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfValorBruto1.setText("Total:");
        tfValorBruto1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfValorBruto, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(tfValorBruto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfValorBruto1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfValorBruto)
                .addContainerGap())
        );

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/telapdv2.png"))); // NOI18N

        tfBarras.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tfBarras.setBorder(null);
        tfBarras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBarrasFocusLost(evt);
            }
        });
        tfBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBarrasActionPerformed(evt);
            }
        });
        tfBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBarrasKeyReleased(evt);
            }
        });

        tfData.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        tfData.setText("NFCe-n");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel5.setText("NFCe-n atualizado");

        tfHora.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        tfHora.setText("NFCe-n");

        tfAno.setForeground(new java.awt.Color(255, 255, 255));
        tfAno.setText("Ano");

        tfMes.setForeground(new java.awt.Color(255, 255, 255));
        tfMes.setText("Mes");

        tfTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/U.png"))); // NOI18N

        tfUsuarioID.setForeground(new java.awt.Color(255, 255, 255));
        tfUsuarioID.setText("Id Usuario");

        tfusuarionome.setText("Nome Usuario");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/cod_barras.png"))); // NOI18N

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("CheckBox.background")));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item", "Código", "Produto", "Quant.", "Valor Uni.", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(15);
            tabela.getColumnModel().getColumn(1).setResizable(false);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(17);
            tabela.getColumnModel().getColumn(2).setResizable(false);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(210);
            tabela.getColumnModel().getColumn(3).setResizable(false);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(17);
            tabela.getColumnModel().getColumn(4).setResizable(false);
            tabela.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel5.setBackground(new java.awt.Color(126, 252, 255));

        tfValorBruto2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        tfValorBruto2.setForeground(new java.awt.Color(255, 255, 255));
        tfValorBruto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfValorBruto2.setText("Valor Pago:");
        tfValorBruto2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        tfValorPago.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        tfValorPago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfValorPago.setText("999,23");
        tfValorPago.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfValorBruto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfValorPago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(tfValorBruto2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfValorPago)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255)));

        jLabel4.setText("Cliente:");

        tfNomeCliente.setForeground(new java.awt.Color(153, 153, 153));
        tfNomeCliente.setText("Nome Cliente");

        jLabel2.setText("Turno:");

        tfTurno.setForeground(new java.awt.Color(153, 153, 153));
        tfTurno.setText("Turno:");

        tfIdCliente.setForeground(new java.awt.Color(153, 153, 153));
        tfIdCliente.setText("id Cliente");

        jLabel6.setText("Id:");

        tfCpfCliente.setForeground(new java.awt.Color(153, 153, 153));
        tfCpfCliente.setText("CPF Cliente");

        jLabel7.setText("CPF:");

        tfVenda.setForeground(new java.awt.Color(153, 153, 153));
        tfVenda.setText("NºVenda");

        jLabel8.setText("Venda:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfVenda)
                    .addComponent(tfTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfCpfCliente)
                        .addComponent(tfIdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomeCliente)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdCliente)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCpfCliente)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTurno)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfVenda)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(153, 255, 153));

        tfValorBruto3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        tfValorBruto3.setForeground(new java.awt.Color(255, 255, 255));
        tfValorBruto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfValorBruto3.setText("Troco:");
        tfValorBruto3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        tfTrocoCliente.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        tfTrocoCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfTrocoCliente.setText("999,23");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfValorBruto3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfTrocoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(tfValorBruto3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfTrocoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfusuarionome, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfUsuarioID, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfHora, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfBarras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(tfAno)
                                        .addGap(57, 57, 57)
                                        .addComponent(tfMes)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(6, 6, 6)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3))))
                .addGap(8, 8, 8))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfData)
                            .addComponent(jLabel5)
                            .addComponent(tfHora)
                            .addComponent(tfUsuarioID)
                            .addComponent(tfusuarionome)))
                    .addComponent(tfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfAno)
                            .addComponent(tfMes))
                        .addGap(90, 90, 90)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu3.setText("Funções");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem2.setText("QUANTIDADE");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem3.setText("ABANDONAR VENDA");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem4.setText("EXCLUIR UM PRODUTO DA LISTA");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem5.setText("FINALIZAR VENDA (DINHEIRO)");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem10.setText("À PRAZO");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem6.setText("FINALIZAR VENDA QUANDO DIVIDIR CARTÃO COM DINHEIRO");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItem13.setText("FINALIZAR VENDA (CARTÃO DE CRÉDITO)");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMenuItem7.setText("FINALIZAR VENDA (TICKETS)");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuItem8.setText("LISTA PRODUTOS");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        jMenuItem9.setText("LISTA CLIENTES");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        jMenuItem11.setText("SANGRIA");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem12.setText("INSERIR VALOR PRODUTOS");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Sair");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1008, 714);
    }// </editor-fold>//GEN-END:initComponents
class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Date sistemaHora = new Date();
            String pmAm = "HH:mm:ss";
            SimpleDateFormat formato = new SimpleDateFormat(pmAm);
            Calendar now = Calendar.getInstance();
            tfHora.setText(String.format(formato.format(sistemaHora), now));
        }  
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     Date sistemaData = new Date(); 
      
        SimpleDateFormat formato = new SimpleDateFormat("dd/MMMM/yyyy");
        SimpleDateFormat mes = new SimpleDateFormat("dd/yyyy");
        SimpleDateFormat ano = new SimpleDateFormat("yyyy");     
        tfData.setText(formato.format(sistemaData)); 
        tfMes.setText(mes.format(sistemaData));
        tfAno.setText(ano.format(sistemaData));
        //HORA DO SISTEMA 
        Timer hr = new Timer(100, new horas());
        hr.start(); 
    }//GEN-LAST:event_formWindowOpened

    private void tfBarrasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBarrasKeyReleased
    if(tfBarras.equals(""))
    { 
    //Quando não tiver nada nessa JTextField; não vai aparecer nenhuma mensagem de alerta    
    }else
    { 
    //função de trazer pelo código de barras
    trazerProdutoEstoque(evt);
    
    }  
        
    }//GEN-LAST:event_tfBarrasKeyReleased
    private void trazerProdutoEstoque(java.awt.event.KeyEvent e){             
   
        try {      
    tfNomeProduto.setForeground(Color.BLACK);
    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();        
    if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){  
    tfValorPago.setText("0.00");  
    tfTrocoCliente.setText("0.00"); 
    DaoVenda2.numeros();
    modelProduto = new ModelProduto();            
    modelProduto = controllerProduto.retornarCodigoBarrasController(tfBarras.getText());
    modelo.addRow(new Object[]{     
    modelo.getRowCount()+1, 
    modelProduto.getId(),   
    modelProduto.getNome(), 
    quantidade,
    formatador.converterPontos(df.format(modelProduto.getPreco_venda() )),
    formatador.converterPontos(df.format(modelProduto.getPreco_venda() * quantidade))
    });                 
    tfBarras.setText("");  
    tfValorBruto.setText(formatador.converterPontos(df.format(somarValor()))+"");
    tfNomeProduto.setText(" "+quantidade+"x  "+modelProduto.getNome()+" = "+formatador.converterPontos(df.format(modelProduto.getPreco_venda() * quantidade))+"");      
    quantidade = 1; 
    }        
    } catch (Exception e3) {
        if(tfBarras.getText().equals(""))
        {
               
        }else{
        JOptionPane.showMessageDialog(null, "Produto não cadastrado na base de dados!");
        tfBarras.setText("");
        }
     
    try {
    if(!modelProduto.getCod_barras().equals(tfBarras.getText())){
 //   JOptionPane.showMessageDialog(null, "Produto não cadastrado na base de dados!");    
    }else   
    {      
    }    
    } catch (Exception e5) {
     if(tfBarras.getText().equals(""))
        {
               
        }else{
        JOptionPane.showMessageDialog(null, "Produto não cadastrado na base de dados!");
        tfBarras.setText("");
        }
    }       
    }       
    }
    private void tfBarrasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBarrasFocusLost
    
    }//GEN-LAST:event_tfBarrasFocusLost

    private void tfBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBarrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBarrasActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
    
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        produtosKL();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        ViewSangria sangria = new ViewSangria();
        sangria.setVisible(true);
        sangria.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        ViewListaClientes v = new ViewListaClientes();
        v.setVisible(true);
        v.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        ViewListaProduto pro = new ViewListaProduto();
        pro.setVisible(true);
        pro.setLocationRelativeTo(null);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        int cont = tabela.getRowCount();
        if(cont<1){
            JOptionPane.showMessageDialog(null, "Você precisa ter um produto na tabela de vendas!");
        }else{
            ModelAbrirTurno modelAbrirTurno = new ModelAbrirTurno();
            ControllerAbrirTuur controllerAbrirTuur = new ControllerAbrirTuur();
            ArrayList<ModelAbrirTurno> listaturno=new ArrayList<>();
            listaturno = controllerAbrirTuur.listaModelUsuarioController();
            for (int i = 0; i < listaturno.size(); i++) {
                int idUser = listaturno.get(i).getId();
                if(idUser != Integer.parseInt(tfUsuarioID.getText())){
                    JOptionPane.showMessageDialog(null, "Você não é o Usuário que iniciou este turno!");
                }else{
                    tfNomeProduto.setText("Finalizando a venda. Aguarde...");
                    viewPagamentoPDVTickets = new ViewPagamentoPDVTickets(this, true);
                    try {
                        viewPagamentoPDVTickets.setValorTotal(Float.parseFloat(tfValorBruto.getText()));
                        viewPagamentoPDVTickets.setValorRecebido(Float.parseFloat(tfValorBruto.getText()));
                        viewPagamentoPDVTickets.textFieldeValorTotal();
                        viewPagamentoPDVTickets.setLocationRelativeTo(null);
                        viewPagamentoPDVTickets.setVisible(true);
                        if(viewPagamentoPDVTickets.isPago()){
                            //salvarVendaTicketsNoServidor();
                            salvarVendaTickets();
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        int cont = tabela.getRowCount();
        if(cont<1){
            JOptionPane.showMessageDialog(null, "Você precisa ter um produto na tabela de vendas!");
        }else{
            ModelAbrirTurno modelAbrirTurno = new ModelAbrirTurno();
            ControllerAbrirTuur controllerAbrirTuur = new ControllerAbrirTuur();
            ArrayList<ModelAbrirTurno> listaturno=new ArrayList<>();
            listaturno = controllerAbrirTuur.listaModelUsuarioController();
            for (int i = 0; i < listaturno.size(); i++) {
                int idUser = listaturno.get(i).getId();
                if(idUser != Integer.parseInt(tfUsuarioID.getText())){
                    JOptionPane.showMessageDialog(null, "Você não é o Usuário que iniciou este turno!");
                }else{
                    tfNomeProduto.setText("Finalizando a venda. Aguarde..");
                    viewPagamentoPDVCartaoNormal = new ViewPagamentoPDVCartaoNormal(this, true);
                    try {
                        viewPagamentoPDVCartaoNormal.setValorTotal(Float.parseFloat(tfValorBruto.getText()));
                        viewPagamentoPDVCartaoNormal.textFieldeValorTotal();
                        viewPagamentoPDVCartaoNormal.setLocationRelativeTo(null);
                        viewPagamentoPDVCartaoNormal.setVisible(true);
                        if(viewPagamentoPDVCartaoNormal.isPago()){
                            //salvarVendaCartaoNoServidor();
                            salvarVendaCartao();
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        int cont = tabela.getRowCount();
        if(cont<1){
            JOptionPane.showMessageDialog(null, "Você precisa ter um produto na tabela de vendas!");
        }else{
            ModelAbrirTurno modelAbrirTurno = new ModelAbrirTurno();
            ControllerAbrirTuur controllerAbrirTuur = new ControllerAbrirTuur();
            ArrayList<ModelAbrirTurno> listaturno=new ArrayList<>();
            listaturno = controllerAbrirTuur.listaModelUsuarioController();
            for (int i = 0; i < listaturno.size(); i++) {
                int idUser = listaturno.get(i).getId();
                if(idUser != Integer.parseInt(tfUsuarioID.getText())){
                    JOptionPane.showMessageDialog(null, "Você não é o Usuário que iniciou este turno!");
                }else{
                    tfNomeProduto.setText("Finalizando a venda. Aguarde...");
                    viewPagamentoPDVCartao = new ViewPagamentoPDVCartao(this, true);
                    try {
                        viewPagamentoPDVCartao.setValorTotal(Float.parseFloat(tfValorBruto.getText()));
                        viewPagamentoPDVCartao.textFieldeValorTotal();
                        viewPagamentoPDVCartao.setLocationRelativeTo(null);
                        viewPagamentoPDVCartao.setVisible(true);
                        if(viewPagamentoPDVCartao.isPago()){
                            // salvarVendaCartaoNoServidor();
                            // salvarVendaDinheiroNoServidor();
                            salvarVendaDinheiroComCartao();
                            salvarVendaCartaoComDinheiro();
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        ModelAbrirTurno modelAbrirTurno = new ModelAbrirTurno();
        ControllerAbrirTuur controllerAbrirTuur = new ControllerAbrirTuur();
        ArrayList<ModelAbrirTurno> listaturno=new ArrayList<>();
        if(tfIdCliente.getText().equals("id Cliente")){
            JOptionPane.showMessageDialog(null, "Informe o Cliente!");
        }else{
            listaturno = controllerAbrirTuur.listaModelUsuarioController();
            for (int i = 0; i < listaturno.size(); i++) {
                int idUser = listaturno.get(i).getId();
                if(idUser != Integer.parseInt(tfUsuarioID.getText())){
                    JOptionPane.showMessageDialog(null, "Você não é o Usuário que iniciou este turno!");
                }else{
                    tfNomeProduto.setText("Finalizando a venda. Aguarde...");
                    viewPagamentopParcelaPDV = new ViewPagamentoPDVParcela(this, true);
                    try {
                        viewPagamentopParcelaPDV.setValorTotal(Float.parseFloat(tfValorBruto.getText()));
                        viewPagamentopParcelaPDV.textFieldeValorTotal();
                        viewPagamentopParcelaPDV.setLocationRelativeTo(null);
                        viewPagamentopParcelaPDV.setVisible(true);
                        if(viewPagamentopParcelaPDV.isPago()){
                            //salvarVendaDinheiroParcelaNoServidor();
                            salvarVendaDinheiroParcela();
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        int cont = tabela.getRowCount();
        if(cont<1){
        JOptionPane.showMessageDialog(null, "Você precisa ter um produto na tabela de vendas!");
        }else{
        ModelAbrirTurno modelAbrirTurno = new ModelAbrirTurno();
        ControllerAbrirTuur controllerAbrirTuur = new ControllerAbrirTuur();
        ArrayList<ModelAbrirTurno> listaturno=new ArrayList<>();
        listaturno = controllerAbrirTuur.listaModelUsuarioController();
        for (int i = 0; i < listaturno.size(); i++) {
        int idUser = listaturno.get(i).getId();
        if(idUser != Integer.parseInt(tfUsuarioID.getText())){
        JOptionPane.showMessageDialog(null, "Você não é o Usuário que iniciou este turno!");
        }else{
        tfNomeProduto.setText("Finalizando a venda. Aguarde...");
        viewPagamentoPDV = new ViewPagamentoPDV(this, true);
        try {
        viewPagamentoPDV.setValorTotal(Float.parseFloat(tfValorBruto.getText()));
        viewPagamentoPDV.textFieldeValorTotal();                    
        viewPagamentoPDV.setLocationRelativeTo(null);
        viewPagamentoPDV.setVisible(true);
        if(viewPagamentoPDV.isPago()){
        tfValorPago.setText(viewPagamentoPDV.tfRecebido.getText());
        tfTrocoCliente.setText(viewPagamentoPDV.tfTroco.getText());
        //salvarVendaDinheiroBanco();
        //salvarVendaDinheiroNoServidor();
        salvarVendaDinheiro();
        } 
        } catch (Exception e) {
        }

        }
        }  
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    try {
    int cont = tabela.getRowCount();
    if(cont<1){
    JOptionPane.showMessageDialog(null, "Não tem produto para excluir!");
    }else{
    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
    int linha = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto para remover?"));
    DaoVenda2.numeros();
    modelo.removeRow(linha-1);
    tfValorBruto.setText(formatador.converterPontos(df.format(somarValor()))+"");
    for (int i = 0; i < cont; i++) {
    modelo.setValueAt(i+1, i, 0);
    }
    }
    } catch (Exception e) {
    }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ModelVendaAbandono modelVendaAbandono = new ModelVendaAbandono();
        ControllervendaAbandono controllervendaAbandono = new ControllervendaAbandono();

        ModelVendaProdutoAbandono modelVendaProdutoAbandono = new ModelVendaProdutoAbandono();
        ControllerVendaProdutoAbandono  controllerVendaProdutoAbandono = new ControllerVendaProdutoAbandono();
        ArrayList<ModelVendaProdutoAbandono> listaModelVendaProdutoAbandono = new ArrayList<>();
        modelVendaAbandono = new ModelVendaAbandono();
        int percorrertabela,codigoProduto, codigoVenda, codCliente;
        if(tfUsuarioID.getText().equals("")){
            tfUsuarioID.setText(String.valueOf(3));
        }else{
            modelVendaAbandono.setCliente(Integer.parseInt(tfUsuarioID.getText()));
        }
        modelVendaAbandono.setCliente(Integer.parseInt(tfUsuarioID.getText()));
        modelVendaAbandono.setData(tfData.getText());
        modelVendaAbandono.setHora(tfHora.getText());
        modelVendaAbandono.setIdVenda(Integer.parseInt(tfVenda.getText()));
        modelVendaAbandono.setPagamento((String) viewPagamentoPDV.jcbPagamento.getSelectedItem());
        modelVendaAbandono.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
        modelVendaAbandono.setValorBruto(Double.parseDouble(tfValorBruto.getText()));
        modelVendaAbandono.setValorDesconto(Double.parseDouble(String.valueOf(viewPagamentoPDV.getDesconto())));
        modelVendaAbandono.setValorLiquido(Double.parseDouble(String.valueOf(viewPagamentoPDV.getValorTotal())));
        controllervendaAbandono.salvarvendaController(modelVendaAbandono);
        JOptionPane.showMessageDialog(null, "Abandono de vendas com exito!");

        percorrertabela = tabela.getRowCount();
        for (int i = 0; i < percorrertabela; i++) {
            codigoProduto=(int) tabela.getValueAt(i, 1);

            modelVendaProdutoAbandono = new ModelVendaProdutoAbandono();

            modelVendaProdutoAbandono.setProduto(codigoProduto);
            modelVendaProdutoAbandono.setVenda(Integer.parseInt(tfVenda.getText()));
            modelVendaProdutoAbandono.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
            modelVendaProdutoAbandono.setValorVenda(Double.parseDouble(String.valueOf(tabela.getValueAt(i, 4))));
            modelVendaProdutoAbandono.setQuantidade(Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));
            modelVendaProdutoAbandono.setNome_produto(String.valueOf(tabela.getValueAt(i, 2)));

            listaModelVendaProdutoAbandono.add(modelVendaProdutoAbandono);

        }
        controllerVendaProdutoAbandono.salvarVendaProdutoController(listaModelVendaProdutoAbandono);
        JOptionPane.showMessageDialog(null, "Produtos do Abandono de vendas salvo com exito!");
        geraId();
        DaoVenda2.numeros();
        limparFormulario();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            quantidade = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro! Só é possível inserir números!");
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
    int linha = tabela.getSelectedRow();
    String cod = String.valueOf(tabela.getValueAt(linha, 0));
    //System.out.println(cod);
    tfNomeProduto.setText(""+String.valueOf(tabela.getValueAt(linha, 3))+" "+"x"+" "+String.valueOf(tabela.getValueAt(linha, 2))+" "+"="+" "+String.valueOf(tabela.getValueAt(linha, 5))+" ");
    tfNomeProduto.setForeground(Color.red);
       
    int resposta =   JOptionPane.showConfirmDialog(this, "Deseja excluir o produto: "+String.valueOf(tabela.getValueAt(linha, 2))+"? \n"+"Que contém: "+String.valueOf(tabela.getValueAt(linha, 3))+""+" Quantidade inserida nessa venda?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if(resposta==JOptionPane.YES_OPTION){
    tfBarras.requestFocus();   
    try {     
    int cont = tabela.getRowCount();
      
    if(cont<1){
    JOptionPane.showMessageDialog(null, "Não tem produto para excluir!");
    tfBarras.requestFocus();
    }else{
    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
    modelo.removeRow(Integer.parseInt(cod)-1);
    tfValorBruto.setText(formatador.converterPontos(df.format(somarValor()))+"");
    for (int i = 0; i < cont; i++) {
    modelo.setValueAt(i+1, i, 0);
    tfBarras.requestFocus();
    } 
    }
    } catch (Exception e) {
    }
    
    }else if(resposta==JOptionPane.NO_OPTION){
    tfNomeProduto.setForeground(Color.BLACK);   
    tfBarras.requestFocus();
    }else if(resposta==JOptionPane.CLOSED_OPTION){
    tfBarras.requestFocus();
    }
    }//GEN-LAST:event_tabelaMouseClicked
          private float somarValor(){
         int cont = tabela.getRowCount(); 
         float valor=0, soma=0;
         
         for (int i = 0; i < cont; i++) {
         valor = Float.parseFloat(String.valueOf(tabela.getValueAt(i, 5)));
         soma += valor;    
         }
         return soma;
     }     private void formaPagamentoDinheiro(java.awt.event.KeyEvent e){
    if(e.getKeyCode() == java.awt.event.KeyEvent.VK_F1){  
    JOptionPane.showMessageDialog(null, "Dinheiro");
    }    
        
    }
    private void formaPagamentoCartao(java.awt.event.KeyEvent e){
    if(e.getKeyCode() == java.awt.event.KeyEvent.VK_F2){    
    JOptionPane.showMessageDialog(null, "Cartao");
    }
    }
    
    private void formaPagamentoTickets(java.awt.event.KeyEvent e){
    if(e.getKeyCode() == java.awt.event.KeyEvent.VK_F3){  
    JOptionPane.showMessageDialog(null, "forma pagamento tickets");
    }                
    }
    
    private void excluirUmProduto(java.awt.event.KeyEvent e){
    if(e.getKeyCode() == java.awt.event.KeyEvent.VK_F4){  
    JOptionPane.showMessageDialog(null, "excluirProduto");
    }                
    }
    
    private void abandono(java.awt.event.KeyEvent e){
    if(e.getKeyCode() == java.awt.event.KeyEvent.VK_F5){  
    JOptionPane.showMessageDialog(null, "abandono");
    }  
    }
    
    private void listarClientes(java.awt.event.KeyEvent e){
    if(e.getKeyCode() == java.awt.event.KeyEvent.VK_F6){  
    JOptionPane.showMessageDialog(null, "listarClientes");
    }  
    }
    
    private void produtos(java.awt.event.KeyEvent e){
    if(e.getKeyCode() == java.awt.event.KeyEvent.VK_F7){  
    JOptionPane.showMessageDialog(null, "produtos");
    }  
    }
    
    private void sangria(java.awt.event.KeyEvent e){
    if(e.getKeyCode() == java.awt.event.KeyEvent.VK_F8){  
    JOptionPane.showMessageDialog(null, "sangria");
    }  
    }
    
    private void quantidade(java.awt.event.KeyEvent e){
    if(e.getKeyCode() == java.awt.event.KeyEvent.VK_F9){  
    JOptionPane.showMessageDialog(null, "quantidade");
    }  
    }
    
    private void parcelamento(java.awt.event.KeyEvent e){
    if(e.getKeyCode() == java.awt.event.KeyEvent.VK_F10){  
    JOptionPane.showMessageDialog(null, "parcelamento");
    }  
    }
    
    private void inserirValorProduto(java.awt.event.KeyEvent e){
    if(e.getKeyCode() == java.awt.event.KeyEvent.VK_F11){  
    JOptionPane.showMessageDialog(null, "inserir valor produto");
    }  
    }
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
            java.util.logging.Logger.getLogger(ViewPdv555.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPdv555.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPdv555.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPdv555.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPdv555().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabela;
    public static javax.swing.JLabel tfAno;
    private javax.swing.JTextField tfBarras;
    public static javax.swing.JLabel tfCpfCliente;
    private javax.swing.JLabel tfData;
    private javax.swing.JLabel tfHora;
    public static javax.swing.JLabel tfIdCliente;
    public static javax.swing.JLabel tfMes;
    public static javax.swing.JLabel tfNomeCliente;
    private javax.swing.JLabel tfNomeProduto;
    public static javax.swing.JLabel tfTipo;
    private javax.swing.JLabel tfTrocoCliente;
    public static javax.swing.JLabel tfTurno;
    public static javax.swing.JLabel tfUsuarioID;
    public static javax.swing.JLabel tfValorBruto;
    public static javax.swing.JLabel tfValorBruto1;
    public static javax.swing.JLabel tfValorBruto2;
    public static javax.swing.JLabel tfValorBruto3;
    public static javax.swing.JLabel tfValorPago;
    public static javax.swing.JLabel tfVenda;
    public static javax.swing.JLabel tfusuarionome;
    // End of variables declaration//GEN-END:variables

private void setIcon() {
setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagem/comp.png"))); 
    }

 public void salvarVendaDinheiro(){
     pagamento = "A vista";  
     try {    
     /*
     Verificar se é correto instanciar novamente essas classes
     */
     modelVenda = new ModelVenda();
     //modelVendaProduto = new ModelVendaProduto();
     //modelProduto = new ModelProduto();   
     listaModelVendaProduto = new ArrayList<>();
     if(tfIdCliente.getText().equals("id Cliente")){
     tfIdCliente.setText(String.valueOf(3));    
     } 
     modelVenda.setCliente(Integer.parseInt(tfIdCliente.getText()));        
     //modelVenda.setCliente(Integer.parseInt(tfIdCliente.getText()));
     modelVenda.setData(tfData.getText());
     modelVenda.setIdVenda(Integer.parseInt(tfVenda.getText()));   
     modelVenda.setHora(tfHora.getText());   
     modelVenda.setData_relatorio(tfMes.getText());
     modelVenda.setAno(tfAno.getText());
     modelVenda.setPagamento((String) viewPagamentoPDV.jcbPagamento.getSelectedItem()); 
     modelVenda.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
     modelVenda.setValorBruto(Double.parseDouble(tfValorBruto.getText()));
     modelVenda.setValorDesconto(Double.parseDouble(String.valueOf(viewPagamentoPDV.getDesconto())));
     modelVenda.setValorLiquido(Double.parseDouble(String.valueOf(viewPagamentoPDV.getValorTotal())));
     controller.salvarvendaController(modelVenda);  
     percorrertabela = tabela.getRowCount();    
     for (int i = 0; i < percorrertabela; i++) { 
     codigoProduto=(int) tabela.getValueAt(i, 1);          
     modelVendaProduto = new ModelVendaProduto(); 
     modelProduto = new ModelProduto();
     modelVendaProduto.setProduto(codigoProduto);   
     modelVendaProduto.setMesAno(tfMes.getText());
     modelVendaProduto.setAno(tfAno.getText());    
     modelVendaProduto.setVenda(Integer.parseInt(tfVenda.getText()));
     modelVendaProduto.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
     modelVendaProduto.setValorVenda(Double.parseDouble(String.valueOf(tabela.getValueAt(i, 4))));
     modelVendaProduto.setQuantidade(Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));
     modelVendaProduto.setNome_produto(String.valueOf(tabela.getValueAt(i, 2)));
     //baixa no estoque  
     modelProduto.setId(codigoProduto); 
     modelProduto.setEstoque(controllerProduto.retornarController(codigoProduto).getEstoque()
     -Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));      
     listaModelVendaProduto.add(modelVendaProduto);
     listaModelProduto.add(modelProduto);     
     }          
     if(controllerVendaProduto.salvarVendaProdutoController(listaModelVendaProduto)){
     //alterando estoque estiva (produto)  
     controllerProduto.alterarEstoqueController(listaModelProduto); 
    
     JOptionPane.showMessageDialog(null, "Venda à vista finalizada!");
     int resposta =   JOptionPane.showConfirmDialog(this, "Deseja imprimir cupom?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     if(resposta==JOptionPane.YES_OPTION){
     imprimirCupom(listaModelVendaProduto, modelVenda); 
     System.out.println(Double.parseDouble(String.valueOf(viewPagamentoPDV.getValorRecebido())));
     int codCli = Integer.parseInt(tfUsuarioID.getText());
     
     geraId(); 
     /*
     Limpando Class daoVendas2
     */ 
     DaoVenda2 daoVendas2 = new DaoVenda2();
     daoVendas2 = new DaoVenda2();
     daoVendas2.numeros();  
     /*  
     Limpando Class daoVendas2
     */
     
     limparFormulario(); 
     }else if(resposta==JOptionPane.NO_OPTION){
     int codCli = Integer.parseInt(tfUsuarioID.getText());
     geraId(); 
     /*
     Limpando Class daoVendas2
     */ 
     DaoVenda2 daoVendas2 = new DaoVenda2();
     daoVendas2 = new DaoVenda2();
     daoVendas2.numeros();  
     /*  
     Limpando Class daoVendas2
     */
     limparFormulario();       
     }else if(resposta==JOptionPane.CLOSED_OPTION){
     int codCli = Integer.parseInt(tfUsuarioID.getText());      
     limparFormulario();    
      geraId(); 
     /*
     Limpando Class daoVendas2
     */ 
     DaoVenda2 daoVendas2 = new DaoVenda2();
     daoVendas2 = new DaoVenda2();
     daoVendas2.numeros();  
     /*  
     Limpando Class daoVendas2
     */
     }
     }else{
     JOptionPane.showMessageDialog(null, "erro");
     }    
     } catch (Exception e) {
     }
     }
 
 
     public void salvarVendaDinheiroComCartao(){
     System.out.println("Passou");
         pagamento = "A vista";
     try {      
     //modelProduto = new ModelProduto();
     modelVenda = new ModelVenda();
     modelVendaProduto = new ModelVendaProduto();
     listaModelVendaProduto = new ArrayList<>();
     
     if(tfIdCliente.getText().equals("id Cliente")){
     tfIdCliente.setText(String.valueOf(3));    
     } 
     modelVenda.setCliente(Integer.parseInt(tfIdCliente.getText()));    
      
 //  modelVenda.setCliente(Integer.parseInt(tfIdCliente.getText()));
     modelVenda.setData(tfData.getText());
     modelVenda.setIdVenda(Integer.parseInt(tfVenda.getText()));   
     modelVenda.setHora(tfHora.getText());   
     modelVenda.setData_relatorio(tfMes.getText());
     modelVenda.setAno(tfAno.getText());
     modelVenda.setPagamento((String) viewPagamentoPDVCartao.jcbPagamento.getSelectedItem()); 
     modelVenda.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
     modelVenda.setValorBruto(Double.parseDouble(tfValorBruto.getText()));
     modelVenda.setValorDesconto(Double.parseDouble(String.valueOf(viewPagamentoPDVCartao.getDesconto())));
     modelVenda.setValorLiquido(Double.parseDouble(String.valueOf(viewPagamentoPDVCartao.getValorTotalDinheiro())));
     controller.salvarvendaController(modelVenda);
      
     
     percorrertabela = tabela.getRowCount();
     
     for (int i = 0; i < percorrertabela; i++) { 
     codigoProduto=(int) tabela.getValueAt(i, 1);
            
     modelVendaProduto = new ModelVendaProduto(); 
     modelProduto = new ModelProduto();
     modelVendaProduto.setProduto(codigoProduto);
      
     
     modelVendaProduto.setMesAno(tfMes.getText());
     modelVendaProduto.setAno(tfAno.getText()); 
     
     modelVendaProduto.setVenda(Integer.parseInt(tfVenda.getText()));
     modelVendaProduto.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
     modelVendaProduto.setValorVenda(Double.parseDouble(String.valueOf(tabela.getValueAt(i, 4))));
     modelVendaProduto.setQuantidade(Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));
     modelVendaProduto.setNome_produto(String.valueOf(tabela.getValueAt(i, 2)));
     //baixa no estoque 
     modelProduto.setId(codigoProduto); 
     modelProduto.setEstoque(controllerProduto.retornarController(codigoProduto).getEstoque()
     -Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));
       
     listaModelVendaProduto.add(modelVendaProduto);
     listaModelProduto.add(modelProduto);     
     }          
     if(controllerVendaProduto.salvarVendaProdutoController(listaModelVendaProduto)){
     //alterando estoque estiva (produto)  
     controllerProduto.alterarEstoqueController(listaModelProduto);
     JOptionPane.showMessageDialog(null, "Venda com o cartão de crédito finalizada!");
     geraId();
     /*
     Limpando Class daoVendas2
     */
     DaoVenda2 daoVendas2 = new DaoVenda2();
     daoVendas2 = new DaoVenda2();
     daoVendas2.numeros();
     /*
     Limpando Class daoVendas2
     */
     } 
     } catch (Exception e) {
     }
     }
 
 
 
  private void salvarVendaTickets(){
     pagamento = "Ticket"; 
     try {
     modelVendaTickets = new ModelVendaTickets();
     modelVendaProdutoTickets = new ModelVendaProdutoTickets();
     listaModelVendaProdutoTickets = new ArrayList<>();
     int percorrertabela, codigoVenda;
     if(tfIdCliente.getText().equals("id Cliente")){
     tfIdCliente.setText(String.valueOf(3));   
     }
     modelVendaTickets.setCliente(Integer.parseInt(tfIdCliente.getText()));    
    // modelVendaTickets.setCliente(Integer.parseInt(tfUsuarioID.getText()));
     modelVendaTickets.setData(tfData.getText());
     modelVendaTickets.setIdVenda(Integer.parseInt(tfVenda.getText())); 
     modelVendaTickets.setHora(tfHora.getText());
     modelVendaTickets.setData_relatorio(tfMes.getText());
     modelVendaTickets.setDataAnual(tfAno.getText()); 
     modelVendaTickets.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
     modelVendaTickets.setValorBruto(Double.parseDouble(tfValorBruto.getText()));
     modelVendaTickets.setValorDesconto(Double.parseDouble(String.valueOf(viewPagamentoPDVTickets.getDesconto())));
     modelVendaTickets.setValorLiquido(Double.parseDouble(String.valueOf(viewPagamentoPDVTickets.getValorTotal())));
     codigoVenda = controllervendaTickets.salvarvendaController(modelVendaTickets);
     if(codigoVenda>0){
    
     }
     
     percorrertabela = tabela.getRowCount();
     for (int i = 0; i < percorrertabela; i++) {
     codigoProduto=(int) tabela.getValueAt(i, 1);
            
     modelVendaProdutoTickets = new ModelVendaProdutoTickets();
     modelProduto = new ModelProduto();
     modelVendaProdutoTickets.setProduto(codigoProduto);
     modelVendaProdutoTickets.setVenda(Integer.parseInt(tfVenda.getText())); 
     modelVendaProdutoTickets.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
     modelVendaProdutoTickets.setValorVenda(Double.parseDouble(String.valueOf(tabela.getValueAt(i, 4))));
     modelVendaProdutoTickets.setNome_produto(String.valueOf(tabela.getValueAt(i, 2)));
     modelVendaProdutoTickets.setQuantidade(Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));
     modelVendaProdutoTickets.setAno(tfAno.getText());
     modelVendaProdutoTickets.setMesAno(tfMes.getText());
     //baixa no estoque 
     modelProduto.setId(codigoProduto); 
     modelProduto.setEstoque(controllerProduto.retornarController(codigoProduto).getEstoque()
     -Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));        
     listaModelVendaProdutoTickets.add(modelVendaProdutoTickets);
     listaModelProduto.add(modelProduto);     
     }   
     if(controllerVendaProdutoTickets.salvarVendaProdutoController(listaModelVendaProdutoTickets)){
     //alterando estoque estiva (produto)
     controllerProduto.alterarEstoqueController(listaModelProduto);
     JOptionPane.showMessageDialog(null, "Venda no ticket finalizada!");
     geraId();
     /*
     Limpando Class daoVendas2
     */
     DaoVenda2 daoVendas2 = new DaoVenda2();
     daoVendas2 = new DaoVenda2();
     daoVendas2.numeros();
     /* 
     Limpando Class daoVendas2
     */
     int resposta =   JOptionPane.showConfirmDialog(this, "Deseja imprimir cupom?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     if(resposta==JOptionPane.YES_OPTION){
     imprimirCupomTickets(listaModelVendaProdutoTickets, modelVendaTickets);
     int codCli = Integer.parseInt(tfUsuarioID.getText());      
     limparFormulario(); 
     }else if(resposta==JOptionPane.NO_OPTION){
     int codCli = Integer.parseInt(tfUsuarioID.getText());      
     limparFormulario();       
     }else if(resposta==JOptionPane.CLOSED_OPTION){
     int codCli = Integer.parseInt(tfUsuarioID.getText());      
     limparFormulario();    
     }
        }else{
            JOptionPane.showMessageDialog(null, "erro");
        }
      } catch (Exception e) {
        }
    }
  
  
    private void salvarVendaTicketsNoServidor(){
    ModelVendaTickets2 modelVendaTickets = new ModelVendaTickets2();
    ControllervendaTickets2 controllervendaTickets = new ControllervendaTickets2();
    ArrayList<ModelVendaTickets2> listaModelVendaTickets = new ArrayList<>();
    
    ModelVendaProdutoTickets2 modelVendaProdutoTickets = new ModelVendaProdutoTickets2();
    ControllerVendaProdutoTickets2 controllerVendaProdutoTickets = new ControllerVendaProdutoTickets2();
    ArrayList<ModelVendaProdutoTickets2>listaModelVendaProdutoTickets= new ArrayList<>();
    
    pagamento = "Ticket"; 
    try {
    modelVendaTickets = new ModelVendaTickets2();
    modelVendaProdutoTickets = new ModelVendaProdutoTickets2();
    listaModelVendaProdutoTickets = new ArrayList<>();
    int percorrertabela, codigoVenda;
    if(tfIdCliente.getText().equals("id Cliente")){
    tfIdCliente.setText(String.valueOf(3));   
    }
    modelVendaTickets.setCliente(Integer.parseInt(tfIdCliente.getText()));    
    //modelVendaTickets.setCliente(Integer.parseInt(tfUsuarioID.getText()));
    modelVendaTickets.setData(tfData.getText());
    modelVendaTickets.setTurno(Integer.parseInt(tfTurno.getText()));
    modelVendaTickets.setIdVenda(Integer.parseInt(tfVenda.getText())); 
    modelVendaTickets.setHora(tfHora.getText());
    modelVendaTickets.setData_relatorio(tfMes.getText());
    modelVendaTickets.setDataAnual(tfAno.getText()); 
    modelVendaTickets.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
    modelVendaTickets.setValorBruto(Double.parseDouble(tfValorBruto.getText()));
    modelVendaTickets.setValorDesconto(Double.parseDouble(String.valueOf(viewPagamentoPDVTickets.getDesconto())));
    modelVendaTickets.setValorLiquido(Double.parseDouble(String.valueOf(viewPagamentoPDVTickets.getValorTotal())));
    codigoVenda = controllervendaTickets.salvarvendaController(modelVendaTickets);
    if(codigoVenda>0){   
    }  
    percorrertabela = tabela.getRowCount();
    for (int i = 0; i < percorrertabela; i++) {
    codigoProduto=(int) tabela.getValueAt(i, 1);        
    modelVendaProdutoTickets = new ModelVendaProdutoTickets2();
    modelProduto = new ModelProduto();
    modelVendaProdutoTickets.setProduto(codigoProduto);
    modelVendaProdutoTickets.setVenda(Integer.parseInt(tfVenda.getText())); 
    modelVendaProdutoTickets.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
    modelVendaProdutoTickets.setValorVenda(Double.parseDouble(String.valueOf(tabela.getValueAt(i, 4))));
    modelVendaProdutoTickets.setNome_produto(String.valueOf(tabela.getValueAt(i, 2)));
    modelVendaProdutoTickets.setQuantidade(Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));
    modelVendaProdutoTickets.setAno(tfAno.getText());
    modelVendaProdutoTickets.setMes(tfMes.getText());
    //baixa no estoque 
    modelProduto.setId(codigoProduto); 
    modelProduto.setEstoque(controllerProduto.retornarController(codigoProduto).getEstoque()
    -Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));      
    listaModelVendaProdutoTickets.add(modelVendaProdutoTickets);
    listaModelProduto.add(modelProduto);     
    } 
    controllerVendaProdutoTickets.salvarVendaProdutoController(listaModelVendaProdutoTickets); 
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Erro ao salvar venda no cartão no servidor");
    }
    }
  
  private void salvarVendaCartao(){
     pagamento = "Cartao de credito";
     try { 
     modelVendaCartao = new ModelVendaCartao();
     //modelVendaProdutoCartao = new ModelVendaProdutoCartao();
     listaModelVendaProdutoCartao = new ArrayList<>();
     int percorrertabela, codigoVenda;
     if(tfIdCliente.getText().equals("id Cliente")){
     tfIdCliente.setText("3");   
     }
     modelVendaCartao.setCliente(Integer.parseInt(tfIdCliente.getText()));    
      
   //modelVendaCartao.setCliente(Integer.parseInt(tfUsuarioID.getText()));
     modelVendaCartao.setData(tfData.getText()); 
     modelVendaCartao.setIdVenda(Integer.parseInt(tfVenda.getText())); 
     modelVendaCartao.setHora(tfHora.getText());    
     modelVendaCartao.setData_relatorio(tfMes.getText());
     modelVendaCartao.setDataAnual(tfAno.getText());
     modelVendaCartao.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
     modelVendaCartao.setValorBruto(Double.parseDouble(tfValorBruto.getText()));
     modelVendaCartao.setValorDesconto(Double.parseDouble(String.valueOf(viewPagamentoPDVCartaoNormal.getDesconto())));
     modelVendaCartao.setValorLiquido(Double.parseDouble(String.valueOf(viewPagamentoPDVCartaoNormal.getValorTotal())));
     modelVendaCartao.setValorDesconto(Double.parseDouble(String.valueOf(viewPagamentoPDVCartaoNormal.getDesconto())));
     codigoVenda = controllervendaCartao.salvarvendaController(modelVendaCartao);
     if(codigoVenda>0){   
     }    
     percorrertabela = tabela.getRowCount(); 
     for (int i = 0; i < percorrertabela; i++) {
     codigoProduto=(int) tabela.getValueAt(i, 1);           
     modelVendaProdutoCartao = new ModelVendaProdutoCartao();
     modelProduto = new ModelProduto();
     modelVendaProdutoCartao.setProduto(codigoProduto);
     modelVendaProdutoCartao.setVenda(Integer.parseInt(tfVenda.getText()));
     modelVendaProdutoCartao.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
     modelVendaProdutoCartao.setValorVenda(Double.parseDouble(String.valueOf(tabela.getValueAt(i, 4))));
     modelVendaProdutoCartao.setQuantidade(Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));
     modelVendaProdutoCartao.setNome_produto(String.valueOf(tabela.getValueAt(i, 2)));    
     modelVendaProdutoCartao.setMes(tfMes.getText());
     modelVendaProdutoCartao.setAno(tfAno.getText());   
     //baixa no estoque  
     modelProduto.setId(codigoProduto);
     modelProduto.setEstoque(controllerProduto.retornarController(codigoProduto).getEstoque()
     -Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));    
     listaModelVendaProdutoCartao.add(modelVendaProdutoCartao);
     listaModelProduto.add(modelProduto);     
     }
     if(controllerVendaProdutoCartao.salvarVendaProdutoController(listaModelVendaProdutoCartao)){
     //alterando estoque estiva (produto)
     controllerProduto.alterarEstoqueController(listaModelProduto);
     geraId();
     /*
     Limpando Clss daoVendas2
     */
     DaoVenda2 daoVendas2 = new DaoVenda2();
     daoVendas2 = new DaoVenda2();
     daoVendas2.numeros();
     /*
     Limpando Clss daoVendas2
     */
     
     JOptionPane.showMessageDialog(null, "Venda no cartão de crédito finalizada!");
     int resposta =   JOptionPane.showConfirmDialog(this, "Deseja imprimir cupom?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     if(resposta==JOptionPane.YES_OPTION){
     imprimirCupomCartao(listaModelVendaProdutoCartao, modelVendaCartao);
     int codCli = Integer.parseInt(tfUsuarioID.getText());      
     limparFormulario(); 
     }else if(resposta==JOptionPane.NO_OPTION){
     int codCli = Integer.parseInt(tfUsuarioID.getText());      
     limparFormulario();       
     }else if(resposta==JOptionPane.CLOSED_OPTION){
     int codCli = Integer.parseInt(tfUsuarioID.getText());      
     limparFormulario();    
     }
     
     }
        
      } catch (Exception e) {
        }
    }
  
    private void salvarVendaCartaoNoServidor(){
    ModelVendaCartao2 modelVendaCartao = new ModelVendaCartao2();
    ControllervendaCartao2 controllervendaCartao = new ControllervendaCartao2();
    ArrayList<ModelVendaCartao2> listaModelVendaCartao = new ArrayList<>();
    
    ModelVendaProdutoCartao2 modelVendaProdutoCartao = new ModelVendaProdutoCartao2();
    ControllerVendaProdutoCartao2 controllerVendaProdutoCartao = new ControllerVendaProdutoCartao2();
    ArrayList<ModelVendaProdutoCartao2> listaModelVendaProdutoCartao = new ArrayList<>();
    
    pagamento = "Cartao de credito";
    try { 
    modelVendaCartao = new ModelVendaCartao2();
    modelVendaProdutoCartao = new ModelVendaProdutoCartao2();
    listaModelVendaProdutoCartao = new ArrayList<>();
    int percorrertabela, codigoVenda;
    if(tfIdCliente.getText().equals("id Cliente")){
    tfIdCliente.setText("3");   
    }
    modelVendaCartao.setCliente(Integer.parseInt(tfIdCliente.getText()));         
    //modelVendaCartao.setCliente(Integer.parseInt(tfUsuarioID.getText()));
    modelVendaCartao.setData(tfData.getText()); 
    modelVendaCartao.setTurno(Integer.parseInt(tfTurno.getText())); 
    modelVendaCartao.setIdVenda(Integer.parseInt(tfVenda.getText())); 
    modelVendaCartao.setHora(tfHora.getText());    
    modelVendaCartao.setData_relatorio(tfMes.getText());
    modelVendaCartao.setDataAnual(tfAno.getText());
    modelVendaCartao.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
    modelVendaCartao.setValorBruto(Double.parseDouble(tfValorBruto.getText()));
    modelVendaCartao.setValorDesconto(Double.parseDouble(String.valueOf(viewPagamentoPDVCartaoNormal.getDesconto())));
    modelVendaCartao.setValorLiquido(Double.parseDouble(String.valueOf(viewPagamentoPDVCartaoNormal.getValorTotal())));
    modelVendaCartao.setValorDesconto(Double.parseDouble(String.valueOf(viewPagamentoPDVCartaoNormal.getDesconto())));
    codigoVenda = controllervendaCartao.salvarvendaController(modelVendaCartao);
    if(codigoVenda>0){
    }    
    percorrertabela = tabela.getRowCount(); 
    for (int i = 0; i < percorrertabela; i++) {
    codigoProduto=(int) tabela.getValueAt(i, 1);           
    modelVendaProdutoCartao = new ModelVendaProdutoCartao2();
    modelProduto = new ModelProduto();
    modelVendaProdutoCartao.setProduto(codigoProduto);
    modelVendaProdutoCartao.setVenda(Integer.parseInt(tfVenda.getText()));
    modelVendaProdutoCartao.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
    modelVendaProdutoCartao.setValorVenda(Double.parseDouble(String.valueOf(tabela.getValueAt(i, 4))));
    modelVendaProdutoCartao.setQuantidade(Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));
    modelVendaProdutoCartao.setNome_produto(String.valueOf(tabela.getValueAt(i, 2)));  
    modelVendaProdutoCartao.setMes(tfMes.getText());
    modelVendaProdutoCartao.setAno(tfAno.getText());   
    //baixa no estoque 
    modelProduto.setId(codigoProduto);
    modelProduto.setEstoque(controllerProduto.retornarController(codigoProduto).getEstoque()
    -Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));     
    listaModelVendaProdutoCartao.add(modelVendaProdutoCartao);
    listaModelProduto.add(modelProduto);     
    }
    controllerVendaProdutoCartao.salvarVendaProdutoController(listaModelVendaProdutoCartao);       
    } catch (Exception e) {
    }
    }
  
     private void salvarVendaCartaoComDinheiro(){
     pagamento = "Cartao de credito";
     try { 
     modelVendaCartao = new ModelVendaCartao();
     modelVendaProdutoCartao = new ModelVendaProdutoCartao();
     listaModelVendaProdutoCartao = new ArrayList<>();
     int percorrertabela, codigoVenda;
     if(tfIdCliente.getText().equals("id Cliente")){
     tfIdCliente.setText("3");   
     }
     modelVendaCartao.setCliente(Integer.parseInt(tfIdCliente.getText()));    
        
   //modelVendaCartao.setCliente(Integer.parseInt(tfUsuarioID.getText()));
     modelVendaCartao.setData(tfData.getText()); 
     modelVendaCartao.setIdVenda(Integer.parseInt(tfVenda.getText())); 
     modelVendaCartao.setHora(tfHora.getText());    
     modelVendaCartao.setData_relatorio(tfMes.getText());
     modelVendaCartao.setDataAnual(tfAno.getText());
     modelVendaCartao.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
     modelVendaCartao.setValorBruto(Double.parseDouble(tfValorBruto.getText()));
     modelVendaCartao.setValorDesconto(Double.parseDouble(String.valueOf(viewPagamentoPDVCartao.getDesconto())));
     modelVendaCartao.setValorLiquido(Double.parseDouble(String.valueOf(viewPagamentoPDVCartao.getValorTotal())));
     modelVendaCartao.setValorDesconto(Double.parseDouble(String.valueOf(viewPagamentoPDVCartao.getDesconto())));

     codigoVenda = controllervendaCartao.salvarvendaController(modelVendaCartao);
     if(codigoVenda>0){
    
     }
     
     percorrertabela = tabela.getRowCount(); 
     for (int i = 0; i < percorrertabela; i++) {
     codigoProduto=(int) tabela.getValueAt(i, 1);
            
     modelVendaProdutoCartao = new ModelVendaProdutoCartao();
     modelProduto = new ModelProduto();
     modelVendaProdutoCartao.setProduto(codigoProduto);
     modelVendaProdutoCartao.setVenda(Integer.parseInt(tfVenda.getText()));
     modelVendaProdutoCartao.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
     modelVendaProdutoCartao.setValorVenda(Double.parseDouble(String.valueOf(tabela.getValueAt(i, 4))));
     modelVendaProdutoCartao.setQuantidade(Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));
     modelVendaProdutoCartao.setNome_produto(String.valueOf(tabela.getValueAt(i, 2)));
     
     modelVendaProdutoCartao.setMes(tfMes.getText());
     modelVendaProdutoCartao.setAno(tfAno.getText());
     
     //baixa no estoque 
     modelProduto.setId(codigoProduto);
     modelProduto.setEstoque(controllerProduto.retornarController(codigoProduto).getEstoque()
     -Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));
       
     listaModelVendaProdutoCartao.add(modelVendaProdutoCartao);
     listaModelProduto.add(modelProduto);     
     }
     if(controllerVendaProdutoCartao.salvarVendaProdutoController(listaModelVendaProdutoCartao)){
     //alterando estoque estiva (produto)
     controllerProduto.alterarEstoqueController(listaModelProduto);
     JOptionPane.showMessageDialog(null, "Venda no dinheiro finalizada!");
     geraId();
     DaoVenda2.numeros(); 
     int resposta =   JOptionPane.showConfirmDialog(this, "Deseja imprimir cupom?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     if(resposta==JOptionPane.YES_OPTION){
     imprimirCupomCartao(listaModelVendaProdutoCartao, modelVendaCartao);
     int codCli = Integer.parseInt(tfUsuarioID.getText());      
     limparFormulario(); 
     }else if(resposta==JOptionPane.NO_OPTION){
     int codCli = Integer.parseInt(tfUsuarioID.getText());      
     limparFormulario();       
     }else if(resposta==JOptionPane.CLOSED_OPTION){
     int codCli = Integer.parseInt(tfUsuarioID.getText());      
     limparFormulario();    
     }
     
     }
        
      } catch (Exception e) {
        }
    }
  
  
  private void salvarVendaDinheiroParcela(){
    pagamento = "A prazo";
     try {       
     modelVenda = new ModelVenda();
     modelVendaProduto = new ModelVendaProduto();
     listaModelVendaProduto = new ArrayList<>();
     int percorrertabela, codigoVenda, codCliente;   
     modelVenda.setCliente(Integer.parseInt(tfIdCliente.getText()));      
   //modelVenda.setCliente(Integer.parseInt(tfUsuarioID.getText()));
     modelVenda.setData(tfData.getText());
     modelVenda.setIdVenda(Integer.parseInt(tfVenda.getText()));
     modelVenda.setHora(tfHora.getText());
     modelVenda.setAno(tfAno.getText()); 
     modelVenda.setData_relatorio(tfMes.getText()); 
     modelVenda.setPagamento((String) viewPagamentopParcelaPDV.jcbPagamento.getSelectedItem()); 
     modelVenda.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
     modelVenda.setValorBruto(Double.parseDouble(tfValorBruto.getText()));
     modelVenda.setValorDesconto(Double.parseDouble(String.valueOf(viewPagamentopParcelaPDV.getDesconto())));
     modelVenda.setValorLiquido(Double.parseDouble(String.valueOf(viewPagamentopParcelaPDV.getValorTotal())));
     codigoVenda = controller.salvarvendaController(modelVenda);
     if(codigoVenda>0){
     }
        
     percorrertabela = tabela.getRowCount();
     
     for (int i = 0; i < percorrertabela; i++) {
     codigoProduto=(int) tabela.getValueAt(i, 1);
            
     modelVendaProduto = new ModelVendaProduto();
     modelProduto = new ModelProduto();
     modelVendaProduto.setProduto(codigoProduto);
     modelVendaProduto.setVenda(Integer.parseInt(tfVenda.getText()));
     modelVendaProduto.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
     modelVendaProduto.setValorVenda(Double.parseDouble(String.valueOf(tabela.getValueAt(i, 4))));
     modelVendaProduto.setQuantidade(Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));
     modelVendaProduto.setNome_produto(String.valueOf(tabela.getValueAt(i, 2)));
     modelVendaProduto.setAno(tfAno.getText()); 
     modelVendaProduto.setMesAno(tfMes.getText()); 
     //baixa no estoque 
     modelProduto.setId(codigoProduto);
     modelProduto.setEstoque(controllerProduto.retornarController(codigoProduto).getEstoque()
     -Integer.parseInt(String.valueOf(tabela.getValueAt(i, 1))));
       
     listaModelVendaProduto.add(modelVendaProduto); 
     listaModelProduto.add(modelProduto);     
        }         
     if(controllerVendaProduto.salvarVendaProdutoController(listaModelVendaProduto)){
     //alterando estoque estiva (produto)  
     controllerProduto.alterarEstoqueController(listaModelProduto);
     JOptionPane.showMessageDialog(null, "Venda a prazo finalizada!"); 
     geraId();
     /*
     Limpando Class daoVendas2
     */
     DaoVenda2 daoVendas2 = new DaoVenda2();
     daoVendas2 = new DaoVenda2();
     daoVendas2.numeros();
     /*
     Limpando Class daoVendas2
     */
     int codCli = Integer.parseInt(tfUsuarioID.getText());
     JOptionPane.showMessageDialog(null, "Cupom para o operador");
     imprimirCupomParcelamento(listaModelVendaProduto, modelVenda);
     JOptionPane.showMessageDialog(null, "Cupom para o cliente");
     imprimirCupomParcelamento(listaModelVendaProduto, modelVenda);
     limparFormulario();
     /*
     if(viewPagamentopParcelaPDV.jcbPagamento.getSelectedItem().equals("A prazo")){      
    
     ViewParcelamento p = new ViewParcelamento(Integer.parseInt(tfVenda.getText()), codCli, tfUsuarioID.getText(), tfCpfCliente.getText());     
     p.setVisible(true); 
     p.setLocationRelativeTo(null);     
     dispose();          
     }     
     */
     }else{
     JOptionPane.showMessageDialog(null, "erro");
     }
    
     } catch (Exception e) {
     } 
     } 
  
     private void salvarVendaDinheiroParcelaNoServidor(){
     ModelVenda2 modelVenda = new ModelVenda2();
     Controllervenda2 controller = new Controllervenda2();
     ArrayList<ModelVenda2> listaModelVenda = new ArrayList<>();    
     ModelVendaProduto2 modelVendaProduto = new ModelVendaProduto2();
     ControllerVendaProduto2 controllerVendaProduto = new ControllerVendaProduto2();
     ArrayList<ModelVendaProduto2> listaModelVendaProduto = new ArrayList<>();
     pagamento = "A prazo";
     try {       
     modelVenda = new ModelVenda2();
     modelVendaProduto = new ModelVendaProduto2();
     listaModelVendaProduto = new ArrayList<>();
     int percorrertabela, codigoVenda, codCliente;   
     modelVenda.setCliente(Integer.parseInt(tfIdCliente.getText()));      
   //modelVenda.setCliente(Integer.parseInt(tfUsuarioID.getText()));
     modelVenda.setData(tfData.getText());
     modelVenda.setTurno(Integer.parseInt(tfTurno.getText()));
     modelVenda.setIdVenda(Integer.parseInt(tfVenda.getText()));
     modelVenda.setHora(tfHora.getText());
     modelVenda.setdataAnual(tfAno.getText()); 
     modelVenda.setData_relatorio(tfMes.getText()); 
     modelVenda.setPagamento((String) viewPagamentopParcelaPDV.jcbPagamento.getSelectedItem()); 
     modelVenda.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
     modelVenda.setValorBruto(Double.parseDouble(tfValorBruto.getText()));
     modelVenda.setValorDesconto(Double.parseDouble(String.valueOf(viewPagamentopParcelaPDV.getDesconto())));
     modelVenda.setValorLiquido(Double.parseDouble(String.valueOf(viewPagamentopParcelaPDV.getValorTotal())));
     codigoVenda = controller.salvarvendaController(modelVenda);
     if(codigoVenda>0){
     }     
     percorrertabela = tabela.getRowCount();   
     for (int i = 0; i < percorrertabela; i++) {
     codigoProduto=(int) tabela.getValueAt(i, 1);          
     modelVendaProduto = new ModelVendaProduto2();
     modelProduto = new ModelProduto();
     modelVendaProduto.setProduto(codigoProduto);
     modelVendaProduto.setVenda(Integer.parseInt(tfVenda.getText()));
     modelVendaProduto.setUsuario(Integer.parseInt(tfUsuarioID.getText()));
     modelVendaProduto.setValorVenda(Double.parseDouble(String.valueOf(tabela.getValueAt(i, 4))));
     modelVendaProduto.setQuantidade(Integer.parseInt(String.valueOf(tabela.getValueAt(i, 3))));
     modelVendaProduto.setNom_produto(String.valueOf(tabela.getValueAt(i, 2)));
     modelVendaProduto.setAno(tfAno.getText()); 
     modelVendaProduto.setMesAno(tfMes.getText()); 
     //baixa no estoque 
     modelProduto.setId(codigoProduto);
     modelProduto.setEstoque(controllerProduto.retornarController(codigoProduto).getEstoque()
     -Integer.parseInt(String.valueOf(tabela.getValueAt(i, 1))));     
     listaModelVendaProduto.add(modelVendaProduto);
     listaModelProduto.add(modelProduto);     
     }           
     controllerVendaProduto.salvarVendaProdutoController(listaModelVendaProduto);  
     } catch (Exception e) {
     } 
     } 
  
  private void imprimirCupom(ArrayList<ModelVendaProduto> listaModelVendaProduto, ModelVenda modelVenda){
        String conteudoImprimir = "";
        for (int x = 0; x < listaModelVendaProduto.size(); x++) {
          conteudoImprimir  += listaModelVendaProduto.get(x).getProduto()  + "    "+
          listaModelVendaProduto.get(x).getQuantidade() +"   "+
          listaModelVendaProduto.get(x).getValorVenda() +"    "+
          listaModelVendaProduto.get(x).getNome_produto() +"\n\r";
   
        }  
        this.imprimir("     \n\r" 
        + "==========================================\n\r"    
        + "          SUPERMERCADO 24 HORAS           \n\r"    
        + "         CNPJ: 05.327.493/0001-04         \n\r" 
        + "==========================================\n\r"
        + "             CUPOM NAO FISCAL             \n\r"
        + "------------------------------------------\n\r"  
        + "COD  QT  PRECO  DESCRICAO                 \n\r"
        + conteudoImprimir + ""
        + "------------------------------------------\n\r"
        + "Valor Bruto: "+ modelVenda.getValorBruto()+"\n\r"       
        + "Desconto: "+ modelVenda.getValorDesconto()+"\n\r"
        + "Valor Total: "+ modelVenda.getValorLiquido()+"\n\r"  
        + "******************************************\n\r"        
        + "Valor Pago: "+ Double.parseDouble(String.valueOf(viewPagamentoPDV.getValorRecebido()))+"\n\r" 
        + "Troco: "+ Double.parseDouble(String.valueOf(viewPagamentoPDV.getTroco()))+"\n\r"
        + "******************************************\n\r"
        + "Forma do Pagamento: "+pagamento+"\n\r"      
        + "Vendedor: "+tfusuarionome.getText()+"\n\r"
        + ""+tfData.getText()+" - "+tfHora.getText()+"\n\r"
        + "------------------------------------------\n\r"
        +"\n\r \n\r \f" 
        + " OBRIGADO PELA PREFERENCIA VOLTE SEMPRE! \n\r"
        + "            JESUS ESTA VOLTANDO!         \n\r"
        +"\n\r \n\r \f"
        +"\n\r \n\r \f"
        +"\n\r \n\r \f"
        + "");
         
      }
     
     
     private void imprimirCupomParcelamento(ArrayList<ModelVendaProduto> listaModelVendaProduto, ModelVenda modelVenda){
        String conteudoImprimir = "";
        for (int x = 0; x < listaModelVendaProduto.size(); x++) {
          conteudoImprimir  += listaModelVendaProduto.get(x).getProduto()  + "    "+
          listaModelVendaProduto.get(x).getQuantidade() +"   "+
          listaModelVendaProduto.get(x).getValorVenda() +"    "+
          listaModelVendaProduto.get(x).getNome_produto() +"\n\r";
   
        }
        String Parcelada="A Prazo";
        this.imprimir("     \n\r" 
        + "==========================================\n\r"    
        + "          SUPERMERCADO 24 HORAS           \n\r"    
        + "         CNPJ: 05.327.493/0001-04         \n\r"   
        + "==========================================\n\r"
        + "             CUPOM NAO FISCAL             \n\r"
        + "------------------------------------------\n\r"  
        + "COD  QT  PRECO  DESCRICAO                 \n\r"
        + conteudoImprimir + ""
        + "------------------------------------------\n\r"
        + "Valor Bruto: "+ modelVenda.getValorBruto()+"\n\r" 
         
        + "Desconto: "+ modelVenda.getValorDesconto()+"\n\r"
        + "Valor Total: "+ modelVenda.getValorLiquido()+"\n\r"
        + "------------------------------------------\n\r"
        + "Forma do Pagamento: "+Parcelada+""+"\n\r"       
        + "Vendedor: "+tfusuarionome.getText()+"\n\r"  
        + "Cliente: "+tfNomeCliente.getText()+"\n\r"
        + "CPF: "+tfCpfCliente.getText()+"\n\r" 
        + ""+tfData.getText()+" - "+tfHora.getText()+"\n\r" 
        + "------------------------------------------\n\r"
        +"\n\r \n\r \f" 
        + " OBRIGADO PELA PREFERENCIA VOLTE SEMPRE! \n\r"
        + "            JESUS ESTA VOLTANDO!         \n\r"
        +"\n\r \n\r \f" 
        +"\n\r \n\r \f"
        +"\n\r \n\r \f"
        + ""); 
           
      }
     
      
     private void imprimirCupomTickets(ArrayList<ModelVendaProdutoTickets> listaModelVendaProduto, ModelVendaTickets modelVenda){
        String conteudoImprimir = "";
        for (int x = 0; x < listaModelVendaProduto.size(); x++) {
          conteudoImprimir  += listaModelVendaProduto.get(x).getProduto()  + "    "+
          listaModelVendaProduto.get(x).getQuantidade() +"   "+
          listaModelVendaProduto.get(x).getValorVenda() +"    "+
          listaModelVendaProduto.get(x).getNome_produto() +"\n\r";
   
        }
        this.imprimir("     \n\r" 
        + "==========================================\n\r"    
        + "          SUPERMERCADO 24 HORAS           \n\r"    
        + "         CNPJ: 05.327.493/0001-04         \n\r" 
        + "==========================================\n\r"
        + "             CUPOM NAO FISCAL             \n\r"
        + "------------------------------------------\n\r"  
        + "COD  QT  PRECO  DESCRICAO                 \n\r"
        + conteudoImprimir + ""
        + "------------------------------------------\n\r"
        + "Valor Bruto: "+ modelVenda.getValorBruto()+"\n\r" 
        
        + "Desconto: "+ modelVenda.getValorDesconto()+"\n\r"
        + "Valor Total: "+ modelVenda.getValorLiquido()+"\n\r"
        + "------------------------------------------\n\r"
        + "Forma do Pagamento: "+pagamento+"\n\r"      
        + "Vendedor: "+tfUsuarioID.getText()+"\n\r"
        + ""+tfData.getText()+" - "+tfHora.getText()+"\n\r"
        + "------------------------------------------\n\r"
        +"\n\r \n\r \f" 
        + " OBRIGADO PELA PREFERENCIA VOLTE SEMPRE! \n\r"
        + "            JESUS ESTA VOLTANDO!         \n\r"
        +"\n\r \n\r \f"
        +"\n\r \n\r \f"
        +"\n\r \n\r \f"
        + "");
        
      }
     
       private void imprimirCupomCartao(ArrayList<ModelVendaProdutoCartao> listaModelVendaProduto, ModelVendaCartao modelVenda){
        String conteudoImprimir = "";
        for (int x = 0; x < listaModelVendaProduto.size(); x++) {
          conteudoImprimir  += listaModelVendaProduto.get(x).getProduto()  + "    "+
          listaModelVendaProduto.get(x).getQuantidade() +"   "+
          listaModelVendaProduto.get(x).getValorVenda() +"    "+
          listaModelVendaProduto.get(x).getNome_produto() +"\n\r";
   
        }  
        this.imprimir("     \n\r" 
        + "==========================================\n\r"    
        + "          SUPERMERCADO 24 HORAS           \n\r"    
        + "         CNPJ: 05.327.493/0001-04         \n\r" 
        + "==========================================\n\r"
        + "             CUPOM NAO FISCAL             \n\r"
        + "------------------------------------------\n\r"  
        + "COD  QT  PRECO  DESCRICAO                 \n\r"
        + conteudoImprimir + ""
        + "------------------------------------------\n\r"
        + "Valor Bruto: "+ modelVenda.getValorBruto()+"\n\r" 
        
        + "Desconto: "+ modelVenda.getValorDesconto()+"\n\r"
        + "Valor Total: "+ modelVenda.getValorLiquido()+"\n\r"
        + "------------------------------------------\n\r"
        + "Forma do Pagamento: "+pagamento+"\n\r"      
        + "Vendedor: "+tfUsuarioID.getText()+"\n\r"
        + ""+tfData.getText()+" - "+tfHora.getText()+"\n\r"
        + "------------------------------------------\n\r"
        +"\n\r \n\r \f" 
        + " OBRIGADO PELA PREFERENCIA VOLTE SEMPRE! \n\r"
        + "            JESUS ESTA VOLTANDO!         \n\r"
        +"\n\r \n\r \f"
        +"\n\r \n\r \f"
        +"\n\r \n\r \f"
        + "");
        
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
      private void geraId(){
        ModelId modelId = new ModelId(); 
        ControllerId controllerId = new ControllerId();
        modelId = new ModelId();
        modelId.setNumero(0);
        if(controllerId.salvarController(modelId)>0){
             
        }
           
        
    }
    public void produtosKL(){     
    try {        
    int codProduto = 7;
    Double valorProduto = Double.parseDouble(formatador.converterPontos(JOptionPane.showInputDialog("Informe o valor desse produto produto")));  
    formatador.arredondamentoValoresDouble(valorProduto);
   //String valorProduto = JOptionPane.showInputDialog(this, "Informe o valor desse produto produto", "CONFIRME", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
    int c = JOptionPane.showConfirmDialog(this, "Está certo?", "CONFIRME", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
    if(c == JOptionPane.NO_OPTION){
    JOptionPane.showMessageDialog(null, "Operação cancelada!");   
    }else if(c == JOptionPane.YES_OPTION){  
    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel(); 
    modelProduto = controllerProduto.retornarController(codProduto);
    codigoProduto = codProduto;
    modelo.addRow(new Object []{
    modelo.getRowCount()+1,     
    codigoProduto,
    modelProduto.getNome(),  
    quantidade,
    formatador.arredondamentoValoresDouble(valorProduto),
    formatador.arredondamentoValoresDouble(valorProduto * quantidade)
    });  
    tfNomeProduto.setText(" "+quantidade+"x  "+modelProduto.getNome()+" = "+formatador.arredondamentoValoresDouble(valorProduto * quantidade)+"");      
    quantidade = 1;
    tfValorBruto.setText(formatador.converterPontos(df.format(somarValor()))+"");          
    }     
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Você só pode inserir número!"); 
    }
    }
    }      
