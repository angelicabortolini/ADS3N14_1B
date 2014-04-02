package br.com.angelica.jogobatalhanaval.controller;

import br.com.angelica.jogobatalhanaval.model.Pontuacao;
import br.com.angelica.jogobatalhanaval.model.Tabuleiro;
import br.com.angelica.jogobatalhanaval.view.Formulario;

public class ControllerPrincipal {
		
		private Formulario formulario;
		private Tabuleiro tabuleiro;
		private Pontuacao pontuacao;
		
		/**
		 * Construtor padrão da classe.
		 */
		public ControllerPrincipal() {
			
			formulario   = new Formulario();
			tabuleiro = new Tabuleiro();
			pontuacao    = new Pontuacao();

		}
		
		/**
		 * Metodos para iniciar o programa
		 */
		public void iniciar() {
		
			formulario.imprimir("Batalha Naval Java.\n");
			tabuleiro.iniciar();
			String opcao = "";
			
			do {
				
				tabuleiro.distribuirNavios();
				
				formulario.imprimir(tabuleiro.imprimir());
				formulario.imprimir("Placar: " + pontuacao.getPontuacao() + " pontos\n");
				formulario.imprimir("*** Menu ***\n");
				formulario.imprimir("1 - Reiniciar jogo.");
				formulario.imprimir("2 - Disparar torpedo.");
				formulario.imprimir("0 - Abandonar jogo.");
				opcao = formulario.cursor("Opção");
				
				switch (opcao) {
				
				case "1":
					
					tabuleiro.iniciar();
					pontuacao.setPontuacao(15);
					
					break;
				
				case "2":
					
					this.executarTurno();
					break;
					
				case "0":
					
					this.finalizar();
					break;
					
				default:
					
					formulario.imprimir("Escolha uma das opções do menu.");
					break;
					
				}
			
			} while(true);
			
		}

		/**
		 * Finaliza o jogo.
		 */
		private void finalizar() {
			
			formulario.imprimir("Fim do jogo.");
			System.exit(0);
			
		}
		
		private void executarTurno() {
			
			String coordenada  = "";
			String coordLinha  = "";
			String coordColuna = "";
			String alertaDisparo = "";
			
			boolean portaAviaoDestruido, detroyerDestruido, fragataDestruido, torpedeiroDestruido, submarinoDestruido;
			portaAviaoDestruido = detroyerDestruido = fragataDestruido = torpedeiroDestruido = submarinoDestruido = false;
			
			do {
				
				coordenada = formulario.cursor("Escolha a coordenada onde linha [0-9] e coluna [A-J]");
				
				if(coordenada.length() != 2) {
					continue;
				}
				
				coordLinha = String.valueOf(coordenada.charAt(0));			
				coordColuna = String.valueOf(coordenada.charAt(1)).toUpperCase();
				coordenada = coordLinha + coordColuna;
				
			} while(!coordLinha.equals("0") &&
					!coordLinha.equals("1") &&
					!coordLinha.equals("2") &&
					!coordLinha.equals("3") &&
					!coordLinha.equals("4") &&
					!coordLinha.equals("5") &&
					!coordLinha.equals("6") &&
					!coordLinha.equals("7") &&
					!coordLinha.equals("8") &&
					!coordLinha.equals("9") &&
					!coordColuna.equals("A") &&
					!coordColuna.equals("B") &&
					!coordColuna.equals("C") &&
					!coordColuna.equals("D") &&
					!coordColuna.equals("E") &&
					!coordColuna.equals("F") &&
					!coordColuna.equals("G") &&
					!coordColuna.equals("H") &&
					!coordColuna.equals("I") &&
					!coordColuna.equals("J"));
			
			tabuleiro.receberCoordenadaNavio(coordenada);

			// Porta-aviões foi atingido.
			if(tabuleiro.getPortaAviao().getParte1().equals("") ||
			   tabuleiro.getPortaAviao().getParte2().equals("") ||
			   tabuleiro.getPortaAviao().getParte3().equals("") ||
			   tabuleiro.getPortaAviao().getParte4().equals("") ||
			   tabuleiro.getPortaAviao().getParte5().equals("")) {
				
				pontuacao.setPontuacao(pontuacao.getPontuacao() + 3);
				alertaDisparo = "Porta aviões atingido";
				
			}
			
			// Destroyer foi atingido.
			if(tabuleiro.getDestroyer().getParte1().equals("") ||
			   tabuleiro.getDestroyer().getParte2().equals("") ||
			   tabuleiro.getDestroyer().getParte3().equals("") ||
			   tabuleiro.getDestroyer().getParte4().equals("")) {
				
				pontuacao.setPontuacao(pontuacao.getPontuacao() + 3);
				alertaDisparo = "Destroyer atingido";
				
			}
			
			// Fragata foi atingida.
			if(tabuleiro.getFragata().getParte1().equals("") ||
	     	   tabuleiro.getFragata().getParte2().equals("") ||
			   tabuleiro.getFragata().getParte3().equals("")) {
				
				pontuacao.setPontuacao(pontuacao.getPontuacao() + 3);
				alertaDisparo = "Fragata atingida";
				
			}
			
			// Torpedeiro foi atingido.
			if(tabuleiro.getTorpedeiro().getParte1().equals("") ||
			   tabuleiro.getTorpedeiro().getParte2().equals("")) {
				
				pontuacao.setPontuacao(pontuacao.getPontuacao() + 3);
				alertaDisparo = "Fragata atingida";
				
			}
			
			
			//Porta-Aviões foi destruido.
			if(tabuleiro.getPortaAviao().getParte1().equals("") &&
			   tabuleiro.getPortaAviao().getParte2().equals("") &&
			   tabuleiro.getPortaAviao().getParte3().equals("") &&
			   tabuleiro.getPortaAviao().getParte4().equals("") &&
			   tabuleiro.getPortaAviao().getParte5().equals("")) {
				
				pontuacao.setPontuacao(pontuacao.getPontuacao() + 5);
				portaAviaoDestruido = true;
				alertaDisparo = "Porta Aviões foi destruído";
				
			}
			
			//Destroyer foi destruido.
			if(tabuleiro.getDestroyer().getParte1().equals("") &&
			   tabuleiro.getDestroyer().getParte2().equals("") &&
			   tabuleiro.getDestroyer().getParte3().equals("") &&
			   tabuleiro.getDestroyer().getParte4().equals("")) {
				
				pontuacao.setPontuacao(pontuacao.getPontuacao() + 5);
				detroyerDestruido = true;
				alertaDisparo = "Destroyer foi destruído";
				
			}
			
			//Fragata foi destruida.
			if(tabuleiro.getFragata().getParte1().equals("") &&
			   tabuleiro.getFragata().getParte2().equals("") &&
			   tabuleiro.getFragata().getParte3().equals("")) {
				
				pontuacao.setPontuacao(pontuacao.getPontuacao() + 5);
				fragataDestruido = true;
				alertaDisparo = "Fragata foi destruída";
				
			}
			
			//Torpedeiro foi destruido.
			if(tabuleiro.getTorpedeiro().getParte1().equals("") &&
			   tabuleiro.getTorpedeiro().getParte2().equals("")) {
				
				pontuacao.setPontuacao(pontuacao.getPontuacao() + 5);
				torpedeiroDestruido = true;
				alertaDisparo = "Torpedeiro foi destruído";
				
			}
			
			
			//Submarino foi destruido.
			if(tabuleiro.getSubmarino().getParte1().equals("")) {
				
				pontuacao.setPontuacao(pontuacao.getPontuacao() + 5);
				submarinoDestruido = true;
				alertaDisparo = "Submarino foi destruído";
			}
			
			// Regra da pontuação
			pontuacao.setPontuacao(pontuacao.getPontuacao() - 1);
			
			formulario.imprimir("Torpedo disparado na coordenada " + coordenada + ": " + (alertaDisparo.equals("") ? "O torpedo caiu na água." : alertaDisparo)  + ".\n");

			if(portaAviaoDestruido && detroyerDestruido && fragataDestruido && torpedeiroDestruido && submarinoDestruido) {
				
				formulario.imprimir("Parabéns, você venceu o jogo!");
				this.finalizar();
			} else if(pontuacao.getPontuacao() == 0) {
				
				formulario.imprimir("Você perdeu o jogo, hahaha!");
				this.finalizar();
				
			}
			
			alertaDisparo = "";
			
		}

}

