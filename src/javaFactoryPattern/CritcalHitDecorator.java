package javaFactoryPattern;

public class CritcalHitDecorator extends WeaponDecorator{
	
	double random = Math.random();
	
	public CritcalHitDecorator (Weapon weapon) {
		this.weapon = weapon;
	}
	public String getDescription() {
		return weapon.getDescription()  + " of Holy Might";
	}
	
	//Adds functionality to the original method by enhancing the criticalHitPercent chance.
	public double getCriticalHitPercent() {
		return  (weapon.getCriticalHitPercent() + (.025 + random * .05));
	}

}
