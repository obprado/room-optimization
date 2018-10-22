package com.obprado;

import java.util.List;

import static java.util.Arrays.asList;

public class MockGuestsService implements GuestsService {

    @Override
    public List<Integer> findGuestsInfo() {
        return asList(23, 45, 155, 374, 22, 99, 100, 101, 115, 209);
    }
}
