import java.util.function.Function;

@FunctionalInterface
public interface It3{
	public <A> A apply(Function<A,A> f, A a);
}