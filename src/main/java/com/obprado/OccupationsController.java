package com.obprado;

import com.obprado.core.RoomBooker;
import com.obprado.core.RoomsSet;
import com.obprado.core.Usages;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OccupationsController {

    private static final String USAGE_TEMPLATE = "{ \n" +
            "  \"premium\": {\n" +
            "    \"usage\": %s,\n" +
            "    \"income\": %s\n" +
            "  },\n" +
            "  \"economy\": {\n" +
            "    \"usage\": %s,\n" +
            "    \"income\": %s\n" +
            "  }\n" +
            "}";

    private RoomBooker roomBooker;

    public OccupationsController(RoomBooker roomBooker) {
        this.roomBooker = roomBooker;
    }

    @RequestMapping("/occupations")
    public String calculateOccupations(
            @RequestParam(name="premium", required=true) int premium,
            @RequestParam(name="premium", required=true) int economy
    ) {
        Usages usages = this.roomBooker.calculateBookings(new RoomsSet(premium, economy));
        return String.format(USAGE_TEMPLATE,
                usages.premiumGuestsCount(),
                usages.premiumGuestsTotalIncome(),
                usages.economyGuestsCount(),
                usages.economyGuestsTotalIncome()
        );
    }

}

