package FromScratch;

import java.util.ArrayList;
import java.util.List;

public class MainLambda {

	public static void main(String[] args) {

		String s = "Coucou";
		String q = "Lala";
		
		Lambda l = new Lambda();

		l.parler(s);
		

		// ***************m�thode classe anonyme******************************
		//********************************************************************
		
		//Si on veut se servir de l'interface fonctionnelle IFuncParler
		//sans impl�menter une classe,
		//il faut passer par une classe anonyme

		IFuncParler p = new IFuncParler() {
			
			@Override
			public void myFunction() {
				System.out.println("coucou");
				
			}
		};
		//Ici on afficherait Coucou.
				

		//*********************** m�thode lambda********************************
		//**********************************************************************
		
		p = () -> System.out.println("Coucou");
		p.myFunction();	
		
		
//		//Si on veut utiliser l'interface IFuncMonologue 
//		//sans cr�er de classe qui l�impl�mente, on peut passer par une lambda
		
		IFuncMonologue m = () -> {System.out.println("Coucou"); System.out.println("toi");};
		m.parle();
		
		
		
		//operateur ::	
//		IFuncMonologue m =  System.out::println; // utiliser pour list.forEach(System.out::println) => pas de param�tres () pour IFuncMonologue, pas de () pour System.out.println
//		m.parle();
		
		
		//Ancienne JAVA : pour afficher les �l�ments d'une liste
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i));
		}
		//JAVA 8:
		list.forEach(System.out::println);
		
		
		// Interface OperationLambda
		// 4 lambdas qui font la somme, la diff�rence, le produit et la division des
		// valeurs pass�es en param�tre

		int x = 3;
		int y = 4;

		OperationLambda operation = (a, b) -> {
			System.out.println(a + b);
			System.out.println(a - b);
			System.out.println(a * b);
			System.out.println(a / b);
		};
		operation.opere(x, y);
		
		OperationLambda2 operation2 = (a, b) -> a + b; // on ne met que le traitement, mais pas le nom de la m�thode interne
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