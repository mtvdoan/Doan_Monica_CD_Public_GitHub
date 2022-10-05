package abstract_art;

//inside of Sculpture.java
//Create a Sculpture class that inherits Art and 
public class Sculpture extends Art {
	
	
	// TODO: implement Sculpture class
	//has an additional member variable material
	public String material;
	
	//Constructor
	public Sculpture(String title, String author, String description, String material) {
		//Remember Sculpture class inherited from Art Class.  :)
		super(title, author, description);
		this.material = material;
	}

	@Override
	public void viewArt() {
		System.out.printf("I observed the marvelous sculpture called %s by %s.\n  The description says: %s.\n It was very %s-y!\n\n", title, author, description, material);
		
	}
}
