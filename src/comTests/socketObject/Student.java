package comTests.socketObject;

import java.io.Serializable;

public class Student implements Serializable{
	private String id;
	private String name;
	
	public void setId(String Id) {
        this.id=Id;
	}
	
	public void setName(String Name) {
		this.name=Name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

}
