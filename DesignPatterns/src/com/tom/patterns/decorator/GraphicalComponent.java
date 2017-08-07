package com.tom.patterns.decorator;

public interface GraphicalComponent {
	public void paint();
	public GraphicalComponent addContent(Object content);
}
