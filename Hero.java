///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment4.java
// File:               Hero.java
// Quarter:            CSE8B Fall 2020
//
// Author:             Mingyi Li  mil011@ucsd.edu
// Instructor's Name:  Professor Ben Ochoa
//

/**
 * This is a Hero class that create Hero objects with properties
 *
 *
 * @author Mingyi Li
 */

public class Hero {

	private String name;
	private int attackDamage;
	private int health;
	private int speed;

	public Hero(String name, Item initialItem, int attackDamage,
				int health, int speed) {
		this.name = name;
		this.attackDamage = attackDamage;
		this.health = health;
		this.speed = speed;
		equipItem(initialItem);
	}

/**
 * This method attacks monster and causes damage on monster's health
 *
 * @param monster
 * @return none
 */
	public void attack(Monster monster) {
		monster.receiveDamage(attackDamage);
		System.out.println(name+" attacks "+monster.getName()+", causing "
		                   +attackDamage+" damage");
        monster.printStats();	
	}

/**
 * This method gets an item and add self-attributes with item's value
 *
 * @param item
 * @return none
 */
	public void equipItem(Item item) {
		attackDamage += item.getAttackDamage();
		health += item.getHealth();
		speed += item.getSpeed();
		System.out.println(name+" received "+item.getName());
	}

/**
 * This method checks who has a higher speed, monster or hero
 *
 * @param monster
 * @return true if hero is faster, else false.
 */
	public boolean isFasterThan(Monster monster) {
		if(speed>monster.getSpeed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

/**
 * This method checks if hero survives
 *
 * @param none
 * @return true if alive, else false.
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
 * This method gets the speed of hero
 *
 * @param none
 * @return integer that represents speed
 */
	public int getSpeed() {
		return speed;
	}

/**
 * This method gets the name of hero
 *
 * @param none
 * @return String that represents name
 */
	public String getName() {
		return name;
	}

/**
 * This method receives damage from monster and deduces health
 *
 * @param damage
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