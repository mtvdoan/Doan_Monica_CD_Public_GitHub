package abstract_art;

//inside of Art.java
//Create an abstract class called Art with member variables: title, author, description
public abstract class Art {

	// TODO: implement Art class
	public String title;
	public String author;
	public String description;
	
	//Constructor
	public Art(String title, String author, String description) {
		this.title = title;
		this.author = author;
		this.description = description;
		
	}
	
	//Create an abstract method called viewArt()
	public abstract void viewArt();
	

}
