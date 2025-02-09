import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Flist {
	public static <A,B> List<B> map(List<A> l, Function<A,B> f) {
		//'a list -> ('a -> 'b) -> 'b list
		List<B> result=new ArrayList<>();
		for (A e:l) {
			result.add(f.apply(e));
		}
		return result;
	}
	
	public static <A> List<A> filter(List<A> l, Predicate<A> b){
		List<A> result=new ArrayList<>();
		for (A e:l) {
			if (b.test(e)) {
				result.add(e);
			}
		}
		return result;
	}
	
	public static <A> List<A> for_all(List<A> l, Consumer<A> f){ //Function<A,Void> marche aussi
		for (A e:l) {
			f.accept(e);
		}
		return l;
	}
	
	public static <A> boolean exists(List<A> l, Predicate<A> b) {
		for (A e:l) {
			if (b.test(e)) {
				return true;
			}
		}
		return false;
	}
}
