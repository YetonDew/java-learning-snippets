class Strategy {
	public double getMean(double[] data) {
		throw new UnsupportedOperationException();
	}
}

class StrategyArithmetic extends Strategy {
	@Override
	public double getMean(double[] data) {
		int n = data.length;
		int i = 0;
		double res = 0;
		while(i < n)
		{
			res += data[i];
			i++;
		}
		return(res / n);
	}
}

class StrategyGeometric extends Strategy {
	@Override
	public double getMean(double[] data) {
		int n = data.length;
		int i = 0;
		double res = 1;
		while(i < n)
		{
			res *= data[i];
			i++;
		}
		return Math.pow(res, 1.0 / n);
	}
}
class StrategyHarmonic extends Strategy {
	@Override
	public double getMean(double[] data) {
		int n = data.length;
		int i = 0;
		double res = 0;
		while(i < n)
		{
			res += 1/data[i];
			i++;
		}
		return (n/res);
	}
}

class Mean {
	private double[] data;
	Strategy strategy;

	public Mean(double[] data) {
		this.data = data;
	}

	void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	double getMean() {
		return strategy.getMean(data);
	}
}

public class TaskEight {

	public static void main(String[] args) {

		double[] data = { 2, 3, 4, 5, 6, 7, 8, 9 };

		Mean mean = new Mean(data);
		double meanVal;
		mean.setStrategy(new StrategyArithmetic());
		meanVal = mean.getMean();
		System.out.printf("%10s strategy: mean = %5.3f\n", "Arithmetic", meanVal);
		mean.setStrategy(new StrategyGeometric());
		meanVal = mean.getMean();
		System.out.printf("%10s strategy: mean = %5.3f\n", "Geometric", meanVal);
		mean.setStrategy(new StrategyHarmonic());
		meanVal = mean.getMean();
		System.out.printf("%10s strategy: mean = %5.3f\n", "Harmonic", meanVal);
	}
}
