package com.joaopedroluz57.cenario02;

import com.joaopedroluz57.cenario02.modelo.navio.Navio;
import com.joaopedroluz57.cenario02.modelo.pacote.Pacote;
import com.joaopedroluz57.cenario02.borda.impl.GeradorImpl;
import com.joaopedroluz57.cenario02.borda.impl.PesquisadorPacote;
import com.joaopedroluz57.cenario02.nuvem.impl.RelatorioImpl;

import java.util.ArrayList;
import java.util.List;

public class App {


    private static final Integer QUANTIDADE_DE_NAVIOS = 10;
    private static final Integer QUANTIDADE_DE_PACOTES_ESPECIAIS = 15;

    private static final List<PesquisadorPacote> pesquisadoresPacote = new ArrayList<>();
    private static final List<Thread> executores = new ArrayList<>();

    /*
     * Inicia o processamento de pesquisa dos pacotes especiais
     * <p>
     * A complexidade eh O(N^4), pois existem 4 loops aninhados. Os demais estão no PesquisadorPacote
     *
     */
    public static void iniciarProcessamentoDePesquisa(List<Navio> navios, List<Pacote> pacotesEspeciais) {
        for (Navio navio : navios) {
            PesquisadorPacote pesquisador = new PesquisadorPacote(navio, pacotesEspeciais);
            Thread thread = new Thread(pesquisador);
            pesquisadoresPacote.add(pesquisador);
            executores.add(thread);
            thread.start();
        }
    }

    /*
     * Espera a finalização dos executores
     * <p>
     * a complexidade e linear ja que nao possui loops alinhados.
     *
     */
    public static void esperarFinalizacaoDosExecutores() throws InterruptedException {
        for (Thread executor : executores) {
            executor.join();
        }
    }

    /*
     * Metodo principal
     * <p>
     * a complexidade e linear ja que nao possui loops alinhados.
     *
     */
    public static void main(String[] args) throws InterruptedException {
        GeradorImpl gerador = new GeradorImpl();
        RelatorioImpl relatorio = new RelatorioImpl();

        List<Navio> naviosMonitorados = gerador.gerarNavio(QUANTIDADE_DE_NAVIOS);
        List<Pacote> pacotesEspeciais = gerador.gerarPacotesEspeciais(QUANTIDADE_DE_PACOTES_ESPECIAIS, naviosMonitorados);

        System.out.println("##### Iniciando pesquisadores de pacotes #####");
        iniciarProcessamentoDePesquisa(naviosMonitorados, pacotesEspeciais);
        esperarFinalizacaoDosExecutores();

        System.out.println("\n### Pacotes especiais encontrados ###");

        List<Pacote> pacotesEspeciaisEncontrados = new ArrayList<>();
        for (PesquisadorPacote pesquisadorPacote : pesquisadoresPacote) {
            pacotesEspeciaisEncontrados.addAll(pesquisadorPacote.getPacotesEspeciaisEncontrados());
        }
        relatorio.gerarRelatorio(pacotesEspeciaisEncontrados);

        System.out.println("### Simulação finalizada ###");

    }

}
