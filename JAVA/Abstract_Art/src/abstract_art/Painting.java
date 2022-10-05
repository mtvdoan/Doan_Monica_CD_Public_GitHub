package abstract_art;

//Inside of Painting.java
//Create a Painting class that inherits Art and 
public class Painting extends Art {
	
	//has an additional member variable paintType
	public String paintType;
	
	//Constructor
	public Painting(String title, String author, String description, String paintType) {
		//Remember that the class Painting inherited 'title', 'author', 'description' method from class Art
		super(title, author, description);
		this.paintType = paintType;
	}
	
	@Override
	public void viewArt() {
		System.out.printf("I looked at the beautiful painting called %s by %s.\n The description says: %s.\n It was very %s-y.\n\n", title, author, description, paintType);
	}	
} 

