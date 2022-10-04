package zoo_keeper_part2_package;

public class Mammal {
	private int energyLevel;
	
	
	public Mammal() {
		this.energyLevel = 300;
	}
	
	public int getEnergyLevel() {
		return this.energyLevel;
	}
	
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public int displayEnergy() {
		System.out.printf("This bat's final energy level is now: %s\n", energyLevel);
		return energyLevel;
		
	}

}
