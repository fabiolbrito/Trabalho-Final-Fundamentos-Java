/*
Autor: Fabio Lopes de Brito
RM: 30399
Trabalho Final 
Turma: 27SCJ
Fundamentos Da Tecnologia Java E Uml
Prof. Michel Pereira Fernandes
*/
package br.com.twitter.aplicacao;

public class ValidarMenu {

	public boolean verificarNumerico( String input) {

	    char[] c = input.toCharArray();
	    boolean d = true;
	    for ( int i = 0; i < c.length; i++ ){

	        if ( !Character.isDigit( c[ i ] ) ) {
	            d = false;
	            break;
	        }
	    }
	    return d;
	}	
	

}
