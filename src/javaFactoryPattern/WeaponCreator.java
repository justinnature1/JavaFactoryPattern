package javaFactoryPattern;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public abstract class WeaponCreator {
	public static final int NORMAL = 0;
	public static final int MAGIC = 1;
	public static final int UNIQUE = 2;
	public static final int RARE = 3;
	
	abstract Weapon createWeapon();
	
	public Weapon createWeapon (int type) {
		return upgradeWeapon(this.createWeapon(), type);
	}
	
/*
 * I was going to make a function that would return a random type of weapon (dagger, axe, sword), but
 * I would have to use code like new Dagger() in the parent class.  This would link the classes together.
 * Would this be an acceptable way to bend the rules of the factory pattern?  Or would it be better to implement
 * this code in another class?	
 */
//	public Weapon createRandomWeapon() {
//		double random = Math.random();
//		if (random < 1/3)
//			
//	}
	
	protected Weapon upgradeWeapon(Weapon weapon, int numberOfDecorators) {
		int TOTALDECORATORS = 3; //Number of concrete decorator classes
		
		if (numberOfDecorators > TOTALDECORATORS || numberOfDecorators < 0) 
			throw new IllegalArgumentException("Invalid Weapon Type: Use WeaponCreator Static "
					+ "Constants NORMAL, MAGIC, UNIQUE, or RARE");
		Random r = new Random();
		Queue<Integer> q = new LinkedList<>();
		Integer randInt;

		//If you know of any other way to do this random assignment, I'm all ears.
		//If the number of decorators grows, this chunk of code would need to be rewritten.  I don't know if there
		//is a way to avoid this or a way to create a list of subclasses of the WeaponDecorator abstract class.
		
		//Populates a queue with the random integers from 0 to TOTALDECORATOR-1 in random order with no repeats
		while (q.size() < TOTALDECORATORS){
			randInt = r.nextInt(TOTALDECORATORS);
			if (!q.contains(randInt))
				q.add(randInt);
		}		
		
		//Uses the queue with random integers to add a random decorators to the weapon.  Only
		//adds the number of decorators specified by the category of weapon you are creating.
		for (int i = 0; i < numberOfDecorators; i++) {
			switch (q.remove()){
			case 0:
				weapon = new CritcalHitDecorator(weapon);
				break;
			case 1:
				weapon = new AttackSpeedDecorator(weapon);
				break;
			case 2:
				weapon = new DamageDecorator(weapon);
				break;
			}
		}	
		return weapon;
	}
}