package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.Place;
import ch.zli.m223.punchclock.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Place create(Place place) {
        return placeRepository.saveAndFlush(place);
    }

    public List<Place> findAllByApplicationUserId(Long id) {
        return placeRepository.findAllByApplicationUserId(id);
    }

    public void deleteByIdAndApplicationUserId(Long id, Long userId){
        placeRepository.deleteByIdAndApplicationUserId(id, userId);
    }

    public boolean existsByIdAndApplicationUserId(Long id, Long userId){
        return placeRepository.existsByIdAndApplicationUserId(id, userId);
    }

    public void update(Place place){
        placeRepository.save(place);
    }
}
