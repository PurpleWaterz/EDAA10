public class MainProgramme {
	public static void main(String[] args) {
		Dialog d = new Dialog();
		Register reg = new Register();
		while (true) {
			String menuItems = "Meny" + "\n"
					+ "1: Sätt in en ny bok med författare och titel." + "\n"
					+ "2: Ta bort alla böcker av en viss författare." + "\n"
					+ "3: Sök upp alla böcker för en viss författare." + "\n"
					+ "4: Sök upp den eller de böcker som har en viss titel." + "\n"
					+ "5: Presentera alla böcker sorterade efter författare." + "\n"
					+ "6: Presentera alla böcker sorterade efter titel." + "\n"
					+ "7: Spara registret på en fil." + "\n"
					+ "8: Hämta uppgifterna till registret från en fil." + "\n";
			int s = d.readInt(menuItems);
			switch (s) {

			case 1:
				String author = "Ange författare";
				String title = "Ange boktitel";
				Book b = new Book(d.readString(author), d.readString(title));
				reg.addBook(b);
				d.printString(reg.printOut());

				break;

			case 2: 
				String removeBooks = "Ange författare";
				reg.removeAuthor(d.readString(removeBooks));
				d.printString(reg.printOut());

				break;

			case 3:
				String specificAuthor = "Ange författare";
				d.printString(reg.searchAuthor(d.readString(specificAuthor)));

				break;

			case 4: 
				String specificTitle = "Ange boktitel";
				d.printString(reg.searchTitle(d.readString(specificTitle)));

				break;

			case 5: 
				reg.sortByAuthor();
				d.printString(reg.printOut());
				break;

			case 6:
				String s1 = reg.sortByTitle();
				d.printString(s1);

				break;

			case 7:
				String fileName = "Ange filnamn";
				d.readString(fileName);
				reg.writeToFile(fileName);

				break;

			case 8:
				String fileNamn = "Ange filnamn";
				d.readString(fileNamn);
				reg.readFromFile(fileNamn);

				break;

			default:
				System.exit(1);
			}
		}
	}
}