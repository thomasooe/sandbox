package com.tom.patterns.creationalpatterns.shapes;

public abstract class Shape {
	abstract public void draw();
	
	public static Shape create(String s) {
		Shape retVal = null;
		
		if (s.startsWith("#rect"))
		{
			retVal = new Rectangle();
		}
		else if (s.startsWith("#oval"))
		{
			retVal = new Oval();
		}
		else if (s.startsWith("#line"))
		{
			retVal = new Line();
		}
		
		return retVal;
	}
}
