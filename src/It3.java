import java.util.function.Function;

@FunctionalInterface
public interface It3 <A>{
	public A apply(Function<A,A> f, A a);
}