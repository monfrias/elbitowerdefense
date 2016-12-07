package object;

import java.util.ArrayList;

import window.Screen;

public class Player {
	
	private Screen screen;
	private int health;
	private int money;
	private final int startingMoney = 1000;
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
	
	public void setMoney(int money) {
		this.money = money;
	}
}