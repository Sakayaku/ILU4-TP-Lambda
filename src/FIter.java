import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FIter {
	public static <A,B> Iterable<B> map(Iterable<A> i, Function<A,B> f) {
		//'a list -> ('a -> 'b) -> 'b list
		Iterator<A> it = i.iterator();
		return new Iterable<B>() {
			@Override
			public Iterator<B> iterator() {
				return new Iterator<B>() {
					@Override
					public boolean hasNext() {
						return it.hasNext();
					}
					@Override
					public B next() {
						return f.apply((it.next()));
					}
				};
			}
		};
	}
	
	public static <A> Iterable<A> filter(Iterable<A> i, Predicate<A> b){
		Iterator<A> it = i.iterator();
		return new Iterable<A>() {
			@Override
			public Iterator<A> iterator() {
				return new Iterator<A>() {
					@Override
					public boolean hasNext() {
						return it.hasNext();
					}
					@Override
					public A next() {
						A actuel=it.next();
						if (b.test(actuel)) {
							return (actuel);
						}else {
							while (!b.test(actuel)){ // a mettre dans hasNext
								if (it.hasNext()) {
									actuel=it.next();
								}
							}
							return actuel;
						}
					}
				};
			}
		};
	}
}
