package com.obprado;

import java.util.Comparator;
import java.util.stream.Stream;

public class RoomBooker {
    public static final int HIGH_END_BUDGET_THRESHOLD = 100;
    private GuestsService guestsService;

    public RoomBooker(GuestsService guestsService) {
        this.guestsService = guestsService;
    }

    public Usages calculateBookings(RoomsSet freeRooms) {
        Stream<Integer> highEndGuests = sortedGuests().filter(this::highEnd);

        // Premium guests are assigned to rooms in budget order
        UsagesBuilder builder = new UsagesBuilder(freeRooms);
        highEndGuests.limit(freeRooms.freePremiumRooms()).forEach(builder::addPremiumGuest);

        int numberOfUpgradedGuests = Math.min(builder.remainingPremiumRooms(), (int)lowEndGuests().count());
        // Low end guests are assigned a premium room if there are rooms left
        lowEndGuests().limit(numberOfUpgradedGuests).forEach(builder::addPremiumGuest);

        // Remaining low end guests are assigned to free rooms in budget order
        lowEndGuests().skip(numberOfUpgradedGuests).limit(freeRooms.freeEconomyRooms()).forEach(builder::addEconomyGuest);

        return builder.build();
    }

    private Stream<Integer> lowEndGuests() {
        return this.sortedGuests().filter(this::lowEnd);
    }

    private Stream<Integer> sortedGuests() {
        return this.guestsService.findGuestsInfo().stream().sorted(Comparator.reverseOrder());
    }

    public boolean highEnd(int guestBudget) {
        return guestBudget >= HIGH_END_BUDGET_THRESHOLD;
    }

    public boolean lowEnd(int guestBudget) {
        return !this.highEnd(guestBudget);
    }
}
