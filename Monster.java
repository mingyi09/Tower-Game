///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment4.java
// File:               Monster.java
// Quarter:            CSE8B Fall 2020
//
// Author:             Mingyi Li  mil011@ucsd.edu
// Instructor's Name:  Professor Ben Ochoa
//

/**
 * This is a Monster class that create Monster objects with properties
 *
 *
 * @author Mingyi Li
 */

public class Monster {

	private String name;
	private String roarSound;
	private int attackDamage;
	private int health;
	private int speed;

	public Monster(String name, String roarSound, int attackDamage,
				   int health, int speed) {
		this.name = name;
		this.attackDamage = attackDamage;
		this.health = health;
		this.speed = speed;
		this.roarSound = roarSound;
	}

/**
 * This method attacks hero and causes damage on hero's health
 *
 * @param hero
 * @return none
 */
	public void attack(Hero hero) {
		hero.receiveDamage(attackDamage);
		System.out.println(name+" attacks "+hero.getName()+", causing "
		                   +attackDamage+" damage");
		hero.printStats();
	}

/**
 * This method makes monster's sound
 *
 * @param none
 * @return none
 */
	public void roar() {
		System.out.println(name+": "+roarSound);
	}

/**
 * This method checks if monsters're alive
 *
 * @param none
 * @return true if survive, else false
 */
	public boolean isStillAlive() {
		if (health>0)
		{
			return true;
		}
		else
		{
			System.out.println(name+" is defeated");
			return false;
		}
	}

/**
 * This method gets the speed of the monster
 *
 * @param none
 * @return integer which represents the speed
 */
	public int getSpeed() {
		return speed;
	}

/**
 * This method gets the name of the monster
 *
 * @param none
 * @return String which represents the name
 */
	public String getName() {
		return name;
	}

/**
 * This method receives damage
 *
 * @param damage that deduces the health
 * @return none
 */
	public void receiveDamage(int damage) {
		health -= damage;
	}


	public void printStats() {
		String str = String.format(
				"\t%s - attack: %d, health: %d, speed: %d",
				this.name, this.attackDamage, this.health, this.speed);
		System.out.println(str);
	}
}