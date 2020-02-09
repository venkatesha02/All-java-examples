package com.tyss.springcore.beans;

import lombok.extern.java.Log;

@Log
public class Cat implements Animal{

	@Override
	public void makeSound() {

		log.info("Meaoooooww");
	}

}
