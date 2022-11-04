package com.teksystems.abstraction;

public class Fish implements AnimalInterface {

	@Override
	public void animalLocation() {
		System.out.println("Fish lives in water");
	}

	@Override
	public void animalName() {
		System.out.println("Fish");
	}

}
