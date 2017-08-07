package com.tom.patterns.creationalpatterns.shapes;

public class Line extends Shape {
	@Override
	public void draw() {
		System.out.println(this.getClass().getName());
	}
}
