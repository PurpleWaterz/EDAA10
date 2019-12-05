package inl1;
import se.lth.cs.p.inl1.*;
import se.lth.cs.p.inl1.nbr4.*;

public class Decryptographer {
	private Key key; 
	private char textCh;


	/** Skapar ett objekt för dechiffering där nyckeln key används. */
	public Decryptographer (Key key) {
		this.key = key;
	}

	/** Dechifferar texten text och returnerar klartexten. */
	public String decrypt (String text) {
		int n = 0;
		StringBuilder sb = new StringBuilder (); //Skapar en tom strängbuffert.
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ' ') {
				sb.append(' ');
			} else {

				char letter = text.charAt(i);	    	
				int index = letter - 'A';	    		    	
				int keyNbr = key.getDigit(n);	    	
				int deChiffernbr = index - keyNbr;
				if (deChiffernbr < 0) {
					deChiffernbr += 26;	 

				} char ch = (char) (deChiffernbr + 'A');
				sb.append(ch);
				if (n < 9) {
					n++;
				} else { 
					n = 0;

				}	    	
			}

		}
		return sb.toString();
	}
}