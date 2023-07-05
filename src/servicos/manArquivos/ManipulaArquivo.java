package servicos.manArquivos;

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
     * Construtor padrão da classe manipula arquivo.
     * Recebe o nome do arquivo para que possa efetuar as operações através de um caminho relativo.
     * @param arquivo
     */
    public ManipulaArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    /**
     * Grava uma lista de imoveis em um arquivo texto.
     * @param imoveis
     * @return
     */
    public boolean gravarImovel(ArrayList<Imovel> imoveis) {
        
        for (Imovel temp_imovel : imoveis) {
            try {
                if (temp_imovel instanceof Casa) {
                    String flag_casa = "Casa";
                    this.gravador.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n", flag_casa, temp_imovel.getNumeroDoAnuncio(), temp_imovel.getDescricao(), temp_imovel.getValor(), temp_imovel.getCidade(), temp_imovel.getEstado(), temp_imovel.getVagasGaragem(), temp_imovel.getArea(), ((Casa) temp_imovel).getDescricaoQuintal(), ((Casa) temp_imovel).getNomeDoCondominio());
                } else if (temp_imovel instanceof Apartamento) {
                    String flag_apartamento = "Apartamento";
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
     *Metodo capaz de abrir o arquivo para gravação.
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
     *Método responsável por fechar o arquivo (gravacão) caso esteja aberto.
     */
    public void fechaArquivoGravacao() {
        if (this.gravador != null) {
            this.gravador.close();
        }

    }

    /**
     *Método responsável por abrir o arquivo para leitura.
     */
    public void abrirArquivoParaLeitura() {
        try {
            this.leitor = new Scanner(Paths.get(arquivo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *Método responsável por fechar o arquivo caso esteja aberto para leitura.
     */
    public void fecharArquivoLeitura() {
        if (this.leitor != null) {
            this.leitor.close();
        }
    }

    /**
     *Lê um arquivo e retorna uma lista de imóveis contidos.
     * @return listaDeImoveis
     */
    public ArrayList<Imovel> lerArquivo() {
        /*Método responsável por ler os contatos no arquivo texto */
        ArrayList<Imovel> retorno = new ArrayList<>();
        while (leitor.hasNext()) {
            String linha = leitor.nextLine();
            String[] dados = linha.split("\t");
            int numeroDoAnuncio = Integer.parseInt(dados[1]);
            String descricao = dados[2];
            double valor = Double.parseDouble(dados[3]);
            String cidade = dados[4];
            String estado = dados[5];
            int vagasGaragem = Integer.parseInt(dados[6]);
            double area = Double.parseDouble(dados[7]);

            if (dados[0].equalsIgnoreCase("Casa")) {
                //String descricaoQuintal, String nomeDoCondominio, int numeroDoAnuncio, String descricao, double valor, String cidade, String estado, int vagasGaragem, double area
                String descricaoQuintal = dados[8];
                String nomeDoCondominio = dados[9];
                Casa temp_casa;
                temp_casa = new Casa(descricaoQuintal, nomeDoCondominio, numeroDoAnuncio, descricao, valor, cidade, estado, vagasGaragem, area);
                retorno.add(temp_casa);
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
