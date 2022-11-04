package com.teksystems.abstraction;

public class Pig extends Animal {

	@Override
	public void animalSound() {
		System.out.println("The pig makes a sound");
	}
	
	public void animalEats() {
		System.out.println("The pig eats some food");
	}
	
}
