package com.obprado.repositories;

import com.obprado.core.GuestsRepository;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class MockGuestsRepository implements GuestsRepository {

    @Override
    public List<Integer> findGuestsInfo() {
        return asList(23, 45, 155, 374, 22, 99, 100, 101, 115, 209);
    }
}
