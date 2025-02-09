import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FIter {
	public static <A,B> Iterable<B> map(Iterable<A> i, Function<A,B> f) {
		//'a list -> ('a -> 'b) -> 'b list
		List<B> result=new ArrayList<>();
		i.forEach(e -> result.add(f.apply(e)));
		return result;
	}
	
	public static <A> Iterable<A> filter(Iterable<A> i, Predicate<A> b){
		List<A> result=new ArrayList<>();
		i.forEach(e -> {
			if (b.test(e)) {
				result.add(e);
			}
		});
		return result;
	}
}
