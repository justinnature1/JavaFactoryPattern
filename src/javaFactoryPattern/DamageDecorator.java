package javaFactoryPattern;

public class DamageDecorator extends WeaponDecorator{
	
	double random = Math.random();
	
	public DamageDecorator (Weapon weapon) {
		this.weapon = weapon;
	}
	
	public String getDescription() {
		return "Deadly " + weapon.getDescription();
	}
	
	//Adds functionality to the original method by enhancing the damage.
	public int getDamage() {
		return  (int) (weapon.getDamage() * (1.2 + random*.15));
	}

}
