package com.joaopedroluz57.cenario02.borda.gerador;

import com.joaopedroluz57.cenario02.modelo.container.Container;
import com.joaopedroluz57.cenario02.modelo.navio.Navio;
import com.joaopedroluz57.cenario02.modelo.pacote.Pacote;

import java.util.List;

public interface Gerador {

    List<Pacote> gerarPacotes(Integer quantidade);

    List<Pacote> gerarPacotesEspeciais(Integer quantidade, List<Navio> navios);

    List<Navio> gerarNavio(Integer quantidade);

    List<Container> gerarContainers(Integer quantidade);

}
