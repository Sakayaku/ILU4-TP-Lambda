import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface Power <T> extends Function<T, T> {
	public static <T> Power<T> identity() {
        return var -> var;
    }
	public default Power <T> andThen(Power <T> f) {
        return var -> f.apply(this.apply(var));
    }
	public default Power <T> power(int n){
		if (n==0) {
			return identity();
		}else {
			return andThen(power(n-1));
		}
	}
}
