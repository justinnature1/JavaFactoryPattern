package javaFactoryPattern;

public abstract class WeaponDecorator extends Weapon {
	Weapon weapon; //Reference to the wrapped Weapon instance.
	public abstract String getDescription();
	public int getAttackSpeed() {return weapon.getAttackSpeed();}
	public int getDamage() {return weapon.getDamage();}
	public double getCriticalHitPercent() {return weapon.getCriticalHitPercent();}
}
