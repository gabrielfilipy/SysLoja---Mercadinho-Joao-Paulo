package Model;
/**
* 
* @author monet
*/
public class ModelVendaProdutoTickets2 {

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * @return the nome_produto
     */
    public String getNome_produto() {
        return nome_produto;
    }

    /**
     * @param nome_produto the nome_produto to set
     */
    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }
 
    private int idVendaDinheiroPro;
    private int produto;
    private int venda;
    private Double valorVenda;
    private int quantidade;
    private int usuario; 
    private String nome_produto;
    private String ano;
    private String mes;
    /**
    * Construtor
    */
    public ModelVendaProdutoTickets2(){}

    /**
    * seta o valor de idVendaDinheiroPro
    * @param pIdVendaDinheiroPro
    */
    public void setIdVendaDinheiroPro(int pIdVendaDinheiroPro){
        this.idVendaDinheiroPro = pIdVendaDinheiroPro;
    }
    /**
    * return pk_idVendaDinheiroPro
    */
    public int getIdVendaDinheiroPro(){
        return this.idVendaDinheiroPro;
    }

    /**
    * seta o valor de produto
    * @param pProduto
    */
    public void setProduto(int pProduto){
        this.produto = pProduto;
    }
    /**
    * return fk_produto
    */
    public int getProduto(){
        return this.produto;
    }

    /**
    * seta o valor de venda
    * @param pVenda
    */
    public void setVenda(int pVenda){
        this.venda = pVenda;
    }
    /**
    * return fk_venda
    */
    public int getVenda(){
        return this.venda;
    }

    /**
    * seta o valor de valorVenda
    * @param pValorVenda
    */
    public void setValorVenda(Double pValorVenda){
        this.valorVenda = pValorVenda;
    }
    /**
    * return valorVenda
    */
    public Double getValorVenda(){
        return this.valorVenda;
    }

    /**
    * seta o valor de quantidade
    * @param pQuantidade
    */
    public void setQuantidade(int pQuantidade){
        this.quantidade = pQuantidade;
    }
    /**
    * return quantidade
    */
    public int getQuantidade(){
        return this.quantidade;
    }

    @Override
    public String toString(){
        return "ModelvendaDinheiroPro {" + "::idVendaDinheiroPro = " + this.idVendaDinheiroPro + "::produto = " + this.produto + "::venda = " + this.venda + "::valorVenda = " + this.valorVenda + "::quantidade = " + this.quantidade +  "}";
    }

    /**
     * @return the usuario
     */
    public int getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
}