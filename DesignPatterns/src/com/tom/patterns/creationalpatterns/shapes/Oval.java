package com.tom.patterns.creationalpatterns.shapes;

public class Oval extends Shape {

	@Override
	public void draw() {
		System.out.println(this.getClass().getName());
	}

}
