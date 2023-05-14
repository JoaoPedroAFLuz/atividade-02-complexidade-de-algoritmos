package com.joaopedroluz57.cenario01.borda.gerador;

import com.joaopedroluz57.cenario01.modelo.container.Container;
import com.joaopedroluz57.cenario01.modelo.navio.Navio;
import com.joaopedroluz57.cenario01.modelo.pacote.Pacote;

import java.util.List;

public interface Gerador {

    List<Pacote> gerarPacotes(Integer quantidade);

    List<Pacote> gerarPacotesEspeciais(Integer quantidade, List<Navio> navios);

    List<Container> gerarContainers(Integer quantidade);

    List<Navio> gerarNavio(Integer quantidade);

}
