package servicos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import servicos.manipulacaoarquivos.ManipulaArquivo;

/**
 * Classe responsável por anunciar e comprar/alugar imóveis na plataforma JotaImoveis.
 * @author Lucas Henrique
 */
public class JotaImoveisGerencia {
    
    private ArrayList<Imovel> imoveisCadastrados;
    private ArrayList<Imovel> imoveisSelecionados;
    private GeraCasas gerador;
    private ManipulaArquivo manArquivosImoveis;
    
    /**
     * Construtor da classe gerenciadora de imóveis
     * <p>
     * Inicializa automaticamente suas variáveis, 
     * incluindo a lista {@code ArrayList<Imovel>} imoveisCadastrados
     */
    public JotaImoveisGerencia() {
        gerador = new GeraCasas();
        manArquivosImoveis = new ManipulaArquivo("ListaDeImoveis");
        geraArquivoDosImoveis();
        leArquivosDosImoveis();
    }

    //Getters
    public ArrayList<Imovel> getImoveisSelecionados() {
        return imoveisSelecionados;
    }
    public ArrayList<Imovel> getImoveisCadastrados() {
        return imoveisCadastrados;
    }
    //Setters
    public void setImoveisCadastrados(ArrayList<Imovel> imoveisCadastrados) {
        this.imoveisCadastrados = imoveisCadastrados;
    }
    public void setImoveisSelecionados(ArrayList<Imovel> imoveisSelecionados) {
        this.imoveisSelecionados = imoveisSelecionados;
    }

    
    /**
     * Grava um arquivo contendo as informações de um 
     * conjunto de imóveis aleatórios com características próprias.
     * O arquivo consite em um montante de 10 Casas e 10 Apartamentos
     * para cada uma das 10 cidades de um estado brasileiro.
     * <p>Nº total de imóveis: <b>10×10×27 = 2700<b/>
     * @author Lucas Henrique
     */
    private void geraArquivoDosImoveis(){
        manArquivosImoveis.abrirArquivoParaGravacao();
        manArquivosImoveis.gravarImoveis(gerador.geraImoveis());
        manArquivosImoveis.fechaArquivoGravacao();
    }

    /**
     * Lê um arquivo contendo as informações de cadastro dos imóveis do sistema e insta
     * conjunto de imóveis aleatórios com características próprias já instanciadas.
     * @author Lucas Henrique
     */
    private void leArquivosDosImoveis(){
        manArquivosImoveis.abrirArquivoParaLeitura();
        imoveisCadastrados = new ArrayList<>(manArquivosImoveis.lerArquivo());
        manArquivosImoveis.fecharArquivoLeitura();
    }

    /**
     * Filtra dentre toda a coleção {@code imoveisCadastrados} os imóveis que atendem aos
     * critérios passados como parâmetro e os adiciona no ArrayList {@code imoveisSelecionados}.
     * @param alugar   Flag que indica se os imóveis são para alugar ou não
     * @param casa_ou_apartamento  Tipo do imóveis
     * @param estado   Estado onde estão localizados os imóveis
     * @param cidade   Cidade em que se localizam os imóveis
     */
    public void obtemImoveisSelecionados(boolean alugar, String casa_ou_apartamento, String estado, String cidade) {
        imoveisSelecionados = new ArrayList<Imovel>();

        //Procura especificamente pelos imóveis do tipo Casa
        if (casa_ou_apartamento.equalsIgnoreCase("Casa")) {
            for (Imovel temp_imovel : this.imoveisCadastrados) {
                if (temp_imovel instanceof Casa && temp_imovel.getEstado().equalsIgnoreCase(estado) && temp_imovel.getCidade().equalsIgnoreCase(cidade)){
                    if(alugar)
                        //As parcelas do aluguel são 0,5% do valor da casa
                        temp_imovel.setValor(temp_imovel.getValor()*0.005);
                    //Inclui os imóveis da coleção que têm os estados e cidades iguais aos dos argumentos
                    this.imoveisSelecionados.add(temp_imovel);
                }
                if (this.imoveisSelecionados.size() == 10){
                    break;
                }    
            }
        }
        //Procura especificamente pelos imóveis do tipo Apartamento
        if (casa_ou_apartamento.equalsIgnoreCase("Apartamento")) {
            for (Imovel temp_imovel : this.imoveisCadastrados) {
                if (temp_imovel instanceof Apartamento && temp_imovel.getCidade().equalsIgnoreCase(cidade) && temp_imovel.getEstado().equalsIgnoreCase(estado)) {
                    if(alugar)
                        //As parcelas do aluguel são 0,5% do valor do apartamento
                        temp_imovel.setValor(temp_imovel.getValor()*0.005);
                    //Inclui os imóveis da coleção que têm os estados e cidades iguais aos dos argumentos
                    this.imoveisSelecionados.add(temp_imovel);
                }
                if (this.imoveisSelecionados.size() == 10) {
                    break;
                }
            }
        }
        gerarImagemImovel();    //Associa uma imagem aleatória à cada Imovel da coleção
    }

    

    
    
    /**
     * Atribui à um String  caminho da imagem associada a cada imóvel selecionado da Lista
     * 
     */
    public void gerarImagemImovel(){
        ArrayList<Integer> numerosSorteados = new ArrayList<Integer>();

        //Preenche o ArrayList com uma sequência de numeros de 1 a 30
        for (int i = 1; i<31; i++)
            numerosSorteados.add(i);

        //Embaralha a ordem dos elementos do Array de números
        Collections.shuffle(numerosSorteados);

        for (int i = 0; i<10; i++){
            //Concatena um número aleatório da ArrayList de numeros sorteados entre 1 a 30 a cada loop
            //com o caminho relativo da imagem
            if(this.imoveisSelecionados.get(i) instanceof Casa)
                this.imoveisSelecionados.get(i).setfonteImagem("/GUI/imagens/imoveis/residencia" + numerosSorteados.get(i) + ".jpg"); //se for do tipo Casa
            else
                this.imoveisSelecionados.get(i).setfonteImagem("/GUI/imagens/imoveis/apartamento" + numerosSorteados.get(i) + ".jpg"); //se for Apartamento
        }
    }
}
