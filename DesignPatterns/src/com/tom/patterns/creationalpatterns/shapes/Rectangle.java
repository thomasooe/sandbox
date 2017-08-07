package com.tom.patterns.creationalpatterns.shapes;

public class Rectangle extends Shape {
	
	@Override
	public void draw()
	{
		System.out.println(this.getClass().getName());
	}
}
