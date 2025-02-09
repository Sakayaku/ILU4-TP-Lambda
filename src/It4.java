import java.util.function.Function;

@FunctionalInterface
public interface It4<T,R> extends Function<T,R>{
	public R apply(T t);
}