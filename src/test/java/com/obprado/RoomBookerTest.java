package com.obprado;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RoomBookerTest {

    private RoomBooker roomBooker = new RoomBooker(new MockGuestsService());

    @Test
    public void shouldAssignGuestsToRoomsWhenTheHotelHasEnoughGuestsForAllRoomsWithoutUpgradingThem() {
        testRooms(roomBooker, new RoomsSet(3, 3), 3, 738, 3, 167);
    }

    @Test
    public void shouldNotUpgradeLowEndGuestsIfThereAreEmptyEconomyRooms() {
        testRooms(roomBooker, new RoomsSet(7, 5), 6, 1054, 4, 189);
    }

    private void testRooms(RoomBooker roomBooker, RoomsSet freeRooms,
                           int expectedPremiumGuestCount, int expectedPremiumGuestTotalIncome,
                           int expectedEconomyGuestCount, int expectedEconomyTotalIncome) {
        Usages roomUsages = roomBooker.calculateBookings(freeRooms);
        assertThat(roomUsages.premiumGuestsCount()).isEqualTo(expectedPremiumGuestCount);
        assertThat(roomUsages.premiumGuestsTotalIncome()).isEqualTo(expectedPremiumGuestTotalIncome);

        assertThat(roomUsages.economyGuestsCount()).isEqualTo(expectedEconomyGuestCount);
        assertThat(roomUsages.economyGuestsTotalIncome()).isEqualTo(expectedEconomyTotalIncome);
    }

}