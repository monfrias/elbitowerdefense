package game.window;

import java.util.ArrayList;

import game.objects.Tower;

public class Player {
	
	private Screen screen;
	private int health;
	private int money;
	private final int startingMoney = 500;
	private final int startingHealth = 10;
	
	public Player(Screen screen) {
		this.screen = screen;
		this.screen.setScene(0);
		this.money = startingMoney;
		this.health = startingHealth;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public int getHealth() {
		return this.health;
	}
}