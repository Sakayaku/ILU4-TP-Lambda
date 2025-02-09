import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class main {
	public static <T,R,S,U> IComp2<T,R,S,U> comp2() {
		return (f1,f2,g,x) -> g.apply(f1.apply(x),f2.apply(x));
		/*return new IComp2<>() {
			@Override
			public U apply(Function<T, R> f1, Function<T, S> f2, BiFunction<R, S, U> g, T x) {
				return g.apply(f1.apply(x),f2.apply(x));
			}
		};*/
	}
	public static void main(String[] args) {
		Increment inc1=new Increment();
		Increment inc2 = new Increment();
		System.out.println(inc1.compose(inc2, 3));
		It1 twoinc = inc1.compose(inc2);
		System.out.println(twoinc.apply(3));
		System.out.println(inc1.apply(3));
		Exercice1b ex1b=new Exercice1b();
		System.out.println(ex1b.apply(inc1));
		It3<String> ex1c = new It3<>() {
			public String apply(Function <String, String> f, String s) {
				return f.apply(f.apply(s));
			}
		};
		
		System.out.println(ex1c.apply(var -> "x"+var, "a"));
		
		Function<Integer, Integer> f= var -> var+1;
		Function<Integer, Integer> g= var -> var*2;
		System.out.println(f.andThen(g).apply(3));
		Power<Integer> h= var -> var*var;
		System.out.println(h.power(4).apply(2));
		
		Function <Integer, Integer> f1= var -> var+1;
		Function <Integer, Integer> f2= var -> var*2;
		BiFunction<Integer,Integer,Integer> p =Integer::max;
		/*Marche quand même
		IComp2<Integer,Integer,Integer,Integer> comp2 =new IComp2<>() {
			public Integer apply(Function<Integer,Integer> f1, Function<Integer,Integer> f2, BiFunction<Integer,Integer,Integer> g, Integer x) {
				return g.apply(f1.apply(x),f2.apply(x));
			}
		};
		*/
		IComp2<Integer,Integer,Integer,Integer> comp2iiii=comp2();
		System.out.println(comp2iiii.apply(f1, f2, p, 2));
		Function <String, Integer> f3= var -> Integer.parseInt(var)+1;
		Function <String, Integer> f4= var -> Integer.parseInt(var)*2;
		IComp2<String,Integer,Integer,Integer> comp2siii=comp2();
		System.out.println(comp2siii.apply(f3, f4, p, "2"));
		
		System.out.println("On est à l'exercice 3");
		List<Integer> liste=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> liste2 = Flist.map(liste, elementListe->elementListe+2);
		Flist.for_all(liste2, elementListe -> System.out.println(elementListe));
		List<Integer> liste3=Flist.filter(liste2, elementListe -> elementListe%2==0);
		Flist.for_all(liste3, elementListe -> System.out.println(elementListe));
		System.out.println(Flist.exists(liste2, elementListe -> elementListe==4));
		
		System.out.println(FIter.map(liste, elementListe -> elementListe+2));
		System.out.println(FIter.filter(liste, elementListe -> elementListe%2==0));
	}
}
