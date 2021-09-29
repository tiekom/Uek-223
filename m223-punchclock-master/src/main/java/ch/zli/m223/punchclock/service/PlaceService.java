package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.repository.PlaceRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }
}
