package abstract_art;

import java.util.ArrayList;
import java.util.Collections;

public class Museum {
	
	public ArrayList<Art> collection;
	
	//Ninja Bonus: store the paintings and sculptures inside of an ArrayList called museum
	public Museum() {
		this.collection = new ArrayList<Art>();
	}
	
	public static void main(String[] args) {
		
		Museum museum = new Museum();
		
		//Create 3 instances of Painting
		//Create 2 instances of Scupture
		museum.collection.add(new Painting(
				"Lavender Mist", 
				"Jackson Pollock",
				"Using house paint, he dripped, poured, and flung pigment from loaded brushes and sticks while walking around it.", 
				"House paint"));
		
		museum.collection.add(new Painting(
				"Blue Poles", 
				"Jackson Pollock",
				"At the time of the painting's creation, Pollock preferred not to assign names to his works, but rather numbers; as such, the original title of Blue Poles was simply \"Number 11\"' or \"No. 11\" for the year 1952. ", 
				"Acrylic paint"));
		
		museum.collection.add(new Painting(
				"Lavender Mist", 
				"Jackson Pollock",
				"Mural was immediately recognized as a turning point for American art. ", 
				"Oil paint"));
		
		museum.collection.add(new Sculpture(
				"Bust of Nefertiti", 
				"Thutmose",
				"This portrait has been a symbol of feminine beauty since it was first unearthed in 1912 within the ruins of Amarna, the capital city built by the most controversial Pharaoh of Ancient Egyptian history: Akhenaten.", 
				"Clay"));
		
		museum.collection.add(new Sculpture(
				"Laocoön and His Sons", 
				"Unknown",
				"It is based on the myth of a Trojan priest killed along with his sons by sea serpents sent by the sea god Poseidon as retribution for Laocoön’s attempt to expose the ruse of the Trojan Horse.", 
				"Marble"));

		//Ninja Bonus: use the viewArt() method of all of the artworks in the museum in a random order
		Collections.shuffle(museum.collection);
		for(Art art : museum.collection) {
			art.viewArt();
		}
	}
}
