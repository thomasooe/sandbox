package com.tom.patterns.decorator;

public class BorderDecorator extends Decorator {

	public BorderDecorator(GraphicalComponent next) {
		super(next);
	}

	@Override
	public void paint() {
		System.out.println("Could have rendered here ...");
		super.paint();
		System.out.println("Should probably render the border here ...");
	}

}
