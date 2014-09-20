package reivax.norac.addressbook.util;

import java.util.Comparator;

import reivax.norac.addressbook.model.Entry;

public class ComparatorClose implements Comparator<Entry> {
	
	private static final String arrayChars [][] = {
			{"a", "à", "â"},
			{"c", "ç"},
			{"e", "é", "è", "ê"},
			{"i", "î", "ï"},
			{"o", "ô", "ö"},
			{"u", "û", "ù"},
		};
	
	private static String replaceAllOccOfSpecialChars(String string){
		string = string.replaceAll(" " , "");
		string = string.replaceAll("-" , "");
		
		for(int j=0; j<arrayChars.length; j++){
			for(int k=1; k<arrayChars[j].length; k++){
				string = string.replaceAll(arrayChars[j][k] , arrayChars[j][0]);
			}
		}
		
		
		
		return string.toUpperCase();
	}
	
	public int compare(Entry o1, Entry o2) {
		
		String name1 = replaceAllOccOfSpecialChars(o1.getName());
		System.out.println(name1);
		String name2 = replaceAllOccOfSpecialChars(o2.getName());
		System.out.println(name2);
		
		if(name1.contains(name2) || name2.contains(name1)){
			return 0;
		};
		
		return name1.compareTo(name2);
	}

	public static void main(String []args){
		Entry e1 = new Entry();
		e1.setName("Bob");
		
		Entry e3 = new Entry();
		e3.setName("Boby");
		
		ComparatorClose comp = new ComparatorClose();
		System.out.println(comp.compare(e1, e3));
	}
	
}
