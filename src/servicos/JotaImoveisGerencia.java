package servicos;

import java.util.ArrayList;
import servicos.manipulacaoarquivos.ManipulaArquivo;

/**
 * Classe responsável por anunciar e comprar/alugar imóveis na plataforma JotaImoveis.
 * @author lucas
 */
public class JotaImoveisGerencia {
    
    private ArrayList<Imovel> imoveisCadastrados;
    private ArrayList<Imovel> imoveisSelecionados;
    private GeraCasas gerador = new GeraCasas();
    private ManipulaArquivo manArquivosImoveis;
    private boolean alugar = false;
    
    private void geraArquivoDosImoveis(){
      
        manArquivosImoveis.abrirArquivoParaGravacao();
        manArquivosImoveis.gravarImovel(gerador.geraArquivo());
        manArquivosImoveis.fechaArquivoGravacao();
    }
    private void leArquivosDosImoveis(){
        manArquivosImoveis.abrirArquivoParaLeitura();
        imoveisCadastrados = new ArrayList<>(manArquivosImoveis.lerArquivo());
  
        manArquivosImoveis.fecharArquivoLeitura();
    }
    public void obtemImoveisSelecionados(boolean alugar, String casa_ou_apartamento, String estado, String cidade){
        //Apartamento
        //Estado
        //Cidade

    }
    public JotaImoveisGerencia() {
        manArquivosImoveis = new ManipulaArquivo("ListaDeImoveis");
        geraArquivoDosImoveis();
        leArquivosDosImoveis();
    }
    

    public ArrayList<Imovel> getImoveisCadastrados() {
        return imoveisCadastrados;
    }

    public void setImoveisCadastrados(ArrayList<Imovel> imoveisCadastrados) {
        this.imoveisCadastrados = imoveisCadastrados;
    }

    public ArrayList<Imovel> getImoveisSelecionados() {
        return imoveisSelecionados;
    }

    public void setImoveisSelecionados(ArrayList<Imovel> imoveisSelecionados) {
        this.imoveisSelecionados = imoveisSelecionados;
    }
    
    
    
}