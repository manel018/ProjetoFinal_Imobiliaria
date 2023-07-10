package servicos.manipulacaoarquivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Scanner;
import servicos.Apartamento;
import servicos.Casa;
import servicos.Imovel;

/**
 * Classe que cuida da manipulação do arquivo texto dos imóveis
 *
 * @author lucas
 */
public class ManipulaArquivo {

    public String arquivo;
    public Formatter gravador;
    public Scanner leitor;

    /**
     * Construtor padrão da classe {@code ManipulaArquivo}.
     * 
     * @param arquivo caminho relativo do arquivo.
     */
    public ManipulaArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    /**
     * Grava uma lista de imoveis em um arquivo texto.
     * 
     * @param imoveis ArrayList com os imóveis a serem gravados
     * @return  {@code true} se a gravação for bem sucedida. {@code false}, caso contrário
     */
    public boolean gravarImoveis(ArrayList<Imovel> imoveis) {
        //Percorre todo o ArrayList
        for (Imovel temp_imovel : imoveis) {
            try {
                if (temp_imovel instanceof Casa) {
                    String flag_casa = "Casa";
                    //Grava os atributos de um objeto Casa
                    this.gravador.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n", flag_casa, temp_imovel.getNumeroDoAnuncio(), temp_imovel.getDescricao(), temp_imovel.getValor(), temp_imovel.getCidade(), temp_imovel.getEstado(), temp_imovel.getVagasGaragem(), temp_imovel.getArea(), ((Casa) temp_imovel).getDescricaoQuintal(), ((Casa) temp_imovel).getNomeDoCondominio());
                } else if (temp_imovel instanceof Apartamento) {
                    String flag_apartamento = "Apartamento";
                    //Grava os atributos de um objeto Apartamento
                    this.gravador.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n", flag_apartamento, temp_imovel.getNumeroDoAnuncio(), temp_imovel.getDescricao(), temp_imovel.getValor(), temp_imovel.getCidade(), temp_imovel.getEstado(), temp_imovel.getVagasGaragem(), temp_imovel.getArea(), ((Apartamento) temp_imovel).getAndar(), ((Apartamento) temp_imovel).isPossuiElevador());
                }
            } catch (FormatterClosedException formatterClosedException) {
                return false;

            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo capaz de abrir o arquivo para gravação.
     */
    public void abrirArquivoParaGravacao() {

        try {
            this.gravador = new Formatter(arquivo);
        } catch (SecurityException securityException) {
            System.out.println("Sem permissão para gravar");
            System.exit(0);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Arquivo não encontrado");
            System.exit(0);
        }
    }

    /**
     * Método responsável por fechar o arquivo (gravacão) caso esteja aberto.
     */
    public void fechaArquivoGravacao() {
        if (this.gravador != null) {
            this.gravador.close();
        }

    }

    /**
     * Método responsável por abrir o arquivo para leitura.
     */
    public void abrirArquivoParaLeitura() {
        try {
            this.leitor = new Scanner(Paths.get(arquivo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método responsável por fechar o arquivo caso esteja aberto para leitura.
     */
    public void fecharArquivoLeitura() {
        if (this.leitor != null) {
            this.leitor.close();
        }
    }

    /**
     * Lê o arquivo texto que contém todos os imóveis cadastrados no arquivo texto.
     * @return Lista de imóveis do tipo com todos os imóveis lidos do arquivo
     */
    public ArrayList<Imovel> lerArquivo() {
        ArrayList<Imovel> retorno = new ArrayList<>();

        //Variáveis locais para receberem os dados de um imóvel à cada iteração
        String[] dados;
        String descricao;
        String cidade;
        String estado;
        int numeroDoAnuncio;
        int vagasGaragem;
        double valor;
        double area;

        while (leitor.hasNext()) {
            String linha = leitor.nextLine();   //Obtém todo o arquivo em uma String

            //Divide cada linha da String em um vetor e copia os dados para variáveis locais
            dados = linha.split("\t"); 
            numeroDoAnuncio = Integer.parseInt(dados[1]);
            descricao = dados[2];
            valor = Double.parseDouble(dados[3]);
            cidade = dados[4];
            estado = dados[5];
            vagasGaragem = Integer.parseInt(dados[6]);
            area = Double.parseDouble(dados[7]);

            //Se o imóvel for uma instância de Casa, acrescenta-se os atributos descrição do quintal e nome do condomínio
            if (dados[0].equalsIgnoreCase("Casa")) {
                //String descricaoQuintal, String nomeDoCondominio, int numeroDoAnuncio, String descricao, double valor, String cidade, String estado, int vagasGaragem, double area
                String descricaoQuintal = dados[8];
                String nomeDoCondominio = dados[9];
                Casa temp_casa;
                temp_casa = new Casa(descricaoQuintal, nomeDoCondominio, numeroDoAnuncio, descricao, valor, cidade, estado, vagasGaragem, area);
                retorno.add(temp_casa);
            //Se o imóvel for uma instância de Apartamento, acrescenta-se a informação de andar e a existência de elevador
            } else if (dados[0].equalsIgnoreCase("Apartamento")) {
                int andar = Integer.parseInt(dados[8]);
                boolean possuiElevador = Boolean.parseBoolean(dados[9]);
                Apartamento temp_apartamento = new Apartamento(andar, possuiElevador, numeroDoAnuncio, descricao, valor, cidade, estado, vagasGaragem, area);
                retorno.add(temp_apartamento);
            }
        }
        return retorno;
    }

}
