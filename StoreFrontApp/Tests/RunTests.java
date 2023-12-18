package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

class RunTests {

	/**
	 * Run all salable tests at once
	 */
	@RunWith(Suite.class)
	@SuiteClasses({ SaleableTest.class , WeaponTest.class, HealthTest.class, ArmorTest.class})
	public class AllTests {
		
	}
}
