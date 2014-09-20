package reivax.norac.addressbook.util;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import reivax.norac.addressbook.model.Entry;

public class JsonEncode {

	public static JSONArray encodeBook(List<Entry> book){
		JSONArray obj = new JSONArray();
		for(Entry e: book){
			obj.add(encodeOneEntry(e));
		}
		return obj;
	}
	
	private static JSONObject encodeOneEntry(Entry e){
		JSONObject obj = new JSONObject();

		obj.put("name", e.getName());
		obj.put("phone", e.getPhone());
		
		return obj;
	}
}
