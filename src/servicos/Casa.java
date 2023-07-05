package servicos;

/**
 * Classe que se refere a entidade casa possui como adicional uma descrição do quintal
 * @author lucas
 */
public class Casa extends Imovel{
    private String descricaoQuintal;
    private String nomeDoCondominio;

    public Casa(String descricaoQuintal, String nomeDoCondominio, int numeroDoAnuncio, String descricao, double valor, String cidade, String estado, int vagasGaragem, double area) {
        super(numeroDoAnuncio, descricao, valor, cidade, estado, vagasGaragem, area);
        this.descricaoQuintal = descricaoQuintal;
        this.nomeDoCondominio = nomeDoCondominio;
    }

    
    
    public String getNomeDoCondominio() {
        return nomeDoCondominio;
    }

    public void setNomeDoCondominio(String nomeDoCondominio) {
        this.nomeDoCondominio = nomeDoCondominio;
    }
    
    
    public String getDescricaoQuintal() {
        return descricaoQuintal;
    }

    public void setDescricaoQuintal(String descricaoQuintal) {
        this.descricaoQuintal = descricaoQuintal;
    }

    @Override
    public boolean cadastraImovel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
