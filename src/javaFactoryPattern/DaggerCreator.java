package javaFactoryPattern;

public class DaggerCreator extends WeaponCreator{
	public Weapon createWeapon() {
		return new Dagger();
	}
}
