package api;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RoomOccupationTest extends AcceptanceTest {

    @Test
    public void calculateRoomOccupation() throws IOException {
        whenWeMakeAGetRequestTo("/occupations?premium=3&economy=3");
        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(200);
        assertThat(responseBody).isEqualTo("{ \n" +
                "  \"premium\": {\n" +
                "    \"usage\": 3,\n" +
                "    \"income\": 738\n" +
                "  },\n" +
                "  \"economy\": {\n" +
                "    \"usage\": 3,\n" +
                "    \"income\": 167\n" +
                "  }\n" +
                "}");
    }

}
