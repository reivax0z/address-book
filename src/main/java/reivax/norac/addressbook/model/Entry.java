package reivax.norac.addressbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Entities represented in the Address Book.
 * 
 * @author Xavier
 *
 */
@Entity
@NamedQuery(name="Entry.findAll", query="SELECT e FROM Entry e")
public class Entry {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public boolean equals(Object o){
		return o instanceof Entry && ((Entry)o).getName().equals(this.getName());
	}
	
	@Override
	public int hashCode(){
		return this.name.hashCode();
	}
}
