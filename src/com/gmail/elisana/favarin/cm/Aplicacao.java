package com.gmail.elisana.favarin.cm;

import com.gmail.elisana.favarin.cm.modelo.Tabuleiro;
import com.gmail.elisana.favarin.cm.visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		new TabuleiroConsole(tabuleiro);
		
	}
}
