package com.obprado;

import java.util.List;

public class Usages {

    private List<Integer> economyUsage;
    private List<Integer> premiumUsage;

    public Usages(List<Integer> economyUsage, List<Integer> premiumUsage) {
        this.economyUsage = economyUsage;
        this.premiumUsage = premiumUsage;
    }

    public int economyGuestsCount() {
        return this.economyUsage.size();
    }

    public int economyGuestsTotalIncome() {
        return sumatorium(this.economyUsage);
    }

    public int premiumGuestsCount() {
        return this.premiumUsage.size();
    }

    public int premiumGuestsTotalIncome() {
        return sumatorium(this.premiumUsage);
    }

    private int sumatorium(List<Integer> usage) {
        return usage.stream().mapToInt(Integer::intValue).sum();
    }
}
