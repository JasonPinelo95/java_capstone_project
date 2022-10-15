package com.example.university.services.implementation;

import com.example.university.model.Professors;
import com.example.university.repository.ProfessorsRepository;
import com.example.university.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorsServiceImpl implements ProfessorsService {
    private final ProfessorsRepository professorsRepository;

    @Autowired
    public ProfessorsServiceImpl(ProfessorsRepository professorsRepository) {
        this.professorsRepository = professorsRepository;
    }

    @Override
    public List<Professors> findAll() {
        return professorsRepository.findAll();
    }

    @Override
    public Professors findById(Long id) {
        return professorsRepository.findById(id).get();
    }

    @Override
    public Professors save(Professors professors) {
        return professorsRepository.save(professors);
    }

    @Override
    public void deleteById(Long id) {
        professorsRepository.deleteById(id);
    }

}

