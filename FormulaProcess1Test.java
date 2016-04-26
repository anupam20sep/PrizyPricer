package plugins;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FormulaProcess1Test {
	List<Double>	prices;

	FormulaPlugin	fp;

	@Before
	public void setUp() throws Exception {

		this.prices = new ArrayList<Double>();
		this.prices.add(20.7);
		this.prices.add(23.8);
		this.prices.add(26.2);
		this.prices.add(18.7);
		this.prices.add(20.7);
		this.prices.add(21.2);
		this.prices.add(19.8);
		this.prices.add(20.7);
		this.prices.add(20.0);
		this.prices.add(25.5);

		this.fp = new FormulaProcess1();

	}

	@Test
	public void test() {

		double idealPrice = 21.43;
		final double DELTA = 1e-2;

		assertEquals("message", idealPrice, this.fp.calculateIdealPrice(this.prices), DELTA);
	}

}
