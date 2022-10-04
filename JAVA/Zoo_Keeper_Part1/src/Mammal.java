import java.util.ArrayList;

public class Mammal {
	private int energyLevel;
	
	
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public int getEnergyLevel() {
		return this.energyLevel;
	}
	
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public int displayEnergy() {
		System.out.printf("This gorilla's final energy level is now: %s\n", energyLevel);
		return energyLevel;
		
	}

}
