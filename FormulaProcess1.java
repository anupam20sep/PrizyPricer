package plugins;

import java.util.Collections;
import java.util.List;

public class FormulaProcess1 implements FormulaPlugin {

	@Override
	public double calculateIdealPrice(final List<Double> prices) {

		// sort the list
		Collections.sort(prices);

		// remove the 2 lowest and 2 highest prices
		if (prices.size() > 4) {
			prices.remove(0);
			prices.remove(1);

			prices.remove(prices.size() - 1);
			prices.remove(prices.size() - 2);
		}

		double sum = 0;
		for (Double p : prices) {
			sum += p;
		}

		double avg = sum / prices.size();

		System.out.println(avg);
		return avg + (0.2 * avg);

	}

}
