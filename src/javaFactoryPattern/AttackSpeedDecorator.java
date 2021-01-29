package javaFactoryPattern;

public class AttackSpeedDecorator extends WeaponDecorator{
	
	double random = Math.random();
	
	public AttackSpeedDecorator (Weapon weapon) {
		this.weapon = weapon;
	}
	
	public String getDescription() {
		return "Fiendish " + weapon.getDescription();
	}
	
	//Adds functionality to the original method by enhancing the attackSpeed.
	public int getAttackSpeed() {
		return  (int) (weapon.getAttackSpeed() * (1.35 + random *.3));
	}

}
