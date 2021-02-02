package com.gmail.elisana.favarin.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import com.gmail.elisana.favarin.cm.excecao.ExplosaoException;

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
	
	void alternarMarcacao() {		
		//s� marca os campos que ainda n�o foram abertos
		if(!aberto) {
			marcado = !marcado;
		}
	}
	
	boolean abrir() {
		//abre o campo se ele estiver fechado e n�o estiver aberto
		if(!aberto && !marcado) {
			aberto = true;
			
			//se o campo est� minado, acaba o jogo
			if(minado) {
				//Vai interromper o processo e voltar para quem chamou
				throw new ExplosaoException();
			}
			
			//se os vizinhos s�o seguros, faz uma chamada recursiva para abrir os vizinhos dos vizinhos
			if(vizinhancaSegura()) {
				//passa uma consumer como parametro
			   vizinhos.forEach(v -> v.abrir());	
			}
			return true;
		} else {
			return false;
		}
	}
	
	boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}
	
	void minar() {		
		minado = true;
	}
	
	public boolean isMarcado() {
		return marcado;
	}
	
	public boolean isAberto() {
		return aberto;
	}
	
	public boolean isFechado() {
		return !isAberto();
	}

}
