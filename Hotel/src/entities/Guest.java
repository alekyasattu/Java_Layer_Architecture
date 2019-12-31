package entities;

public class Guest {
	
	private int id;
	private String name;
	
	public Guest() {
		this(0,"");
	}

	public Guest(int id, String name) {
		
		this.id = id;
		this.name = name;
	}

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
	
	public String toString() {
		String display = id +" "+name;
		return display;
	}
	
	public int hashcode() {
		return id;
	}
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(obj == null || !(obj instanceof Guest)) {
			return false;
		}
		
		Guest g = (Guest)obj;
		return g.id == this.id;
	}
	
	
	
	

}
