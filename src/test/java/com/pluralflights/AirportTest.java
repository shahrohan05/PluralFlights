package com.pluralflights;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

public class AirportTest {

	@DisplayName("Given there is an economy flight")
	@Nested
	class EconomyFlightTest {
		private Flight economyFlight;
		private Passenger mike;
		private Passenger john;

		@BeforeEach
		void setup() {
			economyFlight = new EconomyFlight("1");
			mike = new Passenger("Mike", false);
			john = new Passenger("John", true);
		}

		@DisplayName("When we have a usual passenger")
		@Nested
		class UsualPassenger {

			@DisplayName("Then you can add and remove him from an economy flight")
			@Test
			public void testEconomyFlightUsualPasseger() {

				assertAll("Verify all conditions for a usual passenger and an economy flight",
						() -> assertTrue(economyFlight.addPassenger(mike)),
						() -> assertEquals(1, economyFlight.getPassengersSet().size()),

						() -> assertEquals("1", economyFlight.getId()), 
						() -> assertEquals("Mike", mike.getName()),

						() -> assertTrue(economyFlight.removePassenger(mike)),
						() -> assertEquals(0, economyFlight.getPassengersSet().size()));

			}
			
			
			@DisplayName("Then you cannot add him to an economy flight more than once")
			@RepeatedTest(2)
			public void testEconomyFlightUsualPassengerOnlyOnce(RepetitionInfo repetitionInfo) {
				for(int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
					economyFlight.addPassenger(mike);
				}
				
				assertAll("Verify that a usual passenger can be added to an economy flight only once",
						() -> assertEquals(1, economyFlight.passengersSet.size()),
						() -> assertTrue(economyFlight.getPassengersSet().contains(mike)),
						() -> assertTrue(economyFlight.getPassengersSet().iterator().next().getName().equalsIgnoreCase("mike")));
			}
			
		}

		@DisplayName("When we have a VIP passenger")
		@Nested
		class VIPPassenger {

			@DisplayName("Then you can add him to an economy flight but cannot remove him")
			@Test
			public void testEconomyFlightVipPasseger() {

				assertAll("verify all conditions for a VIP passenger and an economy flight",
						() -> assertTrue(economyFlight.addPassenger(john)),
						() -> assertEquals(1, economyFlight.getPassengersSet().size()),

						() -> assertEquals("1", economyFlight.getId()), 
						() -> assertEquals("John", john.getName()),

						() -> assertFalse(economyFlight.removePassenger(john)),
						() -> assertEquals(1, economyFlight.getPassengersSet().size()));

			}
		}

	}

	@DisplayName("Given there is a business flight")
	@Nested
	class BusinessFlightTest {

		private Flight businessFlight;
		private Passenger mike;
		private Passenger john;

		@BeforeEach
		void setup() {
			businessFlight = new BusinessFlight("2");
			mike = new Passenger("Mike", false);
			john = new Passenger("John", true);
		}

		@DisplayName("When we have a usual passenger")
		@Nested
		class UsualPassenger {

			@DisplayName("Then you can neither add nor remove him from the flight")
			@Test
			public void testBusinessFlightUsualPasseger() {

				assertAll("Verify all the conditions for a usual passenger and a business flight",
						() -> assertFalse(businessFlight.addPassenger(mike)),
						() -> assertEquals(0, businessFlight.getPassengersSet().size()),

						() -> assertFalse(businessFlight.removePassenger(mike)),
						() -> assertEquals(0, businessFlight.getPassengersSet().size()));

			}
		}

		@DisplayName("When we have a VIP passenger")
		@Nested
		class VIPPassenger {

			@DisplayName("Then you can add him but cannot remove him from flight")
			@Test
			public void testBusinessFlightVipPasseger() {

				assertAll("Verify all the conditions for a VIP passenger and a business flight",
						() -> assertTrue(businessFlight.addPassenger(john)),
						() -> assertEquals(1, businessFlight.getPassengersSet().size()),

						() -> assertFalse(businessFlight.removePassenger(john)),
						() -> assertEquals(1, businessFlight.getPassengersSet().size()));

			}
			
			@DisplayName("Then you cannot add him to a business flight more than once")
			@RepeatedTest(2)
			public void testPremiumFlightVIPPassengerOnlyOnce(RepetitionInfo repetitionInfo) {
				for(int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
					businessFlight.addPassenger(john);
				}
				
				assertAll("Verify that a VIP passenger can be added to a business flight only once",
						() -> assertEquals(1, businessFlight.passengersSet.size()),
						() -> assertTrue(businessFlight.getPassengersSet().contains(john)),
						() -> assertTrue(businessFlight.getPassengersSet().iterator().next().getName().equalsIgnoreCase("john")));
			}
		}

	}
	
	
	@DisplayName("Given there is a premium flight")
	@Nested
	class PremiumFlightTest {

		private Flight premiumFlight;
		private Passenger mike;
		private Passenger john;

		@BeforeEach
		void setup() {
			premiumFlight = new PremiumFlight("3");
			mike = new Passenger("Mike", false);
			john = new Passenger("John", true);
		}

		@DisplayName("When we have a usual passenger")
		@Nested
		class UsualPassenger {

			@DisplayName("Then you can neither add nor remove him from the flight")
			@Test
			public void testPremiumFlightUsualPasseger() {

				assertAll("Verify all the conditions for a usual passenger and a premium flight",
						() -> assertFalse(premiumFlight.addPassenger(mike)),
						() -> assertEquals(0, premiumFlight.getPassengersSet().size()),

						() -> assertFalse(premiumFlight.removePassenger(mike)),
						() -> assertEquals(0, premiumFlight.getPassengersSet().size()));

			}
		}

		
		@DisplayName("When we have a VIP passenger")
		@Nested
		class VIPPassenger {

			@DisplayName("Then you can add and remove him from flight")
			@Test
			public void testPremiumFlightVipPasseger() {

				assertAll("Verify all the conditions for a VIP passenger and a premium flight",
						() -> assertTrue(premiumFlight.addPassenger(john)),
						() -> assertEquals(1, premiumFlight.getPassengersSet().size()),

						() -> assertTrue(premiumFlight.removePassenger(john)),
						() -> assertEquals(0, premiumFlight.getPassengersSet().size()));

			}
			
			@DisplayName("Then you cannot add him to a premium flight more than once")
			@RepeatedTest(2)
			public void testPremiumFlightVIPPassengerOnlyOnce(RepetitionInfo repetitionInfo) {
				for(int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
					premiumFlight.addPassenger(john);
				}
				
				assertAll("Verify that a VIP passenger can be added to a premium flight only once",
						() -> assertEquals(1, premiumFlight.passengersSet.size()),
						() -> assertTrue(premiumFlight.getPassengersSet().contains(john)),
						() -> assertTrue(premiumFlight.getPassengersSet().iterator().next().getName().equalsIgnoreCase("john")));
			}
		}

	}

}
