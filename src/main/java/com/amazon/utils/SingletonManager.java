package com.amazon.utils;

import com.amazon.pom.HomePage;

public class SingletonManager {

	private HomePage hp;

	public HomePage getHp() {
		if (hp == null) {
			System.out.println("Object Created");
			hp = new HomePage();
		}
		return hp;
	}

}
