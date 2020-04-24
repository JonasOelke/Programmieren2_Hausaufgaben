package aufgabe3;

public class Contact {
	
	private String name;
	private String phone;
	
	//Die Telefonnummer wird als String gespeichert um Telefonnummern wie "+49 157...", führende Nullen, 
	//Leerzeichen zur Lesbarkeit u.ä. korrekt darzustellen
	
	public Contact(String name, String phone) {
		this.name = name;
		this.phone = phone;
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

}
