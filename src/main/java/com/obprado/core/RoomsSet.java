package com.obprado.core;

public class RoomsSet {

    private int economy;
    private int premium;

    public RoomsSet(int premium, int economy) {
        this.economy = economy;
        this.premium = premium;
    }

    public int freeEconomyRooms() {
        return economy;
    }

    public int freePremiumRooms() {
        return premium;
    }
}
