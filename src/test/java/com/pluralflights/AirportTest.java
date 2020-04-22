package com.pluralflights;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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
						() -> assertEquals(1, economyFlight.getPassengersList().size()),

						() -> assertEquals("1", economyFlight.getId()), 
						() -> assertEquals("Mike", mike.getName()),

						() -> assertTrue(economyFlight.removePassenger(mike)),
						() -> assertEquals(0, economyFlight.getPassengersList().size()));

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
						() -> assertEquals(1, economyFlight.getPassengersList().size()),

						() -> assertEquals("1", economyFlight.getId()), 
						() -> assertEquals("John", john.getName()),

						() -> assertFalse(economyFlight.removePassenger(john)),
						() -> assertEquals(1, economyFlight.getPassengersList().size()));

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
						() -> assertEquals(0, businessFlight.getPassengersList().size()),

						() -> assertFalse(businessFlight.removePassenger(mike)),
						() -> assertEquals(0, businessFlight.getPassengersList().size()));

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
						() -> assertEquals(1, businessFlight.getPassengersList().size()),

						() -> assertFalse(businessFlight.removePassenger(john)),
						() -> assertEquals(1, businessFlight.getPassengersList().size()));

			}
		}

	}

}
