package com.obprado;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RoomBookerTest {

    @Test
    public void shouldAssignGuestsToRooms() {
        RoomBooker roomBooker = new RoomBooker(new MockGuestsService());

        Usages roomUsages = roomBooker.calculateBookings(new RoomsSet(3, 3));
        assertThat(roomUsages.premiumGuestsCount()).isEqualTo(3);
        assertThat(roomUsages.premiumGuestsTotalIncome()).isEqualTo(738);

        assertThat(roomUsages.economyGuestsCount()).isEqualTo(3);
        assertThat(roomUsages.economyGuestsTotalIncome()).isEqualTo(167);
    }

}