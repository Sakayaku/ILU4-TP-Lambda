import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
public interface IComp2 <T,R,S,U>{
	public U apply (Function<T,R> f1, Function<T,S> f2, BiFunction<R,S,U> g, T x);
}
