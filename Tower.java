///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment4.java
// File:               Tower.java
// Quarter:            CSE8B Fall 2020
//
// Author:             Mingyi Li  mil011@ucsd.edu
// Instructor's Name:  Professor Ben Ochoa
//

/**
 * This is a Tower class that create Tower objects with properties
 *
 *
 * @author Mingyi Li
 */

public class Tower {

	private int height;
	private Monster[] monsterEachLevel;
	private Item[] itemEachLevel;

	public Tower(int height) {	
		if (height<1)
		{
			this.height = 1;
		}
		else
		{
			this.height = height;
		}
		monsterEachLevel = new Monster[this.height];
		itemEachLevel = new Item[this.height]; 
	}
/**
 * This method sets every level with a monster and item
 *
 * @param monster, item
 * @return none
 */
 
	public void setOneLevel(int level, Monster monster, Item item) {
		monsterEachLevel[level] = monster;
		itemEachLevel[level] = item;
	}
/**
 * This method gets the height of the tower
 *
 * @param none
 * @return integer which represents the height
 */
	public int getHeight() {
		return height;
	}

/**
 * This method gets the monster at a level
 *
 * @param level 
 * @return Monster
 */
	public Monster getMonsterAtLevel(int level) {
		return monsterEachLevel[level];
	}

/**
 * This method gets the item at a level
 *
 * @param level 
 * @return Item
 */
	public Item getItemAtLevel(int level) {
		return itemEachLevel[level];
	}

}