package com.tom.patterns.command.simple;

public class Demo {

	public static void main(String[] args) {
		System.out.println("The sum of numbers between 1 and 100: " + sumOfSequence(1, 100));
		System.out.println("The sum of squares between 1 and 10: " + sumOfSquares(1, 10));

		System.out.println("The sum of numbers between 1 and 100: " + sum(1, 100, new Function() {

			@Override
			public int apply(int i) {
				return i;
			}
		}));
		System.out.println("The sum of squares between 1 and 10: " + sum(1, 10, new Function() {

			@Override
			public int apply(int i) {
				return i * i;
			}
		}));
	}

	private static int sum(int lower, int upper, Function f) {
		int sum = 0;
		for (int i = lower; i <= upper; i++) {
			sum += f.apply(i);
		}
		return sum;
	}

	private static int sumOfSquares(int lower, int upper) {
		int sum = 0;
		for (int i = lower; i <= upper; i++) {
			sum += i * i;
		}
		return sum;
	}

	private static int sumOfSequence(int lower, int upper) {
		int sum = 0;
		for (int i = lower; i <= upper; i++) {
			sum += i;
		}
		return sum;
	}

}
