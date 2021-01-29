package javaFactoryPattern;



public class SwordCreator extends WeaponCreator{
	public Weapon createWeapon(){
		return new Sword();
	}


}
