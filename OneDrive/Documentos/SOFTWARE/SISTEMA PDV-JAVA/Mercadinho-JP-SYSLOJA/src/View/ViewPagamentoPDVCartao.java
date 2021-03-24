/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */  
package View;

import Controller.ControllerFormaPagamento;
import Controller.ControllerFormaPagamentoCartao;
import Model.ModelFormaPagamento;
import Model.ModelFormaPagamentoCartao;
import Util.Formatador;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**   
 *     
 * @author Monet 
 */     
public class ViewPagamentoPDVCartao extends javax.swing.JDialog {

    /**
     * @return the valorTotalDinheiro
     */
    public float getValorTotalDinheiro() {
        return valorTotalDinheiro;
    }

    /**
     * @param valorTotalDinheiro the valorTotalDinheiro to set
     */
    public void setValorTotalDinheiro(float valorTotalDinheiro) {
        this.valorTotalDinheiro = valorTotalDinheiro;
    }
    ModelFormaPagamentoCartao model = new ModelFormaPagamentoCartao();
    ControllerFormaPagamentoCartao controller = new ControllerFormaPagamentoCartao();
    ArrayList<ModelFormaPagamentoCartao>listaCartao= new ArrayList<>();
    
    private ViewPagamentoPDV viewPagamentoPDV; 
    Formatador formatador = new Formatador();
    /**
     * @return the pago
     */
    public boolean isPago() {
        return pago;
    }

    /**
     * @param pago the pago to set
     */
    public void setPago(boolean pago) {
        this.pago = pago;
    }

    
    public void textFieldeValorTotal() {
    this.tfSubTotal.setText(this.valorTotal+"");
    }
    
    /**
     * @return the valorTotal
     */
    public float getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the valorRecebido
     */
    public float getValorRecebido() {
        return valorRecebido;
    }

    /**
     * @param valorRecebido the valorRecebido to set
     */
    public void setValorRecebido(float valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    /**
     * @return the desconto
     */
    public float getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the troco
     */
    public float getTroco() {
        return troco;
    }

    /**
     * @param troco the troco to set
     */
    public void setTroco(float troco) {
        this.troco = troco;
    }

    /**
     * @return the formaPagamento
     */
    public String getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * @param formaPagamento the formaPagamento to set
     */
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    private float valorTotal;
    private float valorRecebido;
    private float desconto; 
    private float troco;   
    private String formaPagamento;
    private boolean pago;
    private float valorTotalDinheiro;
    /** 
     * Creates new form ViewPagamentoPDV
     */
    public ViewPagamentoPDVCartao(java.awt.Frame parent, boolean modal) {
         
        super(parent, modal);
        initComponents();
        setIcon();
        this.pago=false;
       
        
        listando();
        tfDesconto.setDocument(new Documento());
        tfRecebido.setDocument(new Documento());
        
        tfRecebido.requestFocus();
    }
    private void listando(){
    listaCartao = controller.listaModelController();
    jcbPagamento.removeAllItems();
        for (int i = 0; i < listaCartao.size(); i++) {
        jcbPagamento.addItem(listaCartao.get(i).getDescricao());
        }
    }
     private void calculandoPagamento(){ 
        float desconto, subTotal, recebido, pagar, troco, dinheiro, recebidoDinheiro, pagarDinheiro = 0;
        subTotal = Float.parseFloat(tfSubTotal.getText());
        if(!tfDesconto.getText().equals("")){
        desconto = Float.parseFloat(tfDesconto.getText());
        }else{
        desconto =0;   
        tfDesconto.setText("0.00");    
        } if(!tfRecebido.getText().equals("")){
        recebido = Float.parseFloat(tfRecebido.getText());
        }else{
        recebido = 0;    
        }      
        pagar=subTotal-desconto;      
        troco=recebido-pagar;     
        tfTroco.setText(formatador.arredondamentoValoresFloat(troco)+""); 
        tfRecebido.setText(formatador.arredondamentoValoresFloat(recebido)+""); 
        //se o cliente pagar junto com dinheiro
        
        dinheiro = subTotal - recebido; 
        tfDinheiro.setText(dinheiro+"");
        tfDinheiro.setText(formatador.arredondamentoValoresFloat(dinheiro)+"");
        tfValorTotal.setText(formatador.arredondamentoValoresFloat(pagar));   
        try {
        recebidoDinheiro = Float.parseFloat(tfRecebidoDinheiro.getText());      
        pagarDinheiro = recebidoDinheiro - dinheiro;
        tfTrocoDinheiro.setText(formatador.arredondamentoValoresFloat(pagarDinheiro)+""); 
        pagar = pagar - dinheiro;     
        } catch (Exception e) {
        }       
        System.out.println(pagarDinheiro);
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
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        tfValorTotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfSubTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcbPagamento = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tfDesconto = new javax.swing.JTextField();
        tfRecebido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfTroco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfDinheiro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfRecebidoDinheiro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfTrocoDinheiro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel2.setEnabled(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));
        jPanel5.setForeground(new java.awt.Color(0, 204, 204));

        tfValorTotal.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        tfValorTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfValorTotal.setText("0.00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(307, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("SubTotal:");

        tfSubTotal.setEditable(false);
        tfSubTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfSubTotalFocusLost(evt);
            }
        });
        tfSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSubTotalActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Pagamento:");

        jcbPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbPagamento.setEnabled(false);
        jcbPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPagamentoActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Desconto:");

        tfDesconto.setEditable(false);
        tfDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDescontoFocusLost(evt);
            }
        });
        tfDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDescontoActionPerformed(evt);
            }
        });

        tfRecebido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfRecebidoFocusLost(evt);
            }
        });
        tfRecebido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRecebidoActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Recebido:");

        tfTroco.setEditable(false);
        tfTroco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfTroco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfTrocoFocusLost(evt);
            }
        });
        tfTroco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTrocoActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Troco:");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/RETORNAR.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        tfDinheiro.setEditable(false);
        tfDinheiro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfDinheiro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDinheiroFocusLost(evt);
            }
        });
        tfDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDinheiroActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Para dinheiro:");

        tfRecebidoDinheiro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfRecebidoDinheiro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfRecebidoDinheiroFocusLost(evt);
            }
        });
        tfRecebidoDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRecebidoDinheiroActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Recebido:");

        tfTrocoDinheiro.setEditable(false);
        tfTrocoDinheiro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfTrocoDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTrocoDinheiroActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Troco:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(366, 366, 366))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTrocoDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfRecebidoDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfSubTotal)
                                .addComponent(jcbPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfDesconto)
                                .addComponent(tfRecebido)
                                .addComponent(tfTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(51, 51, 51)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRecebidoDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTrocoDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 870, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSubTotalActionPerformed
    tfDesconto.requestFocus();
    }//GEN-LAST:event_tfSubTotalActionPerformed

    private void jcbPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbPagamentoActionPerformed
 
    private void tfDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescontoFocusLost
    tfDesconto.setText(formatador.converterPontos(tfDesconto.getText()));
   
    calculandoPagamento(); 
    
    }//GEN-LAST:event_tfDescontoFocusLost

    private void tfRecebidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfRecebidoFocusLost
    tfRecebido.setText(formatador.converterPontos(tfRecebido.getText()));
    calculandoPagamento(); 
    }//GEN-LAST:event_tfRecebidoFocusLost

    private void tfDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescontoActionPerformed
    tfRecebido.requestFocus();    
    calculandoPagamento();
    }//GEN-LAST:event_tfDescontoActionPerformed

    private void tfRecebidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRecebidoActionPerformed
    tfRecebidoDinheiro.requestFocus();  
    }//GEN-LAST:event_tfRecebidoActionPerformed
   
    private void tfTrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTrocoActionPerformed
    tfDinheiro.requestFocus();    
    }//GEN-LAST:event_tfTrocoActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
    dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void tfSubTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSubTotalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSubTotalFocusLost

    private void tfDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDinheiroActionPerformed
    tfRecebidoDinheiro.requestFocus();
    }//GEN-LAST:event_tfDinheiroActionPerformed

    private void tfRecebidoDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRecebidoDinheiroActionPerformed
    tfTrocoDinheiro.requestFocus();
    }//GEN-LAST:event_tfRecebidoDinheiroActionPerformed

    private void tfTrocoDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTrocoDinheiroActionPerformed
     if(tfRecebido.getText().equals("") || tfRecebidoDinheiro.getText().equals("")){
     JOptionPane.showMessageDialog(null, "Informe o valor que o cliente passou no\n"
                                        + "cartão de crédito e no dinheiro!");
     }else{     
     JOptionPane.showMessageDialog(null, "O cliente passou o valor de: R$"+tfRecebido.getText()+"\n"
                                        + "no cartão de crédito \n"
                                        + "e o valor de: R$"+tfRecebidoDinheiro.getText()+" \n"
                                        + "em dinheiro \n"
                                        + "Seu troco é de: R$"+tfTrocoDinheiro.getText()+"");
     this.desconto=Float.parseFloat(tfDesconto.getText());
     this.valorRecebido=Float.parseFloat(tfRecebido.getText());
     this.troco=Float.parseFloat(tfTroco.getText());
     this.valorTotal=Float.parseFloat(tfValorTotal.getText());
     this.valorTotalDinheiro=Float.parseFloat(tfDinheiro.getText()); 
     formaPagamento= jcbPagamento.getSelectedItem().toString();
     this.pago=true;
     dispose();
 }
    }//GEN-LAST:event_tfTrocoDinheiroActionPerformed

    private void tfTrocoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTrocoFocusLost
    tfDinheiro.requestFocus();
    calculandoPagamento();
    }//GEN-LAST:event_tfTrocoFocusLost

    private void tfRecebidoDinheiroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfRecebidoDinheiroFocusLost
    tfTrocoDinheiro.requestFocus();
  //tfRecebidoDinheiro.setText(formatador.arredondamentoValoresFloat(Float.parseFloat(tfTrocoDinheiro.getText())));
  //calculandoPagamento();
    tfRecebidoDinheiro.setText(String.valueOf(formatador.converterPontos(tfRecebidoDinheiro.getText())));  
    float recebido = Float.parseFloat(formatador.arredondamentoValoresFloat(Float.parseFloat(tfRecebidoDinheiro.getText())));
    tfRecebidoDinheiro.setText(formatador.arredondamentoValoresFloat(recebido));
    calculandoPagamento();
    }//GEN-LAST:event_tfRecebidoDinheiroFocusLost

    private void tfDinheiroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDinheiroFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDinheiroFocusLost

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
            java.util.logging.Logger.getLogger(ViewPagamentoPDVCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPagamentoPDVCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPagamentoPDVCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPagamentoPDVCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewPagamentoPDVCartao dialog = new ViewPagamentoPDVCartao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public static javax.swing.JComboBox<String> jcbPagamento;
    private javax.swing.JTextField tfDesconto;
    public static javax.swing.JTextField tfDinheiro;
    public static javax.swing.JTextField tfRecebido;
    private javax.swing.JTextField tfRecebidoDinheiro;
    private javax.swing.JTextField tfSubTotal;
    private javax.swing.JTextField tfTroco;
    private javax.swing.JTextField tfTrocoDinheiro;
    public static javax.swing.JLabel tfValorTotal;
    // End of variables declaration//GEN-END:variables

class Documento extends PlainDocument{ 
     
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        try {
            
        
        int tam = (this.getLength() + str.length());
     if(tam <=6){ 
     super.insertString(offs, str.replaceAll("[aA-zZç]", ""), a);     
     }else{
     super.insertString(offs, str.replaceAll("{aA0-zZ9}", ""), a);
     }
       } catch (Exception e) {
           
        } 
    }




}
private void setIcon() {
setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagem/comp.png"))); 
    }
}
