package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.repository.EntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {
    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public Entry createEntry(Entry entry) {
        return entryRepository.saveAndFlush(entry);
    }

    public List<Entry> findAllByApplicationUserId(Long id) {
        return entryRepository.findAllByApplicationUserId(id);
    }

    public void deleteByIdAndApplicationUserId(Long id, Long userId){
        entryRepository.deleteByIdAndApplicationUserId(id, userId);
    }

    public void updateEntry(Entry entry){
        entryRepository.save(entry);
    }
}
