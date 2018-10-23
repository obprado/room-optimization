package com.obprado.core;

import java.util.ArrayList;
import java.util.List;

public class UsagesBuilder {
    private List<Integer> economyUsage;
    private List<Integer> premiumUsage;
    private RoomsSet roomsSet;

    public UsagesBuilder(RoomsSet roomsSet) {
        this.roomsSet = roomsSet;
        this.economyUsage = new ArrayList<>();
        this.premiumUsage = new ArrayList<>();
    }

    public void addPremiumGuest(int guestBudget) {
        this.premiumUsage.add(guestBudget);
    }

    public void addEconomyGuest(int guestBudget) {
        this.economyUsage.add(guestBudget);
    }

    public int remainingPremiumRooms() {
        return this.roomsSet.freePremiumRooms() - this.premiumUsage.size();
    }

    public Usages build() {
        return new Usages(this.economyUsage, this.premiumUsage);
    }
}
