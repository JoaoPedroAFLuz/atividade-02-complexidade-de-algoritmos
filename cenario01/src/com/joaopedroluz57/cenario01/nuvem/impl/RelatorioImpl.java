package com.joaopedroluz57.cenario01.nuvem.impl;

import com.joaopedroluz57.cenario01.modelo.pacote.Pacote;
import com.joaopedroluz57.cenario01.nuvem.relatorio.Relatorio;

import java.util.List;

public class RelatorioImpl implements Relatorio {

    /*
     * Geracao de relatorio
     * <p>
     * a complexidade e linear ja que nao possui loops alinhados.
     *
     */
    @Override
    public void gerarRelatorio(List<Pacote> pacotesEspeciaisEncontrados) {
        for (Pacote pacote : pacotesEspeciaisEncontrados) {
            System.out.println(pacote);
        }
    }

}
