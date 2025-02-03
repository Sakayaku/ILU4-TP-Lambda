public class Exercice1b implements It2<Exercice1a> {
	public int apply(Exercice1a t1) {
		return t1.apply(t1.apply(0));
	}	
}
