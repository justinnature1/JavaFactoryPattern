package javaFactoryPattern;

public class AxeCreator extends WeaponCreator{
	public Weapon createWeapon() {
		return new Axe();
	}
}
