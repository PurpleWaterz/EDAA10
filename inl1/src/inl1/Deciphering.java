package inl1;
import se.lth.cs.p.inl1.*;
import se.lth.cs.p.inl1.nbr4.*;

public class Deciphering {

	public static void main(String[] args) {
		
		TestCase testCase = new TestCase();
		Decryptographer decryptoGrapher = new Decryptographer (new Key());
		
		TextWindow textWindow = new TextWindow ("Dekryptering");
		
		TextView myDecrypt = new TextView("Chiffertext: ", 5, 50);
		TextView clearText = new TextView("Min klartext: ", 5, 50);
		TextView correctDecrypt = new TextView("Korrekt klartext: ", 5, 50);
		
		textWindow.addView(myDecrypt);
		textWindow.addView(clearText);
		textWindow.addView(correctDecrypt);
		
		
		for (int i = 1; i < 6; i++) {
			myDecrypt.displayText(testCase.getCryptoText(i));
			clearText.displayText(decryptoGrapher.decrypt(testCase.getCryptoText(i)));
			correctDecrypt.displayText(testCase.getClearText(i));
			
			textWindow.waitForMouseClick();
				}
	
		}

}
