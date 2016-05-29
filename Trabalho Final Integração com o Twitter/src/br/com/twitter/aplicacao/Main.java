/*
Autor: Fabio Lopes de Brito
RM: 30399
Trabalho Final 
Turma: 27SCJ
Fundamentos Da Tecnologia Java E Uml
Prof. Michel Pereira Fernandes
*/
package br.com.twitter.aplicacao;
import javax.swing.JOptionPane;
import br.com.twitter.dados.BuscarTweets;
import br.com.twitter.enu.Menu;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class Main {

	public static void main(String[] args) {
		
        String input = "";
		String mensagem = "";
		boolean executarPgm = true; 
		String hashtag = "";
		
        
        try {
        	
			// Inicio de configuração de conexão com o Twitter
			String oAuthConsumerKey = "Chave inibida para commit no GitHub";
			String oAuthConsumerSecret = "Chave inibida para commit no GitHub";
			
			ConfigurationBuilder builder = new ConfigurationBuilder();
			 
			builder.setOAuthConsumerKey(oAuthConsumerKey);
			builder.setOAuthConsumerSecret(oAuthConsumerSecret);
			
			twitter4j.conf.Configuration configuration = builder.build();
			
			TwitterFactory factory = new TwitterFactory(configuration);
			
			Twitter twitter = factory.getInstance();
			
			AccessToken accessToken = loadAccessToken();
			
			twitter.setOAuthAccessToken(accessToken);
			
			// Fim da configuração de conexão com o Twitter   
			
			
			// Instância da Classe BuscarTweets
			BuscarTweets bt = new BuscarTweets(twitter);
			

	        while(executarPgm){
	            input = JOptionPane.showInputDialog(Menu.MENU_OPCOES.getTitulo());
	    		
	            // Se o usuário escolher "Cancelar" finaliza o programa
	            if (input == null){
	            	executarPgm = false;
	            	System.out.println(Menu.PGM_SUCESSO.getTitulo());
	            	System.exit(0);
	            	continue;
	            }
	            
	            //Se o usuário não escolheu nenhuma opção
	            if(input.isEmpty() ){
	            	JOptionPane.showMessageDialog(null, Menu.PGM_ESCOLHA_OPCAO.getTitulo());
	            	continue;
	            }
	            
	            // Instância da Classe ValidarMenu
	            ValidarMenu validarMenu = new ValidarMenu();
	            
	            if(!validarMenu.verificarNumerico(input)){
	            	JOptionPane.showMessageDialog(null, Menu.PGM_CONTEUDO_NUMERICO.getTitulo());
	            	continue;
	            }
	            
	            // Cast String para Integer
	            Integer opcao = new Integer(input); 
	            
		        switch (opcao) {
				case 1:
					mensagem = JOptionPane.showInputDialog(Menu.MENU_ENVIAR_TWEET.getTitulo());
					if (mensagem == null){
						continue;
					}else{
						if (mensagem.length() > 140){
							JOptionPane.showMessageDialog(null, Menu.PGM_TAMANHO_TWEET.getTitulo()+mensagem.length()+" caracteres.");
							
						}else { if (mensagem.isEmpty()){
							JOptionPane.showMessageDialog(null, Menu.PGM_DIGITE_TWEET.getTitulo());
							
						}else{
							twitter4j.Status status = twitter.updateStatus(mensagem);
							
							System.out.println(Menu.PGM_TWEET_SUCESSO.getTitulo()+" ["+status.getText()+"].");
							}
						}
					}
					break;
				case 2:					
		            hashtag = JOptionPane.showInputDialog(Menu.MENU_PESQUISAR_TWEET.getTitulo());
		    		
		            if (hashtag == null) {
		            	continue;
		            }else{ if (hashtag.isEmpty()) {
		            		JOptionPane.showMessageDialog(null, Menu.PGM_DIGITE_HASHTAG.getTitulo());
		            	
		            } else{
		            	bt.obterQtdTweets(hashtag);
		            	}
		            }

					break;
				case 3:
		            hashtag = JOptionPane.showInputDialog(Menu.MENU_PESQUISAR_TWEET.getTitulo());
		    		
		            if (hashtag == null) {
		            	continue;
		            }else{ if (hashtag.isEmpty()) {
		            		JOptionPane.showMessageDialog(null, Menu.PGM_DIGITE_HASHTAG.getTitulo());
		            	
		            } else{
		            	bt.obterQtdRetweets(hashtag);
		            	}
		            }
					
					break;
				case 4:
		            hashtag = JOptionPane.showInputDialog(Menu.MENU_PESQUISAR_TWEET.getTitulo());
		    		
		            if (hashtag == null) {
		            	continue;
		            }else{ if (hashtag.isEmpty()) {
		            		JOptionPane.showMessageDialog(null, Menu.PGM_DIGITE_HASHTAG.getTitulo());
		            	
		            } else{
		            	bt.obterQtdFavorite(hashtag);
		            	}
		            }
					
					break;				
				case 5:
		            hashtag = JOptionPane.showInputDialog(Menu.MENU_PESQUISAR_TWEET.getTitulo());
		            
		            if (hashtag == null) {
		            	continue;
		            }else{ if (hashtag.isEmpty()) {
		            		JOptionPane.showMessageDialog(null, Menu.PGM_DIGITE_HASHTAG.getTitulo());
		            	
		            } else{
		            	bt.obterAutor(hashtag);
		            	}
		            }
		            
					break;
				case 6:
		            hashtag = JOptionPane.showInputDialog(Menu.MENU_PESQUISAR_TWEET.getTitulo());
		            
		            if (hashtag == null) {
		            	continue;
		            }else{ if (hashtag.isEmpty()) {
		            		JOptionPane.showMessageDialog(null, Menu.PGM_DIGITE_HASHTAG.getTitulo());
		            	
		            } else{
		            	bt.obterDataTweet(hashtag);
		            	}
		            }
					
					break;
				case 7:
					executarPgm = false;
					System.out.println(Menu.PGM_SUCESSO.getTitulo());
					System.exit(0);
					break;				
					
				default:
					JOptionPane.showMessageDialog(null, Menu.PGM_OPCAO_INVALIDA.getTitulo());
					break;
				}
	        }
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Metodo para retorar o token de acesso ao Twitter
	private static AccessToken loadAccessToken(){ 
		String token = "Token inibido para commit no GitHub"; 
		String tokenSecret ="Token inibido para commit no GitHub"; 
		return new AccessToken(token, tokenSecret);
	}	
	
}
