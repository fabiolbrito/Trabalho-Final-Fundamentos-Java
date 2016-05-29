/*
Autor: Fabio Lopes de Brito
RM: 30399
Trabalho Final 
Turma: 27SCJ
Fundamentos Da Tecnologia Java E Uml
Prof. Michel Pereira Fernandes
*/
package br.com.twitter.dados;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SortedSet;
import java.util.TreeSet;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;

public class BuscarTweets implements BasicoBuscarTweets{

	private Twitter twitter;
	
	// Construtor da Classe BuscarTweets
	public BuscarTweets(Twitter twitter) {
		super();
		this.twitter = twitter;
	}

	//Método para obter a quantidade por dia de tweets da última semana
	@Override
	public void obterQtdTweets(String hashtag){
		
		try {
			
			//Exibindo no console a hashtag informada pelo usuário
			System.out.println("Hashtag : "+hashtag);
			
			//Obtendo a Data de Inicio
			GregorianCalendar gCalendarInicio = obterDataInicial();
			
			// Obtendo a Data Final
			GregorianCalendar gCalendarFinal = obterDataFinal();
			
			//Formando as datas no padrao ano/mes/dia
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
			
			//Formando as datas no padrao dia/mes/ano
			SimpleDateFormat formatDateBR = new SimpleDateFormat("dd-MM-yyyy");
			
			while (gCalendarInicio.before(gCalendarFinal)){
				
				Query query = new Query(hashtag);
				
				GregorianCalendar gCaledarAnterior = new GregorianCalendar();
				gCaledarAnterior.setTime(gCalendarInicio.getTime());
				gCaledarAnterior.add(GregorianCalendar.DAY_OF_MONTH, -1);
				
				query.setSince(formatador.format(gCaledarAnterior.getTime()));
				query.setUntil(formatador.format(gCalendarInicio.getTime()));
								
				QueryResult result;
				int contador = 0;
				
				result = twitter.search(query);
				
				while(result.hasNext()){
					query = result.nextQuery();
					
					for (int i = 0; i < result.getTweets().size(); i++) {
						contador++;
					}
					
					result = twitter.search(query);
				}
				
				System.out.println(formatDateBR.format(gCaledarAnterior.getTime())+": Total = "+contador+" tweets por dia.");
				gCalendarInicio.add(GregorianCalendar.DAY_OF_MONTH, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
	
	//Método para obter a quantidade por dia de retweets da última semana
	@Override
	public void obterQtdRetweets(String hashtag){
		
		try {
			
			//Exibindo no console a hashtag informada pelo usuário
			System.out.println("Hashtag : "+hashtag);
			
			//Obtendo a Data de Inicio
			GregorianCalendar gCalendarInicio = obterDataInicial();
			
			// Obtendo a Data Final
			GregorianCalendar gCalendarFinal = obterDataFinal();
			
			//Formando as datas no padrao ano/mes/dia
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
			
			//Formando as datas no padrao dia/mes/ano
			SimpleDateFormat formatDateBR = new SimpleDateFormat("dd-MM-yyyy");
			
			while (gCalendarInicio.before(gCalendarFinal)){
				
				Query query = new Query(hashtag);
				
				GregorianCalendar gCaledarAnterior = new GregorianCalendar();
				gCaledarAnterior.setTime(gCalendarInicio.getTime());
				gCaledarAnterior.add(GregorianCalendar.DAY_OF_MONTH, -1);
				
				query.setSince(formatador.format(gCaledarAnterior.getTime()));
				query.setUntil(formatador.format(gCalendarInicio.getTime()));
				
				QueryResult result;
				int retweetCount =0;

				result = twitter.search(query);
				
				while(result.hasNext()){
					query = result.nextQuery();
					
					for (Status status : result.getTweets()) {					
						
						retweetCount = retweetCount + status.getRetweetCount();
			
					}
					
					result = twitter.search(query);
				}
				System.out.println(formatDateBR.format(gCaledarAnterior.getTime())+": | Total = "+retweetCount+" retweets por dia.");
				gCalendarInicio.add(GregorianCalendar.DAY_OF_MONTH, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
	
	//Método para obter a quantidade por dia de favoritações da última semana
	@Override
	public void obterQtdFavorite(String hashtag){
		
		try {
			
			//Exibindo no console a hashtag informada pelo usuário
			System.out.println("Hashtag : "+hashtag);
			
			//Obtendo a Data de Inicio
			GregorianCalendar gCalendarInicio = obterDataInicial();
			
			// Obtendo a Data Final
			GregorianCalendar gCalendarFinal = obterDataFinal();
			
			//Formando as datas no padrao ano/mes/dia
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
			
			//Formando as datas no padrao dia/mes/ano
			SimpleDateFormat formatDateBR = new SimpleDateFormat("dd-MM-yyyy");
			
			while (gCalendarInicio.before(gCalendarFinal)){
				
				Query query = new Query(hashtag);
				
				GregorianCalendar gCaledarAnterior = new GregorianCalendar();
				gCaledarAnterior.setTime(gCalendarInicio.getTime());
				gCaledarAnterior.add(GregorianCalendar.DAY_OF_MONTH, -1);
				
				query.setSince(formatador.format(gCaledarAnterior.getTime()));
				query.setUntil(formatador.format(gCalendarInicio.getTime()));
				
				QueryResult result;
				int favoriteCount = 0;
				
				result = twitter.search(query);
				
				while(result.hasNext()){
					query = result.nextQuery();
				
						
					for (Status status : result.getTweets()) {
					
						favoriteCount = favoriteCount + status.getFavoriteCount();
						
					}
					
					result = twitter.search(query);
				}
				System.out.println(formatDateBR.format(gCaledarAnterior.getTime())+": | Total = "+favoriteCount+" favoritações por dia.");
				gCalendarInicio.add(GregorianCalendar.DAY_OF_MONTH, 1);
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
	
	//Método para obter a quantidade por dia de retweets da última semana
	@Override
	public void obterAutor(String hashtag){
		
		try {
			
			//Exibindo no console a hashtag informada pelo usuário
			System.out.println("Hashtag : "+hashtag);
			
			//Obtendo a Data de Inicio
			GregorianCalendar gCalendarInicio = obterDataInicial();
			
			// Obtendo a Data Final
			GregorianCalendar gCalendarFinal = obterDataFinal();
			
			//Formando as datas no padrao ano/mes/dia
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
			
			//SortedSet com os nomes dos autores 
			SortedSet<String> listaAutor = new TreeSet<>();
			
			while (gCalendarInicio.before(gCalendarFinal)){
				
				Query query = new Query(hashtag);
				
				GregorianCalendar gCaledarAnterior = new GregorianCalendar();
				gCaledarAnterior.setTime(gCalendarInicio.getTime());
				gCaledarAnterior.add(GregorianCalendar.DAY_OF_MONTH, -1);
				
				query.setSince(formatador.format(gCaledarAnterior.getTime()));
				query.setUntil(formatador.format(gCalendarInicio.getTime()));
				
				QueryResult result;

				result = twitter.search(query);
				
				while(result.hasNext()){
					query = result.nextQuery();
					
					for (Status status : result.getTweets()) {					
						
						listaAutor.add(status.getUser().getName());
			
					}
					
					result = twitter.search(query);
				}
				gCalendarInicio.add(GregorianCalendar.DAY_OF_MONTH, 1);
			}
			
			System.out.println("Primeiro Nome : "+listaAutor.first());
			System.out.println("Último   Nome : "+listaAutor.last());
						
		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
		
	//Método para obter a quantidade
	@Override
	public void obterDataTweet(String hashtag){
		
		try {
			
			//Exibindo no console a hashtag informada pelo usuário
			System.out.println("Hashtag : "+hashtag);
			
			//Obtendo a Data de Inicio
			GregorianCalendar gCalendarInicio = obterDataInicial();
			
			// Obtendo a Data Final
			GregorianCalendar gCalendarFinal = obterDataFinal();
			
			//Formando as datas no padrao ano/mes/dia
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
			
			//Formando as datas no padrao dia/mes/ano
			SimpleDateFormat formatDateBR = new SimpleDateFormat("dd-MM-yyyy");
			
			SortedSet<Date> listaData = new TreeSet<>();
			
			while (gCalendarInicio.before(gCalendarFinal)){
				
				Query query = new Query(hashtag);
				
				GregorianCalendar gCaledarAnterior = new GregorianCalendar();
				gCaledarAnterior.setTime(gCalendarInicio.getTime());
				gCaledarAnterior.add(GregorianCalendar.DAY_OF_MONTH, -1);
				
				query.setSince(formatador.format(gCaledarAnterior.getTime()));
				query.setUntil(formatador.format(gCalendarInicio.getTime()));
				query.resultType(Query.RECENT);
				
				QueryResult result;

				result = twitter.search(query);
				
				while(result.hasNext()){
					query = result.nextQuery();
					
					for (Status status : result.getTweets()) {					
						
						listaData.add(status.getCreatedAt());
			
					}
					
					result = twitter.search(query);
				}
				gCalendarInicio.add(GregorianCalendar.DAY_OF_MONTH, 1);
			}
		
			System.out.println("Data Mais  Recente : "+formatDateBR.format(listaData.last()));
			System.out.println("Data Menos Recente : "+formatDateBR.format(listaData.first()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	//Método para formatar a data de inico
	private GregorianCalendar obterDataInicial(){
	
		// Obtendo a Data de Inicio.
		GregorianCalendar gCalendarInicio = new GregorianCalendar();
		gCalendarInicio.add(GregorianCalendar.DAY_OF_MONTH, -6);

		return gCalendarInicio;
		
	}
	
	//Método para formatar a data final
	private GregorianCalendar obterDataFinal(){

		// Obtendo a Data Final.
		// Regra -> Data de Final é a Data Atual mais um dia.		
		GregorianCalendar gCalendarFinal = new GregorianCalendar();
		gCalendarFinal.add(GregorianCalendar.DAY_OF_MONTH, 1);

		return gCalendarFinal;
		
	}

	
}
	