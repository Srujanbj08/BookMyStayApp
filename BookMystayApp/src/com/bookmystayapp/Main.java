package com.bookmystayapp;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		InventoryService inventory = new InventoryService();

		inventory.addRoomType("Single", 5, 2000);
		inventory.addRoomType("Double", 3, 3500);
		inventory.addRoomType("Suite", 2, 6000);

		System.out.println("Room Inventory:");
		inventory.displayInventory();
	}
}
