package com.teksystems.abstraction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cat extends Animal implements AnimalInterface, ActionListener {

	@Override
	// this one overrides the implementation in the abstract animal class
	public void animalSound() {
		System.out.println("The cat makes a sound");
	}
	
	// these 3 are from the AnimalInterface
	@Override
	public void animalEats() {
		System.out.println("The cat eats some food");
	}

	@Override
	public void animalLocation() {
		System.out.println("The cat eats some food");		
	}

	@Override
	public void animalName() {
		System.out.println("Cat");		
	}

	@Override
	// this is from the ActionListener interface
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
