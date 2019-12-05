import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Register {
	private ArrayList<Book> reg; //Registret skall lagras i en ArrayList.
	private Book theBook;
	private boolean[] help;

	/** Skapar ett tomt register. */
	public Register() {
		reg = new ArrayList<Book>();
	}

	/** Sätter in boken bok i reg. */
	public void addBook(Book bok) {
		reg.add(bok);
		this.sortByAuthor();
	}

	/** Tar bort alla böcker av en viss författare. */
	public void removeAuthor(String specificAuthor) {
		for (int i = 0; i < reg.size(); i++) {
			if (reg.get(i).getAuthor().equals(specificAuthor)) {
				reg.remove(i);
			}
		}
	}

	/** Skriver ut författare samt titel. */
	public String printOut() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < reg.size(); i++) {
			String author = reg.get(i).getAuthor();
			String title = reg.get(i).getTitle();
			sb.append(author + "\n" + title + "\n");
		}
		return sb.toString();
	}

	/** Söker upp alla böcker som gäller för en viss författare. */
	public String searchAuthor(String author) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < reg.size(); i++) {
			if (reg.get(i).getAuthor().indexOf(author) >= 0) {
				sb.append(reg.get(i).getAuthor() + "\n" + reg.get(i).getTitle() + "\n");
			}

		}
		return sb.toString();
	}

	/** Söker titel för alla författare. */
	public String searchTitle(String title) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < reg.size(); i++) {
			if (reg.get(i).getTitle().equals(title)) {
				sb.append(reg.get(i).getAuthor() + "\n" + reg.get(i).getTitle() + "\n");
			}

		}
		return sb.toString();
	}
	/** Presenterar alla böcker sorterade efter författare. */    
	public void sortByAuthor() {
		int a;
		for (int t = 0; t < reg.size(); t++) {
			a = 0;
			for (int i = 0; i < reg.size(); i++) {
				if (reg.get(t).getAuthor().toLowerCase().compareTo(reg.get(i).getAuthor().toLowerCase()) > 0) {
					a++;
				}
			}
			Book temp = reg.get(a);
			reg.set(a, reg.get(t));
			reg.set(t, temp);
		}
	}

	/** Presentera alla böcker sorterade efter titel. */
	public String sortByTitle() {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		help = new boolean[reg.size()];
		for (int i = 0; i < reg.size(); i++) {
			String low = "}}}}}}}}}";
			index = 0;
			for (int k = 0; k < reg.size(); k++) {
				if (help [k] == false && reg.get(k).getTitle().compareTo(low) < 0) {
					index = k;
					low = reg.get(k).getTitle();
				}	

			}
			sb.append(reg.get(index).toString() + "\n");
			help[index] = true;

		}
		return sb.toString();
	}


	public void readFromFile(String fileName) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.err.println("Filen kunde inte öppnas");
			System.exit(1);
		}

		//Loopar igenom hela filen.
		while (scan.hasNextLine()) { 
			theBook = new Book(scan.nextLine(), scan.nextLine());
			System.out.println("Författare: " + theBook.getAuthor());
			System.out.println("Boktitel: " + theBook.getTitle());
			reg.add(theBook);
		}

		scan.close();
	}

	/** Sparar registret på fil med namnet fileName. */
	public void writeToFile(String fileName) {
		PrintWriter out = null; 

		try {
			out = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.err.println("Filen kunde inte öppnas.");
			System.exit(1);
		}
		for (int i = 0; i < reg.size(); i++) { 
			out.println(reg.get(i).getAuthor());
			out.println(reg.get(i).getTitle());

		}

		out.close();
	}

}