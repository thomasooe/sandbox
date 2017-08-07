package com.tom.patterns.decorator;

public class ScrollBarDecorator extends Decorator implements GraphicalComponent {

	public ScrollBarDecorator(GraphicalComponent next) {
		super(next);
	}
	
	@Override
	public void paint() {
		System.out.println("Render the scrollbar");
		super.paint();
	}
}
