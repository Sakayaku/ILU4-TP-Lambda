public class Exercice1b implements It2<Increment> {
	public int apply(Increment t1) {
		return t1.apply(t1.apply(0));
	}	
}
