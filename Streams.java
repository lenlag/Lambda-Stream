package FromScratch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		Integer i = 0;
		List<Integer> list = new ArrayList<>();

		for (i = 0; i < 100; i++) {
			list.add(i);
		}
		System.out.println(list.size());

		for (Integer in : list) { // avant, pour parcourir une liste, il fallait faire une boucle
			System.out.print(in);
		}

		System.out.println();

		////////////////// CREER & PARCOURIR UN
		////////////////// STREAM/////////////////////////////////////////

		Stream<Integer> stream = list.stream(); // on cr�e le stream associ� � la liste

		stream.forEach(s -> System.out.print(s)); // parcourir une liste avec un stream

		stream = list.stream();// rouvrir le Stream avant de re-faire une op�ration dessus

		System.out.println();
		stream.forEach(System.out::print); // avec operateur ::

		///////////////////////////////////// FILTRAGE////////////////////////////////////////////
		/// C�est une fonction interm�diaire qui s�applique avant le forEach. Elle
		///////////////////////////////////// re�oit un Predicate, c.a.d
		// quelque chose qui re�oit un param�tre et retourne true ou false ;

		System.out.println();
		stream = list.stream();
		stream.filter(x -> x > 50).forEach(System.out::print); // filtrer et n�afficher que les �l�ments de la liste
																// dont la valeur est > 50

		System.out.println();
		stream = list.stream();
		stream.filter(x -> x > 50).filter(x -> x < 77).forEach(System.out::print); // on peut enchainer des filtres

		/////////////////////////////////////////// MAP////////////////////////////////////////////////
		// sert � ne garder qu�une partie de ce qui a servi � construire le Stream (la List dans notre cas)

		List<PersonLambda> personList = new ArrayList<>();
		personList.add(new PersonLambda(18, "Zaza"));
		personList.add(new PersonLambda(58, "Lola"));
		personList.add(new PersonLambda(38, "Baba"));
		personList.add(new PersonLambda(48, "Clara"));
		personList.add(new PersonLambda(50, "Koka"));
		personList.add(new PersonLambda(29, "Zara"));
		personList.add(new PersonLambda(33, "Geko"));
		personList.add(new PersonLambda(35, "Hugo"));
		personList.add(new PersonLambda(1, "Hoc"));
		personList.add(new PersonLambda(7, "Isamu"));
		
		//https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/
		
		System.out.println();
		System.out.println(personList.size());
		
		Stream<PersonLambda> streamPerson = personList.stream(); // on cr�e le stream associ� � la liste des personnes
		streamPerson.filter(p -> p.getAge() > 30).map(p -> p.getName()).forEach(System.out::println); //filtrer pour ne garder que les noms des gens dont l��ge est > 50
		
		System.out.println();
		streamPerson = personList.stream(); // on cr�e le stream associ� � la liste des personnes
		streamPerson.filter(p -> p.getAge() > 30).map(p -> p.getName()).filter(p -> p.contains("H")).forEach(System.out::println); //on encha�ne des filtres
		
		
		/////////////////////////////////////////COLLECT///////////////////////////////////////////
		//Collect permet de r�cup�rer le r�sultat des op�rations successives sous une certaine forme. Cette
		//forme est d�finie par un objet Collectors (impl�mentant l'interface Collector ).
		
		streamPerson = personList.stream(); 
		List<String> listP2 = streamPerson.filter(p -> p.getAge() > 30).map(p -> p.getName()).collect(Collectors.toList());
		
		for (String string : listP2) {
			
		}
	}
}
