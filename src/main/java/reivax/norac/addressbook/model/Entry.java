package reivax.norac.addressbook.model;

public class Entry {

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
