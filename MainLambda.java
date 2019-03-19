package FromScratch;

import java.util.function.Consumer;

public class MainLambda {

	public static void main(String[] args) {

		String s = "Coucou";

		// méthode classe anonyme

		Lambda l = new Lambda() {
			public void parler(String y) {
				System.out.println(y);
			}
		};

		l.parler(s);

		// méthode lambda

		IParler p = (x) -> System.out.println(x);
		p.parler("Lalala");

		// Interface OperationLambda
		// 4 lambdas qui font la somme, la différence, le produit et la division des
		// valeurs passées en paramètre

		int x = 3;
		int y = 4;

		OperationLambda operation = (a, b) -> {
			System.out.println(a + b);
			System.out.println(a - b);
			System.out.println(a * b);
			System.out.println(a / b);
		};
		operation.opere(x, y);
		
		OperationLambda2 operation2 = (a, b) -> a + b; // on ne met que le traitement, mais pas le nom de la méthode interne
		int result = operation2.opere(x, y);
		System.out.println("Result " + result);
		
		OperationLambda2 operation3 = (a, b) -> a - b;
		result = operation3.opere(x, y);
		System.out.println("Result " + result);
		
		OperationLambda2 operation4 = (a, b) -> a * b;
		result = operation4.opere(x, y);
		System.out.println("Result " + result);
		
		OperationLambda2 operation5 = (a, b) -> a / b;
		result = operation5.opere(x, y);
		System.out.println("Result " + result);
		
		
		
		

	}
}