package javaFactoryPattern;

public class Sword extends Weapon {
	public Sword() {
		description = "Sword";
		damage = 50;
		criticalHitPercent = .10;
		attackSpeed = 50;
	}
}
