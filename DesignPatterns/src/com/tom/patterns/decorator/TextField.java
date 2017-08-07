package com.tom.patterns.decorator;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.LinkedList;
import java.util.List;

public class TextField implements GraphicalComponent {
		private List<String> lines = new LinkedList<String>();
	
	@Override
	public void paint() {
		System.out.println(("Start TextField..."));
		for (String l : this.lines)	{
			System.out.println(l);
		}
		System.out.println("End Text");
	}

	@Override
	public GraphicalComponent addContent(Object l) {
		assert(l instanceof String);
		this.lines.add((String) l);
		if (this.lines.size() > 1)
		{
			// add new scrollbar decorator
			return new ScrollBarDecorator(this);
		}
		else
		{
			return this;
		}
	}

}
