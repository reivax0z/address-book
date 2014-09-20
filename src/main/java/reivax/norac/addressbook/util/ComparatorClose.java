package reivax.norac.addressbook.util;

import java.util.Comparator;

import reivax.norac.addressbook.model.Entry;

/**
 * Helper class for comparing Entry with similar names (ie, Boby similar to Bob).
 * 
 * @author Xavier
 *
 */
public class ComparatorClose implements Comparator<Entry> {
	
	private static final String arrayChars [][] = {
			{"a", "à", "â"},
			{"c", "ç"},
			{"e", "é", "è", "ê"},
			{"i", "î", "ï"},
			{"o", "ô", "ö"},
			{"u", "û", "ù"},
		};
	
	public static String replaceAllOccOfSpecialChars(String string){
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
		String name2 = replaceAllOccOfSpecialChars(o2.getName());
		
		if(name1.contains(name2) || name2.contains(name1)){
			return 0;
		}
		
		return name1.compareTo(name2);
	}
}
