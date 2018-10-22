package com.obprado;

public class RoomsSet {

    private int economy;
    private int premium;

    public RoomsSet(int economy, int premium) {
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
