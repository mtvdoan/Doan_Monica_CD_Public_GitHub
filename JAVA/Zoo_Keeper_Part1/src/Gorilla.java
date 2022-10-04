
public class Gorilla extends Mammal {
	

	public int throwSomething() {
		int newEnergyLevel = getEnergyLevel();
		newEnergyLevel -= 5;
		setEnergyLevel(newEnergyLevel);
		System.out.printf("Some other gorilla threw something. This gorilla's energy level has decreased by 5.  Energy level is now: %s", newEnergyLevel);
		return newEnergyLevel;
		
	}
	
	public int eatBananas() {
		int newEnergyLevel = getEnergyLevel();
		newEnergyLevel += 10;
		setEnergyLevel(newEnergyLevel);
		System.out.printf("This gorilla is happily eating a banana. Energy level has increased by 10.  Energy level is now: %s", newEnergyLevel);
		return newEnergyLevel;
		
	}
	
	public int climb() {
		int newEnergyLevel = getEnergyLevel();
		newEnergyLevel -= 10;
		setEnergyLevel(newEnergyLevel);
		System.out.printf("This gorilla climbed up a tree. Energy level has decreased by 10.  Energy level is now: %s", newEnergyLevel);
		return newEnergyLevel;
		
	}


}
