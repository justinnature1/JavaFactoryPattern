package javaFactoryPattern;

public class Axe extends Weapon {
	public Axe() {
		description = "Axe";
		damage = 100;
		criticalHitPercent = .15;
		attackSpeed = 30;
	}
}
