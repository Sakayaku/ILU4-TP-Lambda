@FunctionalInterface
public interface It1{
	int apply(int t);
	default int compose(It1 func, int n) {
		return func.apply(this.apply(n));
	}
	
	default It1 compose(It1 func) {
		return n -> func.apply(this.apply(n));
	}
}
