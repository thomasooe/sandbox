package com.tom.patterns.composite.test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tom.patterns.composite.Adder;
import com.tom.patterns.composite.Constant;
import com.tom.patterns.composite.Divider;
import com.tom.patterns.composite.Expression;
import com.tom.patterns.composite.Multiplier;
import com.tom.patterns.composite.Subtracter;

public class CompositePatternTest {

	@Test
	public void testConstant() {
		double testValue = 3.0;
		Expression e = new Constant(testValue);
		assertEquals(testValue, e.getValue(), 0.0);
	}
	
	@Test
	public void testAdder()
	{
		double testValueA = 2.0;
		double testValueB = 4.0;
		
		Expression left = new Constant(testValueA);
		Expression right = new Constant(testValueB);
		
		Expression e = new Adder(left, right);
		assertEquals((testValueA+testValueB), e.getValue(), 0.0);
	}
	
	@Test
	public void testSubtracter()
	{
		double testValueA = 2.0;
		double testValueB = 4.0;
		
		Expression left = new Constant(testValueA);
		Expression right = new Constant(testValueB);
		
		Expression e = new Subtracter(left, right);
		assertEquals((testValueA-testValueB), e.getValue(), 0.0);
	}
	
	@Test
	public void testDivider()
	{
		double testValueA = 2.0;
		double testValueB = 4.0;
		
		Expression left = new Constant(testValueA);
		Expression right = new Constant(testValueB);
		
		Expression e = new Divider(left, right);
		assertEquals((testValueA/testValueB), e.getValue(), 0.0);
	}
	
	@Test
	public void testMultiplier()
	{
		double testValueA = 2.0;
		double testValueB = 4.0;
		
		Expression left = new Constant(testValueA);
		Expression right = new Constant(testValueB);
		
		Expression e = new Multiplier(left, right);
		assertEquals((testValueA*testValueB), e.getValue(), 0.0);
	}
	
	@Test
	public void testComplexExpression()
	{
		Expression e = new Divider(new Multiplier(new Adder(new Constant(3.0), new Constant(5.0)), new Constant(100)), new Adder(new Constant(2.0), new Constant(64.0)));
		assertEquals(12.121212121212, e.getValue(), 0.00001);
	}

}
