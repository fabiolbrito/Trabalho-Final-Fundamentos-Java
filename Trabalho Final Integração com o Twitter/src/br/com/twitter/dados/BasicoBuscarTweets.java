/*
Autor: Fabio Lopes de Brito
RM: 30399
Trabalho Final 
Turma: 27SCJ
Fundamentos Da Tecnologia Java E Uml
Prof. Michel Pereira Fernandes
*/
package br.com.twitter.dados;

//Interface como métodas basicos para realizar as buscas no Twiiter
public interface BasicoBuscarTweets {
	
	public void obterQtdTweets(String hashtag);
	public void obterQtdRetweets(String hashtag);
	public void obterQtdFavorite(String hashtag);
	public void obterAutor(String hashtag);
	public void obterDataTweet(String hashtag);

}
