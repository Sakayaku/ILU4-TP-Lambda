import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Test {

	private static void test(Function<Integer, String> f) {
		for (int i = 0; i<3; i++) {
			System.out.println(f.apply(i));
		}
	}
	@FunctionalInterface
	private interface Traitement<T> extends Consumer<T> {
		
		default void appliquer(List<T> list) {
			for (T e : list) {
				accept(e);
			}
		}
		
	};
	
	private static Function<Integer, String> alloc() {
		int a = 3;
		return n -> String.valueOf(a);
	}
	
	public static void main(String[] args) {
		Function<Integer, String> function;
		function = alloc();
		test(function);
	}
	
}
