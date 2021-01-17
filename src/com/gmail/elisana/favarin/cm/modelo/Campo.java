package com.gmail.elisana.favarin.cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	
	private final int linha;
	private final int coluna;
	
	private boolean aberto;
	private boolean minado;
	private boolean marcado;
	
	
	//Autorelacionamento: ter um campo do tipo da pr�pria classe
	//atributo � private para que nenhuma outra classe altere os vizinhos do campo
	private List<Campo> vizinhos = new ArrayList<Campo>();
	
	//o n�vel de visibilidade do construtor do campo � pacote
	Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;		
	}
	
	boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int deltaLinha = Math.abs(linha - vizinho.linha); //diferen�a da linha
		int deltaColuna = Math.abs(coluna - vizinho.coluna); //diferen�a entre as colunas
		int deltaGeral = deltaColuna + deltaLinha;
		
		if(deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		}else if(deltaGeral == 2 && diagonal){
			vizinhos.add(vizinho);
			return true;
		}else {
			return false;
		}
		
	}

}
