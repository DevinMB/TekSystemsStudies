package com.teksystems.abstraction;

public class AbstractionMain {

	public static void main(String[] args) {
		
		System.out.println("================ cat ================");
		Cat cat = new Cat();
		cat.animalMove();
		cat.animalSound();
		cat.animalEats();
		cat.animalLocation();
		cat.animalName();
		
		
		System.out.println("================ dog ================");
		Animal dog = new Dog();
		dog.animalMove();
		dog.animalSound();
		dog.animalEats();
		
		System.out.println("================ pig ================");
		Animal pig = new Pig();
		pig.animalMove();
		pig.animalSound();
		pig.animalEats();
		
		
		System.out.println("================ fish ===============");
		AnimalInterface fish = new Fish();
		//fish.animalMove();
		//fish.animalSound();
		//fish.animalEats();
		fish.animalLocation();
		fish.animalName();
		
		// cant do this because Animal does not have an implementation for 2 methods.
		//Animal animal = new Animal();
		
	}
}
