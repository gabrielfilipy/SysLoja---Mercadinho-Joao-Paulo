package Model;
/**
*
* @author monet
*/
public class ModelVendaProduto2 {

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
     * @return the mesAno
     */
    public String getMesAno() {
        return mesAno;
    }

    /**
     * @param mesAno the mesAno to set
     */
    public void setMesAno(String mesAno) {
        this.mesAno = mesAno;
    }

  

    /**
     * @return the nom_produto
     */
    public String getNom_produto() {
        return nom_produto;
    } 

    /**
     * @param nom_produto the nom_produto to set
     */
    public void setNom_produto(String nom_produto) {
        this.nom_produto = nom_produto;
    }

    private int idVendaDinheiroPro;
    private int produto;
    private String nom_produto;
    private int venda;
    private Double valorVenda;
    private int quantidade;
    private int usuario;
    
    private String ano;
    private String mesAno; 
    /**
    * Construtor
    */
    public ModelVendaProduto2(){}

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