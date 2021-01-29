package javaFactoryPattern;

public class WeaponTest {
	public static void main (String[] args) throws InterruptedException {
		
		//Create instances for concrete weapon factory classes.
		WeaponCreator daggerCreator = new DaggerCreator();
		WeaponCreator swordCreator = new SwordCreator();
		WeaponCreator AxeCreator = new AxeCreator();
		
		//Uses the weapon factories to make regular weapons as well as weapons with upgrades using decorators
		Weapon[] weaponInventory = {daggerCreator.createWeapon(),
				swordCreator.createWeapon(WeaponCreator.MAGIC),
				AxeCreator.createWeapon(WeaponCreator.RARE)
		};
		
		for (Weapon weapon : weaponInventory) {
			//Simulates a player using a the decoratedAxe weapon to attack an opponent.
			System.out.println("Attacking with Equipped Weapon: " + weapon.getDescription());
			System.out.println(weapon.weaponStats());	
			for (int i = 0; i < 10; i++) {
				System.out.println("Damage: " + weapon.attack());
				Thread.sleep(500); //Pauses code execution for .5 seconds (500 ms)
			}

			System.out.println();
		}
		
	}
}
