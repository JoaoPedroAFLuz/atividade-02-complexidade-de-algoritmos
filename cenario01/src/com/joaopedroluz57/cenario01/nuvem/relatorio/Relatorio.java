package com.joaopedroluz57.cenario01.nuvem.relatorio;

import com.joaopedroluz57.cenario01.modelo.pacote.Pacote;

import java.util.List;

public interface Relatorio {

    void gerarRelatorio(List<Pacote> pacotesEspeciaisEncontrados);

}
