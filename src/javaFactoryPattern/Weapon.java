package javaFactoryPattern;

import java.util.Date;

public abstract class Weapon {
	protected int damage = 0;
	protected int attackSpeed = 0;
	protected double criticalHitPercent = 0;
	
	private long lastAttack = 0; //Stores the time in milliseconds since the last successful attack
	
	protected String description = "Unnamed Weapon";
	
	
	public double getCriticalHitPercent(){
		return criticalHitPercent;
	}
	
	public int getAttackSpeed() {
		return attackSpeed;
	}
	
	public int getDamage() {
		return damage;
	}
	
	//Displays the weapons statistics
	public String weaponStats() {
		return "\tDamage: " + getDamage() + 
				"\n\tAttackSpeed: " + getAttackSpeed() +
				"\n\tCritical Hit: " + String.format("%.1f", getCriticalHitPercent() * 100) + "%";
	}
	
	public String getDescription() {
		return description;
	}
	
	/*Determines the damage done to an enemy during a successful attack.
	The attack function would be a good candidate for the Strategy Design Pattern.
	There can be ranged attacks (a bow) or special attacks/weapons such as magical
	spells.
	*/ 
	public int attack() {
		int damage = 0;
		if (canAttack()) {
			System.out.print("Attacking! ");
			if (Math.random()<=getCriticalHitPercent()) {
				damage = getDamage()*2;
				System.out.print("Critical Hit! ");
			}
			else {
				damage = getDamage();
			}
		} else {
			System.out.print("Can't Attack Yet! ");
		}
		
		return damage;
	}
	
	//Determines if the weapon is ready to attack again based on attackSpeed
	private boolean canAttack() {
		Date date = new Date();
		long currentTime = date.getTime();
		//Produces the number of seconds since the last attack.
		double timeBetweenAttacks = (currentTime - lastAttack)/1000;
		//An attack speed of 100 represents 1 attack per second.  This formula below
		//is used to calculate the how many seconds must go by before another attack.
		double rechargeTime = 1000/(getAttackSpeed()*10);	
		//An attack is possible if there is sufficient time between attacks.
		if (timeBetweenAttacks >= rechargeTime) {
			lastAttack = currentTime; //If an attack is possible, the lastAttack is reset.
			return true;
		}
		return false;
	}
}
