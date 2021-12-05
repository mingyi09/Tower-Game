///////////////////////////////////////////////////////////////////////////////
//                  
// Title:              PA4
// Files:              Assignment4.java,Item.java,Monster.java,Tower.java,Hero.java
// Quarter:            CSE 8B Fall 2020
//
// Author:             Mingyi Li
// Email:              mil011@ucsd.edu
// Instructor's Name:  Professor Ben Ochoa

/**
 * This class is the main class for a game which fights monsters and climbs tower
 *
 * 
 * @author Mingyi Li
 */

public class Assignment4 {

	public static Tower setUpTower() {
		Tower tower = new Tower(5);

		Monster slime = new Monster("slime", "Zizizi", 1, 4, 1);
		Monster nightBat = new Monster("nightBat", "Urhnnnn", 2, 7, 5);
		Monster ghost = new Monster("ghost", "WinWin", 4, 6, 3);
		Monster zombie = new Monster("zombie", "Rueeeee", 3, 10, 2);
		Monster dragon = new Monster("dragon", "Ahshhhh", 6, 20, 7);

		tower.setOneLevel(0, slime, new Item("Ninja Suit"));
		tower.setOneLevel(1, nightBat, new Item("HP Potion"));
		tower.setOneLevel(2, ghost, new Item("Platinum Shield"));
		tower.setOneLevel(3, zombie, new Item("Thunder Hammer"));
		tower.setOneLevel(4, dragon, new Item("Treasure"));

		return tower;
	}

/**
 * This method plays the fighting game to beat monsters and win/lose
 *
 * @param hero A Hero object who fights monster
 * @param tower The tower which includes monster and item on each level
 * @return none
 */

	public static void playGame(Hero hero, Tower tower) {
		for (int i =0; i<tower.getHeight(); i++)
		{
			
			Monster nowM = tower.getMonsterAtLevel(i);
			System.out.println();
			System.out.println("Level "+i+": "+hero.getName()+" encounters "+nowM.getName());
			nowM.roar();
			nowM.printStats();
			//begin to fight
			while (hero.isStillAlive() && nowM.isStillAlive())
			{
		        //who attack first, damage
				if (hero.isFasterThan(nowM))
				{
					hero.attack(nowM);
					
					//if monster is defeated: next level
		            if (!nowM.isStillAlive())
					{
						hero.equipItem(tower.getItemAtLevel(i));
						break;
					}
					
					nowM.attack(hero);
					//if hero is defeated: game over
					if (!hero.isStillAlive())
					{
						System.out.println("Game Over!");
						return;
					}
				}
				else
				{
				    nowM.attack(hero);
					//if hero is defeated: game over
					if (!hero.isStillAlive())
					{
						System.out.println("Game Over!");
						return;
					}
					
					hero.attack(nowM);
					
					//if monster is defeated: next level
		            if (!nowM.isStillAlive())
					{
						hero.equipItem(tower.getItemAtLevel(i));
						break;
					}
				}
				
			} //fight until one of them died		
		    if (i==tower.getHeight()-1) //if wins the last monster
			{
				System.out.println("The hero Wins!");
			}
				
		}
	}

/**
 * This method performs a test for relevent classes
 *
 * @param none
 * @return true if passed, else false.
 */
	public static boolean unitTests() {
		//test case 1
		Item blabla = new Item ("blabla");
		if (blabla.getAttackDamage()!=0||blabla.getHealth()!=0||blabla.getSpeed()!=0)
		{return false;}
		//test case 2
		Monster air = new Monster("air","blabla",0,1,0);
		if (!air.getName().equals("air"))
		{return false;}
		//test case 3
		Monster scar = new Monster("scar","woo",1,1,1);
		if (scar.getSpeed()!=1)
		{return false;}
		//test case 4
		Tower oh = new Tower(-2);
		if (oh.getHeight()!=1)
		{return false;}
		//test case 5
		Item painful_mask = new Item("pm");
		if (!painful_mask.getName().equals("pm"))
		{return false;}
		//test case 6
		if (!scar.isStillAlive())
		{return false;}
		return true;
	}


	public static void main(String[] args) {

		// Perform unitTests first
		if(unitTests()) {
			System.out.println("All unit tests passed.\n");
		} else {
			System.out.println("Failed test.\n");
			return;
		}

		Tower tower = setUpTower();
		Hero hero = new Hero("CSE_8B_Ninja", new Item("Knife"), 3, 10, 3);
		playGame(hero, tower);
		
	}
}