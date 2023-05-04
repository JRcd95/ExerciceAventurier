package fr.exerciceAventurier.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.exerciceAventurier.app.Movement;

class MovementTest {

	@Test
	void easyWay() {
		assertEquals("(9,2)", Movement.travelMap(3,0, "SSSSEEEEEENN").toString());	
	}
	
	@Test
	void hardWay() {
		assertEquals("(1,9)", Movement.travelMap(6,7, "OONOOOSSO").toString());			
	}
}