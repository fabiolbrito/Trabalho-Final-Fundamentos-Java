/*
Autor: Fabio Lopes de Brito
RM: 30399
Trabalho Final 
Turma: 27SCJ
Fundamentos Da Tecnologia Java E Uml
Prof. Michel Pereira Fernandes
*/
package br.com.twitter.enu;

//Enumerado que possui as constantes utilizadas no menu principal
public enum Menu {

	MENU_OPCOES("Aplicação de Integração com o Twitter\n\n"+
        		"<<<<<< Seleciona uma das opções abaixo: >>>>>> \n\n"+
                "1 - Enviar Tweet \n"+
                "2 - Exibir - Quantidade por dia de tweets da última semana\n"+
                "3 - Exibir - Quantidade por dia de retweets da última semana\n"+
                "4 - Exibir - Quantidade por dia de favoritações da última semana\n"+
                "5 - Exibir - Os tweets pelo nome do autor, primeiro e o último\n"+
                "6 - Exibir - Os tweets por data, data mais recente e a menos recente\n"+
                "7 - Finalizar Aplicação\n"),
	MENU_ENVIAR_TWEET("Digite abaixo o Tweet (máximo 140 caracteres)\n"),
	MENU_PESQUISAR_TWEET("Digite abaixo a hashtag # a ser pesquisada\n"),
	PGM_SUCESSO("Programa Finalizado com Sucesso!"),
	PGM_DIGITE_HASHTAG("Por favor, digite o Hastag!"),
	PGM_ESCOLHA_OPCAO("Por favor, escolha uma opção!"),
	PGM_OPCAO_INVALIDA("Opção Inválida!"),
	PGM_TAMANHO_TWEET("Ultrapassou o número de caracteres permitido | Número digitado : "),
	PGM_CONTEUDO_NUMERICO("Por favor, somente conteudo númerico, escolha um opção de 1 à 7. Opção Inválida!"),
	PGM_DIGITE_TWEET("Por favor, digite o Tweet."),
	PGM_TWEET_SUCESSO("Tweet postado com sucesso!");
	
	private String titulo;

	private Menu(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}
}
