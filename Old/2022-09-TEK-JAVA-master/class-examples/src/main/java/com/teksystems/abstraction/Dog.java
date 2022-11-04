package com.teksystems.abstraction;

public class Dog extends Animal {

	@Override
	public void animalSound() {
		System.out.println("The dog makes a sound");
	}

	@Override
	public void animalEats() {
		System.out.println("The dog eats some food");
	}
	
	

}
