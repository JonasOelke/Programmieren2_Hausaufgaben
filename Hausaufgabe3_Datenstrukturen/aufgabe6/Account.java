package aufgabe6;

public class Account {
	private String username;
	private String phone;
	
	public Account(String username, String phone) {
		this.username = username;
		this.phone = phone;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPhone() {
		return phone;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		else if (obj == null) return false;
		else if (!(obj instanceof Account)) return false;
		
		Account other = (Account) obj;
		if (username == other.getUsername() && phone == other.getPhone()) return true;
		else return false;
	}
	
}
