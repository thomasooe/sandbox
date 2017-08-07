package com.tom.patterns.creationalpatterns.shapes;

public class Main {

	public static void main(String[] args) {
		String[] shapes = { "#rect 1,1,100,200", "#oval 1,1,100,100", "#oval 1,1,100,100", "#line 1,1,100,100" };
		Client c = new Client();
		c.readShapes(shapes);
		c.drawAllShapes();
	}
}
