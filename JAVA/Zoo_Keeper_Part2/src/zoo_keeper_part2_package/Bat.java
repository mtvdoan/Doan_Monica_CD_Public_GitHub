package zoo_keeper_part2_package;

public class Bat extends Mammal {
	
	public int fly() {
		int newEnergyLevel = getEnergyLevel();
		newEnergyLevel -= 50;
		setEnergyLevel(newEnergyLevel);
		System.out.printf("A mad bat flew across the sky screeching,'YEEEEEEEEEET'!! The subject's energy level has decreased by 50.  Energy level is now: %s", newEnergyLevel);
		return newEnergyLevel;
	}
	
	public int eatHumans() {
		int newEnergyLevel = getEnergyLevel();
		newEnergyLevel += 25;
		setEnergyLevel(newEnergyLevel);
		System.out.printf("The crazy bat is now slurping up some human blood!  The energy level has increased by 25! Energy level is now: %s", newEnergyLevel);
		return newEnergyLevel;	

	}
	
	public int attackTown() {
		int newEnergyLevel = getEnergyLevel();
		newEnergyLevel -= 100;
		setEnergyLevel(newEnergyLevel);
		System.out.printf("The bat is has decided to attack the nearby town!  Ah! The town is overcome by a massive underground mine fire! The energy level has decreased by 100! Energy level is now: %s", newEnergyLevel);
		return newEnergyLevel;	

	}

}
