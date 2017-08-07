package com.tom.patterns.decorator;

public class Main {

	public static void main(String[] args) {
		GraphicalComponent tf = construct2LineHCAndersenPoem();
		tf = new BorderDecorator(tf);
		// Add a border to the text field here
		tf.paint();
	}

	public static GraphicalComponent constructHCAndersenPoem() {
		GraphicalComponent tf  = new TextField();
		tf = tf.addContent("To move, to breathe, to fly, to float,");
		tf = tf.addContent("To gain all while you give,");
		tf = tf.addContent("To riam the roads of lands remote,");
		tf = tf.addContent("To travel is live");
		tf = tf.addContent("-- H.C. Andersen");
		return tf;
	}
	
	public static GraphicalComponent construct2LineHCAndersenPoem() {
		GraphicalComponent tf  = new TextField();
		tf = tf.addContent("To travel is live");
		tf = tf.addContent("-- H.C. Andersen");
		return tf;
	}
}
